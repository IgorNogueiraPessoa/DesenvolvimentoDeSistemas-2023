package com.mycompany.exemplo2aula2mascara;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ExemploJFormattedTextField extends JFrame {
    JLabel rotulocep,rotulotel,rotulocpf,rotulodata;
    JFormattedTextField cep,tel,cpf,data;
    MaskFormatter mascaracep,mascaratel,mascaracpf,mascaradata;
    
    public ExemploJFormattedTextField(){
    super("Exemplo com JFormatedTextField");
    Container tela = getContentPane();    
    setLayout(null);   
      
    rotulocep = new JLabel("CEP"); //criando os textos
    rotulotel =  new JLabel("Telefone");
    rotulocpf = new JLabel("CPF");
    rotulodata = new JLabel("Data");
    
    rotulocep.setBounds(50,40,100,20);//ajustando a posição dos textos
    rotulotel.setBounds(50,80,100,20);
    rotulocpf.setBounds(50,120,100,20);
    rotulodata.setBounds(50,160,100,20);
    
    try //método try cath para verificação da digitação de acordo com o que será formatado
    {
    mascaracep = new MaskFormatter("#####-###");//formatação apenas em números
    mascaratel = new MaskFormatter("(##)#####-####");
    mascaracpf = new MaskFormatter("###.###.###-##");
    mascaradata = new MaskFormatter("##/##/####");
    mascaracep.setPlaceholderCharacter('_');//exibir placeholder antes de digitar
    mascaratel.setPlaceholderCharacter('_');
    mascaracpf.setPlaceholderCharacter('_');
    mascaradata.setPlaceholderCharacter('_');
    }
    catch(ParseException excp){}
    
    cep = new JFormattedTextField(mascaracep);
    tel = new JFormattedTextField(mascaratel);
    cpf = new JFormattedTextField(mascaracpf);
    data = new JFormattedTextField(mascaradata);
    
    cep.setForeground(Color.blue); //mudando a cor das linhas
    tel.setForeground(Color.red);
    cpf.setForeground(Color.green);
    data.setForeground(new Color(255,128,128));
    
    cep.setBackground(new Color(255,255,201));//mudando cor do background
    tel.setBackground(new Color(255,255,201));
    cpf.setBackground(new Color(255,255,201));
    data.setBackground(new Color(255,255,201));
    
    cep.setFont(new Font("Times New Roman",Font.BOLD,14));//mudando a fonte do texto
    tel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
    cpf.setFont(new Font("Arial",Font.BOLD,14));
    data.setFont(new Font("Calibri",Font.BOLD,14));
    
    cep.setBounds(150,40,70,20); //ajustando posição da caixa de texto
    tel.setBounds(150,80,100,20);
    cpf.setBounds(150,120,100,20);
    data.setBounds(150,160,70,20);
    
    tela.add(rotulocep);
    tela.add(rotulotel);
    tela.add(rotulocpf);
    tela.add(rotulodata);
    tela.add(cep);
    tela.add(tel);
    tela.add(cpf);
    tela.add(data);
    
    setSize(400, 250);
    setVisible(true);   
    setLocationRelativeTo(null);
 }
  public static void main (String args[])
 {
    ExemploJFormattedTextField  app = new ExemploJFormattedTextField();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
