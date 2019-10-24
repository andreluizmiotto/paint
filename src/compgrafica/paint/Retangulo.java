/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author andre
 */
public class Retangulo extends Painel {
    
    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        
        g2D.setColor(activeColor);
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawRect(1, 1, largura-3, altura-3);
        if (fillForm)
            g2D.fillRect(1, 1, largura-3, altura-3);
        g2D.dispose();
    }

    public Retangulo(int xIni, int yIni, int largura, int altura, Color activeColor, boolean fillForm) {
        super(xIni, yIni, largura, altura, activeColor, fillForm);
    }

    public Retangulo() {
    }
    
    
    
}
