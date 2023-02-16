import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
line = input().strip()
deque = deque()
lst = [int(input()) for _ in range(N)]
ans = 0

for str in line:
    if(str.isalpha()):
        deque.append(lst[ord(str) - 65])
    else:
        first = deque.pop()
        second = deque.pop()
        deque.append(eval(f"{second} {str} {first}"))

print("%0.2f"%deque[0])