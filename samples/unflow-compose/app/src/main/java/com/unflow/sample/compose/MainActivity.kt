package com.unflow.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.unflow.androidsdk.ui.opener.Opener
import com.unflow.sample.compose.theme.UnflowComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnflowComposeTheme {
                Scaffold(
                    topBar = { TopBar() },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            // Place the Opener composable wherever you'd like to display the
                            // Unflow opener banner(s)
                            Opener()
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) }
    )
}
