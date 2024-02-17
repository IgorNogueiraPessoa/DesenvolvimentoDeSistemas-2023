
package com.mycompany.exemploaula1;
import javax.swing.*;
import java.awt.*;
public class PrimeiraJanela extends JFrame{
    public PrimeiraJanela(){
    super("Exemplo aula 1");
    Container tela=getContentPane(); //criando container para mudar cor
    tela.setBackground(new Color(255,255,201));
    setResizable(false); //impedir de mudar o tamanho
    setSize(500,350);// largura  (comprimento)  e altura
    ImageIcon icone = new ImageIcon("src/Nerd-msn.png");//caminho imagem icone
    setIconImage(icone.getImage());
    setVisible(true);
    setLocationRelativeTo(null);//centralizar no centro da tela
    }
    public static void main(String args[])
    {
    PrimeiraJanela app = new PrimeiraJanela();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
    }
