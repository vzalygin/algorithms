import sys
from functools import lru_cache

n, k = [int(x) for x in sys.stdin.read().strip().split()]

@lru_cache(None)
def f(e):
    if e == 1:
        return 1
    elif e < 1:
        return 0
    return sum(f(e-x) for x in range(1, k+1))

print(f(n))