package ae.aicenter.tuts.android.noteapp.feature_note.presentation.notes

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.utils.NoteOrder

sealed class NotesEvents{
    data class OrderNotes(val noteOrder: NoteOrder):NotesEvents()
    data class DeleteNote(val note: Note):NotesEvents()
    object RestoreNote:NotesEvents()
    object ToggleOrderSectionVisibility:NotesEvents()
}
