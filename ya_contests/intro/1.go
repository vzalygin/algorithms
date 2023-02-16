package intro

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	countMap := make(map[uint8]int)
	sl := make([]uint8, 0)
	sc := bufio.NewScanner(os.Stdin)
	for sc.Scan() {
		s := sc.Text()
		for i := range s {
			if s[i] != ' ' {
				countMap[s[i]] += 1
			}
		}
	}
	maxN := 0
	for k, n := range countMap {
		sl = append(sl, k)
		if maxN < n {
			maxN = n
		}
	}
	sort.Slice(sl, func(i, j int) bool {
		return sl[i] < sl[j]
	})
	for maxN > 0 {
		for _, n := range sl {
			if countMap[n] >= maxN {
				fmt.Print("#")
			} else {
				fmt.Print(" ")
			}
		}
		fmt.Print("\n")
		maxN--
	}
	for _, n := range sl {
		fmt.Print(string(n))
	}
}
