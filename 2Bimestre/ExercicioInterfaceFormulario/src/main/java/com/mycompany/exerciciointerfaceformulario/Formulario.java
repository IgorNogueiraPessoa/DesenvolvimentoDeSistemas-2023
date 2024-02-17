package com.mycompany.exerciciointerfaceformulario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Formulario extends JFrame
{
    JLabel rotulo1, rotulo2, rotulo3, rotulo4,rotulo5,texto;
    JTextField camponome,campoidade;
    JCheckBox automoveis,barcos,avioes;
    JRadioButton masc,fem;
    ButtonGroup grupo;
    String estadoc[] = {"Solteiro(a)","Casado(a)","Separado(a)","Divorciado(a)","Viúvo(a)"};
    JComboBox lista;
    JButton limpar,enviar;
    
    public Formulario()
    { //declarando os valores
    super("Exercício Lista 9 - Formulário");   
    Container tela = getContentPane();
    setLayout(null);
    rotulo1 = new JLabel("Nome:");
    rotulo2 = new JLabel("Idade:");
    rotulo3 = new JLabel("Sexo:");
    rotulo4 = new JLabel("Interesses:");
    rotulo5 = new JLabel("Estado Civil");
    texto = new JLabel("Igor Nogueira - 2ºDS/AMS");
    lista = new JComboBox(estadoc);
    lista.setMaximumRowCount(5);
    automoveis = new JCheckBox("Automóveis");
    barcos = new JCheckBox("Barcos");
    avioes = new JCheckBox("Aviões");
    masc = new JRadioButton("Masculino");
    fem = new JRadioButton("Feminino");
    limpar = new JButton("Limpar os dados");
    enviar = new JButton("Enviar os dados");
    camponome = new JTextField(25);
    campoidade = new JTextField(2);
    grupo= new ButtonGroup();
    grupo.add(fem); //buttonGroup necessrio para que somente uma opcao seja marcada por vez
    grupo.add(masc);
    
    //posicionamentos
    rotulo1.setBounds(50,20,100,20);
    rotulo2.setBounds(50,50,100,20);
    rotulo3.setBounds(50,90,100,20);
    rotulo4.setBounds(50,120,100,20);
    rotulo5.setBounds(50,208,100,20);
    camponome.setBounds(120,20,100,20);
    campoidade.setBounds(120,50,100,20);
    texto.setBounds(360,280,200,20); 
    masc.setBounds(90,90,100,20);
    fem.setBounds(190,90,100,20);
    automoveis.setBounds(50,140,100,20);
    barcos.setBounds(50,160,100,20);
    avioes.setBounds(50,180,100,20);
    lista.setBounds(120,208,100,20);
    limpar.setBounds(50,260,130,20);
    enviar.setBounds(180,260,130,20);
    
    //funcionalidade do botão limpar
     limpar.addActionListener(
     new ActionListener()
     {
     public void actionPerformed(ActionEvent e)//método 
     {
       camponome.setText(null);
       campoidade.setText(null);
       automoveis.setSelected(false);
       barcos.setSelected(false);
       avioes.setSelected(false);
       grupo.clearSelection(); //chamada que desmarca a seleão do ButtonGroup
       lista.setSelectedIndex(-1);
       camponome.requestFocus();
    }});
     
    //funcionalidade do botão enviar dados
    enviar.addActionListener(
    new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
        //verificando valores selecionados para exibir na mensagem
        String sexo = "";
        if(masc.isSelected())
        {
        sexo = "Masculino";
        }
        else if(fem.isSelected())
        {
        sexo = "Feminino";
        }
        String interesses = "";
        if (automoveis.isSelected()) 
        {
            interesses += "Automóveis ";
        }
        if (barcos.isSelected()) 
        {
            interesses += "Barcos ";
        }
        if (avioes.isSelected()) 
        {
            interesses += "Aviões ";
        }
    JOptionPane.showMessageDialog(null, "Nome: " + camponome.getText() + "\nIdade: " + campoidade.getText() + "\nSexo: " + sexo + "\nInteresse: " + interesses +"\nEstado Civil: " + lista.getSelectedItem().toString() +"\nAinda não sei enviar esses dados para lugar nenhum. Tente novamente no próximo bimestre!");
    }});
    
    //atalhos
    limpar.setMnemonic(KeyEvent.VK_L);
    enviar.setMnemonic(KeyEvent.VK_E);
  
     //adicionando todos os elementos na tela
     tela.add(rotulo1);
     tela.add(rotulo2);
     tela.add(rotulo3);
     tela.add(rotulo4);
     tela.add(rotulo5);
     tela.add(texto);  
     tela.add(campoidade);
     tela.add(camponome);
     tela.add(automoveis);
     tela.add(barcos);
     tela.add(avioes);
     tela.add(masc);
     tela.add(fem);
     tela.add(lista);
     tela.add(enviar);
     tela.add(limpar);
     setSize(530,350);
     setLocationRelativeTo(null);
     setResizable(false);
     setVisible(true);
    }
    
    public static void main(String args[])
    {
    Formulario app = new Formulario();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
     
}
