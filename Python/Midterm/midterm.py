# -*- coding: utf-8 -*-
"""
Created on Mon Oct 14 22:02:06 2019

@author: jth1
"""
import sys
import os

def get_number(line):
    return int(line[0:6:1].strip())
    
def get_balance(line):
    return float(line[7:17:1].strip())

def get_name(line):
    return line[17::1].strip()
    
def equal_floats(float1, float2):
    return True if abs(float1 - float2) < 0.000000010 else False
    
found = False
command = ""

file_name = input("Please input a file name: ")

if (os.path.isfile(file_name + ".txt")):
    os.rename(file_name + ".txt", file_name + ".old.txt")
    
elif (os.path.isfile(file_name + ".new.txt")):
    if (os.path.isfile(file_name + ".old.txt")):
        os.remove(file_name + ".old.txt")
        os.rename(file_name + ".new.txt", file_name + ".old.txt")
        
    else:
        os.rename(file_name + ".new.txt", file_name + ".old.txt")
        
elif (os.path.isfile(file_name + ".old.txt")):
    pass

else:
    sys.exit("Original file failed to open.")
                
file_old = open(file_name + ".old.txt","r")
file_new = open(file_name + ".new.txt","w")

for line in file_old:
    if (line.strip() != "999999"):
        close = False
        
        while (command != "a"):
            print("Acct#  Balance    Name")
            print(line)
            
            number = get_number(line)
            balance = get_balance(line)
            name = get_name(line)
            
            command = input("Transaction Type: ")
            
            if (command == 'a'):
                pass
            
            elif (command == 'd'):
                amount = float(input("Amount to deposit: "))
                
                if (balance + amount <= 9999999.99):
                    line = ("{:<d} {:>10.2f} {:s}".format(number, balance + amount, name))
                else:
                    print("Input puts balance over maximum.")    
            
            elif (command == 'w'):
                amount = float(input("Amount to withdraw: "))
                
                if (balance - amount >= 0.0):
                    line = ("{:<d} {:>10.2f} {:s}".format(number, balance - amount, name))
                else:
                    print("Input puts balance under minimum.")
                
            elif (command == 'c'):
                if (balance > 0.0):
                    print("Cannot close an account with a balance.")
                    
                else:
                    close = True
                    command = 'a'
                
            else:
                print("Invalid Transaction")
                
    command = ''
    if (close):
        close = False
        pass
    else:
        file_new.write(line.strip() + "\n")

file_old.close()
file_new.close()