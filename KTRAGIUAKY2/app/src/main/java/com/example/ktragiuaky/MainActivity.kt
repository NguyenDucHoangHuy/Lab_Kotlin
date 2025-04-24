package com.example.ktragiuaky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICheckerScreen()
        }
    }

}

@Composable
fun BMICheckerScreen() {
    var bmiInput by remember { mutableStateOf("") }
    val (color,label) = getBMIStatus(bmiInput)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = bmiInput,
            onValueChange = { bmiInput = it },
            label = { Text("Nhập chỉ số BMI") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Chỉ số bạn nhập: ${bmiInput}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .background(color = color, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {

            Text(text = label, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

fun getBMIStatus(bmiInput: String): Pair<Color,String>{
        val bmi = bmiInput.toFloatOrNull()
        return when{
            bmiInput.isBlank() -> Pair(Color.Gray, "Vui lòng nhập BMI")
            bmi == null -> Pair(Color.Gray, "Sai định dạng")
            bmi <= 0 -> Pair(Color.Gray, "Giá trị không hợp lệ")
            bmi < 18.5 -> Pair(Color.Blue, "Thiếu cân 😟")
            bmi < 25 -> Pair(Color.Green, "Bình thường 😎")
            bmi < 30 -> Pair(Color.Yellow, "Thừa cân 😅")
            bmi < 60 -> Pair(Color.Red, "Béo phì 😱")
            else -> Pair(Color.Gray, "Giá trị quá cao")
        }
}

