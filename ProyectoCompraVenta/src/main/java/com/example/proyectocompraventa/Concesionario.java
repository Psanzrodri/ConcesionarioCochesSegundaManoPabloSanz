package com.example.proyectocompraventa;

import java.util.ArrayList;

public class Concesionario {
    private final int tamanyo;
    private double facturacionLocal;
    private ArrayList<Coche> listadoCoches;

    public Concesionario(int tamanyo) {
        this.tamanyo = tamanyo;
        this.facturacionLocal = 0;
        this.listadoCoches = new ArrayList<>();
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }

    public boolean adquirirCoche(Coche coche) {
        if (listadoCoches.size() >= tamanyo) {
            return false;
        } else {
            listadoCoches.add(coche);
            return true;
        }
    }

    public boolean venderCoche(String matricula) {
        for (Coche coche : listadoCoches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                facturacionLocal += coche.getPrecio();
                listadoCoches.remove(coche);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Coche> buscarCochesPorMarca(String marca) {
        ArrayList<Coche> resultado = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getMarca().equalsIgnoreCase(marca)) {
                resultado.add(coche);
            }
        }
        return resultado;
    }

    public ArrayList<Coche> buscarCochesPorModelo(String modelo) {
        ArrayList<Coche> resultado = new ArrayList<>();
        for (Coche coche : listadoCoches) {
            if (coche.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(coche);
            }
        }
        return resultado;
    }

    public void listarCoches() {
        if (listadoCoches.isEmpty()) {
            System.out.println("El concesionario no tiene coches disponibles.");
        } else {
            listadoCoches.forEach(System.out::println);
        }
    }


}
