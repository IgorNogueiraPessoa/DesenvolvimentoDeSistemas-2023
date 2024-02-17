package com.mycompany.lista12menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

  public class ClasseSobre extends JDialog
   {
     JButton sair;
     JLabel rotulo1, rotulo2, rotulo3;
     
     public ClasseSobre(Frame owner, String title, boolean modal)
     {
      super(owner,title,modal);
      Container tela1=getContentPane();
      tela1.setLayout(null);
     
      rotulo1 = new JLabel("Igor Nogueira Pessoa");
      rotulo2 = new JLabel("2º DS AMS - TARDE ");
      rotulo3 = new JLabel("Data de entrega: 19/06/2023");
      
      rotulo1.setFont(new Font("Calibri",Font.BOLD,14));
      rotulo2.setFont(new Font("Calibri",Font.BOLD,14));
      rotulo3.setFont(new Font("Calibri",Font.BOLD,14));
      
      //posicionamentos
      rotulo1.setBounds(50,30,240,20);
      rotulo2.setBounds(50,70,240,20);
      rotulo3.setBounds(50,110,240,20);
      
    
      //adicionando na tela
      tela1.add(rotulo1);
      tela1.add(rotulo2);
      tela1.add(rotulo3);
      
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