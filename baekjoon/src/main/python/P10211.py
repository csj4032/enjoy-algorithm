def solution(size, array):
    sub_sum = -10000000
    sub_max = -10000000
    for k in range(size):
        sub_sum = max(array[k], sub_sum + array[k])
        sub_max = max(sub_max, sub_sum)
    return sub_max


t: int = int(input())

for i in range(t):
    n = int(input())
    numbers = list(map(int, input().split()))
    print(solution(n, numbers))
