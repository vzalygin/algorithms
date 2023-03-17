package intro

import "fmt"

func main() {
	n := 0
	minX, minY, maxX, maxY := 0, 0, 0, 0
	fmt.Scan(&n)

	fmt.Scan(&minX, &minY)
	maxX, maxY = minX, minY
	for i := 1; i < n; i++ {
		x, y := 0, 0
		fmt.Scan(&x, &y)
		if x > maxX {
			maxX = x
		}
		if x < minX {
			minX = x
		}
		if y > maxY {
			maxY = y
		}
		if y < minY {
			minY = y
		}
	}
	fmt.Println(minX, minY, maxX, maxY)
}
