package com.mycompany.exerciciolista10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class Principal extends JFrame
{
    JLabel rotulo1, rotulo2, rotulo3, rotulo4,texto; 
    JTextField txtnome;
    JFormattedTextField txtmatricula;
    MaskFormatter matricula;
    JTextArea restr;
    JScrollPane painelrolagem;
    JPanel painel;
    JRadioButton etim,mtec,tecnico,serie1,serie2,serie3;
    ButtonGroup grupocurso,gruposerie;
    String periodo[] = {"Selecione","Matutino","Vespertino","Noturno"};
    JComboBox lista;
    JButton limpar,apresentar,sair;
    
    public Principal()
    {
     //declaração de valores
     super ("Lista 10 - Passagem de dados");
     Container tela = getContentPane();
     setLayout(null);
     rotulo1 = new JLabel("Nome:");
     rotulo2 = new JLabel("Matrícula:");
     rotulo3 = new JLabel("Informe os dados de seu curso:");
     rotulo4 = new JLabel("Restrições médicas:");
     texto = new JLabel("Dados Cadastrais Do Aluno");
     lista = new JComboBox(periodo);
     lista.setMaximumRowCount(3);
     etim = new JRadioButton("Etim");
     mtec = new JRadioButton("Mtec");
     tecnico = new JRadioButton("Técnico");
     serie1 = new JRadioButton("1º Série");
     serie2 = new JRadioButton("2º Série");
     serie3 = new JRadioButton("3º Série");
     txtnome = new JTextField(25);
     restr = new JTextArea(10,20);
     painelrolagem = new JScrollPane(restr);
     painelrolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     painel = new JPanel();
     painel.add(painelrolagem);
     
     grupocurso = new ButtonGroup();
      grupocurso.add(etim); //buttonGroup necessrio para que somente uma opcao seja marcada por vez
      grupocurso.add(mtec);
      grupocurso.add(tecnico);
      
     gruposerie = new ButtonGroup();
      gruposerie.add(serie1);
      gruposerie.add(serie2);
      gruposerie.add(serie3);
      
    limpar = new JButton("Limpar");
    apresentar = new JButton("Apresentar Dados");
    sair = new JButton("Fechar");
   
      // Formatação da matrícula
    try 
    {
       matricula = new MaskFormatter("#####"); // formatação apenas em números
       matricula.setPlaceholderCharacter('_');
    } 
    catch (ParseException excp) {}
       txtmatricula = new JFormattedTextField(matricula);
     
    
    //posicionamentos
    rotulo1.setBounds(30,50,100,20);
    rotulo2.setBounds(30,80,100,20);
    rotulo3.setBounds(30,120,200,20);
    rotulo4.setBounds(30,220,150,20);    
    texto.setBounds(180,20,200,20); 
    txtnome.setBounds(90,50,200,20);
    txtmatricula.setBounds(90,80,40,20);
    etim.setBounds(27,150,80,20);
    mtec.setBounds(27,170,80,20);
    tecnico.setBounds(27,190,80,20);
    serie1.setBounds(120,150,80,20);
    serie2.setBounds(120,170,80,20);
    serie3.setBounds(120,190,80,20);
    lista.setBounds(210,150,100,20);
    painel.setBounds(150,220,250,190);
    apresentar.setBounds(30,430,150,20);
    sair.setBounds(330,430,130,20);
    limpar.setBounds(190,430,130,20);
     
    //funcionalidade do botão limpar
     limpar.addActionListener(
     new ActionListener()
     {
     public void actionPerformed(ActionEvent e)//método 
     {
       txtnome.setText(null);
       txtmatricula.setText(null);
       restr.setText(null);
       grupocurso.clearSelection(); //chamada que desmarca a seleão do ButtonGroup
       gruposerie.clearSelection();
       lista.setSelectedIndex(0);
       txtnome.requestFocus();
    }}); 
    
  
    //funcionalidade do botão apresentar dados
     apresentar.addActionListener(
     new ActionListener()
     {
     public void actionPerformed(ActionEvent e)//método 
     {
       String cursoe="", seriee="";
    
       String nomee=txtnome.getText();
       String matrice=txtmatricula.getText();
       String restre=restr.getText();
    
       String perioe=lista.getSelectedItem().toString();//pegar item selecionado na lista
    
       if(serie1.isSelected())
       {
        seriee = serie1.getText();
       }
       else
       {
        if(serie2.isSelected())
       {
        seriee = serie2.getText();
       }
        else
       {
         if (serie3.isSelected())
         {
         seriee = serie3.getText();
         }
       }
    }
    
      if(etim.isSelected())
      {
       cursoe = etim.getText();
      }
      else
    {
      if(mtec.isSelected())
      {
         cursoe = mtec.getText();
      }
      else
      {
         if(tecnico.isSelected())
         {
         cursoe = tecnico.getText();
         }
      }
    }
    
    
    //enviar como parametro ao constutor do 2 formulario e analisar o preenchimento dos campos
    if (nomee.isEmpty() || matrice.isEmpty() || restre.isEmpty() || perioe.equals("Selecione") || seriee.isEmpty() || cursoe.isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
    } 
    else 
    {
      frmMostrar mostra = new frmMostrar(nomee, matrice, restre, perioe, cursoe, seriee);
      mostra.setVisible(true);
      dispose();
     }    
    }});
      
   //funcionalidade do botão sair 
   sair.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
    }});

     //atalhos
    limpar.setMnemonic(KeyEvent.VK_L);
    apresentar.setMnemonic(KeyEvent.VK_A);
    sair.setMnemonic(KeyEvent.VK_F);
    
 
      
    tela.add(rotulo1);
    tela.add(rotulo2);
    tela.add(rotulo3);
    tela.add(rotulo4);
    tela.add(texto);
    tela.add(txtnome);
    tela.add(txtmatricula);
    tela.add(etim);
    tela.add(mtec);
    tela.add(tecnico);
    tela.add(serie1);
    tela.add(serie2);
    tela.add(serie3);
    tela.add(lista);
    tela.add(painel);
    tela.add(apresentar);
    tela.add(sair);
    tela.add(limpar);
    setSize(530,510);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
}
   
    public static void main(String args[])
    {
    Principal app = new Principal();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
       
}