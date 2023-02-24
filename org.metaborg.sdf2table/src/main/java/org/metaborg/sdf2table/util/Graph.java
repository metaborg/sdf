package org.metaborg.sdf2table.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Graph<T> {

    public BiMap<T, Integer> getLabels() {
        return labels;
    }

    public void setLabels(BiMap<T, Integer> labels) {
        this.labels = labels;
    }

    private int labelCount = 0; // total number of vertices
    private BiMap<T, Integer> labels;
    private List<Integer> adjacencyList[];

    public Graph(int v) {
        labels = HashBiMap.create();
        adjacencyList = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }
    }

    public Graph(Collection<T> orig_labels) {
        labels = HashBiMap.create();
        adjacencyList = new LinkedList[orig_labels.size()];
        addVertices(orig_labels);
        for(int i = 0; i < orig_labels.size(); i++) {
            for(int j = 0; j < orig_labels.size(); j++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }
    }

    public void addVertices(Collection<T> orig_labels) {
        for(T orig_label : orig_labels) {
            labels.put(orig_label, labelCount++);
        }
    }

    public void addEdge(T orig, T dest) {
        adjacencyList[labels.get(orig)].add(labels.get(dest));
    }

    @Override public String toString() {
        
        
        String result = "               ";
        for(int i = 0; i < labelCount; i++) {
            result += String.format("%" + 15 + "s", labels.inverse().get(i));
        }
        
        result += "\n";

        for(int i = 0; i < labelCount; i++) {
            result += String.format("%" + 15 + "s", labels.inverse().get(i));
            for(int j = 0; j < labelCount; j++) {
                if(adjacencyList[i].contains(j)) {
                    result += String.format("%" + 15 + "d", 1);
                } 
                else {
                    result += String.format("%" + 15 + "s", "");
                }
            }
            result += "\n";
        }


        result += "\n";
        return result;
    }

    public int totalV() {
        return labelCount;
    }

    public Graph<T> getTranspose() {
        Graph<T> transpose = new Graph<>(labels.keySet());
        
        for(int i = 0; i < labelCount; i++) {
            for(int j = 0; j < labelCount; j++) {
                if(adjacencyList[i].contains(j)) {
                    transpose.addEdge(labels.inverse().get(j), labels.inverse().get(i));
                }
            }
        }
        
        return transpose;
    }

    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    } 
}
