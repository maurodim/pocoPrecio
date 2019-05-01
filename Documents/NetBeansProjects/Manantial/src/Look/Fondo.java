/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Look;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

/**
 *
 * @author Usuario
 */
public class Fondo implements Border{
    private BufferedImage image;
    private int ancho;
    private int alto;

    public Fondo(BufferedImage image) {
        this.image = image;
    }
    private Image redimensionar(Image original, int nuevoAncho, int nuevoAlto){
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
    

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        int x0 = x+ (width-image.getWidth())/2;
    int y0 = y+ (height-image.getHeight())/2;
    g.drawImage(image,x0,y0,null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
          return true;
    }
    
}
