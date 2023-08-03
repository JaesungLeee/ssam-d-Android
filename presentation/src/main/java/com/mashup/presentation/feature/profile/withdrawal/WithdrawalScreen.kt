package com.mashup.presentation.feature.profile.withdrawal

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.presentation.ui.common.KeyLinkButton
import com.mashup.presentation.ui.common.KeyLinkToolbar
import com.mashup.presentation.ui.theme.*

/**
 * Ssam_D_Android
 * @author jaesung
 * @created 2023/08/03
 */
@Composable
fun WithdrawalRoute(
    onBackClick: () -> Unit,
    onWithdrawal: () -> Unit,
    onShowSnackbar: (String, SnackbarDuration) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WithdrawalViewModel = hiltViewModel()
) {
    val uiEvent by viewModel.eventFlow.collectAsStateWithLifecycle(Idle)

    when (uiEvent) {
        Withdrawal -> onWithdrawal()
        is Failure -> onShowSnackbar((uiEvent as Failure).message.orEmpty(), SnackbarDuration.Short)
        else -> Unit
    }

    WithdrawalScreen(
        onBackClick = onBackClick,
        onWithdrawalClick = viewModel::withdrawal,
        modifier = modifier
    )
}

@Composable
fun WithdrawalScreen(
    onBackClick: () -> Unit,
    onWithdrawalClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        backgroundColor = Black,
        topBar = {
            KeyLinkToolbar(
                title = {
                    Text(
                        text = "키링 탈퇴하기",
                        style = Body2,
                        color = White
                    )
                },
                onClickBack = onBackClick
            )
        }
    ) { paddingValues ->
        val innerPaddingValues =
            PaddingValues(top = paddingValues.calculateTopPadding(), start = 20.dp, end = 20.dp)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingValues),
        ) {

            KeyLinkButton(
                modifier = Modifier.fillMaxWidth(),
                text = "탈퇴 요청하기",
                backgroundColor = Gray02,
                onClick = onWithdrawalClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WithdrawalScreenPreview() {
    SsamDTheme {
        WithdrawalScreen(onBackClick = { /*TODO*/ }, onWithdrawalClick = { /*TODO*/ })
    }
}

