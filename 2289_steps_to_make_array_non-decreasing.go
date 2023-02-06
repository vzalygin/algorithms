package main

func max(nums ...int) int {
	var m int
	for _, n := range nums {
		if m < n {
			m = n
		}
	}
	return m
}

func totalSteps(nums []int) int {
	maxSteps := 0
	steps := 0
	last := 0
	lastMax := 0

	for _, num := range nums {
		if lastMax <= num { // последовательность неубывает
			maxSteps = max(maxSteps, steps)
			steps = 0
			lastMax = num
		} else {
			if last > num && last != lastMax {
			} else {
				steps += 1
			}
		}
		last = num
	}

	maxSteps = max(maxSteps, steps)
	return maxSteps
}
