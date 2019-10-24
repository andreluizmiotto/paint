/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author andre
 */
public class Borracha extends PainelBorracha {
    
        public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
      
        g2D.clearRect(1, 1, 50, 50);
        g2D.dispose();
    }

    public Borracha(int xIni, int yIni) {
        super(xIni, yIni);
    }
    
    public Borracha() {
    }
    
    
}
