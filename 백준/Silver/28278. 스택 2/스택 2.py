Input = int(input())
list = []
a=[]

for i in range(Input):
    command = input()
    
    if command[0]=="1":
        list.append(int(command[2:]))

    elif command=="2":
        if len(list) > 0:
            a.append(list[-1])
            del list[-1]
        else:
            a.append(-1)

    elif command=="3":
        a.append(len(list))

    elif command=="4":
        if len(list) == 0:
            a.append(1)
        else:
            a.append(0)

    elif command=="5":
        if len(list) > 0:
            a.append(list[-1])
        else:
            a.append(-1)

for i in a:
    print(i)