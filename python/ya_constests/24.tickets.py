import sys

INF = 3601
A, B, C = 0, 1, 2

n, *d = [x for x in sys.stdin.read().strip().split("\n")]
n = int(n)
d = [(INF, INF, INF)] * 3 + [tuple(int(y) for y in x.split()) for x in d]
m = [0] * len(d)

for i in range(3, len(d)):
    m[i] = min(m[i-1] + d[i][A], m[i-2] + d[i-1][B], m[i-3] + d[i-2][C])

print(m[-1])