import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class TST<Value> {
    private int n;
    private Node<Value> root;

    public static class Node<Value> {
        char c;
        Node<Value> left, mid, right;
        Value val;
    }
    public boolean contains(String key) {
        if (key == null) {
            throw new IllegalArgumentException(("argument to contains() is null"));
        }
        return get(key) != null;
    }
    public Value get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null arguement");
        }
        if (key.length() == 0) throw new IllegalArgumentException("Key muust have length >= 1");
        Node <Value> x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }
    private Node<Value> get (Node<Value> x, String key, int d) {
        if (x == null) return null;
        if (key.length() == 0) throw new IllegalArgumentException(("key must have length >= 1"));
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d+1);
        else return x;
    }
    public void put(String key, Value val) {
        if ( key ==  null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) n++;
        else if (val == null) n--;
        root = put(root, key, val, 0);
    }
    private Node<Value> put(Node<Value> x, String key, Value val, int d) {
        char c = key.charAt(d);
        x = new Node<Value>();
        x.c = c;
        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d+1);
        else x.val = val;
        return x;
    }
    public ArrayList<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        ArrayList<String> queue = new ArrayList<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    private void collect (Node<Value> x, StringBuilder prefix, ArrayList<String> queue) {
        if (x == null) return;
        collect (x.left, prefix, queue);
        if (x.val != null) queue.add(prefix.toString() + x.c);
        collect (x.mid, prefix.append(x.c),queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }
}