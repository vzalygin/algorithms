package main

import (
	"bufio"
	"errors"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Deque struct {
	head, tail, size int
	data             []int
}

func empty() Deque {
	return Deque{}
}

func (e *Deque) pushBack(n int) {
	if e.size == cap(e.data) {
		cap := cap(e.data)
		newData := make([]int, 2*cap+1)
		for i := 0; i < e.size; i++ {
			j := (i + e.head) % cap
			newData[i] = e.data[j]
		}
		e.data = newData
		e.head = 0
		e.tail = e.size - 1
	}
	e.tail = (e.tail + 1) % cap(e.data)
	e.size += 1
	e.data[e.tail] = n
}

func (e *Deque) pushFront(n int) {
	if e.size == cap(e.data) {
		cap := cap(e.data)
		newData := make([]int, 2*cap+1)
		for i := 0; i < e.size; i++ {
			j := (i + e.head) % cap
			newData[i+1] = e.data[j]
		}
		e.data = newData
		e.head = 1
		e.tail = e.size
	}
	e.head = (cap(e.data) + e.head - 1) % cap(e.data)
	e.size += 1
	e.data[e.head] = n
}

func (e *Deque) popFront() (int, error) {
	if e.size > 0 {
		popped := e.data[e.head]
		e.head = (e.head + 1) % cap(e.data)
		e.size -= 1
		return popped, nil
	} else {
		return 0, errors.New("popFront empty queue")
	}
}

func (e *Deque) popBack() (int, error) {
	if e.size > 0 {
		popped := e.data[e.tail]
		e.tail = (cap(e.data) + e.tail - 1) % cap(e.data)
		e.size -= 1
		return popped, nil
	} else {
		return 0, errors.New("popFront empty queue")
	}
}

func (e *Deque) back() (int, error) {
	if e.size > 0 {
		return e.data[e.tail], nil
	} else {
		return 0, errors.New("back empty queue")
	}
}

func (e *Deque) front() (int, error) {
	if e.size > 0 {
		return e.data[e.head], nil
	} else {
		return 0, errors.New("peek empty queue")
	}
}

func main() {
	q := empty()
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		args := strings.Split(scanner.Text(), " ")
		switch args[0] {
		case "push_front":
			n, err := strconv.Atoi(args[1])
			if err == nil {
				q.pushFront(n)
				fmt.Println("ok")
			}
		case "push_back":
			n, err := strconv.Atoi(args[1])
			if err == nil {
				q.pushBack(n)
				fmt.Println("ok")
			}
		case "pop_front":
			n, err := q.popFront()
			if err == nil {
				fmt.Println(n)
			} else {
				fmt.Println("error")
			}
		case "pop_back":
			n, err := q.popBack()
			if err == nil {
				fmt.Println(n)
			} else {
				fmt.Println("error")
			}
		case "front":
			n, err := q.front()
			if err == nil {
				fmt.Println(n)
			} else {
				fmt.Println("error")
			}
		case "back":
			n, err := q.back()
			if err == nil {
				fmt.Println(n)
			} else {
				fmt.Println("error")
			}
		case "size":
			fmt.Println(q.size)
		case "clear":
			q = empty()
			fmt.Println("ok")
		case "exit":
			fmt.Println("bye")
			return
		}
	}
}
