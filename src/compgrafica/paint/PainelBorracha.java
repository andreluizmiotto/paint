/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class PainelBorracha extends JPanel {

    protected int xIni;
    protected int yIni;

    public PainelBorracha(int xIni, int yIni) {
        this.xIni = xIni;
        this.yIni = yIni;
    }

    public PainelBorracha() {
        super();
        setOpaque(false);
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
}
