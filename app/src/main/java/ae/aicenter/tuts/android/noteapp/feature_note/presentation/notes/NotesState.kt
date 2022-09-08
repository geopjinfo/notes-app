package ae.aicenter.tuts.android.noteapp.feature_note.presentation.notes

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.NoteOrder
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean=false
)
