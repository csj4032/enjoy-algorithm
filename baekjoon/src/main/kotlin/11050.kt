import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    var s = +K11050().recursive(n, k)
    println(s)
}

open class K11050 {
    fun recursive(n: Int, k: Int): Int {
        if (k == 0 || n == k) return 1
        return recursive(n - 1, k - 1) + recursive(n - 1, k)
    }
}