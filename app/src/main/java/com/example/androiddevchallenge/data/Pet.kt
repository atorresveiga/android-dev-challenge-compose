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
package com.example.androiddevchallenge.data

import java.util.UUID

data class Pet(
    val id: String,
    val age: Float,
    val name: String,
    val color: String,
    val sex: String,
    val breed: String,
    val photo: String,
    val WIH: String,
    val description: String,
    val behaviour: String
)

/**
 * A fake repo
 */
object PetRepository {

    fun getPets(): List<Pet> = pets
    fun getPet(petId: String): Pet = pets.find { it.id == petId }!!

    private val rufus = Pet(
        id = UUID.randomUUID().toString(),
        age = 1f,
        name = "Rufus",
        color = "black",
        sex = "male",
        breed = "pug",
        photo = "photo-1517849845537-4d257902454a".toUnsplashUrl(),
        WIH = "Suspendisse vitae mi sit amet lectus posuere pellentesque. Suspendisse vel egestas massa, a aliquet leo. Nunc pellentesque enim a leo egestas, non elementum leo finibus. Cras ullamcorper diam et mauris dictum, quis sodales metus ullamcorper. Ut aliquam magna in nulla semper aliquet. Quisque non tempor augue. Sed ut est ac elit maximus convallis nec sit amet eros. Donec ultrices tristique mi a dapibus.",
        description = "Nam tincidunt sem ipsum, eu lobortis purus mollis sed. Curabitur nec sem metus. Cras ac quam vel eros aliquam consectetur. Nullam ut erat sagittis, porttitor risus id, venenatis ligula. Phasellus felis urna, pharetra vitae metus ut, imperdiet lacinia ante. Ut non pulvinar dui, non luctus sem.",
        behaviour = "Duis ex diam, vehicula a pellentesque at, accumsan a tortor.",
    )

    private val paco = Pet(
        id = UUID.randomUUID().toString(),
        age = 2.6f,
        name = "Trufa",
        color = "white",
        sex = "female",
        breed = "Poodle",
        photo = "photo-1569841900685-02d57111fbfa".toUnsplashUrl(),
        WIH = "Suspendisse vitae mi sit amet lectus posuere pellentesque. Suspendisse vel egestas massa, a aliquet leo. Nunc pellentesque enim a leo egestas, non elementum leo finibus. Cras ullamcorper diam et mauris dictum, quis sodales metus ullamcorper. Ut aliquam magna in nulla semper aliquet. Quisque non tempor augue. Sed ut est ac elit maximus convallis nec sit amet eros. Donec ultrices tristique mi a dapibus.",
        description = "Nam tincidunt sem ipsum, eu lobortis purus mollis sed. Curabitur nec sem metus. Cras ac quam vel eros aliquam consectetur. Nullam ut erat sagittis, porttitor risus id, venenatis ligula. Phasellus felis urna, pharetra vitae metus ut, imperdiet lacinia ante. Ut non pulvinar dui, non luctus sem.",
        behaviour = "Duis ex diam, vehicula a pellentesque at, accumsan a tortor.",
    )

    private val rintintin = Pet(
        id = UUID.randomUUID().toString(),
        age = 0.3f,
        name = "Rin Tin Tin",
        color = "brown, black",
        sex = "male",
        breed = "German Shepperd",
        photo = "photo-1578362613743-cb09ce05275d".toUnsplashUrl(),
        WIH = "Suspendisse vitae mi sit amet lectus posuere pellentesque. Suspendisse vel egestas massa, a aliquet leo. Nunc pellentesque enim a leo egestas, non elementum leo finibus. Cras ullamcorper diam et mauris dictum, quis sodales metus ullamcorper. Ut aliquam magna in nulla semper aliquet. Quisque non tempor augue. Sed ut est ac elit maximus convallis nec sit amet eros. Donec ultrices tristique mi a dapibus.",
        description = "Nam tincidunt sem ipsum, eu lobortis purus mollis sed. Curabitur nec sem metus. Cras ac quam vel eros aliquam consectetur. Nullam ut erat sagittis, porttitor risus id, venenatis ligula. Phasellus felis urna, pharetra vitae metus ut, imperdiet lacinia ante. Ut non pulvinar dui, non luctus sem.",
        behaviour = "Duis ex diam, vehicula a pellentesque at, accumsan a tortor.",
    )

    private val firulais = Pet(
        id = UUID.randomUUID().toString(),
        age = 0.7f,
        name = "Firulais",
        color = "brown, black, white",
        sex = "male",
        breed = "Crossbred",
        photo = "photo-1588054384802-88b17ab0d288".toUnsplashUrl(),
        WIH = "Suspendisse vitae mi sit amet lectus posuere pellentesque. Suspendisse vel egestas massa, a aliquet leo. Nunc pellentesque enim a leo egestas, non elementum leo finibus. Cras ullamcorper diam et mauris dictum, quis sodales metus ullamcorper. Ut aliquam magna in nulla semper aliquet. Quisque non tempor augue. Sed ut est ac elit maximus convallis nec sit amet eros. Donec ultrices tristique mi a dapibus.",
        description = "Nam tincidunt sem ipsum, eu lobortis purus mollis sed. Curabitur nec sem metus. Cras ac quam vel eros aliquam consectetur. Nullam ut erat sagittis, porttitor risus id, venenatis ligula. Phasellus felis urna, pharetra vitae metus ut, imperdiet lacinia ante. Ut non pulvinar dui, non luctus sem.",
        behaviour = "Duis ex diam, vehicula a pellentesque at, accumsan a tortor.",
    )

    private val pets = listOf(rufus, paco, rintintin, firulais)
}

fun String.toUnsplashUrl(): String = "https://images.unsplash.com/$this?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"

fun Float.toReadableAge(): String = when (this) {
    0.1f -> "1 month"
    in 0.2f..0.99f -> "${(this * 10).toInt()} months"
    1f -> "1 year"
    else -> "${this.toInt()} years"
}
