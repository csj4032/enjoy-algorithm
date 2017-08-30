package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	var a [] int
	fmt.Scan(&n)
	a = make([]int, n)
	for i := range a {
		fmt.Scan(&a[i])
	}
	sort.Ints(a)
	for _, x := range a {
		fmt.Println(x)
	}
}