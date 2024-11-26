package com.example.proyectocompraventa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Compra-Venta de Coches");
        Empresa.cargarDatosIniciales(empresa);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear nueva sede");
            System.out.println("2. Introducir coche en una sede");
            System.out.println("3. Vender coche");
            System.out.println("4. Buscar coches por marca");
            System.out.println("5. Buscar coches por modelo");
            System.out.println("6. Mostrar listado de coches por concesionario");
            System.out.println("7. Listar sedes");
            System.out.println("8. Mostrar facturación total de la empresa");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la ciudad para la nueva sede: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Ingrese el tamaño maximo de coches: ");
                    int tamanyo = scanner.nextInt();
                    empresa.crearSede(ciudad, tamanyo);
                }
                case 2 -> {
                    System.out.print("Ingrese la sede donde añadir el coche: ");
                    String ciudad = scanner.nextLine();
                    Concesionario concesionario = empresa.getConcesionario(ciudad);
                    if (concesionario == null) {
                        System.out.println("ERROR: La sede indicada no existe");
                        break;
                    }
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Año: ");
                    int anyo = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Kilometros: ");
                    int kms = scanner.nextInt();
                    if (!concesionario.adquirirCoche(new Coche(marca, modelo, matricula, anyo, precio, kms))) {
                        System.out.println("ERROR: No hay espacio en el concesionario.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese la sede donde se encuentra el coche: ");
                    String ciudad = scanner.nextLine();
                    Concesionario concesionario = empresa.getConcesionario(ciudad);
                    if (concesionario == null) {
                        System.out.println("ERROR: La sede indicada no existe");
                        break;
                    }
                    System.out.print("Ingrese la matricula del coche a vender: ");
                    String matricula = scanner.nextLine();
                    if (!concesionario.venderCoche(matricula)) {
                        System.out.println("ERROR: No se encontro un coche con esta matricula");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese la marca a buscar: ");
                    String marca = scanner.nextLine();

                    boolean encontrados = false;
                    for (Concesionario concesionario : empresa.getGrupo().values()) {
                        var coches = concesionario.buscarCochesPorMarca(marca);
                        if (!coches.isEmpty()) {
                            encontrados = true;
                            coches.forEach(System.out::println);
                        }
                    }
                    if (!encontrados) {
                        System.out.println("No se encontraron coches de la marca " + marca + " en ninguna sede");
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el modelo a buscar: ");
                    String modelo = scanner.nextLine();

                    boolean encontrados = false;
                    for (Concesionario concesionario : empresa.getGrupo().values()) {
                        var coches = concesionario.buscarCochesPorModelo(modelo);
                        if (!coches.isEmpty()) {
                            encontrados = true;
                            System.out.println("Coches encontrados en " + concesionario );
                            coches.forEach(System.out::println);
                        }
                    }
                    if (!encontrados) {
                        System.out.println("No se encontraron coches del modelo " + modelo + " en ninguna sede");
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese la ciudad del concesionario: ");
                    String ciudad = scanner.nextLine();
                    Concesionario concesionario = empresa.getConcesionario(ciudad);
                    if (concesionario == null) {
                        System.out.println("ERROR: La sede indicada no existe");
                    } else {
                        System.out.println(" Listado de coches en " + ciudad );
                        concesionario.listarCoches();
                    }
                }
                case 7 -> empresa.listarSedes();
                case 8 -> {
                    empresa.actualizarFacturacionTotal();
                    System.out.println("La facturacion total de la empresa es: "
                            + empresa.getFacturacionEmpresa() + " €");
                }
                case 9 -> System.out.println("Adios");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 9);
    }
}
