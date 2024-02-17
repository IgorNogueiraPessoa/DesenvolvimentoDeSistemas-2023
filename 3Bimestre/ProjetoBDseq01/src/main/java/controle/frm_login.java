
package controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import conexao.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.sql.*;


public class frm_login extends JFrame {
    Conexao con_clientes;
    
    JPasswordField txtsenha;
    JLabel labelusuario,labelsenha,labeltitulo;
    JTextField txtusuario;
    JButton botaologar, sair;
    ImageIcon imagem[];
    int tentativa = 0 ;
    
    public frm_login(){
        
        con_clientes = new Conexao();
        con_clientes.conecta();
        
        setTitle("Login de acesso");
        Container tela = getContentPane();
        setLayout(null);
        
        labeltitulo = new JLabel("Acesso ao sistema");
        botaologar = new JButton ("Logar");
        txtsenha = new JPasswordField(5);
        txtusuario = new JTextField(5);
                           
        //icones dos botões
        String icones[]={"src/user.png","src/pass.png","src/exit.png"};
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
        labeltitulo.setBounds(90,40,190,20);
        txtsenha.setBounds(80,154,100,20);
        txtusuario.setBounds(80,105,150,20);     
        botaologar.setBounds(51,210,100,20);
        sair.setBounds(290,270,30,30);
        labeltitulo.setFont(new Font("Calibri",Font.BOLD,20));
        tela.setBackground(new Color(176,196,222));
        
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
        //Character.isDigit() ou Character.isLetter(), importar import java.util.Scanner;
              
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String senha = txtsenha.getText();
        
        if(txtsenha.getText().matches("[0-9]+")){ //ver se existe alguma letra no campo senha (pq se tiver letra na senha, ele cai no try catch da classe de conexao e nao faz contagem de tentativa
      
        try
        {
        String pesquisa = "select * from tblusuario where usuario like '" + txtusuario.getText() + "' && senha = " + txtsenha.getText() + "";
        con_clientes.executaSQL(pesquisa);
          
        if(con_clientes.resultset.first())
        { //acesso ao form cadastro 
        FrmTelaCad mostra = new FrmTelaCad();
        mostra.setVisible(true);
        dispose();
        }
        else
        {
         JOptionPane.showMessageDialog(null, "Senha ou usuário incorreto!!","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
         tentativa++;
        }
        }
        catch(SQLException errosql){
          JOptionPane.showMessageDialog(null, "Os dados digitados não foram localizados!! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          tentativa++;
        }}
        
        else{
             JOptionPane.showMessageDialog(null, "Senha ou usuário incorreto!! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
             tentativa++; 
        }
        if(tentativa>3)
        {
        JOptionPane.showMessageDialog(null, "\n Limite de tentativas excedido!!","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        con_clientes.desconecta();
        System.exit(0);
        }  
        }});
        
        tela.add(botaologar);
        tela.add(txtsenha);
        tela.add(labelusuario);
        tela.add(labelsenha);
        tela.add(labeltitulo);
        tela.add(txtusuario);
        tela.add(sair);
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
    }
     
    public static void main (String args[])
    {
    frm_login app = new frm_login();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
