package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel; //reconhecer a jtable
import conexao.conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.table.TableCellRenderer;

 
public class menu extends JFrame
{
    conexao con_cliente;
    
    JLabel rNum, rNome, rEspecie, rRaca, rCor, rData, rSexo, rPesquisa;
    JTextField tnum, tnome, tespecie, traca,tcor,tsexo,tpesquisa;
    JFormattedTextField data;
    MaskFormatter mData;
    JButton prim,anterior,prox,ultimo, novoreg,gravar,alterar,excluir,pesquisar, sair, retornar, voltar;
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
    
    JTable tbldadoscliente; //datagrid
    JScrollPane scp_tabela; //container para o datagrid

    public menu()
    {
        con_cliente = new conexao(); //inicializacao do objeto
        con_cliente.conecta(); //chama o metodo que conecta
       
         setTitle("Gerenciamento dos Pets");
         ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo3.png");
         setContentPane(backgroundPanel);
         backgroundPanel.setLayout(null);
         setResizable(false);
        
        rNum = new JLabel("Número de Registro: ");
        rNome = new JLabel("Nome do pet: ");
        rEspecie = new JLabel("Espécie: ");
        rRaca = new JLabel ("Raça: ");
        rData = new JLabel ("Data de nascimento: ");
        rCor = new JLabel("Cor predominante:");
        rSexo = new JLabel ("Sexo: ");
        rPesquisa = new JLabel ("Pesquisar pela espécie do pet: ");
        tnum = new JTextField(5);
        tnome = new JTextField(5);
        tespecie = new JTextField(5);
        traca = new JTextField(5);
        tcor = new JTextField(5);
        tsexo = new JTextField(5);
        tpesquisa = new JTextField(5);
         //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());   
       
        //mascara dos campos telefone e data
        try
        {
        mData = new MaskFormatter("##/##/####");
        }
        catch(ParseException excp){}
        data = new JFormattedTextField(mData);
        
        //icones dos botões
        String icones[]={"src/imagens/search.png","src/imagens/write.png","src/imagens/delete.png","src/imagens/alter.png","src/imagens/new.png","src/imagens/next.png","src/imagens/previous.png","src/imagens/exit.png","src/imagens/return.png","src/imagens/back.png","src/imagens/first.png","src/imagens/last.png"};
        imagem = new ImageIcon[13];
        for(int i = 0;i<12;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        pesquisar = new JButton(imagem[0]);
        gravar = new JButton(imagem[1]);
        excluir = new JButton(imagem[2]);
        alterar = new JButton(imagem[3]);
        novoreg = new JButton(imagem[4]);
        prox = new JButton(imagem[5]);
        anterior = new JButton(imagem[6]);
        sair = new JButton(imagem[7]); 
        retornar = new JButton(imagem[8]);
        voltar = new JButton(imagem[9]);
        prim = new JButton(imagem[10]);
        ultimo = new JButton(imagem[11]);
        
        alterar.setToolTipText("Alterar registro já realizado");
        gravar.setToolTipText("Gravar dados digitados");
        excluir.setToolTipText("Excluir registro");
        novoreg.setToolTipText("Limpar textos para realizar novo registro");
        prox.setToolTipText("Próximo registro");
        anterior.setToolTipText("Registro anterior");
        prim.setToolTipText("Primeiro registro");
        ultimo.setToolTipText("Ultimo registro");
        sair.setToolTipText("Sair do programa");
        retornar.setToolTipText("Retornar para tela de cadastro");
        voltar.setToolTipText("Retornar para tela principal");
        
        //posicoes dos rotulos
        rNum.setBounds(50,40,100,20);
        rNome.setBounds(50,90,100,20);
        rEspecie.setBounds(355,90,100,20);
        rRaca.setBounds(560,90,100,20);
        rData.setBounds(50,140,150,20);
        rCor.setBounds(270,140,150,20);
        rSexo.setBounds(510,140,150,20);
        rPesquisa.setBounds(80,460,550,200);
        
        //posicao das caixas de texto e botoes
        tnum.setBounds(150,40,30,20);
        tnome.setBounds(135,90,180,20);
        tespecie.setBounds(410,90,100,20);
        traca.setBounds(600,90,93,20);
        data.setBounds(175,140,70,20);
        tcor.setBounds(385,140,90,20);
        tsexo.setBounds(550,140,70,20);
        prox.setBounds(100,220,40,40);
        anterior.setBounds(50,220,40,40);
        prim.setBounds(150,220,40,40);
        ultimo.setBounds(200,220,40,40);
        novoreg.setBounds(513,220,40,40);
        gravar.setBounds(563,220,40,40);
        alterar.setBounds(613,220,40,40);
        excluir.setBounds(663,220,40,40);
        tpesquisa.setBounds(265,550,250,21);
        pesquisar.setBounds(520,550,30,21);
        sair.setBounds(663,540,40,40);
        
        //estilizando fundo,fonte
        rNum.setFont(new Font("Calibri",Font.BOLD,14));
        rNome.setFont(new Font("Calibri",Font.BOLD,14));
        rEspecie.setFont(new Font("Calibri",Font.BOLD,14));
        rRaca.setFont(new Font("Calibri",Font.BOLD,14));
        rData.setFont(new Font("Calibri",Font.BOLD,14));
        rCor.setFont(new Font("Calibri",Font.BOLD,14));
        rSexo.setFont(new Font("Calibri",Font.BOLD,14));
        rPesquisa.setFont(new Font("Calibri",Font.BOLD,14));
        
        rNum.setForeground(Color.white);
        rNome.setForeground(Color.white);
        rEspecie.setForeground(Color.white);
        rRaca.setForeground(Color.white);
        rData.setForeground(Color.white);
        rCor.setForeground(Color.white);
        rSexo.setForeground(Color.white);
        rPesquisa.setForeground(Color.white);
        
        //funcionalidades dos butoes
        //sair
        sair.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
        }});
          
        //proximo
        prox.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
          if(con_cliente.resultset.isLast())
          {
              JOptionPane.showMessageDialog(null, "Não existem registros depois do último! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          }
          else{
         con_cliente.resultset.next();
         mostrar_Dados();
        }}catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //anterior
        anterior.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
          if(con_cliente.resultset.isFirst())
          {
               JOptionPane.showMessageDialog(null, "Não existem registros antes do primeiro registro! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          }
          else{
         con_cliente.resultset.previous();
         mostrar_Dados();
          }}catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //primeiro
        prim.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
         con_cliente.resultset.first();
         mostrar_Dados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //ultimo
        ultimo.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
         con_cliente.resultset.last();
         mostrar_Dados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //novo registro
        novoreg.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          tnum.setText("");
          tnome.setText("");
          tespecie.setText("");
          traca.setText("");
          data.setText("");
          tcor.setText("");
          tsexo.setText("");
          tnome.requestFocus();
         }});
    
        //gravar
        gravar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String nome = tnome.getText();
          String especie = tespecie.getText();
          String raca = traca.getText();
          String nasc = data.getText();
          String cor = tcor.getText();
          String sexo = tsexo.getText();
          
          try
          {
           String insert_sql="insert into pet (nome_pet,especie,raca,cor_predo,pet_nasc,sexo) values ('" + nome + "','" + especie + "','" + raca + "','" + cor + "','" + nasc + "','" + sexo + "')";   
           con_cliente.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
           
           con_cliente.executaSQL("select * from pet order by num_registro");
           preencherTabela();
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "Erro na gravação!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //alterar
        alterar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String nome = tnome.getText();
          String especie = tespecie.getText();
          String raca = traca.getText();
          String nasc = data.getText();
          String cor = tcor.getText();
          String sexo = tsexo.getText();
          String sql;
          String msg="";
          try
          {
            if(tnum.getText().equals("")){
               sql="insert into pet (nome_pet,especie,raca,cor_predo,pet_nasc,sexo) values ('" + nome + "','" + especie + "','" + raca + "','" + cor + "','" + nasc + "','" + sexo + "')";  
               msg="Gravação de um novo registro";
            }else{
                sql="update pet set nome_pet='" + nome + "',especie='" + especie + "',raca='" + raca + "',cor_predo='" + cor + "',pet_nasc='" + nasc+ "',sexo='"+ sexo +"'where num_registro =" + tnum.getText();  
                msg="Alteração de registro";
            }
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select *from pet order by num_registro");
            preencherTabela();
              
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //excluir
        excluir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String sql="";
          try
          {
           int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
           if (resposta==0){
            sql = "delete from pet where num_registro = " + tnum.getText();
            int excluir = con_cliente.statement.executeUpdate(sql);
            if (excluir==1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.executaSQL("select * from pet order by num_registro");
                con_cliente.resultset.first();
                preencherTabela();
                posicionarRegistro();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            }
               
           }}catch (SQLException excecao){
               JOptionPane.showMessageDialog(null, "Erro na exclusão: "+excecao,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);    
           }
          }});
        
        //pesquisar 
        pesquisar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          try{
             String pesquisa = "select * from pet where especie like '" + tpesquisa.getText() + "%'";
             con_cliente.executaSQL(pesquisa);
             
             if(con_cliente.resultset.first()){
                 preencherTabela();
             }
             else{
               JOptionPane.showMessageDialog(null,"\n Não existe dados com este parâmetro!","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
             }
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }  
           
          }});
        
        
        /////////////////////////configuração da jtable/////////////////////////
        tbldadoscliente = new javax.swing.JTable(){
         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) { //alterar cor das linhas
         Component c = super.prepareRenderer(renderer, row, column);
         if (!isRowSelected(row)){
            c.setBackground(row % 2 == 0 ? Color.WHITE : (new Color(220,220,220)));
        }
        return c;
         }}; //fim da alteração da cor das linhas

        scp_tabela = new javax.swing.JScrollPane();
        
        tbldadoscliente.setBounds(50,310,650,200);
        scp_tabela.setBounds(50,310,650,200);
        
        backgroundPanel.add(tbldadoscliente);
        backgroundPanel.add(scp_tabela);
        
        tbldadoscliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        tbldadoscliente.setFont(new java.awt.Font("Arial",1,12));
        
        tbldadoscliente.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][]{
         {null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null}},
         
         new String[] {"N°", "Nome", "Espécie", "Raça", "Cor", "Nascimento", "Sexo"})
        {
         boolean[] canEdit = new boolean []{false, false, false, false, false,false,false};
         
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];}
        
        });
        
        
        scp_tabela.setViewportView(tbldadoscliente);
        tbldadoscliente.setAutoCreateRowSorter(true);//ativa classificacao ordenada da tabela 
        
        
        /////////////////////////fim da config da jtable/////////////////////////
        
        backgroundPanel.add(rNome);
        backgroundPanel.add(rEspecie);
        backgroundPanel.add(rRaca);
        backgroundPanel.add(rCor);
        backgroundPanel.add(rData);
        backgroundPanel.add(rSexo);
        backgroundPanel.add(tnome);
        backgroundPanel.add(tespecie);
        backgroundPanel.add(traca);
        backgroundPanel.add(tcor);
        backgroundPanel.add(tsexo);
        backgroundPanel.add(data);
        backgroundPanel.add(prim);
        backgroundPanel.add(prox);
        backgroundPanel.add(ultimo);
        backgroundPanel.add(anterior);
        backgroundPanel.add(novoreg);
        backgroundPanel.add(gravar);
        backgroundPanel.add(excluir);
        backgroundPanel.add(alterar);
        backgroundPanel.add(rPesquisa);
        backgroundPanel.add(tpesquisa);
        backgroundPanel.add(pesquisar);
        backgroundPanel.add(sair);
        
        setSize(780,640);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from pet order by num_registro");
        preencherTabela();   
        posicionarRegistro();
    } 
    
    public void preencherTabela() //metodo para popular as caixas da tabela
    {
       tbldadoscliente.getColumnModel().getColumn(0).setPreferredWidth(50);
       tbldadoscliente.getColumnModel().getColumn(1).setPreferredWidth(170);
       tbldadoscliente.getColumnModel().getColumn(2).setPreferredWidth(80);
       tbldadoscliente.getColumnModel().getColumn(3).setPreferredWidth(100);
       tbldadoscliente.getColumnModel().getColumn(4).setPreferredWidth(150);
       tbldadoscliente.getColumnModel().getColumn(5).setPreferredWidth(150);
       tbldadoscliente.getColumnModel().getColumn(6).setPreferredWidth(150);
       
       DefaultTableModel modelo = (DefaultTableModel) tbldadoscliente.getModel();
       modelo.setNumRows(0);
       
       try
       {
         con_cliente.resultset.beforeFirst();
         while(con_cliente.resultset.next())
         {
           modelo.addRow(new Object[]{
               con_cliente.resultset.getString("num_registro"),con_cliente.resultset.getString("nome_pet"),con_cliente.resultset.getString("especie"),con_cliente.resultset.getString("raca"),con_cliente.resultset.getString("cor_predo"),con_cliente.resultset.getString("pet_nasc"),con_cliente.resultset.getString("sexo")
           });
         }
       }catch(SQLException erro)
       {
         JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!: \n"+erro,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
    public void posicionarRegistro()
    {
      try
      {
       con_cliente.resultset.first(); //posiciona no 1 registro da tabela
       mostrar_Dados(); //chama o metodo que ira buscar o dado da tabela
      }catch(SQLException erro){
       JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
      }
    }
    
    public void mostrar_Dados()
    {
       try
       {
        tnum.setText(con_cliente.resultset.getString("num_registro")); //associar a caixa de texto ao campo cod
        tnome.setText(con_cliente.resultset.getString("nome_pet")); //associar a caixa de texto ao campo nome
        tespecie.setText(con_cliente.resultset.getString("especie"));
        traca.setText(con_cliente.resultset.getString("raca"));
        tcor.setText(con_cliente.resultset.getString("cor_predo"));
        data.setText(con_cliente.resultset.getString("pet_nasc"));
        tsexo.setText(con_cliente.resultset.getString("sexo"));
       }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
     public static void main (String args[])
    {
    menu app = new menu();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
} 
