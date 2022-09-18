package map;

public abstract class MyMap<K, V> {
    protected int size;

    protected MyMap() {
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public abstract void put(K key, V value);

    public abstract void remove(K key);

    public abstract void clear();

    public abstract V get(K key);
}
