import string

orig_str = input("Palindrome test -- enter a string: ")

my_str = orig_str.lower()
for bad_char in string.whitespace + string.punctuation:
    my_str = my_str.replace(bad_char,'')

# slicing technique
check_str = my_str
while check_str:
    if check_str[0] != check_str[-1]:
        print(orig_str,'is not a palindrome')
        break
    check_str = check_str[1:-1] # slice out first and last characters
else:
    print("It's a palindrome.")
