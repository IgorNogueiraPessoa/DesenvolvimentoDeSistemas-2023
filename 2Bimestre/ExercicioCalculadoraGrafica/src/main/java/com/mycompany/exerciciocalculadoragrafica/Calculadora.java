package com.mycompany.exerciciocalculadoragrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame 
{
 JLabel rotulo1, rotulo2, exibir1,exibir2,aluno;
 JTextField num1, num2;
 JButton somar,subtrair,mult,div, limpar, ocultar, exbir,habilitar,desabilitar,sair;  
 
  public Calculadora()
  {
      
  super("Mini Calculadora"); //declaração dos valores
  Container tela = getContentPane();
  setLayout(null);
  rotulo1 = new JLabel("1º Número");
  rotulo2 = new JLabel("2º Número");
  aluno = new JLabel("Desenvolvido por: Igor Nogueira - 2ºDS AMS");
  exibir1 = new JLabel("");
  exibir2 = new JLabel("");
  num1 = new JTextField();
  num2 = new JTextField();
  somar = new JButton("+");
  subtrair = new JButton("-");
  mult = new JButton("*");
  div = new JButton ("/");
  limpar = new JButton("Limpar");
  exbir  = new JButton("Exibir");
  ocultar = new JButton("Ocultar");
  habilitar = new JButton("Habilitar");
  desabilitar = new JButton("Desabilitar");
  sair = new JButton("Sair");
  
    
  rotulo1.setBounds(50,20,100,20); //posicionamento dos botões e estilo
  rotulo2.setBounds(50,60,100,20);
  num1.setBounds(120,20,100,20);
  num2.setBounds(120,60,100,20);
  exibir1.setBounds(50,120,200,20);
  exibir2.setBounds(113,120,200,20);
  exbir.setBounds(300,180,80,20);
  habilitar.setBounds(10,180,110,20);
  desabilitar.setBounds(110,180,110,20);
  ocultar.setBounds(220,180,80,20);
  sair.setBounds(300,220,80,20);
  somar.setBounds(300,20,60,20);
  subtrair.setBounds(300,40,60,20);
  mult.setBounds(300,60,60,20);
  div.setBounds(300,80,60,20);  
  limpar.setBounds(300,100,80,20);
  aluno.setBounds(30,220,250,20);
  exibir1.setForeground(Color.red);
  
  //atalhos
  sair.setMnemonic(KeyEvent.VK_S);
  limpar.setMnemonic(KeyEvent.VK_L);
 
  
  somar.addActionListener//evento do botão somar
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       int numero1,numero2,soma;
       soma = 0;
       numero1 = Integer.parseInt(num1.getText());
       numero2 = Integer.parseInt(num2.getText());
       soma = numero1+numero2;
       exibir1.setVisible(true);
       exibir2.setVisible(true);
       exibir1.setText("Resultado: ");exibir2.setText("A soma é "+soma);
     }
   }
  );
  
   subtrair.addActionListener//evento do botão subtrair
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       int numero1,numero2,sub;
       sub = 0;
       numero1 = Integer.parseInt(num1.getText());
       numero2 = Integer.parseInt(num2.getText());
       sub = numero1-numero2;
       exibir1.setVisible(true);
       exibir2.setVisible(true);
       exibir1.setText("Resultado: ");exibir2.setText("A subtração é "+sub);
     }
   }
  );
   
    mult.addActionListener//evento do botão multiplicação
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       int numero1,numero2,multi;
       multi = 0;
       numero1 = Integer.parseInt(num1.getText());
       numero2 = Integer.parseInt(num2.getText());
       multi = numero1*numero2;
       exibir1.setVisible(true);
       exibir2.setVisible(true);
       exibir1.setText("Resultado: ");exibir2.setText("A multiplicação é "+multi);
     }
   }
  );
    
     div.addActionListener//evento do botão da divisão
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       int numero1,numero2,div;
       div = 0;
       numero1 = Integer.parseInt(num1.getText());
       numero2 = Integer.parseInt(num2.getText());
       div = numero1/numero2;
       exibir1.setVisible(true);
       exibir2.setVisible(true);
       exibir1.setText("Resultado: ");exibir2.setText("A divisão é "+div);
     }
   }
  );
  
    limpar.addActionListener//evento do botão limpar
  (
   new ActionListener()
   {
     public void actionPerformed(ActionEvent e)//método 
     {
       num1.setText(null);
       num2.setText(null);
       exibir1.setText(null);
       exibir2.setText(null);
       num1.requestFocus();
     }
   }
  );
    
   sair.addActionListener //acionando o evento do botão sair          
   (
     new ActionListener()
    {
      public void actionPerformed(ActionEvent e)//método do botão sair
      {
        System.exit(0);
      } 
    }     
   );
  
   habilitar.addActionListener //evento do botão habilitar
  (
    new ActionListener()
    {
    public void actionPerformed(ActionEvent e)//método do evento 
    {
      exibir1.setEnabled(true);
      exibir2.setEnabled(true);
    }
    }
  );
   
   desabilitar.addActionListener //evento do botão habilitar
  (
    new ActionListener()
    {
    public void actionPerformed(ActionEvent e)//método do evento 
    {
      exibir1.setEnabled(false);
      exibir2.setEnabled(false);
    }
    }
  );
   
   ocultar.addActionListener //evento do botão ocultar,
  (
      new ActionListener()
      {
       public void actionPerformed(ActionEvent e)// método do evento 
       {
        exibir1.setVisible(false);//ocultando as labels
        exibir2.setVisible(false);
       }
      }
  );
  
     exbir.addActionListener//evento do botão exibir
  (
      new ActionListener()
      {
       public void actionPerformed(ActionEvent e)//método do evento 
       {
        exibir1.setVisible(true);
        exibir2.setVisible(true);
       }
      }
  );
  
  tela.add(rotulo1);
  tela.add(rotulo2);
  tela.add(num1);
  tela.add(num2);
  tela.add(exibir1);
  tela.add(exibir2);
  tela.add(somar);
  tela.add(subtrair);
  tela.add(mult);
  tela.add(div);
  tela.add(limpar);
  tela.add(ocultar);
  tela.add(exbir);
  tela.add(desabilitar);
  tela.add(habilitar);
  tela.add(aluno);
  tela.add(sair);
  
  setSize(500,350);
  setVisible(true);
  setLocationRelativeTo(null);
  }
   public static void main (String args[])
  {
    Calculadora app = new Calculadora();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}