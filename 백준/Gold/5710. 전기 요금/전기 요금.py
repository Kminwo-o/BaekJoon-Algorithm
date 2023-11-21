import sys
input = sys.stdin.readline


def get_total_wh(total_use):
    used = [100 * 2, 100 * 2 + 9900 * 3, 100 * 2 + 9900 * 3 + 990000 * 5]

    if total_use <= used[0]:
        return total_use // 2
    if total_use <= used[1]:
        return (total_use - used[0]) // 3 + 100
    if total_use <= used[2]:
        return (total_use - used[1]) // 5 + 10000

    return (total_use - used[2]) // 7 + 1000000


def get_used_pay(wh):
    arr = [100, 10000, 1000000]

    if wh < arr[0]:
        return wh * 2
    if wh < arr[1]:
        return (wh - 100) * 3 + 100 * 2
    if wh < arr[2]:
        return (wh - 10000) * 5 + 9900 * 3 + 100 * 2

    return 100 * 2 + 9900 * 3 + 990000 * 5 + (wh - 1000000) * 7


def binary_search(s, e, gap):
    total_wh = e

    while True:
        sang_gun = (s + e) // 2
        neighbor = total_wh - sang_gun

        diff_pay = get_used_pay(neighbor) - get_used_pay(sang_gun)

        if diff_pay == gap:
            return get_used_pay(sang_gun)

        if diff_pay > gap:
            s = sang_gun + 1
        else:
            e = sang_gun - 1


while True:
    A, B = map(int, input().split())

    if A == B == 0:
        break

    total_pay = get_total_wh(A)

    print(binary_search(0, total_pay, B))
