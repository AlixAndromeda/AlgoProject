import java.util.ArrayList;
import java.util.Scanner;

//Taken from the book

public class TST<Integer> {
    private int n;              //The size
    private Node<Integer> root;   //Roots

    private static class Node<Integer> {
        private char c;
        private Node<Integer> theleft, themid, theright;
        private Integer val;
    }

    public TST() {
    }

    public boolean contains(String key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public Integer get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null argument");
        }
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        Node<Integer> x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node<Integer> get(Node<Integer> x, String key, int d) {
        if (x == null) return null;
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        char c = key.charAt(d);
        if (c < x.c) return get(x.theleft, key, d);
        else if (c > x.c) return get(x.theright, key, d);
        else if (d < key.length() - 1) return get(x.themid, key, d + 1);
        else return x;
    }
    public void place(String key, Integer val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) n++;
        else if(val == null) n--;       // delete existing key
        root = put(root, key, val, 0);
    }
    private Node<Integer> put(Node<Integer> i, String key, Integer theValue, int p) {
        char c = key.charAt(p);
        if (i == null) {
            i = new Node<Integer>();
            i.c = c;
        }
        if      (c < i.c)               i.theleft  = put(i.theleft,  key, theValue, p);
        else if (c > i.c)               i.theright = put(i.theright, key, theValue, p);
        else if (p < key.length() - 1)  i.themid   = put(i.themid,   key, theValue, p+1);
        else                            i.val   = theValue;
        return i;
    }
    public ArrayList<String> keysWithPrefix(String previous) {
        if (previous == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        ArrayList<String> Q = new ArrayList<String>();
        Node<Integer> x = get(root, previous, 0);
        if (x == null) return Q;
        if (x.val != null) Q.add(previous);
        collect(x.themid, new StringBuilder(previous), Q);
        return Q;
    }
    private void collect(Node<Integer> i, StringBuilder previous, ArrayList<String> theQ) {
        if (i == null) return;
        collect(i.theleft,  previous, theQ);
        if (i.val != null) theQ.add(previous.toString() + i.c);
        collect(i.themid,   previous.append(i.c), theQ);
        previous.deleteCharAt(previous.length() - 1);
        collect(i.theright, previous, theQ);
    }

}
