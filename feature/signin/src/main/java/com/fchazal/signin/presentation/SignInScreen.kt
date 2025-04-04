package com.fchazal.signin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.animation.ToolingState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.fchazal.signin.presentation.SignInScreenType.DONE
import com.fchazal.signin.presentation.SignInScreenType.EMAIL
import com.fchazal.signin.presentation.SignInScreenType.SYNC
import com.fchazal.signin.presentation.composable.DoneSignIn
import com.fchazal.signin.presentation.composable.EmailSignIn
import com.fchazal.signin.presentation.composable.SyncSignIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    state: State<SignInState>,
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
                EMAIL -> EmailSignIn(state.value, {email, password ->
                    pagerState.requestScrollToPage(1)
                    onSignInClick(email, password)
                })
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
fun SignInScreenPreview(
    @PreviewParameter(SignInStateParameterProvider::class) state: SignInState,
) {
    SignInScreen(
        state = ToolingState(state),
        onSignInClick = { _, _ -> }
    )
}

private class SignInStateParameterProvider : PreviewParameterProvider<SignInState> {
    override val values: Sequence<SignInState>
        get() = listOf(
            SignInState.Loading,
            SignInState.Success(
                token = ""
            ),
            SignInState.Error(
                error = ""
            )
        ).asSequence()
}
