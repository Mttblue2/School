# -*- coding: utf-8 -*-
"""
Created on Fri Oct 25 12:00:05 2019

@author: jth1
"""

import matplotlib.pyplot as plt
import numpy as np

file = open("population.txt",'r')
d = {"1":0, "2":0, "3":0, "4":0, "5":0, "6":0, "7":0, "8":0, "9":0}
counter = 0

for line in file:
    if line[0].isdigit():
        counter = counter + 1
        index = line[0]
        d[index] = d[index] + 1

print("{:<8s}{:<8s}{:<8s}{:<8s}{:<8s}{:<8s}{:<8s}{:<8s}{:<8s}".format('1%', '2%', '3%', '4%', '5%', '6%', '7%', '8%', '9%'))
print("{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}{:<8.2f}".format(d["1"]/counter*100, d["2"]/counter*100, d["3"]/counter*100, d["4"]/counter*100,d["5"]/counter*100, d["6"]/counter*100, d["7"]/counter*100, d["8"]/counter*100, d["9"]/counter*100))

y = np.array([0,1,2,3,4,5,6,7,8])
x = [d["1"]/counter*100, d["2"]/counter*100, d["3"]/counter*100, d["4"]/counter*100,d["5"]/counter*100, d["6"]/counter*100, d["7"]/counter*100, d["8"]/counter*100, d["9"]/counter*100]

plt.bar(y, x, align="center", width=0.5, alpha=0.5)
plt.title("Benford's law")
plt.show()