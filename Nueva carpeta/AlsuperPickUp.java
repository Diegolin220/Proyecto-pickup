/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alsuperpickup;

import java.util.Scanner;

/**
 *
 * @author diegi
 */
public class AlsuperPickUp {
    public static void main(String[] args) {
        GestorPasillos gestor = new GestorPasillos();
        Carrito carrito = new Carrito(10);
        ListaCompras listaCompras = new ListaCompras(10);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        
        String[] productosComprados = new String[10];
        int contadorComprados = 0;

        do {
            System.out.println("\n------ Bienvenido a Alsuper PickUp ------");
            System.out.println("1️ Bucar Producto");
            System.out.println("2 Agregar a Lista de Compras");
            System.out.println("3️ Ver Lista de Compras");
            System.out.println("4️ Pasar Lista a Carrito");
            System.out.println("5️ Ver Carrito");
            System.out.println("6️ Vaciar Carrito");
            System.out.println("7️ Finalizar Compra");
            System.out.println("8️ Salir");
            System.out.print("\n Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1 -> {
                    System.out.print("\n Ingresa el nombre del producto: ");
                    String productoBuscar = scanner.nextLine();
                    gestor.buscarProducto(productoBuscar);
                }
                case 2 ->{
                    System.out.print("\n Ingresa el producto para la lista de compras: ");
                    String productoLista = scanner.nextLine();
                    listaCompras.agregarProducto(productoLista);
                }
                case 3 -> listaCompras.mostrarLista();
                case 4 -> {
                    String[] productosLista = listaCompras.getProductos();
                    int cantidadLista = listaCompras.getContador();
                    for (int i = 0; i < cantidadLista; i++) {
                        carrito.agregarProducto(productosLista[i]);
                        if (productosLista[i] != null && contadorComprados < productosComprados.length) {
                            productosComprados[contadorComprados++] = productosLista[i];
                        }
                    }
                    System.out.println("\n Lista de compras agregada al carrito.");
                }
                case 5 -> carrito.mostrarCarrito();
                case 6 -> carrito.vaciarCarrito();
                case 7 -> {
                    carrito.generarTicket();
                    gestor.generarRecomendaciones(productosComprados);
                    carrito.vaciarCarrito();
                }
                case 8 -> System.out.println("\n ¡Gracias por usar Alsuper PickUp!");
                default -> System.out.println("\n Opcion no válida.");
            }
        } while (opcion != 8);
    }
}