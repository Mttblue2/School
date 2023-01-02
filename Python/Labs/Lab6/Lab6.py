# -*- coding: utf-8 -*-
"""
@author: JTH1
"""

file = open("scores.txt", "r")

all_info = []
mean1 = 0
mean2 = 0
mean3 = 0
mean4 = 0

for line in file:
    name = line[:20:1].strip()
    grade = line[20::1].split()
    grade = list(map(int, grade))
    mean = sum(grade)/4
    info = [name, grade, mean]
    
    all_info.append(info)
    
all_info.sort()

print("{:20s}{:>6s}{:>6s}{:>6s}{:>6s}{:>10s}".format("Name", "Exam1", "Exam2", "Exam3", "Exam4", "Mean"))

for element in all_info:
    mean1 = mean1 + element[1][0]
    mean2 = mean2 + element[1][1]
    mean3 = mean3 + element[1][2]
    mean4 = mean4 + element[1][3]
    
    print ("{:20s}{:6d}{:6d}{:6d}{:6d}{:10.2f}".format(element[0],element[1][0],element[1][1],element[1][2],element[1][3],element[2]))
    
print ("{:20s}{:6.1f}{:6.1f}{:6.1f}{:6.1f}".format("Exam Mean",mean1/5,mean2/5,mean3/5,mean4/5))
 

file.close()