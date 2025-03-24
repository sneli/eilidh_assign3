package com.example.eilidh_assign3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
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
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.icon_size))
                        .padding(end = dimensionResource(R.dimen.padding_small))
                )
                Text(
                    text = "30 Day Photography Challenge",
                    style = MaterialTheme.typography.displayMedium
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
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
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
        targetValue = if(expanded) MaterialTheme.colorScheme.surface
                      else MaterialTheme.colorScheme.errorContainer
    )

    Card(
        modifier = modifier
    ){
        Column(
            modifier = Modifier
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
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
                    modifier = Modifier.padding(
                        end = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
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
        modifier = modifier
    ){
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(
                    start = dimensionResource(R.dimen.padding_small),
                    top = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small),
                    end = 0.dp
                ),
            painter = painterResource(chlngeImg),
            contentDescription = null
        )
        Column(
            modifier = modifier
        ){
            Text(
                text = "Challenge Description:",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(chlngeDesc),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
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
    Column(){
        Text(
            text = stringResource(chlngeDay),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = stringResource(chlngeName),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium))
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