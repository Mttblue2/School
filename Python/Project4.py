# -*- coding: utf-8 -*-
"""
Created on Wed Oct  2 11:33:57 2019

@author: jth1
"""

import turtle

def draw_rectangle(length, height, color):
    turtle.color(color)

    turtle.begin_fill()
    turtle.forward(length)
    turtle.right(90)
    turtle.forward(height)
    turtle.right(90)
    turtle.forward(length)
    turtle.right(90)
    turtle.forward(height)
    turtle.end_fill()
    
def draw_star(size, color):
    turtle.color(color)
    
    turtle.begin_fill()
    turtle.forward(size)
    turtle.left(72)
    turtle.forward(size)
    turtle.right(144)
    turtle.forward(size)
    turtle.left(72)
    turtle.forward(size)
    turtle.right(144)
    turtle.forward(size)
    turtle.left(72)
    turtle.forward(size)
    turtle.right(144)
    turtle.forward(size)
    turtle.left(72)
    turtle.forward(size)
    turtle.right(144)
    turtle.forward(size)
    turtle.left(72)
    turtle.forward(size)
    turtle.end_fill()
    
def draw_flag(height):
    b = height*1.9
    c = height * (7/13)
    d = b * (2/5)
    e = c/10
    g = d/12
    l = height/13
    draw_rectangle(b, height, 'red')
    turtle.home()
    draw_rectangle(d, c, 'blue')
    turtle.home()
    
    turtle.forward(d)
    turtle.right(90)
    turtle.forward(l)
    turtle.left(90)
    draw_rectangle(b-d,l, 'white')
    turtle.right(180)
    turtle.forward(l*2)
    turtle.left(90)
    draw_rectangle(b-d,l, 'white')
    turtle.right(180)
    turtle.forward(l*2)
    turtle.left(90)
    draw_rectangle(b-d,l, 'white')
    turtle.penup()
    turtle.home()
    
    turtle.pendown()
    turtle.right(90)
    turtle.forward(c)
    turtle.left(90)
    draw_rectangle(b,l, 'white')
    turtle.right(180)
    turtle.forward(l*2)
    turtle.left(90)
    draw_rectangle(b,l, 'white')
    turtle.right(180)
    turtle.forward(l*2)
    turtle.left(90)
    draw_rectangle(b,l, 'white')
    turtle.penup()
    turtle.home()
    turtle.pendown()
    
    turtle.right(90)
    turtle.forward(c/9)
    turtle.left(90)
    turtle.forward((d/12)/2)
    draw_star(d/12)
    
draw_flag(150)

time.sleep(10)
os._exit(1)