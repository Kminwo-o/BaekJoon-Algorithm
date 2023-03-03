N = int(input())
switch = input().split()

le_switch = len(switch)
stud = int(input())
stud_lst = []
for _ in range(stud):
    stud_lst.append(list(map(int, input().split())))

for i in stud_lst:
    if i[0] == 1:
        for j in range(i[1]-1, le_switch, i[1]):
                if switch[j] == '1':
                    switch[j] = '0'
                elif switch[j] == '0':
                    switch[j] = '1'

    elif i[0] == 2:
        k = 0
        while True:
            if i[1] - k > 0 and i[1] + k <= le_switch:
                if switch[i[1] - k- 1] == switch[i[1] + k - 1]:
                    k += 1
                else:
                    k -= 1
                    for l in range(i[1] - k - 1, i[1] + k):
                        if switch[l] == '1':
                            switch[l] = '0'
                        elif switch[l] == '0':
                            switch[l] = '1'
                    break

            else:
                k -= 1
                for l in range(i[1] - k - 1, i[1] + k):
                    if switch[l] == '1':
                        switch[l] = '0'
                    elif switch[l] == '0':
                        switch[l] = '1'
                break

count = 1
for i in range(le_switch):
    print(switch[i],end=' ')
    count += 1
    if count == 21:
        count = 1
        print()