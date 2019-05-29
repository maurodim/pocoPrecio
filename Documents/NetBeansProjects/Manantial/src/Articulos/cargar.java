/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import Articulos.Pantallas.Ventana;
import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


/**
 *
 * @author mauro
 */
public class cargar extends Thread{
    JProgressBar progreso;
    int maximo;

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
    //JLabel texto;
    public cargar(JProgressBar progreso){
        super();
        this.progreso=progreso;
        //this.texto=texto;
        
    }
    
    public void run(){
        for(int i=1;i < maximo;i++){
            progreso.setValue(i);
            pausa(50);
            
            //if(i < 30)Ventana.Texto.setText("Cargando entorno del sistema.......");
            
            
        }
    }
    public void pausa(int mlSeg){
        try{
            Thread.sleep(mlSeg);
        }catch(Exception e){
            
        }
    }
}
