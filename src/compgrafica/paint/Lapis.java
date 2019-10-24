package compgrafica.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */

public class Lapis extends JPanel {
    
    protected int xIni; 
    protected int yIni;
    protected int xFin;
    protected int yFin;
    protected Color activeColor;
    
    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        //super.paintComponent(g2D);
        
        g2D.setColor(activeColor);
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawLine(xIni, yIni, xFin, yFin);
        g2D.dispose();
    }

    public Lapis() {
    }

    public Lapis(int xIni, int yIni, int xFin, int yFin, Color activeColor) {
        this.xIni = xIni;
        this.yIni = yIni;
        this.xFin = xFin;
        this.yFin = yFin;
        this.activeColor = activeColor;
    }
    
    public int getxIni() {
        return xIni;
    }

    public void setxIni(int xIni) {
        this.xIni = xIni;
    }

    public int getyIni() {
        return yIni;
    }

    public void setyIni(int yIni) {
        this.yIni = yIni;
    }

    public int getxFin() {
        return xFin;
    }

    public void setxFin(int xFin) {
        this.xFin = xFin;
    }

    public int getyFin() {
        return yFin;
    }

    public void setyFin(int yFin) {
        this.yFin = yFin;
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public void setActiveColor(Color activeColor) {
        this.activeColor = activeColor;
    }
}
