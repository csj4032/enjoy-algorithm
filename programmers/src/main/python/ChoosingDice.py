import itertools as it


def dice_sum(dice, combin: list, size: int):
    sums = []
    dice_cal(dice, sums, combin, 0, 0, size)
    return sums


def dice_cal(dice, sub_sums: list, combin: list, count: int, sub_sum: int, size: int):
    if count >= size:
        sub_sums.append(sub_sum)
        return

    for i in range(6):
        dice_cal(dice, sub_sums, combin, count + 1, sub_sum + dice[combin[count] - 1][i], size)


def solution(dice):
    dice_index = {i + 1 for i in range(len(dice))}
    dice_size: int = int(len(dice) / 2)
    combinations = it.combinations(dice_index, dice_size)
    win = 0
    answer = []

    for combination in combinations:
        foo = combination
        boo = [i for i in dice_index if i not in foo]
        foo_sums = sorted(dice_sum(dice, foo, dice_size))
        boo_sums = sorted(dice_sum(dice, boo, dice_size))
        foo_win = 0
        for foo_val in foo_sums:
            left = 0
            right = len(boo_sums)-1
            while left <= right:
                mid = int((left + right) / 2)
                if foo_val > boo_sums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
            foo_win += left

        if foo_win > win:
            win = foo_win
            answer = list(foo)

    return answer