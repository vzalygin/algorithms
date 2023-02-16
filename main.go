package main

import (
	"errors"
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

func (s *Stack) peek() (int, error) {
	if s.size > 0 {
		return s.value[s.size-1], nil
	} else {
		return 0, errors.New("peek empty stack")
	}
}

func (s *Stack) push(num int) {
	s.value = append(s.value, num)
	s.size += 1
}

func main() {

}
