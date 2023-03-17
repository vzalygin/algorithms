package queue_1

import (
	"bufio"
	"errors"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Queue struct {
	head, tail, size int
	data             []int
}

func empty() Queue {
	return Queue{}
}

func (e *Queue) push(n int) {
	if e.size == cap(e.data) {
		cap := cap(e.data)
		newData := make([]int, 2*cap+1)
		for i := 0; i < e.size; i++ {
			j := (i + e.head) % cap
			newData[i] = e.data[j]
		}
		e.data = newData
		e.head = 0
		e.tail = e.size
	}
	e.data[e.tail] = n
	e.tail = (e.tail + 1) % cap(e.data)
	e.size += 1
}

func (e *Queue) pop() (int, error) {
	if e.size > 0 {
		popped := e.data[e.head]
		e.size -= 1
		e.head = (e.head + 1) % cap(e.data)
		return popped, nil
	} else {
		return 0, errors.New("pop empty queue")
	}
}

func (e *Queue) peek() (int, error) {
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
		case "push":
			n, err := strconv.Atoi(args[1])
			if err == nil {
				q.push(n)
				fmt.Println("ok")
			}
		case "pop":
			n, err := q.pop()
			if err == nil {
				fmt.Println(n)
			} else {
				fmt.Println("error")
			}
		case "front":
			n, err := q.peek()
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
