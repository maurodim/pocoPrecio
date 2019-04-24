/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import com.itextpdf.text.pdf.Barcode128;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author andy
 */
public class CodigosDeBarraImpl implements CodigosDeBarra{

    public CodigosDeBarraImpl() {
    }
    
    @Override
    public Image barraCode128(String texto){
        Barcode128 b128 = new Barcode128();
        b128.setCode(texto);
        b128.setCodeType(Barcode128.CODE128);
        
       /* b128.setBarHeight(20);
        b128.setN(1.0f);*/
        
        System.out.println("info BarrCode128: "+b128.getBarcodeSize().toString());
        
        Image imagen = b128.createAwtImage(Color.BLACK, Color.WHITE);
        return imagen;
    }
    
    @Override
    public Image redimensionar(Image original, int nuevoAncho, int nuevoAlto){
        int anchoImagenOriginal = original.getWidth(null);
        int altoImagenOriginal = original.getHeight(null);
        
        BufferedImage biOriginal = new BufferedImage(anchoImagenOriginal, altoImagenOriginal, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2dOriginal = biOriginal.createGraphics();
        g2dOriginal.drawImage(original, 0, 0, null);
        g2dOriginal.dispose();
       
        return biOriginal.getScaledInstance(nuevoAncho, 
                                            nuevoAlto,
                                            Image.SCALE_SMOOTH);
    }
}
