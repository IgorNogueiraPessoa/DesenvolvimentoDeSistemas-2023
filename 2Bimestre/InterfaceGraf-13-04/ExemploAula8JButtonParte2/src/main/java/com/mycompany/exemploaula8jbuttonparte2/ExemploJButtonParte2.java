//projeto abordando todos os conceitos a partir do subitem 8.2 até o final.
package com.mycompany.exemploaula8jbuttonparte2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploJButtonParte2 extends JFrame 
{
    JLabel rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    JButton somar, limpar, ocultar, exbir,habilitar,desabilitar;

 public ExemploJButtonParte2()
 {
  super("Exemplo de soma");
  Container tela = getContentPane();
  setLayout(null);
  rotulo1 = new JLabel("1º Número");
  rotulo2 = new JLabel("2º Número");
  texto1 = new JTextField(5);
  texto2 = new JTextField(5);
  exibir = new JLabel("");
  somar = new JButton("Somar");
  limpar = new JButton("Limpar");
  exbir  = new JButton("Exibir");
  ocultar = new JButton("Ocultar");
  habilitar = new JButton("Habilitar");
  desabilitar = new JButton("Desabilitar");
  
  rotulo1.setBounds(50,20,100,20);
  rotulo2.setBounds(50,60,100,20);
  texto1.setBounds(120,20,200,20);
  texto2.setBounds(120,60,200,20);
  exibir.setBounds(50,120,200,20);
  somar.setBounds(190,100,80,20);
  limpar.setBounds(50,100,80,20);
  exbir.setBounds(270,100,80,20);
  ocultar.setBounds(120,100,80,20);
  habilitar.setBounds(210,150,100,20);
  desabilitar.setBounds(80,150,100,20);
  
  desabilitar.addActionListener //evento do botão desabilitar
  (
    new ActionListener()
    {
    public void actionPerformed(ActionEvent e)//método do botão desabilitar
    {
      rotulo1.setEnabled(false);
      rotulo2.setEnabled(false);
    }
    }
  );
  
  habilitar.addActionListener //evento do botão habilitar
  (
    new ActionListener()
    {
    public void actionPerformed(ActionEvent e)//método do evento 
    {
      rotulo1.setEnabled(true);
      rotulo2.setEnabled(true);
    }
    }
  );
  
  ocultar.addActionListener //evento do botão ocultar,
  (
      new ActionListener()
      {
       public void actionPerformed(ActionEvent e)// método do evento 
       {
        rotulo1.setVisible(false);//ocultando as labels
        rotulo2.setVisible(false);
        exibir.setVisible(false);
       }
      }
  );
  
     exbir.addActionListener//evento do botão exibir
  (
      new ActionListener()
      {
       public void actionPerformed(ActionEvent e)//método do evento 
       {
        rotulo1.setVisible(true);
        rotulo2.setVisible(true);
        exibir.setVisible(true);
       }
      }
  );
  
  
  limpar.addActionListener//evento do botão limpar
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       texto1.setText(null);
       texto2.setText(null);
       texto1.requestFocus();
     }
   }
  );
  
  
  somar.addActionListener//evento do botão somar
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       int numero1,numero2,soma;
       soma = 0;
       numero1 = Integer.parseInt(texto1.getText());
       numero2 = Integer.parseInt(texto2.getText());
       soma = numero1+numero2;
       exibir.setVisible(true);
       exibir.setText("A soma é: "+soma);
     }
   }
  );
  exibir.setVisible(false); //botão exibir apaga tudo 
  
  //exibição final dos botões
  tela.add(rotulo1);
  tela.add(rotulo2);
  tela.add(texto1);
  tela.add(texto2);
  tela.add(exibir);
  tela.add(somar);
  tela.add(limpar);
  tela.add(ocultar);
  tela.add(exbir);
  tela.add(desabilitar);
  tela.add(habilitar);
  
  setSize(400,250);
  setVisible(true);
  setLocationRelativeTo(null);
 }
  public static void main (String args[])
  {
    ExemploJButtonParte2 app = new ExemploJButtonParte2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
