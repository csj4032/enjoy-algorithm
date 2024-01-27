def solution(distance, rocks, n):
    answer = 0
    left = 0
    right = distance

    while (right - left) > 1:
        mid = int((right + left) / 2)
        print(left, mid, right)
        if (mid % 2) == 0:
            right = mid
        else:
            left = mid

    return answer


solution(25, [2, 14, 11, 21, 17], 4)
