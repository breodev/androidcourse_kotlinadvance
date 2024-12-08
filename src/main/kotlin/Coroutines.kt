package org.example

import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//fun main() = runBlocking {
//    println("Start fetching user data...")
//    val userData = fetchUserData()
//    println("User Data: $userData")
//}
//
//suspend fun fetchUserData(): String {
//    delay(2000) // Simulate network delay
//    return "John Doe"
//}

//Example: Using async for Concurrent Operations
//Two coroutines are launched concurrently using async.
//await is called to retrieve the results once both coroutines complete.
//This approach reduces the total execution time compared to running tasks sequentially

//fun main() = runBlocking {
//    val deferred1 = async { fetchDataFromSource1() }
//    val deferred2 = async { fetchDataFromSource2() }
//
//    val result1 = deferred1.await()
//    val result2 = deferred2.await()
//
//    println("Results: $result1 and $result2")
//}
//
//suspend fun fetchDataFromSource1(): String {
//    delay(1000)
//    return "Data from Source 1"
//}
//
//suspend fun fetchDataFromSource2(): String {
//    delay(1500)
//    return "Data from Source 2"
//}


//Supervisor Jobs: Allows child coroutines to fail independently without affecting the parent or other children.
//Example: Using SupervisorJob
//
//A SupervisorJob allows child coroutines to fail independently without canceling the entire scope.
//The first coroutine attempts to fetch data, while the second coroutine simulates a failure.
//The first coroutine continues to completion despite the failure in the second coroutine.

//fun main() = runBlocking {
//    val supervisor = SupervisorJob()
//    val scope = CoroutineScope(Dispatchers.Default + supervisor)
//
//    scope.launch {
//        try {
//            fetchData()
//        } catch (e: Exception) {
//            println("Caught exception: ${e.message}")
//        }
//    }
//
//    scope.launch {
//        delay(500)
//        throw RuntimeException("Failed to fetch data")
//    }
//
//    delay(2000) // Wait for coroutines to finish
//}
//
//suspend fun fetchData() {
//    delay(1000)
//    println("Data fetched successfully")
//}


//Exception Handling in Coroutines
//Try-Catch Blocks: Surround coroutine code with try-catch to handle exceptions.
//CoroutineExceptionHandler: Define a global exception handler for uncaught exceptions.
//A CoroutineExceptionHandler is defined to catch uncaught exceptions.
//When the coroutine throws an AssertionError, the handler catches and prints it.

//fun main() = runBlocking {
//    val handler = CoroutineExceptionHandler { _, exception ->
//        println("Caught $exception")
//    }
//
//    val job = GlobalScope.launch(handler) {
//        throw AssertionError("My custom assertion error")
//    }
//
//    job.join()
//}