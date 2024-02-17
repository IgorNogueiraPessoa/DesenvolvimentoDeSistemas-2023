package com.mycompany.exemploaula2textarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploJTextArea extends JFrame
{
  JLabel rotulo;
  JTextArea texto;
  JScrollPane painelrolagem;
  JPanel painel;
  
   public ExemploJTextArea()
   {
       
   super("Exemplo com JTextField");
   Container tela = getContentPane();
   tela.setLayout(null);
   
   rotulo = new JLabel("Endereço");
   rotulo.setBounds(25,20,100,20);
   texto= new JTextArea(10,20); //criação da área do texto, com o limite de linhas e colunas, respectivamente.
   
   painelrolagem = new JScrollPane(texto);
   painelrolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //scroll de tela sempre irá aparecer, vertical e horizontalmente
   painelrolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   painel = new JPanel();
   painel.add(painelrolagem);
   painel.setBounds(20,40,250,250);
   
   texto.setFont(new Font("Comic Sans MS",Font.BOLD+Font.ITALIC,12)); //alterando a fonte
   texto.setForeground(Color.blue);
   texto.setBackground(new Color(255,255,201));//alterando cor de fundo
   
   texto.setLineWrap(true); //definindo a quebra de texto automatica
   texto.setWrapStyleWord(true);
   
   tela.add(rotulo);
   tela.add(painel);
   setSize(300,280);
   setVisible(true);
   setLocationRelativeTo(null);
   
   }
   
   public static void main(String args[])
   {
   ExemploJTextArea app = new ExemploJTextArea();
   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
}
