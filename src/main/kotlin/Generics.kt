package org.example

//Benefits of Generics:
//
//Type Safety: Ensures that type-related errors are caught at compile-time.
//Reusability: Enables writing reusable and flexible code components.
//Code Clarity: Makes the code more expressive and easier to understand.

//The Repository interface is generic, allowing it to handle any data type T.
//InMemoryRepository implements the Repository interface, providing a concrete implementation for storing items in memory.
//This pattern promotes code reuse and flexibility, enabling the same repository structure to handle different data types.

data class UserForGenerics(val name: String)

interface Repository<T> {
    fun add(item: T)
    fun remove(item: T)
    fun getAll(): List<T>
}

class InMemoryRepository<T> : Repository<T> {
    private val items = mutableListOf<T>()

    override fun add(item: T) {
        items.add(item)
    }

    override fun remove(item: T) {
        items.remove(item)
    }

    override fun getAll(): List<T> = items.toList()
}

//fun main() {
//    // Usage
//     val userRepository: Repository<UserForGenerics> = InMemoryRepository()
//    userRepository.add(UserForGenerics("Alice"))
//    val users = userRepository.getAll()
//    println(users) // Outputs: [User(name=Alice)]
//}

//Variance: in and out Keywords
//Variance annotations help manage type hierarchies in generics, ensuring type safety when dealing with subtypes.
//Covariance (out): Allows a generic type to be a subtype if its type parameter is a subtype. Suitable for producer-only types.

interface Producer<out T> {
    fun produce(): T
}

//Contravariance (in): Allows a generic type to be a supertype if its type parameter is a supertype. Suitable for consumer-only types.

interface Consumer<in T> {
    fun consume(item: T)
}

//Invariant: The default behavior where no variance is specified. The generic type is neither a subtype nor a supertype.
//
//Example: Covariant and Contravariant Interfaces

fun main() {
    val stringProducer: Producer<String> = object : Producer<String> {
        override fun produce(): String = "Hello"
    }

    val anyProducer: Producer<Any> = stringProducer // Covariance allows this

    val anyConsumer: Consumer<Any> = object : Consumer<Any> {
        override fun consume(item: Any) {
            println(item)
        }
    }

    val stringConsumer: Consumer<String> = anyConsumer // Contravariance allows this
}

//Explanation:
//
//Covariance: Producer<String> can be assigned to Producer<Any> because Producer is covariant (out).
//Contravariance: Consumer<Any> can be assigned to Consumer<String> because Consumer is contravariant (in).
//This flexibility allows for more versatile and type-safe code.
