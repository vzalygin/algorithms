package stack_5

import "fmt"

type Pair struct {
	A, B int
}

type Stack struct {
	size  int
	value []Pair
}

func (s *Stack) pop() Pair {
	if s.size > 0 {
		s.size -= 1
		e := s.value[s.size]
		s.value = s.value[:s.size]
		return e
	} else {
		return Pair{}
	}
}

func (s *Stack) peek() Pair {
	if s.size > 0 {
		return s.value[s.size-1]
	} else {
		return Pair{}
	}
}

func (s *Stack) push(new Pair) {
	s.value = append(s.value, new)
	s.size += 1
}

func main() {
	length := 0
	fmt.Scan(&length)
	res := make([]int, length)
	stack := Stack{}
	for i := 0; i < length; i++ {
		num := 0
		fmt.Scan(&num)
		for p := stack.peek(); p.B > num && stack.size > 0; p = stack.peek() {
			p := stack.pop()
			res[p.A] = i
		}
		stack.push(Pair{
			A: i,
			B: num,
		})
	}
	for _, n := range res {
		if n == 0 {
			fmt.Print(-1, " ")
		} else {
			fmt.Print(n, " ")
		}
	}
}
