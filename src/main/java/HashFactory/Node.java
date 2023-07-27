package HashFactory;

import lombok.Builder;

@Builder
public class Node {

    String key;
    String value;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}