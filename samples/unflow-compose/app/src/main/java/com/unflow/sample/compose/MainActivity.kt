package com.unflow.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.unflow.androidsdk.UnflowSdk
import com.unflow.androidsdk.ui.opener.Opener
import com.unflow.androidsdk.ui.opener.OpenerItemState
import com.unflow.androidsdk.ui.opener.OpenerState
import com.unflow.androidsdk.ui.opener.rememberOpenerState
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
                            Column(Modifier.padding(vertical = 16.dp)) {
                                Header("Opener")
                                // Getting started is as simple as placing the Opener composable
                                // wherever you'd like to display the Unflow opener banner(s)
                                Opener()

                                Header("Custom opener item")
                                // Here's an example of how you can customise opener items
                                Opener(
                                    itemContent = { state ->
                                        OpenerItem(
                                            modifier = Modifier.size(width = 120.dp, height = 140.dp),
                                            state = state
                                        )
                                    }
                                )

                                Header("Custom opener layout")
                                // Or customise the layout of the openers completely – here we
                                // take just the first two and put them in a vertical list
                                val openerState = rememberOpenerState()
                                Opener(
                                    openerState = OpenerState(openerState.openers.take(2)),
                                    openerHost = { state ->
                                        LazyColumn(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            items(state.openers) {
                                                OpenerItemImpl(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(64.dp),
                                                    screenId = it.screenId,
                                                    imageUrl = it.imageUrl,
                                                    text = it.title
                                                )
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        style = MaterialTheme.typography.subtitle2
    )
}

@Composable
private fun OpenerItem(
    modifier: Modifier,
    state: OpenerItemState
) {
    OpenerItemImpl(
        modifier = modifier,
        screenId = state.opener.screenId,
        imageUrl = state.opener.imageUrl,
        text = state.opener.title
    )
}

@Composable
private fun OpenerItemImpl(
    modifier: Modifier,
    screenId: Long,
    imageUrl: String?,
    text: String
) {
    Box(
        modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                // Make sure to handle clicks
                UnflowSdk
                    .client()
                    .openScreen(screenId)
            }
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) }
    )
}
