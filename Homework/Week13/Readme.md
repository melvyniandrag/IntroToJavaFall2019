# Homework 
In class we learned about BFS using ints for the vertices. 

See the attached code sample I stole from https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

The output of the code is:

```
Following is Breadth First Traversal (starting from vertex 2)
2 0 3 1
```

Change the code so that the graph is composed of these objects:

```
public/private/howeveryouwant class GraphNode{
	private String nodeName;
	
	public String getName(){
		return nodeName;
	}
	
	GraphNode(String name){
		nodeName = name;
	}	
}
```

And the output should be:

```
The Breadth First Traversal starting from Bob is:
Mary
Jane
Pete
```

Your adjacency list will be a `LinkedList<GraphNode>` and the call to `System.out.print(s+" ");` will be something like `System.out.println(s.getName())`

## Submission guidelines
Submit your java code and the output saved as a .txt on time. Everyone should have a unique output for their code (if youre going to work together, at least change the names of your nodes so your submissions aren't identical).
