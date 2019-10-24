/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author andre
 */
public class Imagem extends Painel {
    
    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        
        g2D.drawOval(1, 1, largura-3, altura-3);
        g2D.dispose();
    }

    public Imagem(int xIni, int yIni, int largura, int altura, Color activeColor, boolean fillForm) {
        super(xIni, yIni, largura, altura, activeColor, fillForm);
    }
    
    public Imagem() {
    }   
}
