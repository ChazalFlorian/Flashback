package com.fchazal.signin.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fchazal.feature.signin.R
import com.fchazal.signin.presentation.SignInState

@Composable
fun EmailSignIn(
    state: SignInState,
    onSignInClick: (String, String) -> Unit,
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val successComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.illustration_done)
    )
    val successProgress by animateLottieCompositionAsState(successComposition)

    val loadingComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.illustration_loading)
    )
    val loadingProgress by animateLottieCompositionAsState(loadingComposition)

    Column {
        TextField(
            value = email.value,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChange = { email.value = it},
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password.value,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange = { password.value = it},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            }
        )

        when (state) {
            is SignInState.Error -> {
                Text(text = state.error)
            }

            SignInState.Loading -> {
                LottieAnimation(
                    modifier = Modifier.background(Color(0xFF25C9B9)),
                    composition = loadingComposition,
                    progress = { loadingProgress },
                )
            }

            is SignInState.Success -> {
                LottieAnimation(
                    modifier = Modifier.background(Color(0xFF25C9B9)),
                    composition = successComposition,
                    progress = { successProgress },
                )
            }

            SignInState.Unconnected -> {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {
                            onSignInClick(email.value, password.value)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Sign In")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun EmailSignInPreview() {
}

@Composable
fun TextField(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}