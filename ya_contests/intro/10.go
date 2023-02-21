package intro

import (
	"fmt"
	"sort"
)

func main() {
	s := ""
	fmt.Scan(&s)
	dict := make(map[int32]int)
	l := len(s)
	for i, r := range s {
		dict[r] += (i + 1) * (l - i)
	}
	sl := make([]int32, 0)
	for k := range dict {
		sl = append(sl, k)
	}
	sort.Slice(sl, func(i, j int) bool {
		return sl[i] < sl[j]
	})
	for _, v := range sl {
		fmt.Print(string(v), ": ", dict[v], "\n")
	}
}
