/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class Painel extends JPanel {

    protected int xIni;
    protected int yIni;
    protected int largura;
    protected int altura;
    protected Color activeColor;
    protected boolean fillForm;

    public Painel(int xIni, int yIni, int largura, int altura, Color activeColor, boolean fillForm) {
        this();
        this.xIni = xIni;
        this.yIni = yIni;
        this.largura = largura;
        this.altura = altura;
        this.activeColor = activeColor;
        this.fillForm = fillForm;
    }

    public Painel() {
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

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public void setActiveColor(Color activeColor) {
        this.activeColor = activeColor;
    }

    public boolean isFillForm() {
        return fillForm;
    }

    public void setFillForm(boolean fillForm) {
        this.fillForm = fillForm;
    }
}
