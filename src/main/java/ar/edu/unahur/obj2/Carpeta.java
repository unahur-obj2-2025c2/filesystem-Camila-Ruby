package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Carpeta implements Elemento{
    private String nombre;
    private List<Elemento> contenido = new ArrayList<>();


    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public Integer tamanio() {
        return contenido.stream().mapToInt(Elemento::tamanio).sum();
    }

    @Override
    public void mostrar() {
        System.out.println("└ " + this.nombre() + "( " + this.tamanio().toString() + " )" );
        for (Elemento e : contenido) e.mostrar();
    }

    public void agregar(Elemento archivo){
        contenido.add(archivo);
    }


    public Archivo archivoMasPesado() {
        Archivo masPesado = null;

        for (Elemento e : contenido) {
            if (e instanceof Archivo) {
                Archivo a = (Archivo) e;
                if (masPesado == null || a.tamanio() > masPesado.tamanio()) {
                    masPesado = a;
                }

            } else if (e instanceof Carpeta) {
                // Buscar en la subcarpeta
                Archivo a = ((Carpeta) e).archivoMasPesado();
                if (a != null && (masPesado == null || a.tamanio() > masPesado.tamanio())) {
                    masPesado = a;
                }
            }
        }

        return masPesado; // puede ser null si no hay archivos en ninguna parte
    }

}
