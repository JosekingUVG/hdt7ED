package uvg;

/**
 * Clase base que representa una asociación de clave y valor.
 * 
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor asociado a la clave.
 */
public class Association<K, V> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Cambia setValue para que devuelva un valor de tipo V
    public V setValue(V value) {
    V oldValue = this.value;
    this.value = value;
    return oldValue;  // Devuelves el valor anterior, como espera Map.Entry
    }


    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
