package uvg;


/**
 * Representa un producto con información básica como SKU, precios, nombre y categoría.
 */
class Producto {
    String sku;
    double priceRetail;
    double priceCurrent;
    String productName;
    String category;

    /**
     * Constructor para inicializar un producto.
     *
     * @param sku          
     * @param priceRetail  
     * @param priceCurrent 
     * @param productName  
     * @param category     
     */
    public Producto(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Información del producto en formato legible.
     */
    @Override
    public String toString() {
        return "SKU: " + sku +
               "\nNombre: " + productName +
               "\nCategoría: " + category +
               "\nPrecio Retail: $" + priceRetail +
               "\nPrecio Actual: $" + priceCurrent;
    }
}