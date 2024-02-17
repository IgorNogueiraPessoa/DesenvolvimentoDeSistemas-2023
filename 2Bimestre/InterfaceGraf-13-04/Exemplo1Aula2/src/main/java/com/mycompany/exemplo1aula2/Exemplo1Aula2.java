package com.mycompany.exemplo1aula2;
import javax.swing.*;
import java.awt.*;

public class Exemplo1Aula2 extends JFrame {
 JLabel rotulo1,rotulo2,rotulo3,rotulo4;// criando objetod do tipo JLabel
 JLabel imagem;
 JTextField texto1, texto2, texto3, texto4;//adicionando caixa de texto
 
 public Exemplo1Aula2(){
  super("Exemplo com label");
  Container tela=getContentPane();
  ImageIcon icone = new ImageIcon("src/bob.jpg"); //inserindo a imagem
  imagem = new JLabel(icone);
  setLayout(null);
  
  rotulo1 = new JLabel("Nome");//atribuindo conteúdo do JLabel
  rotulo2 = new JLabel("Idade");
  rotulo3 = new JLabel("Telefone");
  rotulo4 = new JLabel("Celular");
  
  texto1 = new JTextField(50); //tamanho da caixa
  texto2 = new JTextField(3);
  texto3 = new JTextField(10);
  texto4 = new JTextField(10);
  
  
  rotulo1.setBounds(50,20,80,20);//coluna, linha, largura e comprimento, respectivamente.
  rotulo2.setBounds(50,60,80,20);
  rotulo3.setBounds(20,100,100,20);
  rotulo4.setBounds(40,140,80,20);
  
  
  texto1.setBounds(110,20,200,20);//especificar o posicionamento da caixa
  texto2.setBounds(110,60,20,20);
  texto3.setBounds(110,100,80,20);
  texto4.setBounds(110,140,80,20);
 
  
  rotulo1.setForeground(Color.red);//alterando a cor
  rotulo2.setForeground(Color.blue);
  rotulo3.setForeground(new Color(190,152,142));
  rotulo4.setForeground(new Color(201,200,100));
  
  rotulo1.setFont(new Font("Arial",Font.BOLD, 14));//altersndo fonte
  rotulo2.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
  rotulo3.setFont(new Font("Courier New",Font.BOLD, 18));
  rotulo4.setFont(new Font("Times New Roman",Font.BOLD, 20));
  
  texto1.setFont(new Font("Calibri",Font.BOLD,14));//alterando fonte da caixa
  texto2.setFont(new Font("Calibri",Font.BOLD,14));
  texto3.setFont(new Font("Calibri",Font.BOLD,14));
  texto4.setFont(new Font("Calibri",Font.BOLD,14));
  
  texto1.setHorizontalAlignment(JTextField.CENTER); //alinhando uma caixa de texto ao centro
  texto3.setHorizontalAlignment(JTextField.RIGHT);//alinhando uma caixa de texto da direita pra esquda
  
  texto1.setBackground(new Color(255,255,201));
  texto2.setBackground(new Color(255,255,201));
  texto3.setBackground(new Color(255,255,201));
  texto4.setBackground(new Color(255,255,201));
  

  
  tela.add(rotulo1);//exibição final do rótulo
  tela.add(rotulo2);
  tela.add(rotulo3);
  tela.add(rotulo4);
  
  tela.add(texto1);//exibição final da caixa
  tela.add(texto2);
  tela.add(texto3);
  tela.add(texto4);
  
  imagem.setBounds(50, 180, 200, 235); //ajustando a posição da imgem, para ficar abaixo do formulário. ainda não sei como ajustar o tamanho.
  tela.add(imagem);//exibindo a imagem
  
  setSize(600,560);
  setVisible(true);
  setLocationRelativeTo(null);
 }
 public static void main (String args[])
 {
    Exemplo1Aula2 app = new Exemplo1Aula2();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
