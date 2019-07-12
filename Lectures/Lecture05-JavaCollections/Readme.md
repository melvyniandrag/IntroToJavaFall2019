# Collection!
Choosing the right datastructure for the job is so important in programming. I'll give you an anecdote from my last job up in Beautiful Manchester, NH. We were working on a project that required a sort of container called a map/dictionary/associative array. The job was in C++, but the ideas are the same in Java. We've seen arrays in this class. A map/dictionary/assoc.array is like an array, with a little difference. Arrays are indexed with integers. In java array indexing starts at zero. So if you have an array like 

```
int[] data = {10,20,30,40,50,60,71,80,90,91};
System.out.println(data[0])
```

to initialize an array and grab the first element out of it.

But sometimes you want the array to be indexed not by numbers, but by a different type -  a string perhaps. Maybe I want to store the ages of all of you in an array and then find the age of Sally [ insert student name here ]. For that I'd have to know the index in the array that belongs to sally. Why not make the index of the array a string? I'll get back to my story in a second.

[Class assignment - write a program that allows me to supply a student's name on the command line and print out the student's name, or an error message if the student doesnt exist in the class. Also, make it handle the case of multiple students ahving the same name, like if there are two johns. I don't care how you handle it - Maybe make John01 and John02 or Maybe make the program take two parameters, first name and last name. That still doesnt handle the issue of a possible collision like John Smith or Miguel Rodriguez or Priyanka Patel so work out some scheme I don't care how you do it. Do something simple ].

When done, get back to the story. So you see that this is a pain in the neck - is there a better way?? There is, you can use a dictionary/map/associative array. You make the indices of the array a string, so you can say something liek 

```
System.out.println(AgeArray["John"]);
```

Java allows you to do this? I'll show you how in a second. The problem is that there are multiple ways to do this in C++ ( and java too, I'll show you in a second! ). One method has a run time of O(log(n)) and the other has a run time of 1. Constant run time. For the job I was on we were using an array and expected constant runtime, but the app kept running in logarithmic time, which was very frustrating becasue our code had to run in one microsecond and it was running in something like 5 microseconds, which was absolutely infuriating and had us stuck trying to solve the problem for the better part of 4 hours ( or however long it was, I forget ). Turns out the implementation we were using was using one implementation fo the associative array and not the other. Your task sometime before this class is over is to tell me which Java collection we were using and which one we thought we were using. Actually the trouble is in C++ the two classes were named in confusing ways, and in Java they are not.

https://docs.oracle.com/javase/tutorial/collections/TOC.html

Homework should be to make them time code using the different collections and show which ones are better for certain operations.
