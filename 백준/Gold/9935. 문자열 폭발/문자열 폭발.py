string = input()
boom = input()
stack = []

for i in string:
    stack.append(i)
    if i == stack[-1] and ''.join(stack[-len(boom):]) == boom:
        del stack[-len(boom):]

string = ''.join(stack)
if not string:
    print('FRULA')

else:
    print(string)