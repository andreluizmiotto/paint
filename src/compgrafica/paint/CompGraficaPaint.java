/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgrafica.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author andre
 */
public class CompGraficaPaint extends JFrame implements ActionListener {
    
    ImageIcon Circle_icon = new ImageIcon("src/icones/circulo.png");
    ImageIcon Rect_icon = new ImageIcon("src/icones/retangulo.png");
    ImageIcon Triangle_icon = new ImageIcon("src/icones/triangulo.png");
    ImageIcon Erase_icon = new ImageIcon("src/icones/borracha.png");
    ImageIcon Clean_icon = new ImageIcon("src/icones/desfazerTudo.png");
    ImageIcon Pencil_icon = new ImageIcon("src/icones/lapis.png");
    ImageIcon Paneltheme_icon = new ImageIcon("src/icones/painel.png");
    ImageIcon PanelWhite_icon = new ImageIcon("src/icones/painelBranco.png");
    ImageIcon Polygon_icon = new ImageIcon("src/icones/IconPolygon.png");
    ImageIcon Hexagon_icon = new ImageIcon("src/icones/IconHexagon.png");
    ImageIcon Diamond_icon = new ImageIcon("src/icones/IconDiamond.png");
    ImageIcon SaveImage_icon = new ImageIcon("src/icones/IconSaveImage.png");
    ImageIcon OpenImage_icon = new ImageIcon("src/icones/IconOpenImage.png");
    
    private final JButton jBtnCircle, jBtnRectangle, jBtnTriangle, jBtnErase, jBtnPencil;
    private final JButton jBtnLozange, jBtnHexagon, jBtnPolygon;
    private final JButton jBtnBranco, jBtnAmarelo, jBtnVerde, jBtnAzulMarinho;
    private final JButton jBtnLilas, jBtnVermelho, jBtnAzul, jBtnMarromm; 
    private final JButton jBtnPreto, jBtnCinza, jBtnLaranja, jBtnVerdeOliva;
    private final JButton jBtnBackgroundColor, jBtnFillForm, jBtnClearPanel;
    private final JButton jBtnSaveImage, jBtnOpenImage;
    private final JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    private JLabel coordXY;
    private JPanel mainPanel;
    private int x, y, xIni, yIni, xMin, yMin;
    protected int activeForm = 0;
    protected Color activeColor = Const.CorInicio;
    protected boolean fillForm = false;
    protected Painel panel;
    private PainelBorracha painelBorracha;
    private Lapis lapis;
    private JLabel labelImagem;
    
