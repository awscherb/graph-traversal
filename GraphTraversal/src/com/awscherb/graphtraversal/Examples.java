package com.awscherb.graphtraversal;

public class Examples {
    
    static Node<String> n1 = new Node<String>("n1");
    static Node<String> n2 = new Node<String>("n2");
    static Node<String> n3 = new Node<String>("n3");
    static Node<String> nn2 = new Node<String>("nn2");
    static Node<String> nn3 = new Node<String>("nn3");
    static Node<String> nnn2 = new Node<String>("nnn2");
    static Node<String> nnn3 = new Node<String>("nnn3");
    static Node<String> nnnn2 = new Node<String>("nnnn2");
    static Node<String> nnnn3 = new Node<String>("nnnn3");
    
    static Node<String> a1 = new Node<String>("a1");
    static Node<String> aa1 = new Node<String>("aa1");
    static Node<String> aa2 = new Node<String>("aa2");

    
    public static void init() {
        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n1.addNeighbor(a1);
        a1.addNeighbor(aa1);
        a1.addNeighbor(aa2);
        n2.addNeighbor(nn2);
        n3.addNeighbor(nn3);
        nn3.addNeighbor(nnn3);
        nn3.addNeighbor(nnnn3);
        nn2.addNeighbor(nnn2);
        nn2.addNeighbor(nnnn2);
    }
    
    public static void main(String[] args) {
        init();
 
        out(nnnn2.hasPathTo(n1));
        out(aa2.getPathTo(n1));
    }
    
    /** System output convenience method */
    public static void out(Object o) {
        System.out.println(o);
    }

}
