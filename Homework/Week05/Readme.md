# Homework 5

In class we already timed operations with various collections in Java. For homework you must generate a table that looks like:

| Collection                       | Hash Set | Array List | Linked List | Tree Set |
| -------------------------------- | -------- | ---------- | ----------- | -------- |
| Size=10,     Find Random Element | time     | time       | time        | time     |
| Size=100,    Find Random Element | time     | time       | time        | time     |
| Size=1000,   Find Random Element | time     | time       | time        | time     |
| Size=10000,  Find Random Element | time     | time       | time        | time     |
| Size=100000, Find Random Element | time     | time       | time        | time     |
| Complexity                       | O(?)     | O(?)       | O(?)        | O(?)     |

A common situation in writing code is gathering a collection of objects to be used at a later time. Something like this:

```
public void gather(){
	Collection collection = new Collection();
	
	// gather some data into the collection

	return collection;
}

public bool doesCollectionContainElement( element, collection ){
	if ( collection contains element )
		return true;
	else
		return false;
}
```

Depending on the collection you used, this operation will be fast or slow, depending on the collection you chose to use. 
This homework will give you an understanding of which collections are fast and which are slow for this purpose.

Note: When you take a data structures class you'll look at this more in depth as there are also costs for inserting elements, 
removing elements, sorting, etc. We're just testing one property of the collection - how fast to detect if an element is in the collection.

## Submission guidelines
Submit your code and the output in a .txt file before 7PM on XXX day

## Sample code to get you started
If I have time I'll put something here, otherwise just use the code we wrote in class
to get you started.
