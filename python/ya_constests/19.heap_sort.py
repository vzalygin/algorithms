def sift_down(heap, i, l):
    if i >= l:
        return
    i1, i2 = i*2+1, i*2+2
    if i1 < l and i2 < l:
        if heap[i1] < heap[i2] and heap[i1] < heap[i]:
            heap[i1], heap[i] = heap[i], heap[i1]
            sift_down(heap, i1, l)
        elif heap[i2] < heap[i]:
            heap[i2], heap[i] = heap[i], heap[i2]
            sift_down(heap, i2, l)
    elif i1 < l and heap[i1] < heap[i]:
        heap[i1], heap[i] = heap[i], heap[i1]
        sift_down(heap, i1, l)
    elif i2 < l and heap[i2] < heap[i]:
        heap[i2], heap[i] = heap[i], heap[i2]
        sift_down(heap, i2, l)

def heapify(arr):
    for i in reversed(range(len(arr))):
         sift_down(arr, i, len(arr))

def pop(heap, l):
    if len(heap) > 0:
        popped, heap[0] = heap[0], heap[l-1]
        sift_down(heap, 0, l-1)
        return popped

def heap_sort(arr):
    heapify(arr)
    l = len(arr)
    for i in reversed(range(l)):
        arr[i] = pop(arr, i+1)

def main():
    import sys
    _, *arr = [-int(x) for x in sys.stdin.read().strip().split()]
    heap_sort(arr)
    arr = [-x for x in arr]
    print(*arr)

main()