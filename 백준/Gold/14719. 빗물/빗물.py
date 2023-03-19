import sys

input = sys.stdin.readline

H, W = map(int, input().split())
lst = list(map(int, input().split()))
water = 0
higher = [0, 0]
length = len(lst)

for i in range(length):
    if lst[i] > higher[0]:
        higher = (lst[i], i)

high = lst[0]
for i in range(1, higher[1]):
    if high > lst[i]:
        water += high - lst[i]

    elif high < lst[i]:
        high = lst[i]

high = lst[-1]
for i in range(length - 2, higher[1], -1):

    if high > lst[i]:
        water += high - lst[i]

    elif high < lst[i]:
        high = lst[i]

print(water)