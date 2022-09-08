package ae.aicenter.tuts.android.noteapp.feature_note.domain.usecase

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.InvalidNoteException
import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import ae.aicenter.tuts.android.noteapp.feature_note.domain.repository.NoteRepository

class CreateOrUpdateNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        //TODO: handling events (success or fail)
        if(note.title.isBlank()){
            //TODO: support string from string resource
            throw InvalidNoteException("The title of note can't be empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of note can't be empty.")
        }
        repository.insertNote(note)
    }
}