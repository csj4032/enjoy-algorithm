import sys

m = input()
element = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
element_sort = sorted(element, key=lambda tup: tup[1])
