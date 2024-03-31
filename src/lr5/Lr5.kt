package lr5

fun main() {
    val queue = ArrayListQueue<Int>()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    println(queue.count) // 3

    val element = queue.dequeue()
    println(element) // 1

    println(queue.isEmpty) // false

    val peekedElement = queue.peek()
    println(peekedElement) // 2

    queue.dequeue()
    queue.dequeue()

    println(queue.isEmpty) // true
}