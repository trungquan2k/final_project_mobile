package com.example.jetsellbook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetsellbook.components.RoundedButton
import com.example.jetsellbook.components.SignInButton
import com.example.jetsellbook.components.TransparentTextField

import com.example.jetsellbook.R

@Composable
fun LoginScreen(

) {
    val emailValue = rememberSaveable{ mutableStateOf("") }
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Login Image",
            contentScale = ContentScale.Inside
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            ConstraintLayout {

                val (surface, fab) = createRefs()

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
                            text = "Welcome Back!",
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )

                        Text(
                            text = "Login to your Account",
                            style = MaterialTheme.typography.h5.copy(
                                color = MaterialTheme.colors.primary
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
                                imeAction = ImeAction.Next
                            )

                            TransparentTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Password",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()


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
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RoundedButton(
                                text = "Login",

                                onClick = {

                                }
                            )

                            ClickableText(
                                text = buildAnnotatedString {
                                    append("Do not have an Account?")

                                    withStyle(
                                        style = SpanStyle(
                                            color = MaterialTheme.colors.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                    ){
                                        append("Sign up")
                                    }
                                }
                            ){

                            }
                        }
                    }
                }

                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            top.linkTo(surface.top, margin = (-36).dp)
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.size(42.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Forward Icon",
                        tint = Color.White
                    )
                }
            }
        }

//        if(state.errorMessage != null){
//            EventDialog(
//                errorMessage = state.errorMessage,
//                onDismiss = onDismissDialog
//            )
//        }
    }


//    var isLoading by remember { mutableStateOf(false) }
//    val emailVal = remember { mutableStateOf("") }
//    val passwordVal = remember { mutableStateOf("") }
//    val passwordVisiblity = remember { mutableStateOf(false) }
//    val focusManager = LocalFocusManager.current
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colors.background)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.background),
//            contentDescription = "Login Image",
//            contentScale = ContentScale.Inside
//        )
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.BottomCenter
//        ) {
//            ConstraintLayout() {
//                val (surface, fab) = createRefs()
//                Surface(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(400.dp)
//                        .constrainAs(surface) {
//                            bottom.linkTo(parent.bottom)
//                        },
//                    color = Color.White,
//                    shape = RoundedCornerShape(
//                        topStartPercent = 8,
//                        topEndPercent = 8
//                    )
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        verticalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        Text(
//                            text = "Welcome Back!",
//                            style = MaterialTheme.typography.h4.copy(
//                                fontWeight = FontWeight.Medium
//                            )
//                        )
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 16.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.spacedBy(8.dp)
//                        ) {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                TransparentTextField(
//                                    textFieldValue = emailVal,
//                                    textLabel = "Email / Số điện thoại",
//                                    keyboardType = KeyboardType.Email,
//                                    keyboardActions = KeyboardActions(
//                                        onNext = {
//                                            focusManager.moveFocus(FocusDirection.Down)
//                                        }
//                                    ),
//                                    imeAction = ImeAction.Next
//                                )
//                                TransparentTextField(
//                                    textFieldValue = passwordVal,
//                                    textLabel = "Mật khẩu",
//                                    keyboardType = KeyboardType.Password,
//                                    keyboardActions = KeyboardActions(
//                                        onDone = {
//                                            focusManager.clearFocus()
//                                            viewModel.login(emailVal.value, passwordVal.value)
//                                        }
//                                    ),
//                                    imeAction = ImeAction.Done,
//                                    trailingIcon = {
//                                        IconButton(
//                                            onClick = {
//                                                passwordVisiblity.value = !passwordVisiblity.value
//                                            }
//                                        ) {
//                                            Icon(
//                                                painter = painterResource(id = R.drawable.password_eye),
//                                                modifier = Modifier.size(30.dp),
//                                                contentDescription = "",
//                                                tint = if (passwordVisiblity.value) Color.DarkGray else Color.Gray
//                                            )
//                                        }
//                                    },
//                                    visualTransformation = if (passwordVisiblity.value) {
//                                        VisualTransformation.None
//                                    } else {
//                                        PasswordVisualTransformation()
//                                    }
//                                )
//                                Spacer(modifier = Modifier.padding(10.dp))
//                            }
//                        }
//                        Column(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.spacedBy(8.dp)
//                        ) {
//                            RoundedButton(
//                                text = "Login",
//                                onClick = {
////                                    viewModel.login(emailVal.value, passwordVal.value)
//                                    JetSellBookRouter.navigateTo(Screen.HomePage)
//                                }
//                            )
//                            Row {
//                                SignInButton(
//                                    text = "Google",
//                                    icon = painterResource(id = R.drawable.ic_google),
//                                    loadingText = "Sign in",
//                                    isLoading = isLoading,
//                                    onClick = {
//
//                                    },
//                                )
//                                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
//                                SignInButton(
//                                    text = "Facebook",
//                                    icon = painterResource(id = R.drawable.ic_fb),
//                                    loadingText = "Sign in",
//                                    onClick = {
//                                    },
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
