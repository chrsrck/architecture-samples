package com.example.android.architecture.blueprints.todoapp.data

class TaskWrapper(
        val task : Task,
        var countdown : Int
) {

    val buttonText : String
        get() = if (countdown == 0) "Delete" else "Undo"

    val countdownText : String
        get() = if (countdown == 0) "" else "$countdown - "

}