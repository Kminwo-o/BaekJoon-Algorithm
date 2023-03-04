import sys
input = sys.stdin.readline

T  = int(input())
nemo = 0
for i in range(1, T+1):
    check = []
    for j in range(2, i//2+1):
        if i % j == 0:
            if j in check:
                break
            else:
                nemo += 1
                check.append(i//j)
    nemo += 1
print(nemo)