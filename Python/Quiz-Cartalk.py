# -*- coding: utf-8 -*-
"""
Created on Wed Sep 18 21:07:31 2019

@author: Josh H.
"""

import string



def Palindrome(num):
    reverse_num = num[::-1]

    if (num == reverse_num):
        return(True)
    else:
        return(False)
        
def Pad(num):
    num = str(num)
    while (len(num) < 6):
        num = "0" + num
    return(num)
    
found = False
num_string = ""

for num in range(0, 1000000):
    num_string = Pad(str(num))
    
    if (Palindrome(num_string[2:6:1]) == True):
        num_string = Pad(str(num + 1))
        if (Palindrome(num_string[1:6:1]) == True):
            num_string = Pad(str(num + 2))
            if (Palindrome(num_string[1:5:1]) == True):
                num_string = Pad(str(num + 3))
                if (Palindrome(num_string) == True):
                    found = True
                    
    
    if (found == True):
        print("Terry first reading: " + Pad(num))
        break;

