import sys

n = int(input())
people = []

for i in range(n):
    people.append(list(sys.stdin.readline().split()))

for i in people:
    i[0] = int(i[0])

people.sort(key=lambda x: x[0])

for i in range(n):
    print(f'{people[i][0]} {people[i][1]}')