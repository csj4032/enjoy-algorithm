package main

import "fmt"

func main() {
	var t int
	var k int
	for i := 0; i < 5; i++ {
		fmt.Scanf("%d", &k)
		t += k * k
	}

	fmt.Print(t % 10)
}