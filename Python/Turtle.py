# -*- coding: utf-8 -*-
"""
Created on Wed Sep 11 21:17:21 2019

@author: Tater
"""

import turtle


t = turtle.Turtle()

#Four Squares
t.color("purple")

for n in range(1,5):
    for i in range(1,5):
        t.forward(100)
        t.left(90)
    t.right(90)
    if n == 2:
        t.color("blue")
    elif n == 3:
        t.color("red")
    else:
        t.color("orange")
        
#Hexagon
t.color("green")

for n in range(1,7):
    t.forward(100)
    t.left(60)
    