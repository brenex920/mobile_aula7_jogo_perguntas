package com.aulasandroid.jogorespostas.component

import android.media.tv.TvContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aulasandroid.jogorespostas.R

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.quiz),
        contentDescription = "imc logo",
        modifier = Modifier
            .size(100.dp)
            .padding(vertical = 20.dp)
    )
}