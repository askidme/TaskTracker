package com.codergm.model

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Task(
    val id: String = generateId(),
    val title: String,
    val description: String,
    val dueDate: String? = null, // Format: yyyy-MM-dd
    val priority: Priority = Priority.MEDIUM,
    var status: Status = Status.PENDING
)

@Serializable
enum class Priority {
    LOW, MEDIUM, HIGH
}

@Serializable
enum class Status {
    PENDING, COMPLETED
}
fun generateId(): String = List(8) {
    Random.nextInt(0, 16).toString(16)
}.joinToString("")