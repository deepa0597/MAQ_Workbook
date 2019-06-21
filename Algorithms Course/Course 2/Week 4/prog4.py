import sys
num = [int(i) for i in open("inputTextFile.txt")]
t = range(-10000,10001)
s = set(num)
#print(s)

for i in num:
	for j in t:
		m = j-i
		if(m in num and m!=i):
			#print(m)
			sum.append(t)
final = set(sum)
print(len(final))


