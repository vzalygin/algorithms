package intro

import "fmt"

func main() {
	n, m, k := 0, 0, 0
	fmt.Scan(&n, &m, &k)
	matrix := [1005][1005]int{}
	for i := 0; i < n; i++ {
		sum := 0
		for j := 1; j < m+1; j++ {
			inp := 0
			fmt.Scan(&inp)
			sum += inp
			matrix[i][j] = sum
		}
	}
	for p := 0; p < k; p++ {
		x1, x2, y1, y2, sum := 0, 0, 0, 0, 0
		fmt.Scan(&x1, &y1, &x2, &y2)
		for i := x1 - 1; i < x2; i++ {
			sum += matrix[i][y2] - matrix[i][y1-1]
		}
		fmt.Println(sum)
	}
}
