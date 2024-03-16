package lr5

class ArrayListQueue<T : Any> : Queue<T> {
    private val arrayList = ArrayList<T>()

    override fun enqueue(element: T): Boolean {
        return arrayList.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) {
            null
        } else {
            arrayList.removeAt(0)
        }
    }

    override val count: Int
        get() = arrayList.size

    override fun peek(): T? {
        return if (isEmpty) {
            null
        } else {
            arrayList[0]
        }
    }
}