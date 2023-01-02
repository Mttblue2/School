# -*- coding: utf-8 -*-
"""
Created on Wed Sep 18 21:07:31 2019

@author: Josh H.
"""

import string

original_str = input("Palindrome test -- enter a string: ")

forward_str = original_str
forward_str = forward_str.lower()


for ch in forward_str:
    if ch in string.whitespace + string.punctuation:
        forward_str = forward_str.replace(ch, '')
        
reverse_str = forward_str[::-1]

if forward_str == reverse_str:
    print("It's a palindrome.")
else:
    print(original_str,'is not a palindrome')