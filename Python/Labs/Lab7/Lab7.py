# -*- coding: utf-8 -*-
"""
@author: jth1
"""

import math

def get_freq_dict(file):
    line_dict = {}
    
    for line in file:
        line = line.lower()
        for ch in '!"#$%&()*+,-./:;<=>?@[\\]^_`{|}~':
            line = line.replace(ch,' ')
        for word in line.split():
            for ch in word:
                if ch in "0123456789":
                    break
                else:
                    line_dict[word] = line_dict.get(word, 0) + 1
                    break
    return line_dict

def get_dict_order(file_dict):
    file_list = list(file_dict.items())
    file_list.sort()
    file_list.sort(key=lambda x:x[1], reverse=True)
    file_dict = {}

    file_dict.update(file_list)
    
    return file_dict

def get_tf(file_dict):
    for w in file_dict:
        file_dict[w] = file_dict[w]/len(file_dict)
    return file_dict

def compute_idf(old_list,num_of_doc):
    new_list = []
    for x in old_list:
        new_list.append(math.log(num_of_doc/(x+1)))
    return new_list

file = open('document1.dat', 'r', encoding = "utf-8")

file_dict1 = get_freq_dict(file)
file_dict1 = get_dict_order(file_dict1)

file = open('document2.dat', 'r', encoding = "utf-8")

file_dict2 = get_freq_dict(file)
file_dict2 = get_dict_order(file_dict2)

file = open('document3.dat', 'r', encoding = "utf-8")

file_dict3 = get_freq_dict(file)
file_dict3 = get_dict_order(file_dict3)

file.close()

file_dict1 = get_tf(file_dict1)
file_dict2 = get_tf(file_dict2)
file_dict3 = get_tf(file_dict3)

idf1 = []
idf2 = []
idf3 = []

for w in file_dict1:
    count = 0
    if w in file_dict1:
        count += 1
    if w in file_dict2:
        count += 1
    if w in file_dict3:
        count += 1
    idf1.append(count)

for w in file_dict2:
    count = 0
    if w in file_dict1:
        count += 1
    if w in file_dict2:
        count += 1
    if w in file_dict3:
        count += 1
    idf2.append(count)

for w in file_dict3:
    count = 0
    if w in file_dict1:
        count += 1
    if w in file_dict2:
        count += 1
    if w in file_dict3:
        count += 1
    idf3.append(count)

idf1 = compute_idf(idf1,3)
idf2 = compute_idf(idf2,3)
idf3 = compute_idf(idf3,3)

count = 0
for w in file_dict1:
    file_dict1[w] = file_dict1[w] * idf1[count]
    count += 1
    
count = 0
for w in file_dict2:
    file_dict2[w] = file_dict2[w] * idf2[count]
    count += 1
    
count = 0
for w in file_dict3:
    file_dict3[w] = file_dict3[w] * idf3[count]
    count += 1

file_list = list(file_dict1.items())
file_list.sort(key=lambda x:x[1], reverse=True)

print("Top 3 words in document1:")
for x in range(3):
    print(file_list[x][0])
print("")

file_list = list(file_dict2.items())
file_list.sort(key=lambda x:x[1], reverse=True)

print("Top 3 words in document2:")
for x in range(3):
    print(file_list[x][0])
print("")

file_list = list(file_dict3.items())
file_list.sort(key=lambda x:x[1], reverse=True)

print("Top 3 words in document3:")
for x in range(3):
    print(file_list[x][0])
print("")