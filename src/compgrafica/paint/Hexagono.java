package compgrafica.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;

public class Hexagono extends Painel {

    public void paintComponent(Graphics g) {
        Polygon poligono = new Polygon();
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);

        poligono.addPoint(largura / 2, 1);
        poligono.addPoint(1, (int) (altura / 3));
        poligono.addPoint(1, (int) (altura / 1.5));
        poligono.addPoint(largura / 2, altura - 3);
        poligono.addPoint(largura - 3, (int) (altura / 1.5));
        poligono.addPoint(largura - 3, (int) (altura / 3));

        g2D.setColor(activeColor);
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (fillForm == true) {
            g2D.fillPolygon(poligono);
        } else {
            g2D.drawPolygon(poligono);
        }
        g2D.dispose();
    }

    public Hexagono(int inicio, int fim, int largura, int altura, Color activeColor, boolean fillForm) {
        super(inicio, fim, largura, altura, activeColor, fillForm);
    }

    public Hexagono() {
    }
}
