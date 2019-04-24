/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class Supervisor implements FileVisitor<Path>{
    public static List<Path> contenido;
    public static Path elemento;
    public static int contador;

    public Supervisor() {
        contenido = new ArrayList<>();
        elemento = null;
        contador = 0;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        elemento = dir;
        contenido.add(dir); // Agregando el directorio
        contador++;
       // System.out.println("cuenta: "+contador);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        elemento = file;
        contenido.add(file); // Agregando archivo
        contador++;
        //System.out.println("cuenta: "+contador);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error de lectura de archivo -> "+file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
    
}
