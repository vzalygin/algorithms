package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	return rec(l1, l2, 0)
}

func rec(l1 *ListNode, l2 *ListNode, rem int) *ListNode {
	if l1 == nil && l2 == nil {
		if rem == 0 {
			return nil
		} else {
			return &ListNode{
				Val:  rem,
				Next: nil,
			}
		}
	}

	sum := rem
	var next1, next2 *ListNode
	if l1 != nil {
		sum += l1.Val
		next1 = l1.Next
	}
	if l2 != nil {
		sum += l2.Val
		next2 = l2.Next
	}

	return &ListNode{
		Val:  sum % 10,
		Next: rec(next1, next2, sum/10),
	}
}
