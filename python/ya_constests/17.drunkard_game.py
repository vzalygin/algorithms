import sys
from heapq import heappush, heappop

def main():
    ss = [(i, int(x)) for i, x in enumerate(sys.stdin.read().strip().split())]
    pl1 = ss[:5]
    pl2 = ss[5:]
    i = 0
    next = 10
    while i < 10**6 and len(pl1) > 0 and len(pl2) > 0:
        c1, c2 = heappop(pl1)[1], heappop(pl2)[1]
        if c1 > c2 and not (c2 == 0 and c1 == 9) or (c1 == 0 and c2 == 9): # первый игрок выигрывает
            next += 1
            heappush(pl1, (next, c1))
            next += 1
            heappush(pl1, (next, c2))
        else:
            next += 1
            heappush(pl2, (next, c1))
            next += 1
            heappush(pl2, (next, c2))
        i += 1

    if i == 10**6:
        return 'botva'
    if len(pl1) == 0: # первый проиграл
        return 'second ' + str(i)
    else:
        return 'first ' + str(i)

print(main())
