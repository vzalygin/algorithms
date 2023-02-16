package stacks

import (
	"bufio"
	"errors"
	"fmt"
	"os"
	"strconv"
	"strings"
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
	b := bufio.NewScanner(os.Stdin)
	s := Stack{}
	for b.Scan() {
		ss := strings.Split(b.Text(), " ")
		switch ss[0] {
		case "pop":
			if num, err := s.pop(); err == nil {
				fmt.Println(num)
			} else {
				fmt.Println("error")
			}
		case "back":
			if num, err := s.peek(); err == nil {
				fmt.Println(num)
			} else {
				fmt.Println("error")
			}
		case "size":
			fmt.Println(s.size)
		case "push":
			{
				num, _ := strconv.Atoi(ss[1])
				s.push(num)
				fmt.Println("ok")
			}
		case "clear":
			s = Stack{}
			fmt.Println("ok")
		case "exit":
			fmt.Println("bye")
			return
		}
	}
}
