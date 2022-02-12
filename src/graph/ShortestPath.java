package graph;

import java.util.*;

class ShortestPath {

  static class Graph {
    int vertices;
    Vector<Integer>[] adj;

    static int level;

    // Constructor
    Graph(int vertices) {
      this.vertices = vertices;
      this.adj = new Vector[2 * vertices];

      for (int i = 0; i < 2 * vertices; i++)
        this.adj[i] = new Vector<>();
    }

    public void addEdge(int v, int w, int weight) {
      if (weight == 2) {
        adj[v].add(v + this.vertices);
        adj[v + this.vertices].add(w);
      } else {
        adj[v].add(w);
      }
    }

    public int printShortestPath(int[] parent, int s, int d) {
      level = 0;
      if (parent[s] == -1) {
        System.out.printf("Shortest Path between " + "%d and %d is %s ", s, d, s);
        return level;
      }
      printShortestPath(parent, parent[s], d);
      level++;
      if (s < this.vertices) {
        System.out.printf("%d ", s);
      }
      return level;
    }

    public int findShortestPath(int src, int dest) {
      boolean[] visited = new boolean[2 * this.vertices];
      int[] parent = new int[2 * this.vertices];
      for (int i = 0; i < 2 * this.vertices; i++) {
        visited[i] = false;
        parent[i] = -1;
      }
      Queue<Integer> queue = new LinkedList<>();
      visited[src] = true;
      queue.add(src);

      while (!queue.isEmpty()) {
        int s = queue.peek();

        if (s == dest)
          return printShortestPath(parent, s, dest);
        queue.poll();
        for (int i : this.adj[s]) {
          if (!visited[i]) {
            visited[i] = true;
            queue.add(i);
            parent[i] = s;
          }
        }
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    int vertex = 4;
    Graph g = new Graph(vertex);
    g.addEdge(0, 1, 2);
    g.addEdge(0, 2, 2);
    g.addEdge(1, 2, 1);
    g.addEdge(1, 3, 1);
    g.addEdge(2, 0, 1);
    g.addEdge(2, 3, 2);
    g.addEdge(3, 3, 2);

    int src = 0, dest = 3;
    System.out.printf("\nShortest distance between" + " %d and %d is %d\n", src, dest,
        g.findShortestPath(src, dest));
  }
}
