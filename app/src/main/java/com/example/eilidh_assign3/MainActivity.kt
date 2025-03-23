package com.example.eilidh_assign3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.eilidh_assign3.data.Challenge
import com.example.eilidh_assign3.data.challenges
import com.example.eilidh_assign3.ui.theme.Eilidh_assign3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Eilidh_assign3Theme {
                ChallengeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun ChallengeApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ChallengeAppBar() }
    ){ innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(challenges){
                ChallengeItem(
                    challenge = it,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun ChallengeItem(
    challenge: Challenge,
    modifier: Modifier=Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if(expanded) MaterialTheme.colorScheme.onPrimary
                      else MaterialTheme.colorScheme.secondaryContainer
    )

    Card(
        modifier = modifier
    ){
        Column(
            modifier = Modifier
                .background(color = color)
        ){
            Row(modifier = modifier.fillMaxWidth()){
                ChallengeInformation(
                    challenge.chlngeDay,
                    challenge.chlngeName
                )
                Spacer(modifier = Modifier.weight(1f))
                ChallengeItemButton(
                    expanded = expanded,
                    onClick = {expanded=!expanded}
                )
            }
            if(expanded){
                ChallengeDesc(
                    challenge.imageResourceId,
                    challenge.chlngeDesc,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun ChallengeDesc(
    @DrawableRes chlngeImg: Int,
    @StringRes chlngeDesc: Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
    ){
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small)),
            painter = painterResource(chlngeImg),
            contentDescription = null
        )
        Column(
            modifier = Modifier
        ){
            Text(
                text = "Challenge Description"
            )
            Text(
                text = stringResource(chlngeDesc)
            )
        }
    }
}

@Composable
fun ChallengeItemButton(
    expanded: Boolean,
    onClick: ()->Unit
){
    IconButton(
        onClick = onClick
    ){
        Icon(
            imageVector = if(expanded) Icons.Filled.KeyboardArrowUp
                          else Icons.Filled.KeyboardArrowDown,
            contentDescription = null
        )
    }
}

@Composable
fun ChallengeInformation(
    @StringRes chlngeDay: Int,
    @StringRes chlngeName: Int
){
    Row(){
        Text(
            text = stringResource(chlngeDay)
        )
        Text(
            text = stringResource(chlngeName)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Eilidh_assign3Theme {
        ChallengeApp()
    }
}