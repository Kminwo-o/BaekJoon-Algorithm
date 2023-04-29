N = int(input())
lst = []

for i in range(N):
    lst.append(int(input()))
    
stack = []
max_v = 0
for i in range(N):
    idx = i
    while stack and stack[-1][1] > lst[i]:
        idx, height = stack.pop()
        rst = (i - idx) * height 
        max_v = max(max_v, rst)
    stack.append((idx, lst[i]))

while stack:
    idx, height = stack.pop()
    rst = (N - idx) * height
    max_v = max(max_v, rst)
print(max_v)