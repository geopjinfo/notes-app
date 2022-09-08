package ae.aicenter.tuts.android.noteapp.feature_note.data.data_source

import ae.aicenter.tuts.android.noteapp.feature_note.domain.model.Note
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object{
        const val DATABASE_NAME="notes_db"
    }
}