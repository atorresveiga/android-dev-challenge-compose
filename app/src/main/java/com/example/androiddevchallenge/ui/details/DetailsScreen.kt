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
package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetRepository
import com.example.androiddevchallenge.ui.shared.Info
import com.example.androiddevchallenge.ui.shared.InfoHeader
import com.example.androiddevchallenge.ui.shared.QuickInfo
import com.example.androiddevchallenge.ui.theme.HappyPetShelterIcons

@Composable
fun DetailsScreen(petId: String, upPress: () -> Unit) {
    val pet = remember(petId) { PetRepository.getPet(petId) }
    DetailsScreen(pet, upPress)
}

@Composable
fun DetailsScreen(pet: Pet, upPress: () -> Unit) {
    val (liked, onLiked) = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            InfoHeader(photo = pet.photo, liked = liked, onLiked = onLiked)
            DetailsAppBar(upPress)
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .widthIn(max = 600.dp)
        ) {
            QuickInfo(pet)
            InfoDetails(pet)
            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Button(onClick = {}) {
            Text(
                text = stringResource(id = R.string.button_apply),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun InfoDetails(pet: Pet) {
    Column {
        val modifier = Modifier.padding(top = 24.dp)
        Info(
            title = stringResource(id = R.string.label_why_im_here),
            description = pet.WIH,
            modifier = modifier
        )
        Info(
            title = stringResource(id = R.string.label_behaviour),
            description = pet.behaviour,
            modifier = modifier
        )
        Info(
            title = stringResource(id = R.string.label_description),
            description = pet.description,
            modifier = modifier
        )
    }
}

@Composable
fun DetailsAppBar(onNavigationClick: () -> Unit) {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier
            .height(80.dp),
        backgroundColor = Color.Transparent
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { onNavigationClick() }
        ) {
            Icon(
                imageVector = HappyPetShelterIcons.ArrowBack,
                contentDescription = stringResource(id = R.string.label_back),
                tint = MaterialTheme.colors.secondaryVariant
            )
        }
    }
}
