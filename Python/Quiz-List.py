# -*- coding: utf-8 -*-
"""
Created on Wed Oct 16 21:35:26 2019

@author: jth1
"""

def unique_list(list):
    list2 = []
    
    for element in list:
        if (len(list2) == 0):
            list2.append(element)
        else:
            found = False
            
            for i in list2:
                if (element == i):
                    found = True
            
            if (found == True):
                pass
            else:
                list2.append(element)
    
    return list2
        
#%% Testing unique_list()
list = [1,2,3,3,3,3,4,5]
print(unique_list(list))

#%% program for even numbers

list = [1,2,3,4,5,6,7,8,9]
list2 = []

for element in list:
    if element % 2 == 0:
        list2.append(element)

print(list2)