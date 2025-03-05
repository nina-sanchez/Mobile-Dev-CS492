// Regina Sanchez
// OSU
// CS 492

package com.example.assignment3.data
import com.example.assignment3.R
import com.example.assignment3.model.Courses

class Datasource {
    fun getCourses(): List<Courses> {
        return listOf(
            Courses(R.string.my_name, "Assignment", 3, 1),
            Courses(R.string.title161, "CS", 161, 100),
            Courses(R.string.title162, "CS", 162, 100),
            Courses(R.string.title225, "CS", 225, 200),
            Courses(R.string.title261, "CS", 261, 200),
            Courses(R.string.title271, "CS", 271, 200),
            Courses(R.string.title290, "CS", 290, 200),
            Courses(R.string.title325, "CS", 325, 300),
            Courses(R.string.title340, "CS", 340, 300),
            Courses(R.string.title344, "CS", 344, 300),
            Courses(R.string.title361, "CS", 361, 300),
            Courses(R.string.title362, "CS", 362, 300),
            Courses(R.string.title467, "CS", 467, 400)
        )
    }
}