package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	fmt.Scanf("%d", &n)
	s := strings.Repeat("1", n) + strings.Repeat("0", n-1)
	fmt.Print(s)
}