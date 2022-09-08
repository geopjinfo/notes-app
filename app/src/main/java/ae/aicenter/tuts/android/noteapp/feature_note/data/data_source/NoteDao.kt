package ae.aicenter.tuts.android.noteapp.feature_note.data.data_source

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getALlNotes():Flow<List<Note>>

    @Query("SELECT * FROM note WHERE _id=:id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}