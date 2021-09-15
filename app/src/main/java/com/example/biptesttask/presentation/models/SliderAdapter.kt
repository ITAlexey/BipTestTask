package com.example.biptesttask.presentation.models

import com.example.biptesttask.presentation.command.Command

interface SliderAdapter : Command {
    val pageQuantity: Int
}