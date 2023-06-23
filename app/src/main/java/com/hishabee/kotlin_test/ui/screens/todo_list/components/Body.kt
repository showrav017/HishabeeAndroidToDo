package com.hishabee.kotlin_test.ui.screens.todo_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hishabee.kotlin_test.R

@Composable
fun Body(showNewToDoInputDialog: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize())
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        )
        {
            itemsIndexed(listOf("", "","", "","", "","", "","", "","", "","", "","", "","", "","",
                "","", "","", "","", "","", "","", "","", "","", "","", "","", "","", "","", ""
            )) { index, content ->
                Item()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Box(Modifier.align(Alignment.BottomCenter)) {
            BottomLinearGradient()
            Button(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 30.dp),
                onClick = {
                    showNewToDoInputDialog()
                          },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
                contentPadding = ButtonDefaults.ContentPadding
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}

@Preview
@Composable
fun Item()
{
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(
                "Item",
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp)
                    .padding(10.dp),
                style = MaterialTheme.typography.titleMedium
                    .copy(
                        textDecoration = TextDecoration.LineThrough,
                        color = MaterialTheme.colorScheme.primary
                    )
            )

            Icon(
                imageVector = Icons.Filled.Done,
                tint = colorResource(id = R.color.white),
                contentDescription = "",
                modifier = Modifier.background(colorResource(id = R.color.light_teal), RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))
    }
}

@Composable
fun BottomLinearGradient() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.transparent),
                        colorResource(id = R.color.offwhite)
                    )
                )
            )
    ) {}
}

