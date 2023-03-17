import sys
from functools import lru_cache

dims, *d = [x for x in sys.stdin.read().strip().split('\n')]
n, m = [int(x) for x in dims.split()]
d = [[int(y) for y in x.split()] for x in d]

@lru_cache(None)
def f(y, x):
    if x > 0 and y > 0:
        prev = min(f(y-1, x), f(y, x-1))
    elif x > 0:
        prev = f(y, x-1)
    elif y > 0:
        prev = f(y-1, x)
    else:
        prev = 0
    return prev + d[y][x]
    
print(f(n-1, m-1))