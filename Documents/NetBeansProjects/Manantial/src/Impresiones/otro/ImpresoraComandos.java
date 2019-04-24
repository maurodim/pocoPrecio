/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones.otro;

/**
 *
 * @author andy
 */
public class ImpresoraComandos {

   
   
   //----------------------------------------------------------------------------------
    
   // Beeper
   private final byte[] BEEPER          = {0x1b,0x42,0x05,0x09}; // Beeps 5 times for 9*50ms each time

   // Line Spacing
   private final byte[] LINE_SPACE_24   = {0x1b,0x33,24}; // Set the line spacing at 24
   private final byte[] LINE_SPACE_30   = {0x1b,0x33,30}; // Set the line spacing at 30

   //Image
   private final byte[] SELECT_BIT_IMAGE_MODE = {0x1B, 0x2A, 33};

   // Printer hardware
   private final byte[] HW_INIT         = {0x1b,0x40};          // Clear data in buffer and reset modes

   // Cash Drawer
   private final byte[] CD_KICK_2       = {0x1b,0x70,0x00};      // Sends a pulse to pin 2 []
   private final byte[] CD_KICK_5       = {0x1b,0x70,0x01};      // Sends a pulse to pin 5 []

   // Paper
   private final byte[]  PAPER_FULL_CUT = {0x1d,0x56,0x00}; // Full cut paper
   private final byte[]  PAPER_PART_CUT = {0x1d,0x56,0x01}; // Partial cut paper

   // Text format
   private final byte[] TXT_NORMAL      = {0x1b,0x21,0x00}; // Normal text
   private final byte[] TXT_2HEIGHT     = {0x1b,0x21,0x10}; // Double height text
   private final byte[] TXT_2WIDTH      = {0x1b,0x21,0x20}; // Double width text
   private final byte[] TXT_4SQUARE     = {0x1b,0x21,0x30}; // Quad area text
   private final byte[] TXT_UNDERL_OFF  = {0x1b,0x2d,0x00}; // Underline font OFF
   private final byte[] TXT_UNDERL_ON   = {0x1b,0x2d,0x01}; // Underline font 1-dot ON
   private final byte[] TXT_UNDERL2_ON  = {0x1b,0x2d,0x02}; // Underline font 2-dot ON
   private final byte[] TXT_BOLD_OFF    = {0x1b,0x45,0x00}; // Bold font OFF
   private final byte[] TXT_BOLD_ON     = {0x1b,0x45,0x01}; // Bold font ON
   private final byte[] TXT_FONT_A      = {0x1b,0x4d,0x48}; // Font type A
   private final byte[] TXT_FONT_B      = {0x1b,0x4d,0x01};// Font type B
   private final byte[] TXT_ALIGN_LT    = {0x1b,0x61,0x00}; // Left justification
   private final byte[] TXT_ALIGN_CT    = {0x1b,0x61,0x01}; // Centering
   private final byte[] TXT_ALIGN_RT    = {0x1b,0x61,0x02}; // Right justification

   // Char code table
   private final byte[] CHARCODE_PC437  = {0x1b,0x74,0x00}; // USA){ Standard Europe
   private final byte[] CHARCODE_JIS    = {0x1b,0x74,0x01}; // Japanese Katakana
   private final byte[] CHARCODE_PC850  = {0x1b,0x74,0x02}; // Multilingual
   private final byte[] CHARCODE_PC860  = {0x1b,0x74,0x03}; // Portuguese
   private final byte[] CHARCODE_PC863  = {0x1b,0x74,0x04}; // Canadian-French
   private final byte[] CHARCODE_PC865  = {0x1b,0x74,0x05}; // Nordic
   private final byte[] CHARCODE_WEU    = {0x1b,0x74,0x06}; // Simplified Kanji, Hirakana
   private final byte[] CHARCODE_GREEK  = {0x1b,0x74,0x07}; // Simplified Kanji
   private final byte[] CHARCODE_HEBREW = {0x1b,0x74,0x08}; // Simplified Kanji
   private final byte[] CHARCODE_PC1252 = {0x1b,0x74,0x10}; // Western European Windows Code Set
   private final byte[] CHARCODE_PC866  = {0x1b,0x74,0x12}; // Cirillic //2
   private final byte[] CHARCODE_PC852  = {0x1b,0x74,0x13}; // Latin 2
   private final byte[] CHARCODE_PC858  = {0x1b,0x74,0x14}; // Euro
   private final byte[] CHARCODE_THAI42 = {0x1b,0x74,0x15}; // Thai character code 42
   private final byte[] CHARCODE_THAI11 = {0x1b,0x74,0x16}; // Thai character code 11
   private final byte[] CHARCODE_THAI13 = {0x1b,0x74,0x17}; // Thai character code 13
   private final byte[] CHARCODE_THAI14 = {0x1b,0x74,0x18}; // Thai character code 14
   private final byte[] CHARCODE_THAI16 = {0x1b,0x74,0x19}; // Thai character code 16
   private final byte[] CHARCODE_THAI17 = {0x1b,0x74,0x1a}; // Thai character code 17
   private final byte[] CHARCODE_THAI18 = {0x1b,0x74,0x1b}; // Thai character code 18

