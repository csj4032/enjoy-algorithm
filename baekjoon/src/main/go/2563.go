package main

import "fmt"

const w = 100
const w2 = 10

func main() {
	var t int
	var c int
	fmt.Scanf("%d", &t)
	var m = make([][2]int, t)

	for i := 0; i < t; i++ {
		fmt.Scan(&m[i][0], &m[i][1])
	}

	for i := 0; i < w; i++ {
		for j := 0; j < w; j++ {
			for k := 0; k < t; k++ {
				if m[k][1] <= j && j < (m[k][1]+w2) && m[k][0] <= i && i < (m[k][0]+w2) {
					c++
					break
				}
			}
		}
	}

	fmt.Print(c)
}