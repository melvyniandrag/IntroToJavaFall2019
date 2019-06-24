# Text and Java
The way computers deal with text is very interesting. Since we have little time here, I'll give you a brief summary of the details of the challenges of dealing with text encodings. Way back when computers were being programmed for the first time and datatypes were being defined for difference programming languages we got a standard text encoding called ASCII. This was a 1 byte text encoding that represented characters like this:
http://www.asciitable.com/
In fact the encoding only used 7 bits of the byte, not 8 bits. So there were 2^7 possible characters to be written with these 7 bits. Have a look at the table. 128  2 ^ 7 is enough characters to represent all of the 26 english characters in both lower case and capital. There was also space for numbers and punctuation, as well as some things like blank lines, carriage returns, tabs, even a bell sound ( '\a' ). Fast forward some years, however, and computer technology moved out of American Labs and AT&T - people all over the world began using computers for programming as well as for writing blog posts, and they wanted to write in their own language - but the 1 byte text encoding doesnt have space for characters in other languages! There is no space for Cyrillic characters, for example https://en.wikipedia.org/wiki/Cyrillic_alphabets, so how were Russians supposed to easily handle Russian text? Then fast forward a few more years and a bunch of hooligans wanted to send each other smiley faces and poop symbols over WhatsApp - there certainly was no space for a Poop emoji in 2^7 many possible characters. Some different computer technologies started using the 8th unused bit in the 1 byte char datatype to allow more values - from this point on there were 2^8 possible characters - but this is still not enough. 2^8 = 256 and how many Chinese characters are there? TONS! tl;dr: Characters used to be represented by 1 byte - ASCII was the standard encoding - but people needed more characters than could fit in one byte.

This is where text encodings come in. There are several

https://stackoverflow.com/questions/36236364/why-java-char-uses-utf-16
https://softwareengineering.stackexchange.com/questions/174947/why-does-java-use-utf-16-for-internal-string-representation
https://softwareengineering.stackexchange.com/questions/102205/should-utf-16-be-considered-harmful
https://codeahoy.com/2016/05/08/the-char-type-in-java-is-broken/
https://stackoverflow.com/questions/3240498/why-does-the-java-ecosystem-use-different-character-encodings-throughout-their-s
https://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
https://utf8everywhere.org/
https://medium.com/@apiltamang/unicode-utf-8-and-ascii-encodings-made-easy-5bfbe3a1c45a

I've never wrestled with text encodings in Java on a professional level -though I have faced really challenging problems involving text encoding in C, C++, C#, Python2, Python3, Bash, Awk, and sed, and so I know quite a bit about the types of problems you will need to solve when dealing with text encodings. I'll start by presenting you with the details of how text encodings work and where they come from to help you understand what the problem is. 


## Unicode and Java
See question 2a here: https://docs.oracle.com/javase/tutorial/java/data/QandE/characters-questions.html

Discussion of text encodings. How does java handle UTF8 strings? How does it handle UTF16?

## Unicode in URLs
Paste this into a browser:
https://ko.wikipedia.org/wiki/위키백과

Then copy the address from the address bar and paste it into a text file using sublime or notepad or the like. Notice the URL now looks like:
https://ko.wikipedia.org/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC

