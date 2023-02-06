package main

//type ListNode struct {
//	Val  int
//	Next *ListNode
//}

func mergeKLists(lists []*ListNode) *ListNode {
	var minI, min int
	isFound := false
	for i, list := range lists {
		if list != nil {
			if !isFound || min > list.Val {
				minI = i
				min = list.Val
				isFound = true
			}
		}
	}

	if isFound {
		lists[minI] = lists[minI].Next
		return &ListNode{
			Val:  min,
			Next: mergeKLists(lists),
		}
	} else {
		return nil
	}
}
