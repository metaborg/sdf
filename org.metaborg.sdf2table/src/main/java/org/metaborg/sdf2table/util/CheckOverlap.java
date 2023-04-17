package org.metaborg.sdf2table.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Sort;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.util.collection.SetMultimap;

public class CheckOverlap {

    private final SCCNodes<ISymbol> scc;
    private final Set<IProduction> p;
    private final Set<IProduction> q;
    private final int maxDepth;
    private final Map<Integer, Set<Node>> depthToTreesP = new HashMap<>();
    private final Map<Integer, Set<Node>> depthToTreesQ = new HashMap<>();
    private final SetMultimap<String, Node> yieldsP = new SetMultimap<>();
    private final SetMultimap<String, Node> yieldsQ = new SetMultimap<>();

    private class Node {

        private final ISymbol symbol;
        private final List<Node> children;
        private final List<Node> leaves;
        public final Set<IProduction> productions;

        public Node(ISymbol s) {
            this.symbol = s;
            leaves = new ArrayList<>();
            children = new ArrayList<>();
            productions = new HashSet<IProduction>();
        }

        public Node(IProduction p) {
            this.symbol = p.leftHand();
            leaves = new ArrayList<>();
            children = new ArrayList<>();
            productions = new HashSet<>(Arrays.asList(p));
            for(ISymbol symb_rhs : p.rightHand()) {
                Node child = new Node(symb_rhs);
                children.add(child);
                leaves.add(child);
            }
        }

        public Node(Node n) {
            this.symbol = n.symbol;
            this.leaves = new ArrayList<>();
            this.children = new ArrayList<>();
            this.productions = new HashSet<>(n.productions);


            // if the child object is the same as the leaf object, create new object which is a copy of it
            for(Node child : n.children) {
                Node newChild = new Node(child);
                children.add(newChild);
                if(newChild.leaves.isEmpty()) {
                    leaves.add(newChild);
                } else {
                    leaves.addAll(newChild.leaves);
                }
            }

        }

        public String getYield() {
            String result = "";

            if(leaves.isEmpty()) {
                return symbol.toString();
            }

            for(Node leaf : leaves) {
                ISymbol leafSymb = leaf.symbol;
                if(leafSymb.toString().equals("LAYOUT?-CF")) {
                    result += " ";
                } else if(leafSymb instanceof Sort && ((Sort) leafSymb).getType() != null) {
                    result += ((Sort) leafSymb).getSortName();
                } else {
                    if(scc.nodeSCCNodesMapping.get(leafSymb) != null) {
                        result += "[";

                        List<ISymbol> sccNode = new ArrayList<>(scc.nodeSCCNodesMapping.get(leafSymb));

                        for(int i = 0; i < sccNode.size() - 1; i++) {
                            result += Symbol.getSort(sccNode.get(i)) + ", ";
                        }
                        result += Symbol.getSort(sccNode.get(sccNode.size() - 1)) + "]";

                        scc.nodeSCCNodesMapping.get(leafSymb).toString();
                    } else {
                        result += Symbol.getSort(leafSymb).toString();
                    }
                }
            }
            
            return result;
        }

        @Override public int hashCode() {
            return toString().hashCode();
        }

        @Override public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            return this.toString().equals(other.toString());
        }

