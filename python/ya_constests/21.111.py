from functools import lru_cache

@lru_cache(None)
def f(n, c):
    if n > 0:
        return f(n-1, 0) + (f(n-1, c+1) if c < 2 else 0)
    else:
        return 1

print(f(int(input()), 0))