N = int(input())
exam_lst = list(map(int, input().split()))
good = max(exam_lst)
fake = []
for i in exam_lst:
    fake.append(i/good*100)

print(sum(fake) / N)