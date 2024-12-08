package org.example.examples

import kotlinx.coroutines.*


//The fetchUser extension function on String uses coroutines to simulate fetching user data asynchronously.
//It leverages higher-order functions (async and await) to perform concurrent operations.
//This combination showcases how advanced Kotlin features can be integrated seamlessly to create efficient and readable code.


fun main() = runBlocking {
    // Using an extension function with coroutines
    val user = "alice@example.com".fetchUser()

    println(user)
}

suspend fun String.fetchUser(): User {
    return coroutineScope {
        // Simulate fetching user data asynchronously
        async {
            delay(1000)
            User(name = "Alice", email = this@fetchUser)
        }.await()
    }
}

data class User(val name: String, val email: String)