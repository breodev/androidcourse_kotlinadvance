package org.example


//Delegation
//
//Delegation is a design pattern where an object handles a request by delegating to a second helper object.
// Kotlin provides built-in support for delegation, making it easier to implement.
//The User class delegates the Logger interface to the provided logger instance.
//This allows User to use the log function without explicitly implementing it, promoting code reuse and separation of concerns.

//Class Delegation

interface Logger {
    fun log(message: String)
}

class ConsoleLogger : Logger {
    override fun log(message: String) {
        println("ConsoleLogger: $message")
    }
}

class User(val name: String, logger: Logger) : Logger by logger {
    fun createUser() {
        log("User $name created.")
    }
}

class UserWithoutDelegation(val name: String): Logger {
    override fun log(message: String) {
        println("ConsoleLogger: $message")
    }
    fun createUser() {
        log("User $name created.")
    }
}

//fun main() {
//    // Usage
//    val logger = ConsoleLogger()
//    val user = User("Alice", logger)
//    user.createUser() // Outputs: ConsoleLogger: User Alice created.
//}


//Example: Property Delegation with lazy
//The configValue property is delegated to lazy, meaning it is initialized only when accessed for the first time.
//Subsequent accesses use the cached value, improving performance by avoiding unnecessary computations.

class Configuration {
    val configValue: String by lazy {
        println("Loading configuration...")
        "Config123"
    }
}


fun main() {
    // Usage
    val config = Configuration()
    println(config.configValue) // Triggers lazy initialization
    println(config.configValue) // Uses cached value
}

