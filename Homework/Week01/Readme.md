# Homework 1

Write a class with a main method that contains members of type:

  1. int
  2. byte
  3. short
  4. long
  5. float
  6. double
  7. boolean
  8. char
  9. int[]
  
This class should have methods:

1. getMyInt()
2. getMyByte()
3. etc.
9. getMyIntArray()
// for a total of 9 of these 'getter methods'.

And each of those methods should print out the value you assigned to the member variable.For getMyIntArray() you will need a loop to loop over the array and print each int.

The class should also have methods:
1. useAnIfElseStatement() // contains an if{}else{} statement
2. useAWhileLoop() // contains a while loop
3. useAndComparator() // uses &&
4. useOrComparator() // uses ||

This little assignment is to get your feet wet with basic Java syntax.

Example Incomplete submission 'Homework1.java':
```
class Homework1
{
  int myInt = 1;
  public int getMyInt(){
    return myInt;
  }
  public static void main(String[] args){
    getMyInt();
  }
}
```

## Submission Guidelines
Due before 7PM on 9/11. No late submissions - not even at 7:01!! Part of programming is managing your time and accomplishing coding tasks in a reasonable amount of time.
