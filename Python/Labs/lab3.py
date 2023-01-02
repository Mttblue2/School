import string

VOWELS = "aeiou"
word = input("Enter a word ('quit' to quit): ")
word = word.lower()

while (word != "quit"):
    if (word == ""):
        print("Can't convert empty string.  Try again.")
    elif (word[0] in VOWELS):
        word = word + "way"
    else:
        for ch in word:
            if (ch in VOWELS):
                break
            else:
                word = word[1::1] + word[0]
        word = word + "ay"
    
    if (word != ""):
        print("Your word in Pig Latin: " + word)
    
    word = input("Enter a word ('quit' to quit): ")
    word = word.lower()
    
    
    
