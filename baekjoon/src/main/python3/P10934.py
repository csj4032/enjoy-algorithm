import hashlib
def _10934():
    h = hashlib.new('sha')
    h.update(input().encode())
    print(h.hexdigest())
_10934()