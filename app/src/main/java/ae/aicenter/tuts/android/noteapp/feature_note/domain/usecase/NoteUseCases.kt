package ae.aicenter.tuts.android.noteapp.feature_note.domain.usecase

data class NoteUseCases(
    val getNotesUseCase: GetNotes,
    val deleteNoteUseCase: DeleteNote,
    val createOrUpdateNoteUseCase: CreateOrUpdateNote,
    val getNoteByIdUseCase: GetNoteById
)
