package uvg;

/**
 * Clase que representa una asociación entre una clave y un valor
 * que puede ser comparada con otras asociaciones.
 * 
 * @param <K> Tipo de la clave, debe implementar la interfaz Comparable.
 * @param <V> Tipo del valor asociado a la clave.
 *
 * Esta clase es útil en estructuras de datos como árboles binarios
 * o montículos, donde los elementos deben mantener un orden.
 */
public class ComparableAssociation<K extends Comparable<K>, V> extends Association<K, V>
        implements Comparable<ComparableAssociation<K, V>>, java.util.Map.Entry<K, V> {

    /**
     * Construye una asociación comparable con una clave y un valor.
     *
     * @param key   La clave de la asociación, no puede ser nula.
     * @param value El valor asociado a la clave (puede ser nulo).
     * @throws IllegalArgumentException si la clave es nula.
     */
    public ComparableAssociation(K key, V value) {
        super(key, value);
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
    }

    /**
     * Compara esta asociación con otra basada en las claves.
     *
     * @param other Otra instancia de ComparableAssociation con la cual comparar.
     * @return Un número negativo si esta clave es menor, cero si son iguales,
     *         o un número positivo si es mayor.
     * @throws NullPointerException si la otra asociación es nula.
     */
    @Override
    public int compareTo(ComparableAssociation<K, V> other) {
        if (other == null) {
            throw new NullPointerException("La asociación a comparar no puede ser nula");
        }
        return this.getKey().compareTo(other.getKey());
    }

    /**
     * Devuelve una representación en cadena de la asociación.
     *
     * @return Una cadena que representa la clave y el valor de la asociación.
     */
    @Override
    public String toString() {
        return "(" + getKey() + ", " + getValue() + ")";
    }

    /**
     * Establece un nuevo valor para la asociación.
     *
     * @param value El nuevo valor a asociar con la clave.
     * @return El valor anterior asociado a la clave.
     */
    @Override
    public V setValue(V value) {
        V oldValue = getValue();
        super.setValue(value);  // Esto cambia el valor en la clase base.
        return oldValue;  // Estás devolviendo un valor de tipo V.
    }
    

    
} 
