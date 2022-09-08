package ae.aicenter.tuts.android.noteapp.feature_note.presentation.notes

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.usecase.NoteUseCases
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.NoteOrder
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.OrderType
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesUseCase: NoteUseCases) : ViewModel() {
    private val _state = mutableStateOf(NotesState())
    private val state: State<NotesState> = _state
    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    private var recentlyDeletedNote: Note? = null;

    fun onEvent(events: NotesEvents) {
        when (events) {
            is NotesEvents.DeleteNote -> {
                viewModelScope.launch {
                    notesUseCase.deleteNoteUseCase(events.note)
                    recentlyDeletedNote = events.note
                }
            }
            is NotesEvents.OrderNotes -> {
                if(state.value.noteOrder::class ==events.noteOrder::class &&
                        state.value.noteOrder.orderType ==events.noteOrder.orderType){
                    return
                }
           getNotes(events.noteOrder)
            }
            NotesEvents.RestoreNote -> {
              viewModelScope.launch {
                  notesUseCase.createOrUpdateNoteUseCase(recentlyDeletedNote?:return@launch)
                  recentlyDeletedNote=null
              }
            }
            NotesEvents.ToggleOrderSectionVisibility -> _state.value = _state.value.copy(
                isOrderSectionVisible = !_state.value.isOrderSectionVisible
            )
        }
    }
    private var getNotesJob:Job?=null
    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob=notesUseCase.getNotesUseCase(noteOrder).onEach {notes->
            _state.value=_state.value.copy(
                notes = notes,
                noteOrder=noteOrder
            )
        }.launchIn(viewModelScope)
    }
}