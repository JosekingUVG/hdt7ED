package uvg;

/**
 * Clase NodoBST que representa un nodo en un Árbol Binario de Búsqueda.
 *
 * @param <K> Tipo de la clave, debe ser un Comparable.
 * @param <V> Tipo del valor asociado a la clave.
 */
public class NodoBST<K extends Comparable<K>, V> {
    
    // Atributos para la clave, el valor, y los hijos izquierdo y derecho.
    private ComparableAssociation<K, V> dato;
    private NodoBST<K, V> izquierdo;
    private NodoBST<K, V> derecho;

    /**
     * Constructor para crear un nuevo nodo en el árbol.
     *
     * @param dato Objeto de tipo ComparableAssociation que contiene la clave y el valor.
     */
    public NodoBST(ComparableAssociation<K, V> dato) {
        this.dato = dato;  // Inicializamos el dato con la asociación proporcionada
        this.izquierdo = null;  // El hijo izquierdo es inicialmente null
        this.derecho = null;  // El hijo derecho es inicialmente null
    }

    /**
     * Obtiene la asociación almacenada en el nodo.
     *
     * @return La asociación ComparableAssociation<K, V>.
     */
    public ComparableAssociation<K, V> getDato() {
        return dato;
    }

    /**
     * Establece la asociación almacenada en el nodo.
     *
     * @param dato La nueva asociación ComparableAssociation<K, V>.
     */
    public void setDato(ComparableAssociation<K, V> dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Referencia al nodo hijo izquierdo o null si no existe.
     */
    public NodoBST<K, V> getIzquierdo() {
        return izquierdo;
    }

    /**
     * Establece el hijo izquierdo del nodo.
     *
     * @param izquierdo Nuevo nodo hijo izquierdo.
     */
    public void setIzquierdo(NodoBST<K, V> izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Referencia al nodo hijo derecho o null si no existe.
     */
    public NodoBST<K, V> getDerecho() {
        return derecho;
    }

    /**
     * Establece el hijo derecho del nodo.
     *
     * @param derecho Nuevo nodo hijo derecho.
     */
    public void setDerecho(NodoBST<K, V> derecho) {
        this.derecho = derecho;
    }

    /**
     * Representación en cadena del nodo, mostrando la clave y el valor.
     *
     * @return Una cadena con el contenido del nodo.
     */
    @Override
    public String toString() {
        return dato.toString();  // Devolver la representación en cadena de la asociación
    }
}
