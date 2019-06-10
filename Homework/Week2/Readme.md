# Homework 2

## Problem 1
This assignment was shamelessly lifted from here:
https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn03.pdf

__Student Time(min)__
Elena  341
Thomas 273
Juan   278
Maria  329
Phil   445
Matt   402
Alex   388
Emma   275
John   243
James  334
Jane   412
Emily  393
Daniel 299
Neda   343
Aaron  317
Kate   265 

This table contains student names and how long it took them to run 26.2 miles. Write a Java class containing this data that has two methods:

1. getFastestRunner()
2. getSecondFastestRunner()

*getFastestRunner()* returns a string of the form "The fastest runner was Name who ran the race in MINUTES minutes.". And the getSecondFastestRunner() method returns a similar string.

Code to get you started:

```
class Marathon {
  public static void main (String[] arguments) {
    String[] names = {
      "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
      "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
      "Aaron", "Kate"
    };
    int[] times = {
      341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
      343, 317, 265
    };
    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i] + ": " + times[i]);
    }
    
    String fastest = getFastestRunner();
    System.out.println(fastest);
    
    String ifYouAintFirstYoureLast = getSecondFastestRunner();
    System.out.println(ifYouAintFirstYoureLast);
    
  }
}
```

## Problem 2

Shamelessly lifted from here: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn04.pdf
