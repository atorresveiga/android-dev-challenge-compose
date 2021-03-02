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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import java.util.Locale

@Composable
fun InfoTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.h4,
        modifier = modifier
    )
}

@Composable
fun InfoDescription(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        style = MaterialTheme.typography.body2,
        modifier = modifier
    )
}

@Composable
fun InfoTag(
    tag: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.subtitle2
) {
    Text(
        text = tag.toUpperCase(Locale.ROOT),
        style = style,
        modifier = modifier
    )
}

@Composable
fun Info(title: String, description: String, modifier: Modifier = Modifier) {
    InfoTitle(title = title, modifier = modifier.fillMaxWidth())
    InfoDescription(
        description = description,
        modifier = modifier
    )
}
