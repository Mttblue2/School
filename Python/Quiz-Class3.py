# -*- coding: utf-8 -*-
"""
@author: jth1
"""

class Animal:
    def __init__(self, name, weight):
        self.name = name
        self.weight = weight

class Dog():
    def __init__(self, name, weight, times_barks):
        self.animal = Animal(name, weight)
        
        self.times_barks = times_barks # we added a member
        
    def bark(self): # We added functionality
        print("{} barks: ".format(self.animal.name) + "woof " * self.times_barks)
        
class Square:
    def __init__(self, sidelen):
        self.sidelen = sidelen

    def area_volume(self):
        return self.sidelen**2

class Cube():
    def __init__(self, sidelen):
        self.square = Square(sidelen)
    
    def area_volume(self):
        return self.square.sidelen**3
        
        
        
#%%        
d = Dog("Clifford", 420, 5)
d.bark()

#%%
shape1 = Square(3)
shape2 = Cube(3)

print(shape1.area_volume())
print(shape2.area_volume())