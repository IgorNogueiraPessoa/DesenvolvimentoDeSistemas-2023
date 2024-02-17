package com.mycompany.exerciciolista10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class frmMostrar extends JFrame 
{
   JLabel lnome,lmatric,lrest,lperiod,lcurso,lserie,rotulo1,rotulo2,rotulo3,rotulo4,rotulo5,rotulo6;
   JButton voltar,sair;
   
   public frmMostrar(String nome, String matr, String restr, String period, String curso, String serie) 
   {
   //declaracao de valores
   super ("Lista 10 - Passagem de dados");
   Container tela = getContentPane();
   setLayout(null);
   rotulo1 = new JLabel("Nome:");
   rotulo2 = new JLabel("Matrícula:");
   rotulo3 = new JLabel("Série:");
   rotulo4 = new JLabel("Curso:");
   rotulo5 = new JLabel("Período:");
   rotulo6 = new JLabel("Restrição médica:");
   lnome = new JLabel("");
   lmatric = new JLabel("");
   lperiod = new JLabel ("");
   lcurso = new JLabel ("");
   lserie = new JLabel ("");
   lrest = new JLabel("");
   voltar = new JButton("Voltar");
   sair = new JButton("Fechar");
   
   
   //posicionamentos
   rotulo1.setBounds(30,50,100,20);
   lnome.setBounds(80,50,200,20);
   rotulo2.setBounds(30,70,100,20);
   lmatric.setBounds(105,70,60,20);
   rotulo3.setBounds(30,90,60,20);
   lserie.setBounds(75,90,60,20);
   rotulo4.setBounds(30,110,60,20);
   lcurso.setBounds(80,110,60,20);
   rotulo5.setBounds(30,130,60,20);
   lperiod.setBounds(95,130,130,20);
   rotulo6.setBounds(30,150,150,20);
   lrest.setBounds(160,150,120,20);
   sair.setBounds(240,250,130,20);
   voltar.setBounds(30,250,150,20);
   
   //negrito
   rotulo1.setFont(new Font("Arial",Font.BOLD,14));
   rotulo2.setFont(new Font("Arial",Font.BOLD,14));
   rotulo3.setFont(new Font("Arial",Font.BOLD,14));
   rotulo4.setFont(new Font("Arial",Font.BOLD,14));
   rotulo5.setFont(new Font("Arial",Font.BOLD,14));
   rotulo6.setFont(new Font("Arial",Font.BOLD,14));
   
   
   //funcionalidade do botão sair 
   sair.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
    }});
   
   //funcionalidade do botão voltar
   voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        Principal p = new Principal();
        p.setVisible(true);
        dispose();
    }});
   
    voltar.setMnemonic(KeyEvent.VK_V);
    sair.setMnemonic(KeyEvent.VK_F);
   
   lnome.setText(nome);
   lmatric.setText(matr);
   lperiod.setText(period);
   lcurso.setText(curso);
   lserie.setText(serie);
   lrest.setText(restr);
   
    tela.add(rotulo1);
    tela.add(rotulo2);
    tela.add(rotulo3);
    tela.add(rotulo4);
    tela.add(rotulo5);
    tela.add(rotulo6);
    tela.add(lnome);
    tela.add(lmatric);
    tela.add(lperiod);
    tela.add(lcurso);
    tela.add(lserie);
    tela.add(lrest);
    tela.add(sair);
    tela.add(voltar);
    setSize(450,350);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
 
  }    
}

    