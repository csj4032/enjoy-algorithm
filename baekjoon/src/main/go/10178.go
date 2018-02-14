package main

import (
	"fmt"
)

func main() {
	var t int
	fmt.Scanf("%d", &t)
	k := make([]int, t)
	p := make([]int, t)

	for i := 0; i < t; i++ {
		var n int
		var m int
		fmt.Scanf("%d", &n)
		fmt.Scanf("%d", &m)
		k[i] = (n - (n % m)) / m
		p[i] = n % m
	}

	for i := 0; i < t; i++ {
		fmt.Printf("You get %d piece(s) and your dad gets %d piece(s).\n", k[i], p[i])
	}
}