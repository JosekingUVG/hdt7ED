package uvg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void testInsertarYBuscar() {
        // Crear un producto de prueba
        Producto producto = new Producto("SKU123", 100.0, 80.0, "Producto de Prueba", "Categoría 1");
        
        // Insertar el producto en el árbol
        bst.insertar(producto);
        
        // Buscar el producto por SKU
        Producto resultado = bst.buscar("SKU123");
        
        // Verificar que el producto encontrado es el mismo que el insertado
        assertNotNull(resultado, "El producto debería ser encontrado");
        assertEquals("SKU123", resultado.sku, "El SKU debería coincidir");
        assertEquals(80.0, resultado.priceCurrent, 0.01, "El precio actual debería coincidir");
        assertEquals(100.0, resultado.priceRetail, 0.01, "El precio de venta debería coincidir");
        assertEquals("Producto de Prueba", resultado.productName, "El nombre del producto debería coincidir");
        assertEquals("Categoría 1", resultado.category, "La categoría debería coincidir");
    }

    @Test
    public void testBuscarProductoNoExistente() {
        // Intentar buscar un SKU que no existe
        Producto resultado = bst.buscar("SKU999");
        
        // Verificar que el resultado sea null
        assertNull(resultado, "El producto no debería ser encontrado");
    }
}