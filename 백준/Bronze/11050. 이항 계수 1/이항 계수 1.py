import sys
input = sys.stdin.readline

N, K = map(int, input().split())

def factorial(x):
    if x == 1 or x == 0:
        return 1
    return x * factorial(x-1)

def nCk(n, k):
    nCk = factorial(n) // (factorial(n-k)*factorial(k))
    return nCk

print(nCk(N, K))