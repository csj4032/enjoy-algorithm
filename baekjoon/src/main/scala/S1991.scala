import java.util.Scanner

object S1991 {

  val node: Array[String] = new Array[String](2048)

  def main(args: Array[String]): Unit = {
    val sc: Scanner = new Scanner(System.in)
    val n = sc.nextInt()
    node(1) = "A"
    for (i: Int <- 1 to n) {
      val a = sc.next()
      val b = sc.next()
      val c = sc.next()
      val s = search(a)
      node(s * 2) = b
      node(s * 2 + 1) = c
    }
    proOrder(1)
    println()
    inOrder(1)
    println()
    postOrder(1)
  }

  def proOrder(i: Int): Unit = {
    if (node(i).equals(".")) return
    print(node(i))
    proOrder(i * 2)
    proOrder(i * 2 + 1)
  }

  def inOrder(i: Int): Unit = {
    if (node(i).equals(".")) return
    inOrder(i * 2)
    print(node(i))
    inOrder(i * 2 + 1)
  }

  def postOrder(i: Int): Unit = {
    if (node(i).equals(".")) return
    postOrder(i * 2)
    postOrder(i * 2 + 1)
    print(node(i))
  }

  def search(a: String): Int = {
    var r: Int = 1
    for (i: Int <- 1 until node.length) {
      if (a.equals(node(i))) {
        r = i
      }
    }
    return r
  }
}