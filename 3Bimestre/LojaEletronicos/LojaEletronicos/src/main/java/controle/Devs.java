package controle;

import javax.swing.*;
import java.awt.*;
import conexao.conexao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Devs extends JFrame {
    conexao con_clientes;
    
    JLabel dev1,dev2,dev3,sala;
    JButton voltar;
    ImageIcon imagem[];

    
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
    
    
    
    public Devs(final int cargo){
        
        con_clientes = new conexao();
        con_clientes.conecta();
        
        setTitle("Sobre");
        ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo5.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);
        
        dev1 = new JLabel("André Oliveira Paim");
        dev2 = new JLabel("Bruno Aparecido Vivencio Rodrigues");
        dev3 = new JLabel("Igor Nogueira Pessoa");
        sala = new JLabel("Turma: 2ºDS(AMS) - Tarde");
        voltar = new JButton("Retornar");
        
        //icone do botão
        String icones[]={"src/imagens/back.png"};
        imagem = new ImageIcon[2];
        for(int i = 0;i<1;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        voltar = new JButton(imagem[0]);
        
        dev1.setBounds(96,75,550,100);
        dev2.setBounds(96,120,550,100);
        dev3.setBounds(96,165,550,100);
        sala.setBounds(96,240,550,100);
        voltar.setBounds(395,10,30,30);
        dev1.setFont(new Font("Arial",Font.BOLD,13));
        dev2.setFont(new Font("Arial",Font.BOLD,13));
        dev3.setFont(new Font("Arial",Font.BOLD,13));
        sala.setFont(new Font("Arial",Font.BOLD,18));
        
        //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());                 
        
        //funcionalidade botao voltar
        voltar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        menu mostra = new menu(cargo);
        mostra.setVisible(true);
        dispose();
        }});
      
        
        backgroundPanel.add(voltar);
        backgroundPanel.add(dev1);
        backgroundPanel.add(dev2);
        backgroundPanel.add(dev3);
        backgroundPanel.add(sala);


        setSize(450,450);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
   
}