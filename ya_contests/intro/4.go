package intro

import "fmt"

func main() {
	var n, k, x, y int
	fmt.Scan(&n, &k, &x, &y)
	p := (x-1)*2 + y
	v1 := p + k
	v2 := p - k
	if v1 <= n || v2 > 0 {
		if (v1 <= n) && (!(v2 > 0) || (v1+1)/2-x <= x-(v2+1)/2) {
			fmt.Println((v1+1)/2, (v1+1)%2+1)
		} else {
			fmt.Println((v2+1)/2, (v2+1)%2+1)
		}
	} else {
		fmt.Println(-1)
	}
}
