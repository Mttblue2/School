# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 21:43:15 2019

@author: Tater
"""
import os
import sys

def open_file():
    file_name = input("Please enter a file name: ")
    
    while (os.path.isfile(file_name + ".txt") == False):
        file_name = input("Error. Please enter valid file name: ")
        
    return open(file_name + ".txt","r")

def process_file(file):
    count = 0
    percentage = 0.0
    low = 99999999
    high = -99999999
    low_cont = ""
    high_cont = ""
    
    year_input = input("Please input a year: ")
    income = input("Please input an income level: ")
    
    if (year_input.isdigit() == False or income.isdigit() == False):
        sys.exit("Year or Income level invalid")
        file.close()
    
    for line in file:
        year = line[88::1].strip()
        inc = line[54:57:1].strip()
        perc = int(line[59:61:1].strip())
        
        if (inc == "LI"):
            inc = "1"
        elif (inc == "LMI"):
            inc = "2"
        elif (inc == "UMI"):
            inc = "3"
        elif (inc == "HI"):
            inc = "4"
        
        if (year[0:4:1] == year_input[0:4:1] and inc == income):
            count = count + 1
            percentage = percentage + perc
            
            if (perc < low):
                low = perc
                low_cont = line[0:50:1].strip()
            if (perc > high):
                high = perc
                high_cont = line[0:50:1].strip()
                
    if (count == 0):
        sys.exit("Error: No records found")
    else:
        print("{:5<d} {:<10.1f} {:<s}:{:>d}, {:<s}:{:>d}".format(count, percentage/count, low_cont, low, high_cont, high))




file = open_file()
process_file(file)

file.close()