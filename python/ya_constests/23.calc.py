n = int(input())
dp = [0] * (n+1)
prev = [-1] * (n+1)

for i in range(2, n+1): # нумерация с 1
    min = dp[i-1]
    p = i-1
    if i % 2 == 0 and dp[i//2] < min:
        min = dp[i//2]
        p = i//2
    if i % 3 == 0 and dp[i//3] < min:
        min = dp[i//3]
        p = i//3
    dp[i] = min + 1
    prev[i] = p

way = []
i = n
while i != -1:
    way.append(i)
    i = prev[i]
print(dp[n])
print(*reversed(way))