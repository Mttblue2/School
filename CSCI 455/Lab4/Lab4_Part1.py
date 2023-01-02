import gmpy2
# import library
from gmpy2 import mpz

# set up parameters
c = mpz(28822365203577929536184039125870638440692316100772583657817939349051546473185)
n = mpz(70736025239265239976315088690174594021646654881626421461009089480870633400973)

e = mpz(3)

p = mpz(238324208831434331628131715304428889871)
q = mpz(296805874594538235115008173244022912163)

####################
# Decryption Process

phi = gmpy2.mul(p-1,q-1)
d = gmpy2.invert(e,phi)

m = gmpy2.powmod(c, d, n)

print("The private key component is:", d)
print("The original message is:", m)

print("The number of digits of the private key is:", gmpy2.num_digits(d))
