/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import com.itextpdf.text.Image;

/**
 *
 * @author andy
 */
public class FormatoCodigoBarras {
    private Image imagen;
    private int cantidadRequerida;

    public FormatoCodigoBarras() {
    }

    public FormatoCodigoBarras(Image imagen, int cantidadRequerida) {
        this.imagen = imagen;
        this.cantidadRequerida = cantidadRequerida;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(int cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    @Override
    public String toString() {
        return "FormatoCodigoBarras{" + "imagen=" + imagen.getAnnotation().content()+ ", cantidadRequerida=" + cantidadRequerida + '}';
    }
    
    
    
}