        @Override public String toString() {
            if(children.isEmpty()) {
                return symbol.toString();
            }

            String result = "[" + symbol + " = ";

            for(int i = 0; i < children.size() - 1; i++) {
                result += children.get(i).toString() + " ";
            }

            result += children.get(children.size() - 1).toString() + "]";

            return result;
        }



    }

    public CheckOverlap(Set<IProduction> p, Set<IProduction> q, int maxDepth, SCCNodes<ISymbol> scc) {
        this.p = p;
        this.q = q;
        this.maxDepth = maxDepth;
        this.scc = scc;
    }

    public String checkHarmfulOverlap() {
        int depth = 0;
        Set<Node> treesP = new HashSet<Node>();
        Set<Node> treesQ = new HashSet<Node>();

        for(IProduction prod : p) {
            Node node = new Node(prod);
            yieldsP.put(node.getYield(), node);
            node.productions.add(prod);
            treesP.add(node);
        }

        for(IProduction prod : q) {
            Node node = new Node(prod);
            yieldsQ.put(node.getYield(), node);
            treesQ.add(node);
        }

        depthToTreesP.put(depth, treesP);
        depthToTreesQ.put(depth, treesQ);

        while(depth < 2) {

            Set<String> intersectingYields = new HashSet<>(yieldsP.keySet());
            intersectingYields.retainAll(yieldsQ.keySet());

            for(String yield : intersectingYields) {
                Set<Node> nodesP = yieldsP.get(yield);
                Set<Node> nodesQ = yieldsQ.get(yield);

                if(!nodesP.equals(nodesQ)) {
                    Set<IProduction> prodsP = new HashSet<IProduction>();
                    Set<IProduction> prodsQ = new HashSet<IProduction>();

                    for(Node n : nodesP) {
                        prodsP.addAll(n.productions);
                    }

                    for(Node n : nodesQ) {
                        prodsQ.addAll(n.productions);
                    }

                    if(!prodsP.equals(prodsQ)) {
                        return yield;
                    }
                }
            }

            depth++;

            treesP = getNewTrees('p', depth);
            treesQ = getNewTrees('q', depth);



        }
        return null;
    }

    private Set<Node> getNewTrees(char set, int depth) {
        Set<Node> oldTrees, newTrees = new HashSet<Node>();
        if(set == 'p') {
            oldTrees = depthToTreesP.get(depth - 1);
            for(Node n : oldTrees) {
                for(int i = 0; i < n.leaves.size(); i++) {
                    Node leaf = n.leaves.get(i);
                    // if leaf is recursive expand tree
                    // TODO Consider indirect recursion (need to consider other productions to construct trees)
                    if(n.symbol.equals(leaf.symbol)) {
                        for(IProduction prod : p) {
                            Node newTree = new Node(n); // take copy of old tree
                            newTree.productions.add(prod);
                            Node leafNewTree = newTree.leaves.get(i); // get leaf from new tree
                            newTree.leaves.remove(i); //
                            for(int j = 0; j < prod.arity(); j++) {
                                Node newLeaf = new Node(prod.rightHand().get(j));
                                newTree.leaves.add(i + j, newLeaf);
                                leafNewTree.children.add(newLeaf);
                            }
                            String yield = newTree.getYield();
                            if(yieldsP.containsKey(yield)) {
                                yieldsP.put(yield, newTree);
                                continue;
                            }
                            yieldsP.put(yield, newTree);
                            newTrees.add(newTree);
                        }
                    }
                }
            }
            depthToTreesP.put(depth, newTrees);
            // for(Node tree : newTrees) {
            // System.out.println(tree.getYield());
            // }
            // System.out.println("");
        } else {
            oldTrees = depthToTreesQ.get(depth - 1);

            for(Node n : oldTrees) {
                for(int i = 0; i < n.leaves.size(); i++) {
                    Node leaf = n.leaves.get(i);
                    // if leaf is recursive expand tree
                 // TODO Consider indirect recursion (need to consider other productions to construct trees)
                    if(n.symbol.equals(leaf.symbol)) {
                        for(IProduction prod : q) {
                            Node newTree = new Node(n); // take copy of old tree
                            newTree.productions.add(prod);
                            Node leafNewTree = newTree.leaves.get(i); // get leaf from new tree
                            newTree.leaves.remove(i); //
                            for(int j = 0; j < prod.arity(); j++) {
                                Node newLeaf = new Node(prod.rightHand().get(j));
                                newTree.leaves.add(i + j, newLeaf);
                                leafNewTree.children.add(newLeaf);
                            }
                            String yield = newTree.getYield();
                            if(yieldsQ.containsKey(yield)) {
                                yieldsQ.put(yield, newTree);
                                continue;
                            }
                            yieldsQ.put(yield, newTree);
                            newTrees.add(newTree);
                        }
                    }
                }
            }



            depthToTreesQ.put(depth, newTrees);
        }
        return newTrees;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public Set<IProduction> getQ() {
        return q;
    }

    public Set<IProduction> getP() {
        return p;
    }

}
