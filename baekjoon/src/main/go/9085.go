package main

import "fmt"

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var n, k int
		fmt.Scanf("%d", &n)
		for j := 0; j < n; j++ {
			var m int
			fmt.Scan(&m)
			k += m
		}
		fmt.Println(k)
	}
}