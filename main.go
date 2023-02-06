package main

import "fmt"

func main() {
	f := []int{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11} // 3
	e := []int{7, 14, 4, 14, 13, 2, 6, 13}        // 3
	t := []int{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}     // 6
	fmt.Println(totalSteps(f))
	fmt.Println(totalSteps(e))
	fmt.Println(totalSteps(t))
}
