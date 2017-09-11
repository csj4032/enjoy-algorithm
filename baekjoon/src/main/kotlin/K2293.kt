import java.util.*

var m: IntArray? = null

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    m = IntArray(n, { sc.nextInt() })
    println(recursive(0, k))
}

fun recursive(n: Int, k: Int): Int {
    if (k == 0) return 1
    if (k < 0 || m!!.size <= n) return 0
    return recursive(n, k - m!![n]) + recursive(n + 1, k)
}