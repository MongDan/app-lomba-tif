package com.example.lombatif.component

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lombatif.R
import com.example.lombatif.ui.theme.LombaTIFTheme
import com.example.lombatif.viewModels.ViewRegisterUser

class Registrasi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            LombaTIFTheme(darkTheme = isDarkMode) {
               Register()
            }
        }
    }
}

@Composable
fun Register(viewRegisterUser: ViewRegisterUser = viewModel() ){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    val succes = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()){
        }
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "LombaTIF",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif
            )

            Spacer(modifier = Modifier.height(25.dp))

           Image(
               painter = painterResource(id = R.drawable.logotiflomba),
               contentDescription = "logoLomba",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .clip(CircleShape)
                   .size(120.dp)
           )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Register",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Competition Management Platfrom",
                fontSize = 15.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Username
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Username") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null)
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF1C3ED3),
                        focusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color(0xFF000000)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null)
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF1C3ED3),
                        focusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color(0xFF000000)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // PASSWORD
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF1C3ED3),
                        focusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color(0xFF000000)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // CONFIRM PASSWORD
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF1C3ED3),
                        focusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color(0xFF000000)
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp)
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        buildAnnotatedString {
                            append("I agree to the  ")

                            withStyle(
                                style = SpanStyle(
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("Terms and Conditions and Privacy Policy")
                            }
                        },
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = ({
                        if (!viewRegisterUser.validasi(email,password)){
                            showDialog.value = true
                        }else{
                            if (password == confirmPassword){
                                viewRegisterUser.postUser(name,email,password)
                                succes.value = true
                            }else{
                                Toast.makeText(context, "Password dan Konfirmasi Password tidak cocok", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C3ED3)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Register",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    buildAnnotatedString {
                        append("Already have an account? ")

                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Login")
                        }
                    },
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )

            }
        }

    if (showDialog.value){
        AlertDialog(
            onDismissRequest = {
                // Menutup dialog saat di luar dialog atau tombol close ditekan
                showDialog.value = false
            },
            title = {
                Text("Warning⚠️")
            },
            text = {
                Text(viewRegisterUser.stateUI)
            },
            confirmButton = {
                Button(onClick = {
                    // Tutup dialog saat tombol OK ditekan
                    showDialog.value = false
                }) {
                    Text("OK")
                }
            }

        )
    }
    if (succes.value) {
        AlertDialog(
            onDismissRequest = {
                // Menutup dialog saat di luar dialog atau tombol close ditekan
                succes.value = false
            },
            title = {
                Text("Succes 😂✅")
            },
            text = {
                Text(viewRegisterUser.stateUI)
            },
            confirmButton = {
                Button(onClick = {
                    // Tutup dialog saat tombol OK ditekan
                    succes.value = false
                }) {
                    Text("OK")
                }
            }

        )
    }
}

