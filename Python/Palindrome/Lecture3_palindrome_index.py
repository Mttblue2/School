import string

# input convertion: remove white space and punctuation. Replace them with ''
input_str = input("DEGGED Test -- Please enter a string: ")

input_str = input_str.lower()


for ch in input_str:
    if ch in string.whitespace + string.punctuation:
        input_str = input_str.replace(ch, '')
        

# check palindrome using indexing technique
front = 0
end = len(input_str) - 1

while end >= front:
    if input_str[front] != input_str[end]:
        print('It is not a palindrome!')
        break
    
    front += 1
    end -= 1
    
else:
    print('It is a palindrome!')