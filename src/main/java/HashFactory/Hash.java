package HashFactory;

import java.util.Iterator;
import java.util.LinkedList;
import lombok.AllArgsConstructor;
import lombok.Lombok;

@AllArgsConstructor



public class Hash {

    class Node {

        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
//        Lombok AllArgsConstructor
    }

    private LinkedList<Node>[] table;

    public Hash(int size) {
        table = new LinkedList[size];
    }

    private int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += (int) c;
        }
        return hashCode;
    }

    private int getIndex(int hashCode) {
        return hashCode % table.length;
    }


    //이터레이터로 원하는 노드 찾기.
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
            table[index] = new LinkedList<Node>();
            table[index].add(new Node(key, value));
        } else {
            Node searched = searchNode(index, key);
            if (searched != null) {
                searched.value = value;
            }else {
                table[index].add(new Node(key, value));
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
