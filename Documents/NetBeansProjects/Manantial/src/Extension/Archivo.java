/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author andy
 */
public interface Archivo {
    
    public Path rutaNormalizadaLocal(String nombreArchivo) throws MalformedURLException, URISyntaxException;
    public Path normalizarRuta(String rutaActual);
    
    
    /**Metodo que permite leer cualquier documento de texto plano en la ruta de la aplicacion
     * @param nombreArchivo nombre completo con extension del documento de interes.
     * @return Stream<String> lineas del archivo de texto plano
     */
    public Stream<String> leerAchivoLocal(String nombreArchivo);
    
    /**Metodo que permite leer cualquier documento de texto plano en cualquier direccion distinta a la de la aplicacion
     * @param nombreArchivo nombre completo con extension del documento de interes.
     * @return Stream<String> lineas del archivo de texto plano
     */
    public Stream<String> leerAchivoExterno(String nombreArchivo);
    
    /**Metodo que permite listar los directorios recursivamente con sus archivos
     * @param nombreArchivo nombre completo con extension del documento de interes.
     * @return List<Path> directorios encontrados
     */
    public Stream<Path> listarDirectoriosyArchivos(String rutaBase);
    
    public List<Path> listarDirectoriosyArchivosSupervisado(String rutaBase);
    
    /**Metodo que permite leer cualquier documento de texto plano en cualquier direccion distinta a la de la aplicacion
     * @param nombreArchivo nombre completo con extension del documento de interes.
     * @return lineas del archivo de texto plano
     */
    public void copiarArchivo(Path archivoOriginal, Path rutaArchivo);
    
    /**Metodo que permite verificar si el directorio o archivo ya existe previamente
     * @param ruta direccion completa del elemento de interes
     * @return la misma ruta pero con el nombre del directorio o archivo modificado por un patron automatico
     */
    public Path verificarDuplicidadDirectorio(Path ruta);
    
    public void crearNuevoArchivoSecuencial(Path archivoFuente, Path archivoDestino);
    
    public Path verificarDirectorioBaseDestino(Path directorioBase, Path directorioOrigen, Path directorioDestino);
    
    public Path fusionRutas(Path directorioBase, Path directorioOrigen, Path directorioDestino);
    
    public void escribirArchivo(Path rutaDestino, List<String> lineas);
    
    public boolean guardarImagenLocal(String nombreArchivoDestino, Image imagen);
    
    
}