   // Barcode format
   private final byte[] BARCODE_TXT_OFF = {0x1d,0x48,0x00}; // HRI printBarcode chars OFF
   private final byte[] BARCODE_TXT_ABV = {0x1d,0x48,0x01}; // HRI printBarcode chars above
   private final byte[] BARCODE_TXT_BLW = {0x1d,0x48,0x02}; // HRI printBarcode chars below
   private final byte[] BARCODE_TXT_BTH = {0x1d,0x48,0x03}; // HRI printBarcode chars both above and below
   private final byte[] BARCODE_FONT_A  = {0x1d,0x66,0x00}; // Font type A for HRI printBarcode chars
   private final byte[] BARCODE_FONT_B  = {0x1d,0x66,0x01}; // Font type B for HRI printBarcode chars
   private final byte[] BARCODE_HEIGHT  = {0x1d,0x68,0x64}; // Barcode Height [1-255]
   private final byte[] BARCODE_WIDTH   = {0x1d,0x77,0x03}; // Barcode Width  [2-6]
   private final byte[] BARCODE_UPC_A   = {0x1d,0x6b,0x00}; // Barcode type UPC-A
   private final byte[] BARCODE_UPC_E   = {0x1d,0x6b,0x01}; // Barcode type UPC-E
   private final byte[] BARCODE_EAN13   = {0x1d,0x6b,0x02}; // Barcode type EAN13
   private final byte[] BARCODE_EAN8    = {0x1d,0x6b,0x03}; // Barcode type EAN8
   private final byte[] BARCODE_CODE39  = {0x1d,0x6b,0x04}; // Barcode type CODE39
   private final byte[] BARCODE_ITF     = {0x1d,0x6b,0x05}; // Barcode type ITF
   private final byte[] BARCODE_NW7     = {0x1d,0x6b,0x06}; // Barcode type NW7

   // Printing Density
   private final byte[] PD_N50          = {0x1d,0x7c,0x00}; // Printing Density -50%
   private final byte[] PD_N37          = {0x1d,0x7c,0x01}; // Printing Density -37.5%
   private final byte[] PD_N25          = {0x1d,0x7c,0x02}; // Printing Density -25%
   private final byte[] PD_N12          = {0x1d,0x7c,0x03}; // Printing Density -12.5%
   private final byte[] PD_0            = {0x1d,0x7c,0x04}; // Printing Density  0%
   private final byte[] PD_P50          = {0x1d,0x7c,0x08}; // Printing Density +50%
   private final byte[] PD_P37          = {0x1d,0x7c,0x07}; // Printing Density +37.5%
   private final byte[] PD_P25          = {0x1d,0x7c,0x06}; // Printing Density +25%
   private final byte[] PD_P12 = {0x1d,0x7c,0x05}; // Printing Density +12.5%
    
   
   
   public void inicializarImpresora(){
   
   
   }
   
   public void escribirLinea(String texto){
   
   }
   
   public static void main(String args[]){
       
       char x = (char) 255;
       // 
       
       System.out.println("representacionA: "+("0x"+Integer.toHexString(255)));
       System.out.println("representacionB: "+String.valueOf(x));
       System.out.println("representacionC: "+((byte) 254));
     
   }
   
}
