import sys
from collections import deque

input = sys.stdin.readline


def check(arr):
    if arr.count(0) >= K:
        return False
    return True


def move():
    global robot
    for i in range(N - 2, -1, -1):
        if robot[i]:
            if belt[i + 1] > 0 and not robot[i + 1]:
                robot[i], robot[i + 1] = robot[i + 1], robot[i]
                belt[i + 1] -= 1

                if robot[N - 1]:
                    robot[N - 1] = 0

N, K = map(int, input().split())
belt = deque(list(map(int, input().split())))
quarter = 0
robot = deque([0] * N)

while check(belt):
    quarter += 1
    belt.rotate(1)
    robot.rotate(1)
    robot[N - 1] = 0

    move()

    if not robot[0] and belt[0] > 0:
        robot[0] = 1
        belt[0] -= 1

print(quarter)