# Homework 8

Create a UTF-8 encoded text file called `mytext.utf8`.
Write a Java program to read the UTF-8 encoded file, translate the text to UTF-16, and dump out this text in a file called `mytext.utf16`. 
Run the same Java program, feeding it the UTF-16 encoded file this time.
Ensure that the program barfs appropriately.

## Submission Guidelines
Due before 7PM next week. Submit:
1. Your code file(s)
2. mytext.utf8
3. mytext.utf16.

For credit:
1. mytext.utf8 must be utf8 encoded
2. your code must compile and generate mytext.utf16 when I run it on the command line, supplying it mytext.utf8 as a parameter.
3. Your code must barf when I run `java UnicodeExample mytext.utf16`.
