package com.mycompany.exemploaula6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.Timer;

public class ExemploAula6 extends JFrame
{
   JButton botao, erro,informacao,exclamacao,pergunta,nenhum,copiar,limpar;
   String nome;
   JLabel rotulo, rotulo1,rotulo2,rotulo3,rotulo4,rotulo5;
   JTextField texto1,texto2;
   
   int ds,dia,mes,ano,hh,mm,ss,h;
   DecimalFormat formato;
   Calendar data, hora;
   String diasemana[]={"Domingo","Segunda - Feira","Terça - Feira","Quarta - Feira","Quinta - Feira","Sexta - Feira","Sábado"};
   String meses[]={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
   
public ExemploAula6()
{
   super("Exemplo de Input Dialog");
   Container tela = getContentPane();
   Object linguagens [] = {"Java","Delphi","C++","Visual Basic"};
   tela.setLayout(null);
 
   
   nome = JOptionPane.showInputDialog("Entre com seu nome: ");
   Object opcao = JOptionPane.showInputDialog(null,"Qual sua linguagem favorita?" ,"Enquete",JOptionPane.QUESTION_MESSAGE,null,linguagens,linguagens[0]);
   
   erro = new JButton("Erro");
   informacao = new JButton("Informação");
   exclamacao = new JButton("Exclamação");
   pergunta = new JButton("Pergunta");
   nenhum = new JButton("Nenhum");
   rotulo = new JLabel("");
   botao = new JButton("Sair");
   rotulo1 = new JLabel("Nome: ");
   rotulo2 = new JLabel("Nome: ");
   rotulo3 = new JLabel("");
   rotulo4 = new JLabel("");
   rotulo5 = new JLabel("");
   data = Calendar.getInstance();
   ds = data.get(Calendar.DAY_OF_WEEK);
   dia = data.get(Calendar.DAY_OF_MONTH);
   mes = data.get(Calendar.MONTH);
   ano = data.get(Calendar.YEAR);
   rotulo3.setText("Data: "+ds+" "+dia+"/"+(mes+1)+"/"+ano);
   rotulo4.setText("Data: "+diasemana[ds-1]+", "+dia+" de "+meses[mes]+" de "+ano);
   
   
   
   texto1 = new JTextField(20);
   texto2 = new JTextField(20);
   copiar = new JButton("Copiar");
   limpar = new JButton("Limpar");

   
  
   rotulo.setBounds(10,40,350,20);
   botao.setBounds(100,190,100,20);
   erro.setBounds(20, 280, 120, 25); 
   informacao.setBounds(140, 280, 120, 25); 
   exclamacao.setBounds(250, 280, 120, 25); 
   pergunta.setBounds(370, 280, 120, 25); 
   nenhum.setBounds(470, 280, 120, 25);
   rotulo1.setBounds(370,30,50,20);
   rotulo2.setBounds(370,60,50,20);
   rotulo3.setBounds(10,80,280,20);
   rotulo4.setBounds(10,110,280,20);
   rotulo5.setBounds(10,140,280,20);
   texto1.setBounds(410,30,180,20);
   texto2.setBounds(410,60,180,20);
   copiar.setBounds(440,130,100,20);
   limpar.setBounds(340,130,100,20);
   rotulo.setText("O nome digitado foi: " + nome.toUpperCase() + " e a sua linguagem favorita é:"+opcao);
   
   //dicas
   botao.setToolTipText("Botão que finaliza a janela");
   erro.setToolTipText("Botão que exibe mensagem de erro");
   informacao.setToolTipText("Botão que exibe mensagem de informação");
   exclamacao.setToolTipText("Botão que exibe mensagem de exclamação");
   pergunta.setToolTipText("Botão que exibe mensagem de pergunta");
   nenhum.setToolTipText("Botão que exibe nenhuma mensagem");
  
   botao.addActionListener(new ActionListener(){
       
   public void actionPerformed(ActionEvent e){ //acão da caixa de diálogo
   int opcao;
   Object[] botoes = {"Sim","Não"};

   opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
   if (opcao==JOptionPane.YES_OPTION)
   System.exit(0);
}});
  //ação da mensagem de erro
  erro.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog(null,"Você escolheu erro","Mensagem de Erro",JOptionPane.ERROR_MESSAGE,null);
}});
  //ação da mensagem de informação
  informacao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog(null,"Você escolheu informação","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE,null);
}});
  //ação da mensagem de exclamação
  exclamacao.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
JOptionPane.showMessageDialog(null,"Você escolheu exclamação","Mensagem de Exclamação",JOptionPane.WARNING_MESSAGE,null);
}});
  //ação da mensgagem de pergunta
  pergunta.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
JOptionPane.showMessageDialog(null,"Você escolheu pergunta","Mensagem de Pergunta",JOptionPane.QUESTION_MESSAGE,null);
}});
  //ação da mensagame 'nenhum'
  nenhum.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
JOptionPane.showMessageDialog(null,"Você escolheu nenhum","Mensagem",JOptionPane.PLAIN_MESSAGE,null);
}});
  
  //função do botao copiar
  copiar.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
  String texto;
  texto = texto1.getText().toUpperCase();
  texto1.setText(texto);
  texto2.setText(texto1.getText().toLowerCase());
  }});
  
  //função do botao limpar
  limpar.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
  texto1.setText("");
  texto2.setText("");
  texto1.requestFocus();
}});
  
  //função das horas
  ActionListener tarefa = (new ActionListener(){
  public void actionPerformed(ActionEvent e){
  HORAS();
}});

javax.swing.Timer time = new javax.swing.Timer(1000,tarefa);
time.start();
tela.add(rotulo3);
tela.add(rotulo4);
tela.add(rotulo5);
tela.add(rotulo);
tela.add(botao);
tela.add(erro);
tela.add(informacao);
tela.add(exclamacao);
tela.add(pergunta);
tela.add(nenhum);
tela.add(rotulo1);
tela.add(rotulo2);
tela.add(texto1);
tela.add(texto2);
tela.add(copiar);
tela.add(limpar);
setSize(630,350);
setVisible(true);
setLocationRelativeTo(null);
}

public static void main(String args[]){

ExemploAula6 app = new ExemploAula6();
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
//métodos das horas
private void HORAS()
{
  hora = Calendar.getInstance();
  hh = hora.get(Calendar.HOUR_OF_DAY);
  mm = hora.get(Calendar.MINUTE);
  ss = hora.get(Calendar.SECOND);
  formato = new DecimalFormat("00");
  rotulo5.setText("Hora: "+formatar(hh)+":"+formatar(mm)+":"+formatar(ss));
}
private String formatar(int num)
{
formato = new DecimalFormat("00");
return formato.format(num);
}

}