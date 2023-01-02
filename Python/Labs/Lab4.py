# -*- coding: utf-8 -*-
"""
Created on Mon Sep 30 21:24:34 2019

@author: jth1
"""
import string

def leap_year(year):
    return True if (int(year) % 400 == 0 or int(year) % 4 == 0 and int(year) % 100 != 0) else False

def rotate(s, n):
    if (len(s) < 2):
        return s
    elif (n > len(s)):
        return ("Rotate variable longer than length.")
    elif (n < 0):
        return ("Rotate variable must be positive.")
    else:
        a = s[-n::1]
        return a + s[0:-n:1]
    
def digit_count(num):
    num_string = str(num)
    even = 0
    odd = 0
    zero = 0
    
    for x in num_string:
        if (x == '.'):
            break
        elif (int(x) == 0):
            zero = zero + 1
        elif (int(x) % 2 == 0):
            even = even + 1
        else:
            odd = odd + 1
    return (even, odd, zero)

def float_check(num):
    return True if (num.replace('.', '', 1).isdigit() == True) else False
            

#%% testing leap Year
print(leap_year(1896))
print(leap_year(1904))
print(leap_year(1900))
print(leap_year(2400))

#%% testing rotate
print(rotate('',0))
print(rotate('a',2))
print(rotate('abcdefgh',3))
print(rotate('meowmix',8))
print(rotate('nyaa', -1))

#%% testing digit count
print(digit_count(1234567890123))
print(digit_count(123400.345))
print(digit_count(123.))
print(digit_count(0.123))

#%% testing float check
print(float_check('1234'))
print(float_check('123.45'))
print(float_check('123.45.67'))
print(float_check('34e46'))
print(float_check('.45'))
print(float_check('45.'))
print(float_check('45..'))
