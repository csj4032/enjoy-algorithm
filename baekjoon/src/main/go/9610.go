package main

import "fmt"

func main() {
	var t int
	var q1, q2, q3, q4, axis int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var x, y int
		fmt.Scan(&x)
		fmt.Scan(&y)

		if x == 0 || y == 0 {
			axis++
		}

		if x > 0 && y > 0 {
			q1++
		}

		if x < 0 && y > 0 {
			q2++
		}

		if x < 0 && y < 0 {
			q3++
		}

		if x > 0 && y < 0 {
			q4++
		}
	}

	fmt.Printf("Q1: %d\n", q1)
	fmt.Printf("Q2: %d\n", q2)
	fmt.Printf("Q3: %d\n", q3)
	fmt.Printf("Q4: %d\n", q4)
	fmt.Printf("AXIS: %d", axis)
}