# Midterm Exam

Write a java class to take in some binary data, parse it and return an object containing a reinterpretation of the binary data!

i.e. takes an Int32 where:

bits 0-8 represent a char
bits 9-15 represent a char
bits 16-23 are junk
bits 24-31 are bools.

The return value should be a Class with 10 fields:
char1
char2
ArrayList of bools.
