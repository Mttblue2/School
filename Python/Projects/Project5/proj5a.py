# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 21:43:15 2019

@author: Tater
"""
import os
import sys


if (os.path.isfile("measles.txt")):
    measles = open("measles.txt","r")
    
else:
    sys.exit("Original file failed to open.")
    
output_name = input("Please enter output file name: ")

output = open(output_name + ".txt","w")

year_input = input("Please enter a year or All: ")

if (year_input.isdigit() == False):
    year_input.lower()

for line in measles:
    year = line[88::1].strip()
    
    if (year_input == "all" or year_input == ""):
        output.write(line)
        
    if (len(year_input) == 4):
        if (year[0:4:1] == year_input[0:4:1]):
            output.write(line)
    elif (len(year_input) == 3):
        if (year[0:3:1] == year_input[0:3:1]):
            output.write(line)
    elif (len(year_input) == 2):
        if (year[0:2:1] == year_input[0:2:1]):
            output.write(line)
    elif (len(year_input) == 1):
        if (year[0:1:1] == year_input[0:1:1]):
            output.write(line)

output.close()    
measles.close()