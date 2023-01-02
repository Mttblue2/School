# -*- coding: utf-8 -*-
"""
Created on Mon Sep 23 11:38:20 2019

@author: jth1
"""

import string

play_again = "y"
vowels = "aeiouAEIOU"

while (play_again != "n"):
    f_syllable = ""
    s_syllable = ""
    word = ""
    word_t = ""
    f_used = False
    previous_v = False
    
    while (f_syllable == ""):
        f_syllable = input("Enter your first Gibberish syllable (add * for the vowel substitute): ")
        if (f_syllable == ""):
            print("Error: Must have valid syllable to substitue.")
            
    while (s_syllable == ""):
        s_syllable = input("Enter the second Gibberish syllable (* for vowel substitute): ")
        if (s_syllable == ""):
            print("Error: Must have a syllable to substitue.")
    
    while (word == ""):
        word = input("Please enter a word you want to translate:\n-->")
        if (word == ""):
            print("Error: Must have a word to translate.")
    
    for ch in word:
        if (ch in vowels):
            if (previous_v == False):
                if (f_used == False):
                    if (f_syllable[0] == "*"):
                        word_t = word_t + ch + f_syllable[1::1] + ch
                    else:
                        word_t = word_t + f_syllable + ch
                        f_used = True
                else:
                    if (s_syllable[0] == "*"):
                        word_t = word_t + ch + s_syllable[1::1] + ch
                    else:
                        word_t = word_t + s_syllable + ch
            else:
                word_t = word_t + ch
                
            previous_v = True
        else:
            word_t = word_t + ch
            previous_v = False
            
    print("Your final word:\n")
    print(word_t)
    
    play_again = (input("Play again? (y/n)")).lower()