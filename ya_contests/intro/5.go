package intro

import "fmt"

func min(first int, other ...int) int {
	min := first
	for _, n := range other {
		if n < min {
			min = n
		}
	}
	return min
}

func main() {
	var n int
	fmt.Scan(&n)
	var prev int
	fmt.Scan(&prev)
	goodness := 0
	for i := 1; i < n; i++ {
		var num int
		fmt.Scan(&num)
		goodness += min(prev, num)
		prev = num
	}
	fmt.Println(goodness)
}
