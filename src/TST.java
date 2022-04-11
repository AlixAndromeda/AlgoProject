import java.util.ArrayList;
import java.util.Scanner;

public class TST<Integer> {
    private int n;              // size
    private Node<Integer> root;   // root of TST

    private static class Node<Integer> {
        private char c;                        // character
        private Node<Integer> left, mid, right;  // left, middle, and right subtries
        private Integer val;                     // Integer associated with string
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
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }
    public void put(String key, Integer val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) n++;
        else if(val == null) n--;       // delete existing key
        root = put(root, key, val, 0);
    }
    private Node<Integer> put(Node<Integer> x, String key, Integer val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<Integer>();
            x.c = c;
        }
        if      (c < x.c)               x.left  = put(x.left,  key, val, d);
        else if (c > x.c)               x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
        else                            x.val   = val;
        return x;
    }
    public ArrayList<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        ArrayList<String> queue = new ArrayList<String>();
        Node<Integer> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    private void collect(Node<Integer> x, StringBuilder prefix, ArrayList<String> queue) {
        if (x == null) return;
        collect(x.left,  prefix, queue);
        if (x.val != null) queue.add(prefix.toString() + x.c);
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }
    private class StopInfo {

        private String stop_id;
        private String stop_code;
        private String stop_name;
        private String stop_desc;
        private String stop_lat;
        private String stop_lon;
        private String zone_id;
        private String stop_url;
        private String location_type;
        private String parent_station;

        private StopInfo( String stop_id, String stop_code, String stop_name, String stop_desc,  String stop_lat, String stop_lon, String zone_id, String stop_url, String location_type,  String parent_station ) {
            this.stop_id = stop_id;
            this.stop_code = stop_code;
            this.stop_name = stop_name;
            this.stop_desc = stop_desc;
            this.stop_lat = stop_lat;
            this.stop_lon = stop_lon;
            this.zone_id = zone_id;
            this.stop_url = stop_url;
            this.location_type = location_type;
            this.parent_station = parent_station;
        }
        }
}
