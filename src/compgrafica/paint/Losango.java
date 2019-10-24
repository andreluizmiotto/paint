package compgrafica.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;

public class Losango extends Painel {

    public void paintComponent(Graphics g) {
        Polygon poligono = new Polygon();
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        poligono.addPoint(largura / 2, 1);
        poligono.addPoint(1, altura / 2);
        poligono.addPoint(largura / 2, altura - 3);
        poligono.addPoint(largura - 3, altura / 2);

        g2.setColor(activeColor);
        g2.setStroke(new BasicStroke(3.0f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (fillForm == true) {
            g2.fillPolygon(poligono);
        } else {
            g2.drawPolygon(poligono);
        }
        g2.dispose();
    }

    public Losango(int inicio, int fim, int largura, int altura, Color activeColor, boolean fillForm) {
        super(inicio, fim, largura, altura, activeColor, fillForm);
    }

    public Losango() {
    }
}
