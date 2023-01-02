# -*- coding: utf-8 -*-
"""
 @author: jth1
"""

class SortableDict(dict):
        
    def sort(self):
        
        file_list = list(self.items())
        file_list.sort()
        file_list.sort(key=lambda x:x[1])
        self = {}
        
        self.update(file_list)
        return self

testing = SortableDict({"1":5,"2":15,"3":8,"4":20,"5":14,"6":-1})
print (testing.sort())