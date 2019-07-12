# Homework 7
Write a Java program that contains a method/class that returns a collection of historical events associated with a given Date object.

Here is a quick sketch of the code I thought up. You can use it for inspiration, or go your own route.

```
public class HistoricalEventFinder{
	HashMap<String, ArrayList<String>> eventMap = new HashMap<String, ArrayList<String>>();
	// populate this map with a few things

	public Collection getHistoricalEvents( Date d ){
		String s = d.toString();
		if( s is in eventMap keys ){
			return eventMap[s];		
		}
		else {
			return new ArrayList<String>();
		}
	}

	public static void main(String[] args){
		Date d1 = blah;
		Date d2 = foobar;
		
		returnValue = getHistoricalEvents(d1);
		// print out the historical events
		
		returnValue2 = getHistoricalEvents(d2);
		//print out the historical events. If returnValue2 is empty, print out "there were no historical events on PUT_THE_DATE_HERE.
	}
}
```

## Submission guidelines
Submit your java file(s) and your code output on time. All submissions must be unique for credit.
