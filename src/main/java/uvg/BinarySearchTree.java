package uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que representa un árbol binario de búsqueda.
 */
public class BinarySearchTree {
    private NodoBST<String, Producto> raiz; // K es String y V es Producto

    /**
     * Constructor del árbol binario de búsqueda.
     */
    public BinarySearchTree() {
        this.raiz = null;
    }

    /**
     * Inserta un producto en el árbol binario de búsqueda.
     * @param producto Objeto Producto a insertar.
     */
    public void insertar(Producto producto) {
        ComparableAssociation<String, Producto> nuevaAsociacion = new ComparableAssociation<>(producto.sku, producto);
        raiz = insertarRecursivo(raiz, nuevaAsociacion);
    }

    /**
     * Método privado que inserta de forma recursiva en el árbol.
     * @param nodo Nodo actual del árbol.
     * @param data Dato a insertar.
     * @return Nodo actualizado.
     */
    private NodoBST<String, Producto> insertarRecursivo(NodoBST<String, Producto> nodo, ComparableAssociation<String, Producto> data) {
        if (nodo == null) {
            return new NodoBST<>(data);
        }

        if (data.getKey().compareTo(nodo.getDato().getKey()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), data));
        } else if (data.getKey().compareTo(nodo.getDato().getKey()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), data));
        }
        return nodo; // No se permiten duplicados.
    }

     /**
     * Carga productos desde un archivo CSV e inserta los datos en el árbol.
     * @param rutaArchivo Ruta del archivo CSV.
     */
    public void cargarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int lineasLeidas = 0;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;
                String[] datos = linea.split(",", -1);
                if (datos.length < 20) continue; // Validación de columnas.

                try {
                    String sku = datos[6].trim();
                    String priceRetailStr = datos[9].trim();
                    String priceCurrentStr = datos[10].trim();
                    String productName = datos[18].trim();
                    String category = datos[0].trim();

                    if (sku.isEmpty() || priceRetailStr.isEmpty() || priceCurrentStr.isEmpty()) continue;

                    double priceRetail = Double.parseDouble(priceRetailStr);
                    double priceCurrent = Double.parseDouble(priceCurrentStr);

                    Producto producto = new Producto(sku, priceRetail, priceCurrent, productName, category);
                    insertar(producto);
                } catch (NumberFormatException e) {
                    System.err.println("Error en línea " + lineasLeidas + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    /**
 * Busca un producto en el árbol por su SKU.
 * @param sku Código único del producto.
 * @return Producto asociado al SKU, o null si no se encuentra.
 */
public Producto buscar(String sku) {
    NodoBST<String, Producto> nodo = buscarRecursivo(raiz, sku);
    return (nodo != null) ? nodo.getDato().getValue() : null; // No es necesario hacer un casting
}

/**
 * Método privado que busca de forma recursiva en el árbol.
 * @param nodo Nodo actual.
 * @param key Clave a buscar.
 * @return Nodo encontrado o null.
 */
private NodoBST<String, Producto> buscarRecursivo(NodoBST<String, Producto> nodo, String key) {
    if (nodo == null || nodo.getDato().getKey().equals(key)) {
        return nodo;
    }

    if (key.compareTo(nodo.getDato().getKey()) < 0) {
        return buscarRecursivo(nodo.getIzquierdo(), key);
    } else {
        return buscarRecursivo(nodo.getDerecho(), key);
    }
}

/**
 * Imprime el contenido del árbol en orden ascendente (inorden).
 */
public void inorden() {
    inordenRecursivo(raiz);
}

/**
 * Método privado para recorrer el árbol en orden (inorden) de forma recursiva.
 * @param nodo Nodo actual.
 */
private void inordenRecursivo(NodoBST<String, Producto> nodo) {
    if (nodo != null) {
        inordenRecursivo(nodo.getIzquierdo());
        System.out.println(nodo.getDato().getValue()); // Imprime el valor del nodo.
        inordenRecursivo(nodo.getDerecho());
    }
}

}