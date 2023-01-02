# -*- coding: utf-8 -*-
"""
Created on Fri Oct 25 23:24:57 2019

@author: Tater
"""
import os

def get_crater_tuple(line_str):
    line_list = line_str.split()
    if (line_list[2][-1].isdigit() == False):
        return(line_list[0], line_list[1] + " " + line_list[2], float(line_list[3]), float(line_list[4]), float(line_list[5]))
    return(line_list[0], line_list[1], float(line_list[2]), float(line_list[3]), float(line_list[4]))
    
def read_craters(filename):
    crater_list_full = []
    while (os.path.isfile(filename + ".txt") == False):
        filename = input("Enter a valid filename: ")
        
    file = open(filename + ".txt","r")
    file.readline()
    file.readline()
    file.readline()
    
    for line in file:
        crater_list_full.append(get_crater_tuple(line))
    
    file.close()
    return crater_list_full
    
def get_eligible_craters(crater_list):
    crater_list_new = []
    
    for x in crater_list:
        if (-40 < x[2] < 50 and 40 < x[3] < 135 and x[4] >= 60):
            crater_list_new.append(x)
    
    return crater_list_new
    
def write_craters(eligible_crater_list):
    good_craters = open("craters.txt","w")
    
    good_craters.write("{:>3s} {:^15s} {:>9s} {:>9s} {:>9s}".format("ID", "Name", "Latitude", "Longitude", "Diameter") + "\n")
    
    for x in eligible_crater_list:
        good_craters.write("{:>3} {:<15} {:>9.2f} {:>9.2f} {:>9.2f}".format(x[0],x[1],x[2],x[3],x[4]) + "\n")
    good_craters.close()
    

    
filename = input("Enter a filename: ")
crater_list = read_craters(filename)
eligible_crater_list = get_eligible_craters(crater_list)
write_craters(eligible_crater_list)