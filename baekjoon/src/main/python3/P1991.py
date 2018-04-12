tree = {}
for _ in range(int(input())):
    p, a, b = input().split()
    tree[p] = (a, b)


def preorder(start):
    if start == '.': return
    print(start, end='')
    preorder(tree[start][0])
    preorder(tree[start][1])


def inorder(start):
    if start == '.': return
    inorder(tree[start][0])
    print(start, end='')
    inorder(tree[start][1])


def postorder(start):
    if start == '.': return
    postorder(tree[start][0])
    postorder(tree[start][1])
    print(start, end='')


preorder('A')
print()
inorder('A')
print()
postorder('A')
