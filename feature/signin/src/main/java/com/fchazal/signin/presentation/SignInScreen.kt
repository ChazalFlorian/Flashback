package com.fchazal.signin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fchazal.signin.presentation.SignInScreenType.DONE
import com.fchazal.signin.presentation.SignInScreenType.EMAIL
import com.fchazal.signin.presentation.SignInScreenType.SYNC
import com.fchazal.signin.presentation.composable.DoneSignIn
import com.fchazal.signin.presentation.composable.EmailSignIn
import com.fchazal.signin.presentation.composable.SyncSignIn

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: (String, String) -> Unit,

    ) {
    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { SignInScreenType.entries.size })

    HorizontalPager(pagerState) { index ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            when (SignInScreenType.entries[index]) {
                EMAIL -> EmailSignIn(onSignInClick)
                SYNC -> SyncSignIn()
                DONE -> DoneSignIn()
            }
        }
    }
}

private enum class SignInScreenType {
    EMAIL,
    SYNC,
    DONE
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(
        state = SignInState.Success(
            token = ""
        ),
        onSignInClick = { _, _ -> }
    )
}
