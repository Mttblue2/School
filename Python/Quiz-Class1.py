# -*- coding: utf-8 -*-
"""
@author: jth1
"""

# Version 5: add_clocks
class Clock:
    def __init__(self, hours=0, minutes=0, seconds=0):
        # Clock arithmetic initializer
        self.seconds = seconds % 60
        total_minutes = minutes + (seconds // 60)
        self.minutes = total_minutes % 60
        self.hours = (hours + (total_minutes // 60)) % 24
        
    def __str__(self):
        # leading 0 in format statement puts a 0 in each element if
        # necessary so that every field is 2 decimals wide
        
        return("{:02d}:{:02d}:{:02d}".format(self.hours, self.minutes, self.seconds))
        
    def __add__(self, clock2):
        # no change to self or clock2. Return a new clock instance
        # no checks on attribute sums, the __init__ will handle it
        seconds = self.seconds + clock2.seconds
        minutes = self.minutes + clock2.minutes
        hours = self.hours + clock2.hours
        return Clock(hours, minutes, seconds) # return a new clock
    
    def __add__(self, x):
        # no change to self or clock2. Return a new clock instance
        # no checks on attribute sums, the __init__ will handle it
        seconds = self.seconds + x
        minutes = self.minutes
        hours = self.hours
        return Clock(hours, minutes, seconds) # return a new clock
    
c1 = Clock(2,2,2)
print(c1 + 5)
