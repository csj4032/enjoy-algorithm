package main

import (
	"fmt"
	"sort"
)

func main() {
	var s [] int
	var n int
	fmt.Scanf("%d", &n)
	s = append(s, n)
	fmt.Scanf("%d", &n)
	s = append(s, n)
	fmt.Scanf("%d", &n)
	s = append(s, n)
	sort.Ints(s)

	for i, x := range s {
		fmt.Print(x)
		if i != len(s)-1 {
			fmt.Print(" ")
		}
	}
}