/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import java.awt.Image;

/**
 *
 * @author andy
 */
public interface ImpresoraService {
    /**Este metodo permite imprimir con el contenido de interes.
     * 
     * @param  texto Contenido a imprimir
     */
    public void imprimirTicket(String texto);
    
    /**Este metodo permite imprimir un codigo de barra tipo 128 */
    public void imprimirCodigoDeBarra(Image imagen, String texto, int margenX, int margenY);
    
    public void imprimirCodigoBarraMatriz(Image imagen, int margenX, int margenY);
}
