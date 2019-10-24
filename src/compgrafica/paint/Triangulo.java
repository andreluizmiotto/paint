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
import java.awt.Polygon;
import java.awt.RenderingHints;

/**
 *
 * @author andre
 */
public class Triangulo extends Painel {
    
    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        
        g2D.setColor(activeColor);
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Polygon poligono = new Polygon();
        
        poligono.addPoint(1, altura-3);
        poligono.addPoint(largura/2, 1);
        poligono.addPoint(largura-3, altura-3);
        
        g2D.drawPolygon(poligono);
        if (fillForm)
            g2D.fill(poligono);
        g2D.dispose();
    }

    public Triangulo(int inicio, int fim, int largura, int altura, Color activeColor, boolean fillForm) {
        super(inicio, fim, largura, altura, activeColor, fillForm);
    }

    public Triangulo() {
    }    
}
