/////////////////////projeto abordando itens 19.2 , 20 e 21/////////////////////
package com.mycompany.exemplomenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploMenu extends JFrame
{
   JMenuBar barra;
   JMenu opcoes, fonte, cor;
   JMenuItem limpar,sair,azul,verde,vermelho,amarelo,preto,recortar,copiar,colar;
   JPopupMenu opcoespop;
   JToolBar barratool;
   JButton direita,esquerda,centralizar,recortartool,copiartool,colartool;
   ImageIcon imagens[];
   JTextArea texto;
   JPanel painel;
   JScrollPane rolagem;
   
   public ExemploMenu()
   { //declarando os valores
     super("Exemplo de menus executando ações");
     Container tela = getContentPane();
     tela.setLayout(null);
     barra = new JMenuBar();
     setJMenuBar(barra);
     opcoes = new JMenu("Opcoes");
     barra.add(opcoes);
     limpar = new JMenuItem("Limpar");
     fonte = new JMenu("Fonte");
     cor = new JMenu("Cor");
     azul = new JMenuItem("Azul");
     verde = new JMenuItem("Verde");
     vermelho = new JMenuItem("Vermelho");
     amarelo = new JMenuItem("Amarelo");
     preto = new JMenuItem("Preto");
     //////////valores menu popup//////////////////
     opcoespop = new JPopupMenu();
     recortar = new JMenuItem("Recortar");
     copiar = new JMenuItem("Copiar");
     colar = new JMenuItem("Colar");
     sair = new JMenuItem("Sair");
     ////////////valores barra de ferramentas ** nao apresentam funcionalidade, como no exemplo.////////////////
     String icones[]={"src/direita.png","src/esquerda.png","src/centro.png","src/cortar.png","src/copiar.png","src/colar.png"};
     imagens = new ImageIcon[6];
     for(int i = 0;i<6;i++)
     {
      imagens[i] = new ImageIcon(icones[i]);
     }
     direita = new JButton(imagens[0]);
     esquerda = new JButton(imagens[1]);
     centralizar = new JButton(imagens[2]);
     recortartool = new JButton(imagens[3]);
     copiartool = new JButton(imagens[4]);
     colartool = new JButton(imagens[5]);
     direita.setToolTipText("Direita (Ctrl+d)");
     esquerda.setToolTipText("Esquerda (Ctrl+e)");
     centralizar.setToolTipText("Centralizar (Ctrl+z)");
     recortartool.setToolTipText("Recortar (Ctrl+x)");
     copiartool.setToolTipText("Copiar (Ctrl+c)");
     colartool.setToolTipText("Colar (Ctrl+v)");
     barratool = new JToolBar("Barra de Ferramentas");
     UIManager.put("ToolTip.background",SystemColor.info);
     UIManager.put("ToolTip.foreground",Color.blue);
     barratool.setBounds(1,1,260,50);
     barratool.setRollover(true); 
     
     
     //atalhos
     opcoes.setMnemonic(KeyEvent.VK_O);
     limpar.setMnemonic(KeyEvent.VK_L);
     fonte.setMnemonic(KeyEvent.VK_F);
     sair.setMnemonic(KeyEvent.VK_S);
     cor.setMnemonic(KeyEvent.VK_C);
     recortar.setMnemonic(KeyEvent.VK_R);
     copiar.setMnemonic(KeyEvent.VK_C);
     colar.setMnemonic(KeyEvent.VK_L);
     
     
     //configurações da área de texto
     texto = new JTextArea(10,20);
     rolagem = new JScrollPane(texto);
     rolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     painel = new JPanel(); 
     painel.setBounds(30,60,250,250);
     ///////////////////funcionalidade do botao direito do mouse, para aparecer o menu popup////////////////////////
     texto.addMouseListener(new MouseAdapter(){
     public void mouseReleased(MouseEvent e){
     if(e.isPopupTrigger())
     opcoespop.show(e.getComponent(),e.getX(),e.getY()); }});
     Tratador tratmenu = new Tratador();
     recortar.addActionListener(tratmenu);
     copiar.addActionListener(tratmenu);
     colar.addActionListener(tratmenu);
     
     
     //funcionalidade do botão limpar
     limpar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
           texto.setText("");
           texto.requestFocus();
         }});
     
     //funcionalidade do botão sair
     sair.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         System.exit(0);
       }});
     
     //funcionalidade do botão azul
     azul.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         texto.setForeground(Color.blue);
         repaint();
       }});

     //funcionalidade do botão verde
     verde.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         texto.setForeground(Color.green);
         repaint();
       }});
     
     //funcionalidade do botão vermelho
     vermelho.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         texto.setForeground(Color.red);
         repaint();
       }});
     
     //funcionalidade do botão amarelo
     amarelo.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         texto.setForeground(Color.yellow);
         repaint();
       }});
     
     //funcionalidade do botão preto
     preto.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
         texto.setForeground(Color.black);
         repaint();
       }});
     
    
     //adicionando na tela 
     tela.add(painel);
     painel.add(rolagem);
     opcoes.add(limpar);
     opcoes.add(fonte);
     opcoes.addSeparator();
     opcoes.add(sair);
     cor.add(azul);
     cor.add(verde);
     cor.add(vermelho);
     cor.add(amarelo);
     cor.add(preto);
     fonte.add(cor);
     opcoespop.add(recortar);
     opcoespop.add(copiar);
     opcoespop.addSeparator();
     opcoespop.add(colar);
     barratool.add(direita);
     barratool.add(esquerda);
     barratool.add(centralizar);
     barratool.addSeparator();
     barratool.add(recortartool);
     barratool.add(copiartool);
     barratool.add(colartool);
     tela.add(barratool);
     setSize(400,330);
     setLocationRelativeTo(null);
     setVisible(true);
     setResizable(false);
   }
   
   public static void main (String args[])
   {
   ExemploMenu app = new ExemploMenu();
   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   private class Tratador implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
        if(e.getSource()==recortar)
        texto.cut();
        if(e.getSource()==copiar)
        texto.copy();
        if(e.getSource()==colar)
        texto.paste();
        repaint(); 
       }}
}