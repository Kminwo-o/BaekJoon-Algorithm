import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    line = input()
    open = 0
    close = 0

    for j,k in enumerate(line):
        if j == 0 and k == ')':
            close += 1
            break
        
        # 중요, 닫힘이 먼저 나오면 연결이 안됨.
        # 또한 마지막에 '('가 나왔을 때 open과 close의 갯수가 일치해서 Yes가 나오는 상황을 방지 가능.
        if close > open:
            break

        elif k == '(':
            open += 1
        
        elif k == ')':
            close += 1
    
    if open == close:
        print('YES')
    
    else:
        print('NO')