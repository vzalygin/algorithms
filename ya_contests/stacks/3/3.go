package stack_3

import (
	"errors"
	"fmt"
	"strconv"
)

type Stack struct {
	size  int
	value []int
}

func (s *Stack) pop() (int, error) {
	if s.size > 0 {
		s.size -= 1
		e := s.value[s.size]
		s.value = s.value[:s.size]
		return e, nil
	} else {
		return 0, errors.New("pop empty s")
	}
}

func (s *Stack) push(new int) {
	s.value = append(s.value, new)
	s.size += 1
}

func main() {
	stack := Stack{}
	str := ""
	for _, err := fmt.Scan(&str); err == nil; _, err = fmt.Scan(&str) {
		switch str {
		case "+":
			a, _ := stack.pop()
			b, _ := stack.pop()
			stack.push(a + b)
		case "-":
			a, _ := stack.pop()
			b, _ := stack.pop()
			stack.push(b - a)
		case "*":
			a, _ := stack.pop()
			b, _ := stack.pop()
			stack.push(a * b)
		default:
			num, err := strconv.Atoi(str)
			if err == nil {
				stack.push(num)
			}
		}
	}
	res, _ := stack.pop()
	fmt.Println(res)
}
