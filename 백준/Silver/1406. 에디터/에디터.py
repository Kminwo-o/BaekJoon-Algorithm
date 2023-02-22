import sys

s1 = list(sys.stdin.readline().strip())
s2 = []
N = len(s1)
M = int(sys.stdin.readline())

# s1에서 s2로 갈 때
# 역행으로 가기 때문에 1개면 상관없지만 2개 이상이 되면 reversed해서 넣어줘야한다.
for _ in range(M):
    order = sys.stdin.readline().strip()
    if order[0] == 'L' and s1:
        s2.append(s1.pop())
    elif order[0] == 'D' and s2:
        s1.append(s2.pop())
    elif order[0] == 'B' and s1:
        s1.pop()
    elif order[0] == 'P':
        s1.append(order[2])

print(''.join(s1 + list(reversed(s2))))