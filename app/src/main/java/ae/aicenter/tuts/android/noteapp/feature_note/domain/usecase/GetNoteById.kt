package ae.aicenter.tuts.android.noteapp.feature_note.domain.usecase

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteById(private val repository: NoteRepository) {

    suspend operator fun invoke(id:Int):Note?{
        return repository.getNoteById(id)
    }
}