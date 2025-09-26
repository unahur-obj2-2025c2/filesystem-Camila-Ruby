package ar.edu.unahur.obj2;

public class Archivo implements Elemento{
    private String nombre;
    private String extension;
    private Integer tamanio;

    public Archivo(String nombre, String extension, Integer tamanio) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    @Override
    public Integer tamanio() {
        return this.tamanio;
    }

    @Override
    public void mostrar() {
        System.out.println("├ " + this.nombre() + this.getExtension() ); ;
    }

}
