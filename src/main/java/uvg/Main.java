package uvg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.cargarDesdeCSV("src/main/resources/home appliance skus lowes.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el SKU del producto que desea buscar: ");
        String sku = scanner.nextLine();

        Producto producto = bst.buscar(sku);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println("SKU: " + producto.sku);
            System.out.println("Precio Actual: " + producto.priceCurrent);
            System.out.println("Precio de Venta: " + producto.priceRetail);
            System.out.println("Nombre del Producto: " + producto.productName);
            System.out.println("Categoría: " + producto.category);
        } else {
            System.out.println("Producto no encontrado para el SKU: " + sku);
        }

        scanner.close();
    }
}