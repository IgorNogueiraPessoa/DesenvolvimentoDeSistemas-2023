    package controle;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; //reconhecer a jtable
import conexao.conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.table.TableCellRenderer;

 
public class adm_prod extends JFrame
{
    conexao con_cliente;
    
    JLabel rCodigo, rNome, rEmail, rTel, rData, rPesquisa,rNavegacao;
    JTextField tcodigo, tpreco, tnomepro, tpesquisa, tcodbar, testoque;
    JButton prim,anterior,prox,ultimo, novoreg,gravar,alterar,excluir,pesquisar, sair, retornar, voltar;
    ImageIcon imagem[];
    
    JTable tblClientes; //testoquegrid
    JScrollPane scp_tabela; //container para o testoquegrid

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
    
    public adm_prod(final int cargo)
    {
        con_cliente = new conexao(); //inicializacao do objeto
        con_cliente.conecta(); //chama o metodo que conecta
        
        setTitle("Tela Cadastro de Produto");
         //icone da janela
         ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());
        
         ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo7.png");
         setContentPane(backgroundPanel);
         backgroundPanel.setLayout(null);
         setResizable(false);
        
        rCodigo = new JLabel("Codigo: ");
        rNome = new JLabel("Preço: ");
        rEmail = new JLabel("Estoque: ");
        rTel = new JLabel ("Cod. Barras: ");
        rData = new JLabel ("Nome: ");
        rPesquisa = new JLabel ("Pesquisar pelo nome do produto: ");
        rNavegacao = new JLabel ("Botões de navegação:");
        tcodigo = new JTextField(5);
        tpreco = new JTextField(5);
        testoque = new JTextField(5);
        tcodbar = new JTextField(5);
        tnomepro = new JTextField(5);
        
        tpesquisa = new JTextField(5);
        prim = new JButton("Primeiro");
        ultimo = new JButton("Último");
        
        //icones dos botões
        String icones[]={"src/imagens/search.png","src/imagens/write.png","src/imagens/delete.png","src/imagens/alter.png","src/imagens/new.png","src/imagens/next.png","src/imagens/previous.png","src/imagens/exit.png","src/imagens/return.png","src/imagens/back.png"};
        imagem = new ImageIcon[10];
        for(int i = 0;i<10;i++)
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
        rCodigo.setBounds(50,40,100,20);
        rNome.setBounds(50,80,100,20);
        rEmail.setBounds(50,120,100,20);
        rTel.setBounds(50,160,100,20);
        rData.setBounds(50,40,200,20);
        rPesquisa.setBounds(50,380,550,200);
        rNavegacao.setBounds(485,-5,550,100);
        
