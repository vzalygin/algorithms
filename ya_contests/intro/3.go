package intro

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)
	set := make(map[int]bool)
	a := make([]int, 0)
	for i := 0; i < n; i++ {
		var num int
		fmt.Scan(&num)
		if _, ok := set[num]; !ok {
			set[num] = true
			a = append(a, num)
		}
	}
	sort.Slice(a, func(i, j int) bool {
		return a[i] < a[j]
	})

	var k int
	fmt.Scan(&k)
	b := make([]int, k)
	for i := 0; i < k; i++ {
		var target int
		fmt.Scan(&target)
		b[i] = sort.Search(len(a), func(i int) bool {
			return a[i] >= target
		})
	}
	for _, n := range b {
		fmt.Println(n)
	}
}
