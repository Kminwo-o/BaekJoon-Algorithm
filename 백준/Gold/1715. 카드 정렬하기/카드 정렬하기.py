import sys
from heapq import heappop, heappush, heapify
input = sys.stdin.readline

N = int(input())
card = []
total = 0

for _ in range(N):
    card.append(int(input()))

card.sort()

if N == 1:
    print(0)
else:
    while len(card) != 1:
        card1 = heappop(card)
        card2 = heappop(card)

        total += card1+card2

        heappush(card, card1+card2)
    
    print(total)