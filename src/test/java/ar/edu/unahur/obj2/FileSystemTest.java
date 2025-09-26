package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FileSystemTest {
    @Test
    void dadaUnaCarpetaCon4ArchivosDeTamanio100SutamanioEs400() {
        Carpeta c = new Carpeta("carpetita");
        c.agregar(new Archivo("foto", ".jpg", 100));
        c.agregar(new Archivo("foto1", ".jpg", 100));
        c.agregar(new Archivo("foto2", ".jpg", 100));
        c.agregar(new Archivo("foto3", ".jpg", 100));
        c.mostrar();
        assertEquals(400, c.tamanio());
    }

    @Test
    void devuelveElArchivoMasPesadoDeUnaCarpeta() {
       Carpeta c = new Carpeta("carpetita");
        c.agregar(new Archivo("foto", ".jpg", 100));
        c.agregar(new Archivo("foto1", ".jpg", 100));
        c.agregar(new Archivo("foto2", ".jpg", 100));
        Archivo heavy = new Archivo("foto3", ".jpg", 500);
        c.agregar(heavy);
        c.mostrar();
        assertEquals(heavy, c.archivoMasPesado()); 
    }
    
    @Test
    void devuelveElArchivoMasPesadoDeUnaCarpetaBuscandoEnSubcarpetas() {
       Carpeta c = new Carpeta("carpetita");
        c.agregar(new Archivo("foto", ".jpg", 100));
        c.agregar(new Archivo("foto1", ".jpg", 100));
        c.agregar(new Archivo("foto2", ".jpg", 100));
        Carpeta subcarpeta = new Carpeta("Subcarpeta");
        c.agregar(subcarpeta);
        Archivo heavy = new Archivo("foto3", ".jpg", 500);
        subcarpeta.agregar(heavy);
        c.mostrar();
        assertEquals(heavy, c.archivoMasPesado()); 
    }

    @Test
    void dadoUnFileSystemDevuelveElTamanio() {
        FileSystem sistemita = new FileSystem();
        sistemita.getRoot().agregar(new Archivo("foto", ".jpg", 100));
        sistemita.getRoot().agregar(new Archivo("foto1", ".jpg", 100));
        sistemita.getRoot().agregar(new Archivo("foto2", ".jpg", 100));
        Archivo heavy = new Archivo("foto3", ".jpg", 500);
        sistemita.getRoot().agregar(heavy);
        sistemita.mostarListado();
        assertEquals(800, sistemita.tamanio());
    }

    @Test
    void dadoUnFileSystemDevuelveElArchivoMasPesado() {
        FileSystem sistemita = new FileSystem();
        sistemita.getRoot().agregar(new Archivo("foto", ".jpg", 100));
        sistemita.getRoot().agregar(new Archivo("foto1", ".jpg", 100));
        sistemita.getRoot().agregar(new Archivo("foto2", ".jpg", 100));
        Archivo heavy = new Archivo("foto3", ".jpg", 500);
        sistemita.getRoot().agregar(heavy);
        sistemita.mostarListado();
        assertEquals(heavy, sistemita.archivoMasPesado());
    }

}
