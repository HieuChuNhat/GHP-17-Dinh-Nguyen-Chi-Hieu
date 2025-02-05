package com.example.minitestlogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "login image",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "login to your account")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email address")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                Log.i("Credential", "Email : $email Password : $password")
            },
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password",
            modifier = Modifier.clickable { }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Or sign in with")
        Spacer(modifier = Modifier.height(18.dp))
        Row(

            ) {
            Image(
                painter = painterResource(id = R.drawable.face),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.gg),
                contentDescription = "Google",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Apple",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "Already Registered. ")
            Text(
                text = "Sign Up !",
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                }
            )
        }
    }

}