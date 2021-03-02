/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.toReadableAge
import com.example.androiddevchallenge.ui.theme.HappyPetShelterIcons
import com.example.androiddevchallenge.ui.theme.HappyPetShelterTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun QuickInfo(pet: Pet, modifier: Modifier = Modifier, textStartMargin: Dp = 0.dp) {
    Column(
        modifier = modifier.widthIn(max = 600.dp),
        horizontalAlignment = Alignment.Start
    ) {
        InfoTag(
            pet.breed,
            modifier = Modifier
                .padding(top = 24.dp, start = textStartMargin),
            style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.secondary)
        )
        InfoTitle(
            title = pet.name,
            modifier = Modifier
                .padding(start = textStartMargin)
        )
        val tags = "${pet.sex} \u00B7 ${pet.age.toReadableAge()} \u00B7 ${pet.color}"
        InfoTag(
            tags,
            modifier = Modifier
                .padding(top = 8.dp, start = textStartMargin)
        )
    }
}

@Composable
fun InfoHeader(
    photo: String,
    liked: Boolean,
    onLiked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = modifier.fillMaxWidth()
    ) {
        CoilImage(
            data = photo,
            contentDescription = null,
            fadeIn = true,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .heightIn(min = 420.dp, max = 480.dp)
                .scrim(colors = listOf(Color(0x33000000), Color(0x11FFFFFF)))
        )
        LikeButton(liked = liked, onLiked = onLiked)
    }
}

@Composable
fun LikeButton(
    liked: Boolean,
    onLiked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier.padding(16.dp),
        onClick = { onLiked(!liked) },
    ) {
        if (!liked) {
            Icon(
                imageVector = HappyPetShelterIcons.FavoriteBorder,
                contentDescription = "add to favorites",
                tint = MaterialTheme.colors.secondaryVariant
            )
        } else {
            Icon(
                imageVector = HappyPetShelterIcons.Favorite,
                contentDescription = "add to favorites",
                tint = MaterialTheme.colors.secondaryVariant
            )
        }
    }
}

@Composable
@Preview
fun LikeButtonPreview() {
    val (liked, onLiked) = remember { mutableStateOf(false) }
    HappyPetShelterTheme {
        Surface {
            Column {
                LikeButton(
                    liked = liked, onLiked = onLiked
                )
            }
        }
    }
}

/**
 * A [Modifier] which draws a vertical gradient
 */
fun Modifier.scrim(colors: List<Color>): Modifier = drawWithContent {
    drawContent()
    drawRect(Brush.verticalGradient(colors))
}
