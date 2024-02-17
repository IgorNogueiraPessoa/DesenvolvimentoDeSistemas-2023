package com.mycompany.lista12menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lista12Menu extends JFrame
{
   JMenuBar barra;
   JMenu opcoes, operacoes;
   JMenuItem sair,soma,subtracao,multiplicacao,divisao,sobre,sairpop,sobrepop;
   JPopupMenu opcoespop; 
   JToolBar barratool;
   JButton somartool, subtrairtool, multiplicacaotool, divisaotool, sairtool;
   ImageIcon imagens[];
   
   public Lista12Menu()
   {
    super("Exercício Lista 12  - Menu");
    Container tela = getContentPane();
    tela.setLayout(null);
    barra = new JMenuBar();
    setJMenuBar(barra);
    opcoes = new JMenu("Opçôes");
    barra.add(opcoes);
    sobre = new JMenuItem("Sobre");
    operacoes = new JMenu("Operações");
    soma = new JMenuItem("Soma");
    subtracao = new JMenuItem("Subtração");
    divisao = new JMenuItem("Divisão");
    multiplicacao = new JMenuItem("Multiplicação");
    sair = new JMenuItem("Sair");
    //menu popup//
    sobrepop = new JMenuItem("Sobre");
    sairpop = new JMenuItem("Sair"); 
    opcoespop = new JPopupMenu();
    
    //atalhos
     opcoes.setMnemonic(KeyEvent.VK_O);
     operacoes.setMnemonic(KeyEvent.VK_P);
     sobre.setMnemonic(KeyEvent.VK_B);
     sair.setMnemonic(KeyEvent.VK_S);
     soma.setMnemonic(KeyEvent.VK_M);
     subtracao.setMnemonic(KeyEvent.VK_N);
     multiplicacao.setMnemonic(KeyEvent.VK_X);
     divisao.setMnemonic(KeyEvent.VK_D);
     
    ////////////barra de ferramentas////////////////
     String icones[]={"src/somar.png","src/sub.png","src/multi.png","src/divide.png","src/exit.png"};
     imagens = new ImageIcon[6];
     for(int i = 0;i<5;i++)
     {
      imagens[i] = new ImageIcon(icones[i]);
     }
     somartool = new JButton(imagens[0]);
     subtrairtool = new JButton(imagens[1]);
     multiplicacaotool = new JButton(imagens[2]);
     divisaotool = new JButton(imagens[3]);
     sairtool = new JButton(imagens[4]);
     
     somartool.setToolTipText("Realizar operação de soma");
     subtrairtool.setToolTipText("Realizar operação de subtração");
     divisaotool.setToolTipText("Realizar operação de dividir");
     multiplicacaotool.setToolTipText("Realizar operação de multiplicação");
     sairtool.setToolTipText("Sair do programa");
     barratool = new JToolBar("Barra de Ferramentas");
     UIManager.put("ToolTip.background",SystemColor.info);
     UIManager.put("ToolTip.foreground",Color.blue);
     barratool.setBounds(1,1,550,50);
     barratool.setRollover(true); 
    
    
    ///////////////////funcionalidade do botao direito do mouse, para aparecer o menu popup////////////////////////
     tela.addMouseListener(new MouseAdapter(){
     public void mouseReleased(MouseEvent e){
     if(e.isPopupTrigger())
     opcoespop.show(e.getComponent(),e.getX(),e.getY()); }});
     Tratador tratmenu = new Tratador();
     sobrepop.addActionListener(tratmenu);
     sairpop.addActionListener(tratmenu);
   
    
    //funcionalidade das opçoes sair (barra de ferramentas e  menu)
    sair.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
    }});

    sairtool.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
    }});
    
    //funcionalidade do botao somar
    soma.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSoma segundajanela = new ClasseSoma(null,"Soma",true);
    segundajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    segundajanela.setVisible(true);
    }});
    
    somartool.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSoma segundajanela = new ClasseSoma(null,"Soma",true);
    segundajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    segundajanela.setVisible(true);
    }});
    
    //funcionalidade do botao de subtrair
    subtracao.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSub terceirajanela = new ClasseSub(null,"Subtração",true);
    terceirajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    terceirajanela.setVisible(true);
    }});
    
    subtrairtool.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSub terceirajanela = new ClasseSub(null,"Subtração",true);
    terceirajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    terceirajanela.setVisible(true);
    }});
  
    //funcionalidade botão multiplicar
    multiplicacao.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseMulti quartajanela = new ClasseMulti(null,"Multiplicação",true);
    quartajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    quartajanela.setVisible(true);
    }});
   
    multiplicacaotool.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseMulti quartajanela = new ClasseMulti(null,"Multiplicação",true);
    quartajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    quartajanela.setVisible(true);
    }});
   
    //funcionalidade botão dividir
    divisao.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseDividir quintajanela = new ClasseDividir(null,"Divisão",true);
    quintajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    quintajanela.setVisible(true);
    }});
    
    divisaotool.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseDividir quintajanela = new ClasseDividir(null,"Divisão",true);
    quintajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    quintajanela.setVisible(true);
    }});
   
    //funcionalidade do botão sobre
    sobre.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSobre sextajanela = new ClasseSobre(null,"Sobre",true);
    sextajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    sextajanela.setVisible(true);
    }});
    
    sobrepop.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    ClasseSobre sextajanela = new ClasseSobre(null,"Sobre",true);
    sextajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    sextajanela.setVisible(true);
    }});
   
    opcoes.add(operacoes);
    opcoes.add(sobre);
    opcoes.addSeparator();
    opcoes.add(sair);
    operacoes.add(soma);
    operacoes.add(subtracao);
    operacoes.add(multiplicacao);
    operacoes.add(divisao);
    opcoespop.add(sobrepop);
    opcoespop.addSeparator();
    opcoespop.add(sairpop);
    barratool.add(somartool);
    barratool.add(subtrairtool);
    barratool.add(multiplicacaotool);
    barratool.add(divisaotool);
    barratool.addSeparator();
    barratool.add(sairtool);
    tela.add(barratool);
    setSize(500, 550);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
   }
    
    public static void main (String args[])
   {
   Lista12Menu app = new Lista12Menu();
   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
     private class Tratador implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==sairpop){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)
        System.exit(0);
        else{
        if(e.getSource()==sobrepop){
        ClasseSobre sextajanela = new ClasseSobre(null,"Terceira Janela",true);
        sextajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sextajanela.setVisible(true);}}}       
    }};  
}