package com.example.iddirapp.ui.screens.admin

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iddirapp.ui.theme.IddirAppTheme
import com.example.iddirapp.ui.theme.TealMain
import com.example.iddirapp.ui.components.BottomNavBar
import java.util.Locale

@Composable
fun SignUpScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            CurvedTopBackground()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 180.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Create an account",
                            style = MaterialTheme.typography.headlineSmall
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Full Name") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Date of Birth") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Address") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Phone Number") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { /* TODO: Add file picker */ }) {
                            Icon(Icons.Filled.CloudUpload, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Add File")
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Password") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = "", onValueChange = {},
                            label = { Text("Confirm Password") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { navController.navigate("verification") },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Submit")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurvedTopBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(220.dp)) {

        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height * 0.7f)
            quadraticBezierTo(
                width / 2, height,
                width, height * 0.7f
            )
            lineTo(width, 0f)
            close()
        }

        drawPath(
            path = path,
            color = TealMain,
            style = Fill
        )
    }
}
// ... existing code ...

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    IddirAppTheme {
        SignUpScreen(navController = rememberNavController())
    }
}