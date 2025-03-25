***Java-TopoSort***

This program creates a topologically sorted representation of a directed acyclic graph (DAG) using a depth first search algorithm. It reads in the graph from a user-provided file, and displays the 
traversal of points in the sorted order. While multiple outputs are possible for a given DAG, all outputs are guaranteed to maintain the ordering where all children of a node are displayed before 
the parent node. The program requires that the input graph is a DAG, meaning it will not work as intended if the input is undirected or contains any repeating loops or cycles.

Input:
```
<source node 1>: <destination>, <destination>
<source node 2>: <destination>, <destination>
```


Usage: javac Toposort.java, java Toposort <input.txt>
