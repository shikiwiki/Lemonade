package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(Color.Yellow),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = MaterialTheme.typography.headlineLarge.fontStyle
        )
        Spacer(modifier = modifier.weight(1f))
        when (currentStep) {
            1 -> {
                squeezeCount = (2..4).random()
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = stringResource(id = R.string.tree),
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            currentStep = 2
                        })
                Spacer(modifier = modifier.weight(0.2f))
                Text(
                    text = stringResource(id = R.string.tap_tree),
                    modifier = modifier.weight(1f),
                    fontSize = 18.sp
                )
            }

            2 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = stringResource(id = R.string.lemon),
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        })
                Spacer(modifier = modifier.weight(0.2f))
                Text(
                    text = stringResource(id = R.string.keep_tapping),
                    modifier = modifier.weight(1f),
                    fontSize = 18.sp
                )
            }

            3 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = stringResource(id = R.string.glass),
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            currentStep = 4
                        })
                Spacer(modifier = modifier.weight(0.2f))
                Text(
                    text = stringResource(id = R.string.tap_glass),
                    modifier = modifier.weight(1f),
                    fontSize = 18.sp
                )
            }

            4 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = stringResource(id = R.string.lemonade),
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            currentStep = 1
                        })
                Spacer(modifier = modifier.weight(0.2f))
                Text(
                    text = stringResource(id = R.string.tap_lemonade),
                    modifier = modifier.weight(1f),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}