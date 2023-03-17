import sys

n, *pins = [int(x) for x in sys.stdin.read().strip().split()]
pins.sort()
# ds = [pins[i+1] - pins[i] for i in range(n-1)]
dp = [False] * (n-1)
dp[0] = True

# обработка крайних
res = pins[1] - pins[0]
if not dp[-1]: # последний ещё не привязан
    res += pins[-1] - pins[-2]
    dp[-1] = True

for i in range(1, n-1):
    if not (dp[i-1] or dp[i]): # гвоздик ещё не привязан
        left, right = pins[i] - pins[i-1], pins[i+1] - pins[i]
        if left < right: # проще привязать к левому
            res += left
        else:
            res += right
            dp[i] = True

print(res)
