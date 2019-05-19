N = 12345


def trit(n):
    if (n == 0):
        return 1;
    a = 0
    while 3 ** (a + 1) <= n:
        a += 1
    return 2 ** 2 + trit(min([n - 3 ** a, 3 ** a - 1]))


print(trit(1));
