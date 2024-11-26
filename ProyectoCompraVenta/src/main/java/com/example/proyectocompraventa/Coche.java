package com.example.proyectocompraventa;

public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private int kms;

    // Constructor
    public Coche(String marca, String modelo, String matricula, int anyo, double precio, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = kms;
    }

    //Getters y Setters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getMatricula() { return matricula; }
    public double getPrecio() { return precio; }

    //para aplicar descuento
    public void aplicarDescuento(int porcentaje) {
        if (porcentaje < 1 || porcentaje > 50) {
            System.out.println("ERROR: Debe especificar un valor entre 1 y 50.");
        } else {
            precio -= precio * porcentaje / 100.0;
        }
    }

    //mostrar toda la info del coche
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula +
                ", Año: " + anyo + ", Precio: " + precio + "€ y Kms: " + kms;
    }
}
