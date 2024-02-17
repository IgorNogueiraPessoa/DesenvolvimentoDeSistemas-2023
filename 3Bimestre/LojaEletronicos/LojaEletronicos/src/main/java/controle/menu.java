package controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class menu extends JFrame
{
   JMenuBar barra;
   JMenu info,cadastros,sairmenu;
   JMenuItem sobre,funcionariomenu,clientemenu,produtomenu;
   JButton funcionariob, clienteb, produtob, caixab, sairb, retornar;
   ImageIcon imagem[];
   JLabel titulo;
   

   //imagem de fundo
         class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            try {
                backgroundImage = javax.imageio.ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
   
   
   public menu(final int cargo)
   {
    super("Menu de Gerenciamento");
     ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo2.png");
     setContentPane(backgroundPanel);
     backgroundPanel.setLayout(null);

    barra = new JMenuBar();
    setJMenuBar(barra);
    //icone da janela
    ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
    setIconImage(icone.getImage());
    
    //icone dos botoes
    String icones[]={"src/imagens/exit.png","src/imagens/return.png","src/imagens/client-icon.png","src/imagens/produtos-icon.png","src/imagens/func-icon.png","src/imagens/caixa.png"};
    imagem = new ImageIcon[7];
    for(int i = 0;i<6;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
    sairb = new JButton(imagem[0]);
    retornar = new JButton(imagem[1]);
    clienteb = new JButton (imagem[2]);
    produtob = new JButton (imagem[3]); 
    funcionariob = new JButton (imagem[4]);
    caixab = new JButton(imagem[5]);
    
    info = new JMenu("Info");
    cadastros = new JMenu("Cadastros");
    clientemenu = new JMenuItem("Cliente");
    funcionariomenu = new JMenuItem("Funcionário");
    produtomenu = new JMenuItem("Produto");
    sobre = new JMenuItem("Devs");
    sairmenu = new JMenu("Sair");
    titulo = new JLabel("Opções para gerenciamento:");

    barra.add(cadastros);
    barra.add(info);
    barra.add(sairmenu);
    

    //atalhos
     funcionariob.setMnemonic(KeyEvent.VK_F);
     clienteb.setMnemonic(KeyEvent.VK_C);
     produtob.setMnemonic(KeyEvent.VK_P);
     sobre.setMnemonic(KeyEvent.VK_D);
     sairb.setMnemonic(KeyEvent.VK_S);

    ////////////posiciona na tela os conteudos////////////////

    clienteb.setBounds(45,320,102,40);
    funcionariob.setBounds(175,320,102,40);
    produtob.setBounds(305,320,102,40);
    sairb.setBounds(60,440,30,30);
    retornar.setBounds(20,440,30,30);
    titulo.setBounds(45,270,300,40);
    
    if (cargo!= 1)
    {
     caixab.setBounds(160,320,102,40);
    }
    else
    {
        caixab.setBounds(435,320,102,40);
    }
    
    titulo.setFont(new Font("Calibri",Font.BOLD,20));
    
    //funcionalidade das opçoes sair (barra de ferramentas e  menu)
    sairmenu.addMenuListener(
            new MenuListener() {

        public void menuSelected(MenuEvent e) {
                    int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
        }

        public void menuDeselected(MenuEvent e) {
            System.out.println("menuDeselected");

        }

        public void menuCanceled(MenuEvent e) {
            System.out.println("menuCanceled");

            
        }
    });

        //funcionalidade botao sair
        sairb.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
        }});
        
      //funcionalidade do botao cliente
        clienteb.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_cli mostra = new adm_cli(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
      //funcionalidade do botao funcionário
        funcionariob.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_func mostra = new adm_func(cargo);
        mostra.setVisible(true);
        dispose();
        }});
     
      //funcionalidade do botao cliente
        produtob.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_prod mostra = new adm_prod(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
       //funcionalidade do botao caixa
        caixab.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_caixa mostra = new adm_caixa(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
        //funcionalidade do menu, opção cliente
        clientemenu.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_cli mostra = new adm_cli(cargo);
        mostra.setVisible(true);
        dispose();
        }});

         //funcionalidade do menu, opção funcionário
        funcionariomenu.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_func mostra = new adm_func(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
        //funcionalidade do menu, opção produto
        produtomenu.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        adm_prod mostra = new adm_prod(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
        //funcionalidade do menu, opção devs
        sobre.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        Devs mostra = new Devs(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
        //retornar
        retornar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        frm_login mostra = new frm_login();
        mostra.setVisible(true);
        dispose();
        }});
    
        
    backgroundPanel.add(clienteb);
    backgroundPanel.add(caixab);
    if(cargo == 1){
        backgroundPanel.add(funcionariob);
        backgroundPanel.add(produtob);
    }
    backgroundPanel.add(sairb);
    info.add(sobre);
    cadastros.add(clientemenu);
    cadastros.add(funcionariomenu);
    cadastros.add(produtomenu);
    
    backgroundPanel.add(titulo);
    
    backgroundPanel.add(retornar);
    setSize(600, 550);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
   }
   
    
}