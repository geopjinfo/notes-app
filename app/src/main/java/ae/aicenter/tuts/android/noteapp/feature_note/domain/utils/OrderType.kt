package ae.aicenter.tuts.android.noteapp.feature_note.domain.utils

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
