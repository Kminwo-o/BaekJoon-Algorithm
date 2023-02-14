N = int(input())

st = [1] * N
bigger_lst = []

for i in range(N):
    bigger_lst.append(list(map(int, input().split())))

for i in range(len(bigger_lst)):
    for j in range(len(bigger_lst)):
        if bigger_lst[i][0] == bigger_lst[j][0] and\
            bigger_lst[i][1] == bigger_lst[j][1]:
            continue
        elif bigger_lst[i][0] < bigger_lst[j][0] and\
            bigger_lst[i][1] < bigger_lst[j][1]:
            st[i] += 1
        
for i in st:
    print(i,end=' ')