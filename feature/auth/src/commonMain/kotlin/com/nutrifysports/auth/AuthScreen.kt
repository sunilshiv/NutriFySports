package com.nutrifysports.auth

import ContentWithMessageBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase
import com.nutrifysports.auth.component.GoogleButton
import com.nutrifysports.shared.Alpha
import com.nutrifysports.shared.BebasNeueFontFamily
import com.nutrifysports.shared.FontSize
import com.nutrifysports.shared.Surface
import com.nutrifysports.shared.SurfaceBrand
import com.nutrifysports.shared.SurfaceError
import com.nutrifysports.shared.TextPrimary
import com.nutrifysports.shared.TextSecondary
import com.nutrifysports.shared.TextWhite
import rememberMessageBarState

@Composable
fun AuthScreen() {
    val rememberMessageBarState = rememberMessageBarState()
    var loadingState by remember { mutableStateOf(false) }

    Scaffold { padding ->
        ContentWithMessageBar(
            contentBackgroundColor = Surface,
            modifier = Modifier
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                ),
            messageBarState = rememberMessageBarState,
            errorMaxLines = 2,
            errorContainerColor = SurfaceError,
            errorContentColor = TextWhite,
            successContainerColor = SurfaceBrand,
            successContentColor = TextPrimary
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "NutriFySports",
                        textAlign = TextAlign.Center,
                        fontFamily = BebasNeueFontFamily(),
                        fontSize = FontSize.EXTRA_LARGE,
                        color = TextSecondary
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(Alpha.HALF),
                        text = "Sign in to continue",
                        textAlign = TextAlign.Center,
                        fontSize = FontSize.EXTRA_REGULAR,
                        color = TextPrimary
                    )
                }
                GoogleButtonUiContainerFirebase(
                    linkAccount = false,
                    onResult = { result ->
                        result.onSuccess { success ->
                            rememberMessageBarState.addSuccess("Authentication successful!")
                            loadingState = false
                        }.onFailure { error ->
                            if (error.message?.contains("A network error") == true) {
                                rememberMessageBarState.addError("Internet connection unavailable.")
                            } else if (error.message?.contains("Idtoken is null") == true) {
                                rememberMessageBarState.addError("Sign in cancelled")
                            } else {
                                rememberMessageBarState.addError(error.message ?: "Unknown")
                            }
                            loadingState = false
                        }

                    }
                ) {
                    GoogleButton(
                        loading = loadingState,
                        onClick = {
                            this@GoogleButtonUiContainerFirebase.onClick()
                        },
                    )
                }
            }

        }
    }
}