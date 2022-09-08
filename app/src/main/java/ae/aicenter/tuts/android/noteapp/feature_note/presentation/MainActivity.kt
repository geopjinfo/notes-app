package ae.aicenter.tuts.android.noteapp.feature_note.presentation

import ae.aicenter.tuts.android.noteapp.ui.theme.NoteAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                ScreenContent()
            }
        }
    }
}

@Composable
private fun ScreenContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    NoteAppTheme {
        ScreenContent()
    }
}