ns = list(map(int, (input().split())))
numbers = list(map(int, (input().split())))

n: int = ns[0]
s: int = ns[1]
i: int = 0
j: int = 0
k: int = 0
l: int = n + 1

while True:
    if k >= s:
        l = min(l, j - i)
        k -= numbers[i]
        i = i + 1
    elif j == n:
        break
    else:
        k += numbers[j]
        j = j + 1

if l == n + 1:
    l = 0

print(l)