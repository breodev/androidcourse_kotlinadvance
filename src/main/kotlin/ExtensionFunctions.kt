package org.example

import kotlinx.coroutines.*

// Extension function for String to validate email format
fun String.isValidEmail(): Boolean {
//    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    return true;
}

fun String.capitalizeWords(): String = this.split(" ").joinToString(" ") { it.capitalize() }

fun String.removeWhitespace(): String = this.replace("\\s".toRegex(), "")

val String.lengthWithoutSpaces: Int
    get() = this.replace(" ", "").length


//fun main() {
//
//    val myString: String = "hello world"
//    println(myString.isValidEmail())
//
//    println(myString.capitalizeWords())
//    println(myString.removeWhitespace())
//
//    println(myString.lengthWithoutSpaces) // Outputs: 10
//}

//Limitations and Best Practices
//
//Cannot Access Private Members: Extension functions cannot access private members of the class they are extending.
//Scope Resolution: If a member function and an extension function have the same signature, the member function takes precedence.
//Avoid Overuse: While powerful, overusing extension functions can lead to code that’s hard to navigate. Use them judiciously to enhance clarity.
//
//Best Practices:
//
//Meaningful Names: Ensure that extension functions have clear and descriptive names to indicate their purpose.
//Grouping Related Extensions: Organize extension functions logically, such as grouping them in separate files or objects based on functionality.
//Avoid Side Effects: Extension functions should avoid modifying the state of the object they extend unless explicitly intended.
//Documentation: Document extension functions thoroughly to clarify their behavior and usage.
