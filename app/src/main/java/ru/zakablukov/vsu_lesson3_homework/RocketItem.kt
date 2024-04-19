package ru.zakablukov.vsu_lesson3_homework

data class RocketItem(
    val name: String,
    val launchSite: String,
    val launchDate: String,
    val drawableId: Int,
    val isActive: Boolean = false
)