        //posicao das caixas de texto e botoes
        tcodigo.setBounds(150,40,30,20);
        tpreco.setBounds(150,80,80,20);
        testoque.setBounds(150,120,90,20);
        tcodbar.setBounds(150,160,90,20);
        tnomepro.setBounds(150,40,180,20);
        prox.setBounds(568,140,30,30);
        anterior.setBounds(513,140,30,30);
        prim.setBounds(513,180,85,20);
        ultimo.setBounds(513,210,85,20);
        novoreg.setBounds(513,60,30,30);
        gravar.setBounds(568,60,30,30);
        alterar.setBounds(513,100,30,30);
        excluir.setBounds(568,100,30,30);
        tpesquisa.setBounds(250,470,250,21);
        pesquisar.setBounds(505,470,30,20);
        sair.setBounds(130,510,30,30);
        retornar.setBounds(50,510,30,30);
        voltar.setBounds(90,510,30,30);
       
        
        //estilizando fundo,fonte
        backgroundPanel.setBackground(new Color(176,196,222));
        rCodigo.setFont(new Font("Calibri",Font.BOLD,16));
        rNome.setFont(new Font("Calibri",Font.BOLD,16));
        rEmail.setFont(new Font("Calibri",Font.BOLD,16));
        rTel.setFont(new Font("Calibri",Font.BOLD,16));
        rData.setFont(new Font("Calibri",Font.BOLD,16));
        rPesquisa.setFont(new Font("Calibri",Font.BOLD,14));
        rNavegacao.setFont(new Font("Calibri",Font.BOLD,16));
        
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
          tcodigo.setText("");
          tpreco.setText("");
          tnomepro.setText("");
          tcodbar.setText("");
          testoque.setText("");
          tpreco.requestFocus();
         }});
    
        //gravar
        gravar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String preco = tpreco.getText();
          String nomepro = tnomepro.getText();
          String codbar = tcodbar.getText();
          String estoque = testoque.getText();
          
          try
          {
           String insert_sql="insert into produto (preco,estoque,codbarras,nome_pro) values ('" + preco + "','" + estoque + "','" + codbar + "','" + nomepro + "')";   
           con_cliente.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
           
           con_cliente.executaSQL("select * from produto order by cod_pro");
           preencherTabela();
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "Erro ao gravar conteúdo: "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //alterar
        alterar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String preco = tpreco.getText();
          String nome = tnomepro.getText();
          String codbar = tcodbar.getText();
          String estoque = testoque.getText();
          String sql;
          String msg="";
          try
          {
            if(tcodigo.getText().equals("")){
               sql="insert into produto (preco,estoque,codbarras,nome_pro) values ('" + preco + "','" + estoque + "','" + codbar + "','" + nome + "')"; 
               msg="Gravação de um novo registro";
            }else{
                sql="update produto set preco='" + preco + "',estoque='" + estoque + "',codbarras='" + codbar + "',nome_pro='" + nome + "'where cod_pro =" + tcodigo.getText();  
                msg="Alteração de registro";
            }
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select *from produto order by cod_pro");
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
            sql = "delete from produto where cod_pro = " + tcodigo.getText();
            int excluir = con_cliente.statement.executeUpdate(sql);
            if (excluir==1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.executaSQL("select * from produto order by cod_pro");
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
             String pesquisa = "select * from produto where nome_pro like '" + tpesquisa.getText() + "%'";
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
        
        //sair
        voltar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        menu mostra = new menu(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
        retornar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        frm_login mostra = new frm_login();
        mostra.setVisible(true);
        dispose();
        }});
        
        /////////////////////////configuração da jtable/////////////////////////
        tblClientes = new javax.swing.JTable(){
         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) { //alterar cor das linhas
         Component c = super.prepareRenderer(renderer, row, column);
         if (!isRowSelected(row)){
            c.setBackground(row % 2 == 0 ? Color.WHITE : (new Color(220,220,220)));
        }
        return c;
         }}; //fim da alteração da cor das linhas

        scp_tabela = new javax.swing.JScrollPane();
        
        tblClientes.setBounds(50,260,650,200);
        scp_tabela.setBounds(50,260,550,200);
        
        backgroundPanel.add(tblClientes);
        backgroundPanel.add(scp_tabela);
        
        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        tblClientes.setFont(new java.awt.Font("Arial",1,12));
        
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][]{
         {null, null, null, null, null},
         {null, null, null, null, null},
         {null, null, null, null, null},
         {null, null, null, null, null}},
         
         new String[] {"Código", "Preço", "Estoque", "Cod. Barras", "Nome"})
        {
         boolean[] canEdit = new boolean []{false, false, false, false, false};
         
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];}
        
        });
        
        
        scp_tabela.setViewportView(tblClientes);
        tblClientes.setAutoCreateRowSorter(true);//ativa classificacao ordenada da tabela 
        
        
        /////////////////////////fim da config da jtable/////////////////////////
        
        backgroundPanel.add(rNavegacao);
        backgroundPanel.add(rNome);
        backgroundPanel.add(rEmail);
        backgroundPanel.add(rTel);
        backgroundPanel.add(rData);
        backgroundPanel.add(tpreco);
        backgroundPanel.add(testoque);
        backgroundPanel.add(tnomepro);
        backgroundPanel.add(tcodbar);
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
        backgroundPanel.add(retornar);
        backgroundPanel.add(voltar);
        
        setSize(700,600);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from produto order by cod_pro");
        preencherTabela();   
        posicionarRegistro();
    } 
    
    public void preencherTabela() //metodo para popular as caixas da tabela
    {
       tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
       tblClientes.getColumnModel().getColumn(1).setPreferredWidth(170);
       tblClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
       tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
       tblClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
       
       DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
       modelo.setNumRows(0);
       
       try
       {
         con_cliente.resultset.beforeFirst();
         while(con_cliente.resultset.next())
         {
           modelo.addRow(new Object[]{
               con_cliente.resultset.getString("cod_pro"),con_cliente.resultset.getString("preco"),con_cliente.resultset.getString("estoque"),con_cliente.resultset.getString("codbarras"),con_cliente.resultset.getString("nome_pro")
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
        tcodigo.setText(con_cliente.resultset.getString("cod_pro")); //associar a caixa de texto ao campo cod
        tpreco.setText(con_cliente.resultset.getString("preco")); //associar a caixa de texto ao campo nome
        testoque.setText(con_cliente.resultset.getString("estoque"));
        tcodbar.setText(con_cliente.resultset.getString("codbarras"));
        tnomepro.setText(con_cliente.resultset.getString("nome_pro"));
       }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
} 


