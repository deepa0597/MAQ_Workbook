#Open input File
f = open('inputFile.txt','r')
#initialize empty array Jobs where a sub lit will be stored at every index.
jobs = []
length,weight = 0,0
#read the lines after the 1st line, 1st line is no.of Jobs
lines = f.readlines()[1:]
for line in lines:
    weight = int(line.split()[0])
    length = int(line.split()[1])
    jobs.append([weight,length,weight/length])
    #for first iteration, job[0] = ([weight,length,weight-length],...)

#sorting according to weight-length first, if that is same then sort according to priority
jobs = sorted(jobs,key = lambda x:(x[2],x[0]))
jobs = jobs[-1::-1]#reverse the list for decreasing order
Time = 0
Length = 0 
for job in jobs:
    Length += job[1]
    Time += job[0] * Length
print(Time)
    
    
#Time = 67311454237