    public CompGraficaPaint() {
        
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(0, 100, 1440, 720);
        add(mainPanel);
        
        coordXY = new JLabel("X : Y");
        coordXY.setBounds(10, 825, 80, 30);
        add(coordXY);
        
        jBtnCircle = new JButton();
        criaBotao(jBtnCircle, Const.CorPadrao, 25, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnCircle.setIcon(Circle_icon);
        
        jBtnRectangle = new JButton();
        criaBotao(jBtnRectangle, Const.CorPadrao, 95, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnRectangle.setIcon(Rect_icon);
        
        jBtnTriangle = new JButton();
        criaBotao(jBtnTriangle, Const.CorPadrao, 165, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnTriangle.setIcon(Triangle_icon);
        
        jBtnLozange = new JButton();
        criaBotao(jBtnLozange, Const.CorPadrao, 235, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnLozange.setIcon(Diamond_icon);
        
        jBtnHexagon = new JButton();
        criaBotao(jBtnHexagon, Const.CorPadrao, 305, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnHexagon.setIcon(Hexagon_icon);
        
        jBtnPolygon = new JButton();
        criaBotao(jBtnPolygon, Const.CorPadrao, 375, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnPolygon.setIcon(Polygon_icon);
        
        jBtnPencil = new JButton();
        criaBotao(jBtnPencil, Const.CorPadrao, 445, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnPencil.setIcon(Pencil_icon);
        
        jBtnErase = new JButton();
        criaBotao(jBtnErase, Const.CorPadrao, 515, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnErase.setIcon(Erase_icon);
        
        jBtnBackgroundColor = new JButton();
        criaBotao(jBtnBackgroundColor, activeColor, 1340, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnBackgroundColor.setIcon(PanelWhite_icon);
        
        jBtnClearPanel = new JButton();
        criaBotao(jBtnClearPanel, Const.CorPadrao, 1270, 25, Const.TamBotaoForma, Const.TamBotaoForma);
        jBtnClearPanel.setIcon(Clean_icon);
        
        jBtnBranco = new JButton();
        criaBotao(jBtnBranco, Const.White, 585, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnAmarelo = new JButton();
        criaBotao(jBtnAmarelo, Const.Yellow, 630, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnVerde = new JButton();
        criaBotao(jBtnVerde, Const.Green, 675, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnAzulMarinho = new JButton();
        criaBotao(jBtnAzulMarinho, Const.RoyalBlue, 720, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnLilas = new JButton();
        criaBotao(jBtnLilas, Const.CornflowerBlue, 765, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnVermelho = new JButton();
        criaBotao(jBtnVermelho, Const.Red, 810, 10, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnAzul = new JButton();
        criaBotao(jBtnAzul, Const.DeepSkyBlue, 585, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnMarromm = new JButton();
        criaBotao(jBtnMarromm, Const.Brown, 630, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnPreto = new JButton();
        criaBotao(jBtnPreto, Const.Black, 675, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnCinza = new JButton();
        criaBotao(jBtnCinza, Const.Grey, 720, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnLaranja = new JButton();
        criaBotao(jBtnLaranja, Const.Orange, 765, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnVerdeOliva = new JButton();
        criaBotao(jBtnVerdeOliva, Const.SeaGreen1, 810, 52, Const.TamBotaoCor, Const.TamBotaoCor);
        
        jBtnFillForm = new JButton("Preencher");
        criaBotao(jBtnFillForm, Const.CorPadrao, 855, 32, 100, 40);
        
        jBtnSaveImage = new JButton();
        criaBotao(jBtnSaveImage, Const.CorPadrao, 1000, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnSaveImage.setIcon(SaveImage_icon);
        
        jBtnOpenImage = new JButton();
        criaBotao(jBtnOpenImage, Const.CorPadrao, 1070, 25, Const.TamBotaoForma, Const.TamBotaoForma);   
        jBtnOpenImage.setIcon(OpenImage_icon);
        
        labelImagem = new JLabel();
        add(new JScrollPane(labelImagem), BorderLayout.CENTER);
        
        compEventos();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint");
        setSize(1440, 900);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == jBtnClearPanel){
            mainPanel.setBackground(Const.White);
            resetButtonColor();
            mainPanel.removeAll();
            repaint();
        }
        else if(ae.getSource() == jBtnCircle){
            if (activeForm != Const.CIRCULO){
                panel = new Circulo();    
                activeForm = Const.CIRCULO;
                buttonColor(jBtnCircle); 
            } else {
                activeForm = Const.NO_FORM;
                jBtnCircle.setBackground(Const.CorPadrao);
            }                      
        }
        else if(ae.getSource() == jBtnRectangle){
            if (activeForm != Const.RETANGULO){
                panel = new Retangulo();
                activeForm = Const.RETANGULO;
                buttonColor(jBtnRectangle);
            } else {
                activeForm = Const.NO_FORM;
                jBtnRectangle.setBackground(Const.CorPadrao);
            }                      
        }
        else if(ae.getSource() == jBtnTriangle){
            if (activeForm != Const.TRIANGULO){
                panel = new Triangulo();
                activeForm = Const.TRIANGULO;
                buttonColor(jBtnTriangle);
            } else {
                activeForm = Const.NO_FORM;
                jBtnTriangle.setBackground(Const.CorPadrao);
            }                     
        }
        else if(ae.getSource() == jBtnLozange){
            if (activeForm != Const.LOSANGO){
                panel = new Losango();
                activeForm = Const.LOSANGO;
                buttonColor(jBtnLozange);
            } else {
                activeForm = Const.NO_FORM;
                jBtnLozange.setBackground(Const.CorPadrao);
            }                     
        } 
        else if(ae.getSource() == jBtnHexagon){
            if (activeForm != Const.HEXAGONO){
                panel = new Hexagono();
                activeForm = Const.HEXAGONO;
                buttonColor(jBtnHexagon);
            } else {
                activeForm = Const.NO_FORM;
                jBtnHexagon.setBackground(Const.CorPadrao);
            }                     
        } 
        else if(ae.getSource() == jBtnPolygon){
            if (activeForm != Const.POLIGONO){
                panel = new Estrela();
                activeForm = Const.POLIGONO;
                buttonColor(jBtnPolygon);
            } else {
                activeForm = Const.NO_FORM;
                jBtnPolygon.setBackground(Const.CorPadrao);
            }                     
        } 
        else if(ae.getSource() == jBtnErase){
            if (activeForm != Const.BORRACHA){
                painelBorracha = new Borracha();
                activeForm = Const.BORRACHA;
                buttonColor(jBtnErase);  
            } else {
                activeForm = Const.NO_FORM;
                jBtnErase.setBackground(Const.CorPadrao);
            }        
        } 
        else if(ae.getSource() == jBtnPencil){
            if (activeForm != Const.LAPIS){
                lapis = new Lapis();
                activeForm = Const.LAPIS;
                buttonColor(jBtnPencil);
            } else {
                activeForm = Const.NO_FORM;
                jBtnPencil.setBackground(Const.CorPadrao);
            } 
        }
        else if(ae.getSource() == jBtnBranco)
            activeColor = Const.White;
        
        else if(ae.getSource() == jBtnAmarelo)
            activeColor = Const.Yellow;
        
        else if(ae.getSource() == jBtnVerde)
            activeColor = Const.Green;
        
        else if(ae.getSource() == jBtnAzulMarinho)
            activeColor = Const.RoyalBlue;
        
        else if(ae.getSource() == jBtnLilas)
            activeColor = Const.CornflowerBlue;
        
        else if(ae.getSource() == jBtnVermelho)
            activeColor = Const.Red;
      
        else if(ae.getSource() == jBtnAzul)
            activeColor = Const.DeepSkyBlue;
        
        else if(ae.getSource() == jBtnMarromm)
            activeColor = Const.Brown;
        
        else if(ae.getSource() == jBtnPreto)
            activeColor = Const.Black;
        
        else if(ae.getSource() == jBtnCinza)
            activeColor = Const.Grey;
        
        else if(ae.getSource() == jBtnLaranja)
            activeColor = Const.Orange;
        
        else if(ae.getSource() == jBtnVerdeOliva)
            activeColor = Const.SeaGreen1;
        
        else if(ae.getSource() == jBtnBackgroundColor)
            mainPanel.setBackground(activeColor);
        
        else if(ae.getSource() == jBtnFillForm){
            fillForm = !fillForm;
            if (fillForm)
                jBtnFillForm.setBackground(activeColor);
            else
                jBtnFillForm.setBackground(Const.CorPadrao);
        }
        
         else if(ae.getSource() == jBtnSaveImage){
             salvarImagem();
         }
        
        else if(ae.getSource() == jBtnOpenImage){
             abrirImagem();
         }
        
        if((activeColor == Const.Black) || (activeColor == Const.CorInicio))
           jBtnBackgroundColor.setIcon(PanelWhite_icon); 
        else 
           jBtnBackgroundColor.setIcon(Paneltheme_icon); 
        
        if(fillForm == true)
            jBtnFillForm.setBackground(activeColor);
        
        jBtnBackgroundColor.setBackground(activeColor);
    }
    
    private void abrirImagem() {

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens jpg, png e gif", "jpg", "png", "gif");
        fileChooser.setFileFilter(filtro);

        int option = fileChooser.showOpenDialog(CompGraficaPaint.this);

        if (option == JFileChooser.APPROVE_OPTION) {
            JPanel painel = new JPanel();
            painel.setBounds(0, 0, mainPanel.getWidth(), mainPanel.getHeight());
            String caminho = fileChooser.getSelectedFile().getPath();
            labelImagem.setIcon(new ImageIcon(caminho));
            painel.add(labelImagem);
            mainPanel.add(painel);
        }
    }
    
    private void salvarImagem() {
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivo = fileChooser.getSelectedFile();
                int largura = mainPanel.getWidth();
                int altura = mainPanel.getHeight();
                BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
                Graphics graphics = imagem.getGraphics();
                mainPanel.paint(graphics);
                ImageIO.write(imagem, "jpg", new FileOutputStream(arquivo + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void lapis() {
        lapis = new Lapis();
        lapis.setBackground(Color.WHITE);
        lapis.setBounds(1,1,1440,900);
        lapis.setxIni(xIni);
        lapis.setyIni(yIni);
        lapis.setxFin(x);
        lapis.setyFin(y);
        lapis.setActiveColor(activeColor);
        mainPanel.add(lapis);
        mainPanel.setComponentZOrder(lapis, 0);
        repaint();
        xIni = x;
        yIni = y;
    }
    
    public void borracha(){
        painelBorracha = new Borracha();
        painelBorracha.setxIni(xIni);
        painelBorracha.setyIni(yIni);
        painelBorracha.setLocation(x, y);
        painelBorracha.setSize(Const.TAM_BORRACHA);
        mainPanel.add(painelBorracha);
        mainPanel.setComponentZOrder(painelBorracha, 0);
        repaint();
    }
    
    public void desenharFormaGeometrica(){
        xMin = Math.min(xIni, x);
        yMin = Math.min(yIni, y);
        panel.setxIni(xIni);
        panel.setyIni(yIni);
        panel.setLargura(Math.abs(x - xIni));
        panel.setAltura(Math.abs(y - yIni));
        panel.setLocation(xMin, yMin);
        panel.setSize(panel.getLargura(), panel.getAltura());
        panel.setActiveColor(activeColor);
        panel.setFillForm(fillForm);
        mainPanel.add(panel);
        mainPanel.setComponentZOrder(panel, 0);
        repaint();
    }
    
    private void forMouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        coordXY.setText("X: " + x + " Y: " + y);
        if (activeForm != Const.NO_FORM){
            if (activeForm == Const.BORRACHA)
                borracha();
            else if (activeForm == Const.LAPIS)
                lapis();
            else
                desenharFormaGeometrica();
        }
    }
    
    private void forMouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        coordXY.setText("X: " + x + " Y: " + y);
    }
    
    private void compEventos(){
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e){
                forMouseDragged(e);
            }
            public void mouseMoved(MouseEvent e){
                forMouseMoved(e);
            }
        
        });
        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetButtonColor();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xIni = x;
                yIni = y;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (activeForm) {
                    case Const.CIRCULO:
                        panel = new Circulo();
                        break;
                    case Const.RETANGULO: 
                        panel = new Retangulo();
                        break;
                    case Const.TRIANGULO:
                        panel = new Triangulo();
                        break;
                    case Const.LOSANGO:
                        panel = new Losango();
                        break;
                    case Const.HEXAGONO:
                        panel = new Hexagono();
                        break;
                    case Const.POLIGONO:
                        panel = new Estrela();
                        break;
                    case Const.LAPIS:
                        lapis = new Lapis();
                        break;
                    case Const.BORRACHA:
                        painelBorracha = new Borracha();
                        break;

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
    }
    
    private JButton buttonColor(JButton jBtn){
        if (!(jBtn == null)) {
            if (!(jBtn.equals(jBtnCircle))) 
                jBtnCircle.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnRectangle))) 
                jBtnRectangle.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnTriangle))) 
                jBtnTriangle.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnLozange))) 
                jBtnLozange.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnHexagon))) 
                jBtnHexagon.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnPolygon))) 
                jBtnPolygon.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnErase))) 
                jBtnErase.setBackground(Const.CorPadrao);
            if (!(jBtn.equals(jBtnPencil))) 
                jBtnPencil.setBackground(Const.CorPadrao);
            
            jBtn.setBackground(Const.CorBotaoPress);
            return jBtn;
        } else {
            activeForm = 0;
            return null;
        }
    }
    
    private void resetButtonColor(){
        switch (activeForm) {
            case Const.CIRCULO:
                jBtnCircle.setBackground(Const.CorPadrao);
                break;
            case Const.RETANGULO:
                jBtnRectangle.setBackground(Const.CorPadrao);
                break;
            case Const.TRIANGULO: 
                jBtnTriangle.setBackground(Const.CorPadrao);
                break;
            case Const.LOSANGO: 
                jBtnLozange.setBackground(Const.CorPadrao);
                break;
            case Const.HEXAGONO: 
                jBtnHexagon.setBackground(Const.CorPadrao);
                break;
            case Const.POLIGONO: 
                jBtnPolygon.setBackground(Const.CorPadrao);
                break;
            case Const.LAPIS:
                jBtnPencil.setBackground(Const.CorPadrao);
                break;
            case Const.BORRACHA:
                jBtnErase.setBackground(Const.CorPadrao);
                break;
        }
        activeColor = Const.CorInicio;
        activeForm = Const.NO_FORM;
        if (fillForm == true){
            fillForm = false;
            jBtnFillForm.setBackground(Const.CorPadrao);
        }
    }
    
    private JButton criaBotao(JButton _jBtn, Color _corBotao, int _x, int _y, int _width, int _height){;
        _jBtn.addActionListener(this);
        _jBtn.setBounds(_x, _y, _width, _height);
        _jBtn.setBackground(_corBotao);
        add(_jBtn);
        return _jBtn;
    }
    
    public static void main(String[] args) {
        CompGraficaPaint jp = new CompGraficaPaint();
    }
    
}