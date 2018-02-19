package main

import (
	"fmt"
)

func main() {
	var a int
	var b int
	var c int
	var d int
	var p int
	var x int
	var y int
	var f int

	fmt.Scanf("%d", &a)
	fmt.Scanf("%d", &b)
	fmt.Scanf("%d", &c)
	fmt.Scanf("%d", &d)
	fmt.Scanf("%d", &p)

	x = a * p

	if p > c {
		y = ((p - c) * d) + b
	} else {
		y = b
	}

	if x > y {
		f = y
	} else {
		f = x
	}

	fmt.Print(f)

}