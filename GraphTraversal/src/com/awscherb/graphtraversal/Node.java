package com.awscherb.graphtraversal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Represents a Node */
public class Node<T> {

    /** Data of this node */
    private T data;
    /** List of neighbors */
    private List<Node<T>> neighbors;
    
    /** Parent node of this node */
    private Node<T> parent;

    /** Public constructor */
    public Node(T t) {
        neighbors = new ArrayList<Node<T>>();
        data = t;
        parent = null;
    }

    /** Connect this node to the given node */
    public void addNeighbor(Node<T> n) {
        addNeighborHelper(n);
        n.addNeighborHelper(this);
    }
    
    /** Add the given node to our neighbor list */
    private void addNeighborHelper(Node<T> n) {
        neighbors.add(n);
    }

    /** Return the immediate neighbors of this node */
    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    /**
     * Returns true if a path exists to the given node from this node
     * @param n the node we want to navigate to
     * @return true if a path exists
     */
    public boolean hasPathTo(Node<T> n) {
        return getPathTo(n) != null;
    }
    
    /**
     * Gets path to given node from this node
     * @param n the node we want to navigate to
     * @return the list of nodes to the given node
     */
    public List<Node<T>> getPathTo(Node<T> n) {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        Queue<Node<T>> seen = new LinkedList<Node<T>>();
        
        queue.add(this);
        seen.add(this);
        
        while (! queue.isEmpty()) {
            Node<T> t = queue.poll();
            if (t.equals(n)) {
                return getParentPath(t);
            }
            
            for (Node<T> a : t.neighbors) {
                if (! (seen.contains(a))) {
                    a.parent = t;
                    seen.add(a);
                    queue.add(a);
                }
            }
        }
        return null;      
    }
    
    /**
     * Return the list of parent nodes up to the root.
     * @param n the node we want the family tree of
     * @return the list of parents
     */
    public List<Node<T>> getParentPath(Node<T> n) {
        List<Node<T>> out = new ArrayList<Node<T>>();
        while (n.parent != null) {
            out.add(0, n);
            n = n.parent;
        }
        return out;
    }
    
    /** toString() method override */
    public String toString() {
        return data.toString();
    }
    
    /** 
     * Checks equality
     * @param o the object we want to check against this
     * @return true if they have the same data
     */
    public boolean equals(Object o) {
        if (o == null || (!(o instanceof Node<?>))) {
            return false;
        }
        else {
            Node<?> n = (Node<?>)o;
            return n.data.equals(data);
        }
    }
}
