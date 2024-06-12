from sys import stdin

fib = [0]*(101)
fib[1] = 1
fib[2] = 1
fib[3] = 1
fib[4] = 2
fib[5] = 2
for k in range(6, 101):
    fib[k] = (fib[k-5] + fib[k-1])

a=int(stdin.readline().rstrip())
for i in range(a):
    b = int(stdin.readline())
    print(fib[b])