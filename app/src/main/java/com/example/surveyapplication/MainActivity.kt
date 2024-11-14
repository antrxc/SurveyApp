package com.example.surveyapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surveyapplication.ui.theme.SurveyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var databaseHelper: SurveyDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = SurveyDatabaseHelper(this)
        setContent {
            FormScreen(this, databaseHelper)
        }
    }
}

@Composable
fun FormScreen(context: Context, databaseHelper: SurveyDatabaseHelper) {

    // Define state for form fields
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var genderOptions = listOf("Rarely", "Sometimes", "Frequently")
    var selectedGender by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var diabeticsOptions = listOf("Yes", "No")
    var selectedDiabetics by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            text = "Survey on Sleep Patterns and Health",
            color = Color(0xFF1976D2)  // Blue header color
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "What is your full name?", fontSize = 15.sp, color = Color.Black)  // Black text color
        TextField(
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFBBDEFB),
                focusedIndicatorColor = Color(0xFF2196F3),
                unfocusedIndicatorColor = Color(0xFF2196F3)
            ),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(text = "What is your age?", fontSize = 15.sp, color = Color.Black)  // Black text color
        TextField(
            value = age,
            onValueChange = { age = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFBBDEFB),
                focusedIndicatorColor = Color(0xFF2196F3),
                unfocusedIndicatorColor = Color(0xFF2196F3)
            ),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(text = "Describe your current health condition.", fontSize = 15.sp, color = Color.Black)  // Black text color
        TextField(
            value = mobileNumber,
            onValueChange = { mobileNumber = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFBBDEFB),
                focusedIndicatorColor = Color(0xFF2196F3),
                unfocusedIndicatorColor = Color(0xFF2196F3)
            ),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(text = "Trouble falling asleep?", fontSize = 15.sp, color = Color.Black)  // Black text color
        RadioGroup(
            options = genderOptions,
            selectedOption = selectedGender,
            onSelectedChange = { selectedGender = it }
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(text = "Consulted a doctor?", fontSize = 15.sp, color = Color.Black)  // Black text color
        RadioGroup(
            options = diabeticsOptions,
            selectedOption = selectedDiabetics,
            onSelectedChange = { selectedDiabetics = it }
        )

        Text(
            text = error,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                if (name.isNotEmpty() && age.isNotEmpty() && mobileNumber.isNotEmpty() && selectedGender.isNotEmpty() && selectedDiabetics.isNotEmpty()) {
                    val survey = Survey(
                        id = null,
                        name = name,
                        age = age,
                        mobileNumber = mobileNumber,
                        gender = selectedGender,
                        diabetics = selectedDiabetics
                    )
                    databaseHelper.insertSurvey(survey)
                    error = "Survey Completed"
                } else {
                    error = "Please fill all fields"
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1976D2)),  // Blue button color
            modifier = Modifier.padding(start = 70.dp).size(height = 35.dp, width = 200.dp)
        ) {
            Text(text = "Submit", color = Color.White)
        }
    }
}

@Composable
fun RadioGroup(
    options: List<String>,
    selectedOption: String?,
    onSelectedChange: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { onSelectedChange(option) }
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 15.sp,
                    color = Color.Black  // Black text color for options
                )
            }
        }
    }
}
