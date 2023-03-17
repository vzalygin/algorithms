package stack_4

import (
	"fmt"
)

type Stack struct {
	size  int
	value []int
}

func (s *Stack) pop() int {
	if s.size > 0 {
		s.size -= 1
		e := s.value[s.size]
		s.value = s.value[:s.size]
		return e
	} else {
		return 0
	}
}

func (s *Stack) peek() int {
	if s.size > 0 {
		return s.value[s.size-1]
	} else {
		return 0
	}
}

func (s *Stack) push(new int) {
	s.value = append(s.value, new)
	s.size += 1
}

func main() {
	n := 0
	stack := Stack{}
	last := 0

	fmt.Scan(&n)
	for i := 0; i < n; i++ {
		n := 0
		fmt.Scan(&n)
		for n > stack.peek() && stack.size > 0 {
			popped := stack.pop()
			if popped < last {
				fmt.Println("NO")
				return
			} else {
				last = popped
			}
		}
		stack.push(n)
	}
	if stack.peek() < last {
		fmt.Println("NO")
	} else {
		fmt.Println("YES")
	}
}
