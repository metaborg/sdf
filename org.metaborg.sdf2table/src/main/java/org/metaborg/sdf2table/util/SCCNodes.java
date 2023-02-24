package org.metaborg.sdf2table.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SCCNodes<T> {
    final Graph<T> orig;
    Graph<List<T>> scc;
    List<Set<T>> sccNodes;
    Set<T> nodesComponent;
    Map<T, Set<T>> nodeSCCNodesMapping;

    public SCCNodes(Graph<T> orig) {
        this.orig = orig;
        sccNodes = new ArrayList<>();
        nodeSCCNodesMapping = new HashMap<>();
    }

    // The main function that finds and prints all strongly
    // connected components
    public void calculateSCCNodes() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[orig.totalV()];
        for(int i = 0; i < orig.totalV(); i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for(int i = 0; i < orig.totalV(); i++)
            if(visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        Graph<T> gr = orig.getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for(int i = 0; i < orig.totalV(); i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while(stack.empty() == false) {
            // Pop a vertex from stack
            int v = (int) stack.pop();

            // Print Strongly connected component of the popped vertex
            if(visited[v] == false) {
                nodesComponent = new HashSet<T>();
                DFSUtil(gr, v, visited);
                if(nodesComponent.size() > 1) {
                    sccNodes.add(nodesComponent);
                }
                // System.out.println();
            }
        }

        for(Set<T> sccNode : sccNodes) {
            for(T origNode : sccNode) {
                nodeSCCNodesMapping.put(origNode, sccNode);
            }
        }
    }

    // A recursive function to print DFS starting from v
    private void DFSUtil(Graph<T> g, int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        nodesComponent.add(g.getLabels().inverse().get(v));
        // System.out.print(g.getLabels().inverse().get(v) + " ");

        int n;

        List<Integer>[] adj = g.getAdjacencyList();

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while(i.hasNext()) {
            n = i.next();
            if(!visited[n])
                DFSUtil(g, n, visited);
        }
    }

    private void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        List<Integer>[] adj = orig.getAdjacencyList();

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    public Map<T, Set<T>> getNodesMapping() {
        return nodeSCCNodesMapping;
    }
    
    public List<Set<T>> getSCCNodes() {
        return sccNodes;
    }


}
