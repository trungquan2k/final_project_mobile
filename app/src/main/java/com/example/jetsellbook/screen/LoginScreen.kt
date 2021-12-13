

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

import com.example.jetsellbook.components.RoundedButton
import com.example.jetsellbook.components.TransparentTextField
import com.example.jetsellbook.viewmodel.MainViewModel
import com.example.jetsellbook.R
import com.example.jetsellbook.components.EventDialog


@Composable
fun LoginScreen(
    viewModel: MainViewModel,
) {
    val emailValue = rememberSaveable{ mutableStateOf("") }
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_signin),
            contentDescription = "Login Image",
            contentScale = ContentScale.Inside
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            // position of box login
            contentAlignment = Alignment.BottomCenter
        ){
            ConstraintLayout {
                val (surface) = createRefs()
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){
                        Text(
                            text = "Welcome Jet Sell Book!",
                            style = MaterialTheme.typography.h5.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                            TransparentTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email",
                                keyboardType = KeyboardType.Email,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next,
                            )
                            TransparentTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Password",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()
                                        viewModel.addlogin(emailValue.value, passwordValue.value)
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.password_eye),
                                            modifier = Modifier.size(30.dp),
                                            contentDescription = "",
                                            tint = if (passwordVisibility) Color.DarkGray else Color.Gray
                                        )
                                    }
                                },
                                visualTransformation = if(passwordVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                }
                            )
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Forgot Password?",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.End
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RoundedButton(
                                text = "Login",
                                onClick = {
                                    viewModel.addlogin(emailValue.value, passwordValue.value)
                                }
                            )
                        }
                    }
                }
            }
        }
        if(viewModel.state.value.errorMessage != null){
            EventDialog(
                errorMessage = viewModel.state.value.errorMessage!!,
                onDismiss = { viewModel.hideErrorDialog() }
            )
        }
    }
}















