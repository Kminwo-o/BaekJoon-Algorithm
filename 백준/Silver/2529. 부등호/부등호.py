def find(x, depth):
    global idx
    if depth == k:
        arr = []
        for j in used:
            arr.append(j)
        possible.append(arr)
        return

    for i in range(10):
        if operator[idx] == '<':
            if i not in used and i > x:
                used.append(i)
                idx += 1
                find(i, depth + 1)
                used.pop()
                idx -= 1

        elif operator[idx] == '>':
            if i not in used and i < x:
                used.append(i)
                idx += 1
                find(i, depth + 1)
                used.pop()
                idx -= 1
    return

k = int(input())
operator = input().split()
depth = 0
possible = []
idx = 0

for i in range(10):
    used = []
    used.append(i)
    find(i, 0)
    idx = 0
    
max_ = max(*possible)
min_ = min(*possible)

print(*max_, sep='')
print(*min_, sep='')