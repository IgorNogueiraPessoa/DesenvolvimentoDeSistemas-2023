package com.mycompany.lista12menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

  public class ClasseDividir extends JDialog
   {
     JButton sair , limpar;
     JLabel rotulo1, rotulo2, rotulo3, exibir;
     JTextField texto1, texto2;
     JButton dividir2n;
     
     public ClasseDividir(Frame owner, String title, boolean modal)
     {
      super(owner,title,modal);
      Container tela1=getContentPane();
      tela1.setLayout(null);
      //layout do formulario
      rotulo1 = new JLabel("1º Número: ");
      rotulo2 = new JLabel("2º Número: ");
      texto1 = new JTextField(5);
      texto2 = new JTextField(5);
      exibir = new JLabel("");
      dividir2n = new JButton("Dividir");
      limpar = new JButton("Limpar");
      //posicionamentos
      rotulo1.setBounds(50,20,100,20);
      rotulo2.setBounds(50,60,100,20);
      texto1.setBounds(120,20,100,20);
      texto2.setBounds(120,60,100,20);
      exibir.setBounds(50,140,200,20);
      dividir2n.setBounds(50,100,80,20);
      limpar.setBounds(160,250,100,20);
      
      
      //funcionalidade do botão dividir
      dividir2n.addActionListener(
      new ActionListener(){
      public void actionPerformed(ActionEvent e){
      try{    
         int numero1, numero2;
         double div;
         div = 0;
         numero1 = Integer.parseInt(texto1.getText());
         numero2 = Integer.parseInt(texto2.getText());
         div = (double) numero1 / numero2;
         // Formata o resultado com uma casa decimal
         DecimalFormat df = new DecimalFormat("#.#");
         String resultadoFormatado = df.format(div);
      
         exibir.setVisible(true);
         exibir.setText("A divisão é: "+resultadoFormatado);
        }
        catch (NumberFormatException ex) 
       {
         JOptionPane.showMessageDialog(null, "Digite apenas números válidos!","Erro", JOptionPane.ERROR_MESSAGE);
       }     
      }});
      
      exibir.setVisible(false);
      
     //limpar
     limpar.addActionListener(
     new ActionListener()
     {
     public void actionPerformed(ActionEvent e)
     {
       texto1.setText(null);
       texto2.setText(null);
       exibir.setText(null);
       texto1.requestFocus();
    }}); 
      
      //adicionando na tela
      tela1.add(rotulo1);
      tela1.add(rotulo2);
      tela1.add(texto1);
      tela1.add(texto2);
      tela1.add(exibir);
      tela1.add(dividir2n);
      tela1.add(limpar);
      
      sair = new JButton("Voltar");
      sair.setBounds(50,250,100,20);
      TBsair tsair = new TBsair();
      sair.addActionListener(tsair);
      tela1.add(sair);
      setSize(400,400);
      setLocationRelativeTo(null);
      setResizable(false);
     }                 
   
   
   //funcionalidade do botão sair
    private class TBsair implements ActionListener{
    public void actionPerformed(ActionEvent evento)
    {
    setVisible(false);
    dispose();
    }}} 