/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.architecture.blueprints.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.architecture.blueprints.todoapp.R
import java.util.UUID

/**
 * Immutable model class for a Task. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param title title of the task
 * @param description description of the task
 * @param isCompleted whether or not this task is completed
 * @param id id of the task
 */
@Entity(tableName = "tasks")
data class Task @JvmOverloads constructor(
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "completed") var isCompleted: Boolean = false,
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "countdown") var countdown : Int = 0 // saved countdown in Room DB for persistence - Christopher
    ) {

    val buttonText : Int
        get() = if (isCountDownFinished) R.string.delete else R.string.undo

    val countdownText : String
        get() = if (isCountDownFinished) "" else "$countdown - "

    val isCountDownFinished : Boolean
        get() = countdown == 0

    val titleForList: String
        get() = if (title.isNotEmpty()) title else description

    val isActive
        get() = !isCompleted

    val isEmpty
        get() = title.isEmpty() || description.isEmpty()
}
