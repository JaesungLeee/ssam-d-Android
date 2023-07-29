package com.mashup.presentation.feature.report

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.presentation.R
import com.mashup.presentation.ui.common.KeyLinkToolbar
import com.mashup.presentation.ui.theme.*

/**
 * Ssam_D_Android
 * @author jaesung
 * @created 2023/07/01
 */
@Composable
fun ReportRoute(
    onBackClick: () -> Unit,
    onReportIconClick: () -> Unit,
    onShowSnackbar: (String, SnackbarDuration) -> Unit,
    modifier: Modifier = Modifier,
) {
    ReportScreen(
        modifier = modifier,
        onBackClick = onBackClick,
        onReportIconClick = onReportIconClick,
        onShowSnackbar = onShowSnackbar
    )
}

@Composable
fun ReportScreen(
    onBackClick: () -> Unit,
    onReportIconClick: () -> Unit,
    onShowSnackbar: (String, SnackbarDuration) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        backgroundColor = Black,
        topBar = {
            KeyLinkToolbar(
                onClickBack = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 8.dp, start = 20.dp, end = 20.dp),
        ) {
            ReportHeader(modifier = Modifier.fillMaxWidth())

            ReportContent(
                modifier = Modifier.padding(top = 28.dp),
                onReportIconClick = onReportIconClick,
                onShowSnackbar = onShowSnackbar
            )
        }
    }
}

@Composable
fun ReportContent(
    onReportIconClick: () -> Unit,
    onShowSnackbar: (String, SnackbarDuration) -> Unit,
    modifier: Modifier = Modifier
) {
    val reportOptions = stringArrayResource(id = R.array.report)
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(reportOptions) {
            ReportTypeContent(
                reportType = it,
                onReportIconClick = onReportIconClick,
                onShowSnackbar = onShowSnackbar,
            )
        }
    }
}

@Composable
fun ReportTypeContent(
    reportType: String,
    onReportIconClick: () -> Unit,
    onShowSnackbar: (String, SnackbarDuration) -> Unit,
    modifier: Modifier = Modifier
) {
    val snackbarMessage = stringResource(R.string.snackbar_report)
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable {
                    onReportIconClick()
                    onShowSnackbar(snackbarMessage, SnackbarDuration.Short)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = reportType,
                style = Body1,
                color = White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right_24),
                tint = White,
                contentDescription = stringResource(R.string.content_description_report),
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray03,
            thickness = 1.dp
        )
    }
}

@Composable
fun ReportHeader(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.report_title),
        style = Heading3,
        color = White
    )
}

@Preview(showBackground = true, backgroundColor = 0XFFFFFFFF)
@Composable
private fun ReportScreenPreview() {
    SsamDTheme {
        ReportScreen(
            onBackClick = {},
            onReportIconClick = {},
            onShowSnackbar = { _, _ -> }
        )
    }
}
