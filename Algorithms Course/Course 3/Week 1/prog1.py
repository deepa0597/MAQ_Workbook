#Open input File
f = open('inputFile.txt','r')
#initialize empty array Jobs where a sub lit will be stored at every index.
ListJobs = []
l = 0
w = 0
#read the lines after the 1st line, 1st line is no.of Jobs
lines = f.readlines()[1:]
for line in lines:
    weight = int(line.split()[0])
    length = int(line.split()[1])
    ListJobs.append([w,l,w - l])
    #for first iteration, job[0] = ([weight,length,weight-length],...)

#sorting according to weight-length first, if that is same then sort according to priority
ListJobs = sorted(Listjobs,key = lambda x:(x[2],x[0]))
ListJobs = ListJobs[-1::-1]#reverse the list for decreasing order
Time = 0
Length = 0 
for job in ListjJbs:
    Length += job[1]
    Time += job[0] * sumLength
print(Time)
    
    
#Time = 69119377652
