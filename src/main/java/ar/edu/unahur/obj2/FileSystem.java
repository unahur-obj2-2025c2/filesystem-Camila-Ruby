package ar.edu.unahur.obj2;

public class FileSystem {
    private Carpeta root = new Carpeta("Root");

    public FileSystem() {}

    public Integer tamanio(){
        return root.tamanio();
    }

    public void mostarListado(){
        root.mostrar();
    }


    public Carpeta getRoot() {
        return root;
    }

    // Método que delega la búsqueda
    public Archivo archivoMasPesado() {
        return root.archivoMasPesado();
    }

}
