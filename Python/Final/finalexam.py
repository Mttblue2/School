"""
    SOURCE HEADER GOES HERE!
"""

import csv
from operator import itemgetter
import matplotlib.pyplot as plt
import numpy as np
import os
import string

def open_file(message):
    
    if (message == ""):
        return open('breachdata.csv', "r",encoding='utf8')
    
    else:
        while (os.path.isfile(message + '.csv') == False):
            message = input("Error. Please enter valid file name: ")
        return open(message + '.csv', "r",encoding='utf8')
    
    
def build_dict(reader):
    
    dic = dict()
    
    file_reader = reader
    next(reader,None)
    
    for row in reader:
        if (row[3] == '' or row[4] == '' or row[5] == '' or row[6] == '' or row[11]== ''):
            pass
        else:
            if (row[2] == ''):
                row[2] = '0'
                
            if row[0] not in dic.keys():
                dic[row[0]] = [[int(row[2].replace(',','')),int(row[3]),row[4],row[5],row[6],row[11]]]
            else:
                dic[row[0]].append([int(row[2].replace(',','')),int(row[3]),row[4],row[5],row[6],row[11]])
    
    return dic

def top_rec_lost_by_entity(dictionary):
   
    dic2 = dict()
    
    for key in dictionary:
        dic2[key] = 0
        for row in (dictionary[key]):
            dic2[key] = dic2[key] + row[0]
            
    dic2_list = list(dic2.items())
    dic2_list.sort()
    dic2_list.sort(key=lambda x:x[1], reverse=True)
    dic2 = {}
    count = 0
    
    for x, y in dic2_list:
        if (count == 10):
            break
        else:
            dic2[x] = y
            count = count + 1
    
    return dic2


def records_lost_by_year(dictionary):
    
    dic2 = dict()
    
    for key in dictionary:
        for row in (dictionary[key]):
            if row[1] not in dic2.keys():
                dic2[row[1]] = row[0]
            else:
                dic2[row[1]] = dic2[row[1]] + row[0]
            
    dic2_list = list(dic2.items())
    dic2_list.sort()
    dic2_list.sort(key=lambda x:x[1], reverse=True)
    dic2 = {}
    
    dic2.update(dic2_list)
    
    return dic2
    

def top_methods_by_sector(dictionary):
    
    dic2 = dict()
    
    for key in dictionary:
        for row in (dictionary[key]):
            if row[3] not in dic2.keys():
                dic2[row[3]] = dict()
            if row[4] not in dic2[row[3]].keys():
                dic2[row[3]][row[4]] = 1
            else:
                dic2[row[3]][row[4]] = dic2[row[3]][row[4]] + 1
    

    dic2_list = list(dic2.items())
    dic2_list.sort()
    dic2 = {}
    
    dic2.update(dic2_list)
    
    return dic2

        
def top_rec_lost_plot(names,records):


    ''' Plots a bargraph pertaining to
        the cybersecurity breaches data '''
        

    
def top_methods_by_sector_plot(methods_list):

    
    ''' Plots the top methods used to compromise
        the security of a sector '''

    
def main():
    BANNER = '''
    
                 _,.-------.,_
             ,;~'             '~;, 
           ,;                     ;,
          ;                         ;
         ,'                         ',
        ,;                           ;,
        ; ;      .           .      ; ;
        | ;   ______       ______   ; | 
        |  `/~"     ~" . "~     "~\'  |
        |  ~  ,-~~~^~, | ,~^~~~-,  ~  |
         |   |        }:{        |   | 
         |   l       / | \       !   |
         .~  (__,.--" .^. "--.,__)  ~. 
         |     ---;' / | \ `;---     |  
          \__.       \/^\/       .__/  
           V| \                 / |V  
            | |T~\___!___!___/~T| |  
            | |`IIII_I_I_I_IIII'| |  
            |  \,III I I I III,/  |  
             \   `~~~~~~~~~~'    /
               \   .       .   /
                 \.    ^    ./   
                   ^~~~^~~~^ 
                   
           
           ~~Cybersecurity Breaches~~        
                   @amirootyet    
                
    '''
   
    MENU = '''  
[ 1 ] Most records lost by entities
[ 2 ] Records lost by year
[ 3 ] Top methods per sector
[ 4 ] Search stories
[ 5 ] Exit

[ ? ] Choice: '''

    print(BANNER)
    print(MENU)
    
    file = input("Please Input File: ")
    dic = build_dict(csv.reader(open_file(file), delimiter=',', quotechar='"'))
    
    command = 0
    
    while (command != '5'):
        print(MENU)
        command = input("Please Enter Command: ")
        
        if (command == "1"):
            dic2 = top_rec_lost_by_entity(dic)
            count = 1
            for key in dic2:
                print("[ {:2d} ] | {:15.10s} | {:10d}".format(count, key, dic2[key]))
                print("---------------------------------------------")
                count = count +1
            command = input("Would you like to plot results? (y/n)")
            if (str.lower(command) == "y"):
                top_rec_lost_plot(list(dic2.keys()),list(dic2.values()))
                
        elif(command == "2"):
            dic2 = records_lost_by_year(dic)
            count = 1
            for key in dic2:
                print("[ {:2d} ] | {:15.10s} | {:10d}".format(count, str(key), dic2[key]))
                print("---------------------------------------------")
                count = count +1
            command = input("Would you like to plot results? (y/n)")
            if (str.lower(command) == "y"):
                top_rec_lost_plot(list(dic2.keys()),list(dic2.values()))
                
        elif(command == "3"):
            dic2 = top_methods_by_sector(dic)
            d_list = list(dic2.keys())
            print(d_list)
            count = 1
            
            while command not in d_list:
                command = input("Please input sector name: ")
            
            for value in dic2[command]:
                print(value)
                print("[ {:2d} ] | {:15.10s} | {:10d}".format(count, value, dic2[command][value]))
                print("---------------------------------------------")
                count = count +1
            command = input("Would you like to plot results? (y/n)")
            if (str.lower(command) == "y"):
                top_rec_lost_plot(list(dic2[command].keys()),list(dic2[command].values()))
                
        elif(command == "4"):
            d_list = list(dic.keys())
            count = 0
            while command not in d_list:
                command = input("Please input an Entity: ")
            for row in dic[command]:
                print("Story", count+1, ": ", dic[command][count][2])
                count = count +1
            

if __name__ == "__main__":
     main()
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     