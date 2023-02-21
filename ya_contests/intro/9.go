package intro

import "fmt"

func main() {
	n, m, k := 0, 0, 0
	fmt.Scan(&n, &m, &k)
	matrix := make([][]int, n+1)
	matrix[0] = make([]int, m+1)
	for i := 1; i < n+1; i++ {
		matrix[i] = make([]int, m+1)
		for j := 1; j < m+1; j++ {
			inp := 0
			fmt.Scan(&inp)
			matrix[i][j] = inp + matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1]
		}
	}
	for p := 0; p < k; p++ {
		x1, x2, y1, y2 := 0, 0, 0, 0
		fmt.Scan(&x1, &y1, &x2, &y2)
		x1--
		y1--
		sum := matrix[x2][y2] - matrix[x2][y1] - matrix[x1][y2] + matrix[x1][y1]
		fmt.Println(sum)
	}
}
