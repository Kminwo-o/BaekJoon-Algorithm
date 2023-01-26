while True:
    N = input()
    M = N[::-1]

    if N == '0':
        break

    if N == M:
        print('yes')
    else:
        print('no')