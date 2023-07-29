package com.mashup.presentation.feature.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.presentation.R
import com.mashup.presentation.ui.common.KeyLinkButton
import com.mashup.presentation.ui.common.KeyLinkMintText
import com.mashup.presentation.ui.theme.*

@Composable
fun NotificationPermissionRoute(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit = {},
    requestNotificationPermission: () -> Unit = {}
) {
    NotificationPermissionScreen(modifier = modifier)
}

@Composable
fun NotificationPermissionScreen(
    modifier: Modifier,
    navigateToHome: () -> Unit = {},
    requestNotificationPermission: () -> Unit = {}
) {
    BackHandler(true) {
        navigateToHome()
    }

    Scaffold(
        backgroundColor = Black,
        modifier = modifier.fillMaxSize()
    ) {
        NotificationPermissionContent(
            modifier = modifier.padding(it),
            navigateToHome = navigateToHome,
            requestNotificationPermission = requestNotificationPermission
        )
    }
}

@Composable
fun NotificationPermissionContent(
    modifier: Modifier,
    navigateToHome: () -> Unit,
    requestNotificationPermission: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = modifier.height(85.dp))
        NotificationPermissionTitle(modifier = modifier)
        Spacer(modifier = modifier.height(48.dp))
        NotificationPermissionGuideImage(modifier = modifier.weight(1f))
        NotificationPermissionGuideBottomButtons(
            navigateToHome = navigateToHome,
            requestNotificationPermission = requestNotificationPermission
        )
    }
}

@Composable
fun NotificationPermissionTitle(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.notification_subtitle),
            style = Body2,
            color = Gray05
        )
        KeyLinkMintText(
            text = stringResource(id = R.string.notification_signal),
            modifier = Modifier
        )
    }
}

@Composable
fun NotificationPermissionGuideImage(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 48.dp)
    ) {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.img_notificationsenabled),
            contentDescription = stringResource(id = R.string.notification_img_content_description),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun NotificationPermissionGuideBottomButtons(
    navigateToHome: () -> Unit,
    requestNotificationPermission: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 20.dp)
    ) {
        KeyLinkButton(
            text = stringResource(id = R.string.get_notification),
            modifier = Modifier.fillMaxWidth(),
            onClick = requestNotificationPermission

        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 2.dp)
                .clickable {
                    navigateToHome()
                },
            text = stringResource(id = R.string.notification_disallow),
            style = Body1,
            color = Gray06,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewNotificationPermissionGuideScreen() {
    SsamDTheme {
        NotificationPermissionScreen(modifier = Modifier)
    }
}
