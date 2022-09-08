package ae.aicenter.tuts.android.noteapp.feature_note.domain.usecase

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.repository.NoteRepository
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.NoteOrder
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    /*UseCase should only one function that public can access. and each use case defines different business rules/requirements*/
    /*suspend fun execute(){

    }*/

    /*We can use our use-case class as a function by using operator function*/
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}