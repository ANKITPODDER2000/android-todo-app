package com.example.todoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LowPriority = Color(0xFF00C980)
val MediumPriority = Color(0xFFFFC114)
val HighPriority = Color(0xFFFF4646)
val NonePriority = Color(0xFFFFFFFF)


val ColorScheme.scaffoldContainerColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color.Black else Purple40

val ColorScheme.scaffoldContentColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color(0xFFFCFCFC) else Color.White


val ColorScheme.todoContainerColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color(0x4D000000) else Color(0x1A000000)
val ColorScheme.todoItemContainerColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color(0XFF000000) else Color(0XFFFFFFFF)
val ColorScheme.todoContentColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color(0XFFFFFFFF) else Color(0XFF000000)