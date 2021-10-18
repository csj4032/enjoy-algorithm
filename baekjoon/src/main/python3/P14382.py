def split(word):
    return [char for char in word]

def insomnia(c,n):
    visitor = [0,0,0,0,0,0,0,0,0,0]
    for i in range(1, 1000):
        for j in split(str(i*n)):
            visitor[int(j)] = 1
            if sum(visitor) == 10:
                break
        if sum(visitor) == 10:
            break
    if sum(visitor) == 10:
        print('Case #{0}: {1}'.format(c,i*n))
    else:
        print('Case #{0}: {1}'.format(c,'INSOMNIA'))

t = int(input())
for i in range(1, t+1):
    n = int(input())
    insomnia(i, n)