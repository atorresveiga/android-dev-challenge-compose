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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PetRepository
import com.example.androiddevchallenge.ui.shared.InfoHeader
import com.example.androiddevchallenge.ui.shared.QuickInfo
import com.example.androiddevchallenge.ui.theme.HappyPetShelterIcons

@Composable
fun HomeScreen(selectPet: (id: String) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { HomeAppBar() }
    ) {

        val pets = PetRepository.getPets()

        LazyRow(
            modifier = Modifier
                .background(MaterialTheme.colors.onSurface)
                .padding(bottom = 60.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(pets) { pet ->
                val (liked, onLiked) = remember { mutableStateOf(false) }
                Card(
                    modifier = modifier
                        .padding(16.dp)
                        .clickable { selectPet(pet.id) }
                        .widthIn(max = 380.dp)
                        .heightIn(min = 480.dp)
                        .aspectRatio(3 / 5f, true)
                ) {
                    Column {
                        InfoHeader(pet.photo, liked, onLiked, Modifier.weight(3f))
                        QuickInfo(
                            pet = pet,
                            textStartMargin = 24.dp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(bottom = 12.dp)
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(onClick = {}) {
                Text(
                    text = stringResource(id = R.string.button_filter),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun HomeAppBar() {
    TopAppBar(
        elevation = 2.dp,
        modifier = Modifier
            .height(86.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Text(
            text = stringResource(id = R.string.label_discover),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(24.dp)
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = {  }
        ) {
            Icon(
                imageVector = HappyPetShelterIcons.AccountCircle,
                contentDescription = stringResource(id = R.string.label_profile)
            )
        }
    }
}
