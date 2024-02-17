/**
 *
 * @author AnDrÉ, niegar, sanchola
 */

package controle;
import javax.swing.*;
import java.awt.*;
import conexao.conexao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class frm_login extends JFrame {
    conexao con_clientes;
    
    JPasswordField txtsenha;
    JLabel labelusuario,labelsenha,labeltitulo;
    JTextField txtusuario;
    JButton botaologar, sair;
    ImageIcon imagem[];

    int tentativa = 0, cargo = 0;
    
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
    
    
    
    public frm_login(){
        
        con_clientes = new conexao();
        con_clientes.conecta();
        
        setTitle("Login de acesso");
        ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo1.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);
        
        labeltitulo = new JLabel("Acesso ao sistema");
        botaologar = new JButton ("Logar");
        txtsenha = new JPasswordField(7);
        txtusuario = new JTextField(7);
        
        //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());                 
        //icones dos botões
        String icones[]={"src/imagens/user.png","src/imagens/pass.png","src/imagens/exit.png"};
        imagem = new ImageIcon[4];
        for(int i = 0;i<3;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        labelusuario = new JLabel(imagem[0]);
        labelsenha = new JLabel(imagem[1]);
        sair = new JButton(imagem[2]);
        
        labelsenha.setToolTipText("Senha");
        labelusuario.setToolTipText("Nome do usuário");
        
        //posições e estilos
        labelsenha.setBounds(48,150,25,25);
        labelusuario.setBounds(48,100,25,25);
        labeltitulo.setBounds(90,70,190,20);
        txtsenha.setBounds(80,154,170,20);
        txtusuario.setBounds(80,105,170,20);     
        botaologar.setBounds(114,190,100,20);
        sair.setBounds(290,270,30,30);
        labeltitulo.setFont(new Font("Calibri",Font.BOLD,20));
        
        //funcionalidade botao sair
        sair.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
        }});
        
         //funcionalidade botao logar
        
        botaologar.addActionListener(   
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String senha = txtsenha.getText();
      
        try
        {
        String pesquisa = "select * from funcionario where login_func like '" + txtusuario.getText() + "' and senha_func like '" + txtsenha.getText() + "'";
        con_clientes.executaSQL(pesquisa);
        
        if(con_clientes.resultset.first())
        { //acesso ao form cadastro 
            cargo = con_clientes.resultset.getInt("cod_cargo");
            
            menu mostra = new menu(cargo);
            mostra.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Senha ou usuário inválidos!! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
            txtusuario.setText(null);
            txtsenha.setText(null);
            txtusuario.requestFocus();
            tentativa++;
        }
        }
        catch(SQLException errosql){
          JOptionPane.showMessageDialog(null, "Os dados digitados não foram localizados!! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          txtusuario.setText(null);
          txtsenha.setText(null);
          txtusuario.requestFocus();
          tentativa++;
        }
        
        if(tentativa>3)
        {
        JOptionPane.showMessageDialog(null, "\n Limite de tentativas excedido!!","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        con_clientes.desconecta();
        System.exit(0);
        }  
        }});
        
        getRootPane().setDefaultButton(botaologar);
        
        backgroundPanel.add(botaologar);
        backgroundPanel.add(txtsenha);
        backgroundPanel.add(labelusuario);
        backgroundPanel.add(labelsenha);
        backgroundPanel.add(labeltitulo);
        backgroundPanel.add(txtusuario);
        backgroundPanel.add(sair);
        setSize(350,350);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
     
    public static void main (String args[])
    {
    frm_login app = new frm_login();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}