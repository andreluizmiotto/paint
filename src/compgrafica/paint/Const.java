/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;

/**
 *
 * @author andre
 */
public final class Const {
    
     public static final int NO_FORM = 0;
     public static final int CIRCULO = 1;
     public static final int RETANGULO = 2;
     public static final int TRIANGULO = 3;
     public static final int LOSANGO = 4;
     public static final int HEXAGONO = 5;
     public static final int POLIGONO = 6;
     
     public static final int LAPIS = 7;
     public static final int BORRACHA = 8;
     public static final Dimension TAM_BORRACHA = new Dimension(30, 30);
     
     public static final Color CorPadrao = UIManager.getDefaults().getColor("");
     public static final Color CorInicio = Color.BLACK;
     public static final Color CorBotaoPress = new Color(141, 182, 205);
     public static final Color DeepSkyBlue = new Color(0, 191, 255);
     public static final Color White = new Color(255, 255, 255);
     public static final Color Yellow = new Color(255, 255, 0);
     public static final Color Green = new Color(0, 255, 0);
     public static final Color RoyalBlue = new Color(65, 105, 225);
     public static final Color Red = new Color(255, 0, 0);
     public static final Color CornflowerBlue = new Color(100, 149, 237);
     public static final Color Brown = new Color(165, 42, 42);
     public static final Color Black = new Color(0, 0, 0);
     public static final Color Grey = new Color(190, 190, 190);
     public static final Color Orange = new Color(255, 165, 0);
     public static final Color SeaGreen1 = new Color(84, 255, 159);
     
     public static final int TamBotaoCor = 40;
     public static final int TamBotaoForma = 60;
     
     

    private Const() {
        throw new AssertionError();
    }
     
}
