package stack_2

import (
	"errors"
	"fmt"
)

type Stack struct {
	size  int
	value []int32
}

func (s *Stack) pop() (int32, error) {
	if s.size > 0 {
		s.size -= 1
		e := s.value[s.size]
		s.value = s.value[:s.size]
		return e, nil
	} else {
		return 0, errors.New("pop empty s")
	}
}

func (s *Stack) push(new int32) {
	s.value = append(s.value, new)
	s.size += 1
}

func main() {
	stack := Stack{}
	str := ""
	fmt.Scan(&str)
	for _, ch := range str {
		switch {
		case ch == '(' || ch == '[' || ch == '{':
			stack.push(ch)
		case ch == ')':
			if last, err := stack.pop(); err != nil || last != '(' {
				fmt.Println("no")
				return
			}
		case ch == ']':
			if last, err := stack.pop(); err != nil || last != '[' {
				fmt.Println("no")
				return
			}
		case ch == '}':
			if last, err := stack.pop(); err != nil || last != '{' {
				fmt.Println("no")
				return
			}
		}
	}
	if stack.size == 0 {
		fmt.Println("yes")
	} else {
		fmt.Println("no")
	}
}
