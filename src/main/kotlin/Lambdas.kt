package org.example

fun main() {

    //Android

    //OLD java code
//    button.setOnClickListener(new OnClickListener() {
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//        }
//    });

//    @Composable
//    fun MyButton() {
//        Button(onClick = {
//            println("Button clicked!")
//        }) {
//            Text("Click Me")
//        }
//    }

    //Function References
    //Allows passing existing functions as parameters without invoking them.
    //Function References: Simplify passing existing functions as parameters, enhancing code clarity.
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = numbers.filter(::isEven)
    println(evenNumbers) // Outputs: [2, 4, 6]

    //Inline Functions: Functions that are inlined at the call site to reduce the overhead of higher-order functions.
    //Improve performance by eliminating the creation of additional objects for higher-order functions, especially in performance-critical code sections.
    val result = performOperation(5, 3) { x, y -> x + y }
    println(result) // Outputs: 8

//   Implementing Functional Pipelines
//    The pipeline filters even numbers, maps them to their squares, and sorts them in descending order.
//    This approach promotes a declarative coding style, making the code easier to understand and maintain.
    val processedNumbers = numbers
        .filter { it % 2 == 0 }      // Keep even numbers
        .map { it * it }             // Square each number
        .sortedDescending()          // Sort in descending order

    println(processedNumbers) // Outputs: [36, 16, 4]




}

//Ex1
//fun <T, R> Collection<T>.fold(
//    initial: R,
//    combine: (acc: R, nextElement: T) -> R
//): R {
//    var accumulator: R = initial
//    for (element: T in this) {
//        accumulator = combine(accumulator, element)
//    }
//    return accumulator
//}

//Function References
fun isEven(number: Int) = number % 2 == 0

//inline functions
inline fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int ): Int {
    return operation(a, b)
}