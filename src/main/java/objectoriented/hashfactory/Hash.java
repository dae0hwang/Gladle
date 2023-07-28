package objectoriented.hashfactory;

import java.util.Iterator;
import java.util.LinkedList;

public class Hash {

    private LinkedList<Node>[] table;

    public Hash(int size) {
        table = new LinkedList[size];
    }

    private int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    private int getIndex(int hashCode) {
        return hashCode % table.length;
    }

    private Node searchNode(int index, String key) {
        if (table[index] == null) {
            return null;
        }
        Iterator<Node> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
            table[index].add(Node.builder().key(key).value(value).build());
        } else {
            Node searched = searchNode(index, key);
            if (searched != null) {
                searched.value = value;
            }else {
                table[index].add(Node.builder().key(key).value(value).build());
            }
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        Node searched = searchNode(index, key);
        if (searched == null) {
            return "null";
        }else {
            return searched.value;
        }
    }
}
