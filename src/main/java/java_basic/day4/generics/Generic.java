package java_basic.day4.generics;

/* Gabriel Kiprono
 * Generics practice
 *
 *
 *
 */

public class Generic<K, V> {
    private K key;
    private V value;

    public Generic(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Generic() {

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
