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

public class Circulo extends Painel {
    
    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        
        g2D.setColor(activeColor);
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawOval(1, 1, largura-3, altura-3);
        if (fillForm)
            g2D.fillOval(1, 1, largura-3, altura-3);
        g2D.dispose();
    }

    public Circulo(int xIni, int yIni, int largura, int altura, Color activeColor, boolean fillForm) {
        super(xIni, yIni, largura, altura, activeColor, fillForm);
    }
    
    public Circulo() {
    }
}
