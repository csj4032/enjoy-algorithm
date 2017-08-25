object s1934 {

	def main(args: Array[String]): Unit = {
		for (i <- 1 to readLine.toInt) {
			val t: Array[Int] = readLine() split (" ") take 2 map (_.toInt);
			println(t(0) * t(1) / gcd(t(0), t(1)));
		}
	}

	def gcd(a: Int, b: Int): Int = {
		if (b == 0) a;
		else gcd(b, a % b)
	}
}