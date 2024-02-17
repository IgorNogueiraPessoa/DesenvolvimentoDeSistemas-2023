package com.mycompany.exemploaula4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExemploAula4 extends JFrame
{
  JList lista;
  JComboBox lista2;
  JComboBox lista3;
  String cidades[] = {"Rio de Janeiro","São Paulo","Minas Gerais","Espírito Santo","Bahia","Pernambuco","Rio Grande do Sul","Acre"};
  JButton exibir;
  JLabel rotulo;
  JLabel rotulo2;
  public ExemploAula4()
  {
  super("Exemplo de List");
  Container tela = getContentPane();
  setLayout(null);
  exibir = new JButton("Exibir");
  lista = new JList(cidades);
  rotulo = new JLabel("");
  rotulo2 = new JLabel("");
  lista2=new JComboBox(cidades);
   lista3=new JComboBox(cidades); //combobox não editável
  lista2.setEditable(true); //combobox editável
  lista.setVisibleRowCount(5);
  JScrollPane painelRolagem = new JScrollPane(lista);
  lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  painelRolagem.setBounds(40, 50, 150, 100);
  exibir.setBounds(270, 50, 100, 30);
  lista2.setBounds(240, 100, 150, 30);
  lista3.setBounds(240, 150, 200, 30);
  rotulo.setBounds(50,150,200,30);
  rotulo2.setBounds(50,180,200,30);
  lista.setForeground(Color.blue);
  lista.setBackground(Color.yellow);
  lista.setFont(new Font("Times New Roman",Font.BOLD,16));
  //acionando evento do botão exibir
  exibir.addActionListener(
  new ActionListener(){
    public void actionPerformed(ActionEvent e){
    Object selecionados[]=lista.getSelectedValues();
    String resultados = "Valores selecionados:\n";
    for(int i=0; i<selecionados.length;i++)
     resultados += selecionados[i].toString()+"\n";
     JOptionPane.showMessageDialog(null,resultados);
     rotulo.setText("o estado é: "+lista2.getSelectedItem().toString());
      rotulo2.setText("o estado é: "+lista3.getSelectedItem().toString());
    } 
    }
    );
   tela.add(painelRolagem);
   tela.add(lista2);
   tela.add(lista3);
   tela.add(exibir);
   tela.add(rotulo);
   tela.add(rotulo2);
   setSize(400,250);
   setLocationRelativeTo(null);
   setVisible(true);
  }
  public static void main(String args[])
  {
    ExemploAula4 app = new ExemploAula4();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
