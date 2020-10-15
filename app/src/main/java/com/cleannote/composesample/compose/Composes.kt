package com.cleannote.composesample.compose

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.cleannote.composesample.R

@Composable
fun ItemTextHolder(text: String, childViews: @Composable () -> Unit){
    val isExpended = remember { mutableStateOf(false) }
    Text(text, Modifier.clickable(onClick = { isExpended.value = isExpended.value == false }))
    if (isExpended.value) childViews()
}

@Composable
fun ListView(list: List<String>){
    ScrollableColumn(Modifier.padding(15.dp).fillMaxSize()) {

        list.forEachIndexed { index, value ->
            if (index % 10 == 0) HeaderView(index / 10)
            ItemTextHolder(value){
                ChildListView(index)
            }
            Spacer(Modifier.padding(3.dp))
            if (index == list.lastIndex) FooterView()
        }

    }
}

@Composable
fun HeaderView(pageNum: Int){
    Surface(color = colorResource(R.color.header_bg)) {
        Row(modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 3.dp), horizontalArrangement = Arrangement.Center){
            Text("Header #$pageNum")
        }
    }
}

@Composable
fun FooterView(){
    Surface(color = colorResource(R.color.footer_bg)) {
        Row(modifier = Modifier.fillMaxWidth().padding(top = 3.dp, bottom = 3.dp), horizontalArrangement = Arrangement.Center){
            Text("Don't Exist Items", color = Color.White)
        }
    }
}

@Composable
fun ChildListView(count: Int){
    ScrollableColumn(Modifier.padding(start = 5.dp).wrapContentWidth().preferredHeightIn(minHeight = 50.dp, maxHeight = 250.dp)){
        (0 .. count).forEachIndexed { index, i ->
            ChildItemTextHolder("-- $i ChildNumber")
        }
    }
}

@Composable
fun ChildItemTextHolder(text: String){
    Text(text, color = Color.Magenta)
}