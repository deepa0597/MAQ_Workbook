#input file 
input_file = "IntegerArray.txt.txt"
#open the file in read mode
ifile = open(input_file,'r')

#separating the numbers and storing it in an array. Readlines to read entire file at once 
with ifile as f:
	num = [int(number.strip()) for number in f.readlines()]
#print(num)

count = 0 

def count_inversions(x):
	global count
	midpoint = len(x) / 2
	leftside = x[:int(midpoint)]
	rightside = x[int(midpoint):]
	if len(x) > 1:
		count_inversions(leftside)
		count_inversions(rightside)
		i=0
		j=0
		a = leftside 
		b = rightside
		for m in range (len(a) + len(b) + 1):
			if a[i] <= b[j]:
				x[m] = a[i]
				i+=1
				if i == len(a) and j != len(b):
					while j!= len(b) :
						m+=1
						x[m] = b[j]
						j+=1
					break	
			elif a[i] > b[j]:
				x[m] = b[j]
				count += (len(a) - i)
				j+=1
				if j == len(b) and i != len(a):
					while i!= len(a) :
						m+=1
						x[m] = a[i]
						i+=1
					break
	return x

count_inversions(num)
print(count)					


	