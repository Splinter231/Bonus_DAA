# Edge Removal from an MST
by: Chepurnenko Sergey  
group: SE-2422

This project demonstrates the full process of working with a Minimum Spanning Tree (MST) using Kruskal’s algorithm, removing an edge from the MST, finding the resulting connected components, and restoring the MST by selecting a minimum-weight replacement edge.

## Features

The program performs the following steps:

1. Builds an MST from a given graph using **Kruskal’s algorithm**
2. Displays all MST edges **before removal**
3. Removes one selected edge from the MST
4. Computes and prints the **two connected components** created after removal
5. Scans all original edges to find the **minimum-weight replacement edge** that reconnects the components
6. Builds and prints the **final MST** after reconnection
7. Outputs the **total weight** of the final MST

The implementation is minimal and simple, following the required bonus task structure.

## Requirements
- Java 17
- Maven

## How to build and run

Clone the repository:
git clone https://github.com/Splinter231/Bonus_DAA  
cd Bonus_DAA


Build:
mvn clean package

This will generate:
target/<project-name>-1.0-SNAPSHOT.jar

Run the program:
java -jar target/<project-name>-1.0-SNAPSHOT.jar

The program uses a built-in example graph (you may modify `Main.java` to test other inputs).

## Example Output

The program prints:

- MST edges before removal
- The removed edge
- Two connected components
- The chosen replacement edge
- Final MST after reconnection
- Total MST weight

## Implementation Notes

- MST is built using **Kruskal’s algorithm**.
- Components are found using a simple **BFS** traversal.
- The replacement edge is found in **O(E)** time by scanning all original edges.
- The project contains the following classes:
    - `Edge.java` – edge model
    - `Graph.java` – simple graph helper (optional)
    - `UnionFind.java` – disjoint set data structure
    - `KruskalMST.java` – MST builder
    - `Main.java` – main program logic  
