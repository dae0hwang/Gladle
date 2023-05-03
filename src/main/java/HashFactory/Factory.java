package HashFactory;

public class Factory {

    public Hash createHash(int size) {
        return new Hash(size);
    }
}
