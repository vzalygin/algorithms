def empty():
    return []

def sift_up(heap, i):
    if i == 0:
        return
    parent = (i-1) // 2
    if heap[parent] > heap[i]:
        heap[parent], heap[i] = heap[i], heap[parent]
        sift_up(heap, parent)

def push(heap, x):
    heap.append(x)
    sift_up(heap, len(heap)-1)

def sift_down(heap, i):
    l = len(heap)
    if i >= l:
        return
    i1, i2 = i*2+1, i*2+2
    if i1 < l and i2 < l:
        if heap[i1] < heap[i2] and heap[i1] < heap[i]:
            heap[i1], heap[i] = heap[i], heap[i1]
            sift_down(heap, i1)
        elif heap[i2] < heap[i]:
            heap[i2], heap[i] = heap[i], heap[i2]
            sift_down(heap, i2)
    elif i1 < l and heap[i1] < heap[i]:
        heap[i1], heap[i] = heap[i], heap[i1]
        sift_down(heap, i1)
    elif i2 < l and heap[i2] < heap[i]:
            heap[i2], heap[i] = heap[i], heap[i2]
            sift_down(heap, i2)

def pop(heap):
    if len(heap) > 0:
        popped, heap[0] = heap[0], heap[-1]
        heap.pop()
        sift_down(heap, 0)
        return popped
    
def main():
    import sys
    heap = empty()
    _, *inp = [x.split() for x in sys.stdin.read().strip().split('\n')]
    for com in inp:
        if com[0] == '0':
            push(heap, -int(com[1]))
        elif com[0] == '1':
            print(-pop(heap))

main()