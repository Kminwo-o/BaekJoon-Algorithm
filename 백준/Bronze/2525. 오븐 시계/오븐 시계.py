A, B = map(int, input().split())
C = int(input())
tmp = ((B + C) // 60)
print((A + tmp) % 24, (B + C) % 60)