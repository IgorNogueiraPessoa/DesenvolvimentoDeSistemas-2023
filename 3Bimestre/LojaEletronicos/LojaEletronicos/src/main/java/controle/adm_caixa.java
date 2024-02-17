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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class adm_caixa extends JFrame {
    conexao con_clientes;
    
    int qtcompras, codigonota;
    ArrayList<Integer> itens = new ArrayList<Integer>();
    JLabel cod, total, codcli;
    JTextField txtcod,txtcodcli;
    JButton voltar, adicionar, nfiscal;
    ImageIcon imagem[];
    JTable tblClientes; 
    JScrollPane scp_tabela; 
    
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
    
    
    
    public adm_caixa(final int cargo){
        
        con_clientes = new conexao();
        con_clientes.conecta();
        
        setTitle("Caixa");
        ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo-caixa.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);
        
        cod = new JLabel("Digite o código do produto:");
        codcli = new JLabel("Digite o código do cliente:");
        total = new JLabel("Total da Compra: R$ 0.00",JLabel.RIGHT);
        txtcod = new JTextField(5);
        txtcodcli = new JTextField(5);
        adicionar = new JButton("Adicionar à compra");
        
        //icone do botão
        String icones[]={"src/imagens/back.png","src/imagens/gerarnota.png"};
        imagem = new ImageIcon[3];
        for(int i = 0;i<2;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        voltar = new JButton(imagem[0]);
        nfiscal = new JButton(imagem[1]);
        
        cod.setBounds(45,85,550,100);
        txtcod.setBounds(230,125,30,20);
        codcli.setBounds(45,35,550,100);
        txtcodcli.setBounds(230,75,30,20);
        adicionar.setBounds(45,165,160,20);
        voltar.setBounds(20,560,30,30);
        total.setBounds(310, 160, 290, 30);
        nfiscal.setBounds(500, 496,102,40);
        cod.setFont(new Font("Arial",Font.PLAIN,13));
        codcli.setFont(new Font("Arial",Font.BOLD,13));
        total.setFont(new Font("Arial",Font.BOLD,16));
        
        
        //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());                 
        
        //funcionalidade botao voltar
        voltar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        menu mostra = new menu(cargo);
        mostra.setVisible(true);
        dispose();
        }});
        
         //adicionar
      adicionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
            con_clientes.executaSQL("select * from produto where cod_pro = " + txtcod.getText());
            if (con_clientes.resultset.next()) {
                
                String resCod_pro =con_clientes.resultset.getString("cod_pro");
                String resPreco = con_clientes.resultset.getString("preco");
                int resEstoque =con_clientes.resultset.getInt("estoque");
                String resCodBar =con_clientes.resultset.getString("codbarras");
                String resNome =con_clientes.resultset.getString("nome_pro");
                
                if(resEstoque >= 1){
                    DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
                modelo.addRow(new Object[]{
                    
                    resCod_pro,
                    resPreco,
                    resEstoque,
                    resCodBar,
                    resNome
                    
                });
                
                itens.add(Integer.valueOf(txtcod.getText()));
                
                double totalcompra = calculartotal();
                total.setText(String.format("Total da Compra: R$ %.2f",totalcompra));
                
                int desconto = resEstoque - 1;
                con_clientes.statement.executeUpdate("update produto set estoque = " + desconto +" where cod_pro = " + con_clientes.resultset.getString("cod_pro"));
                
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parâmetro!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
        txtcod.setText(null);
        txtcod.requestFocus();
    }
});
      
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
        
        
        ////////////////////////botão nota fiscal//////////////////////////
        nfiscal.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
          String codclie = txtcodcli.getText();
          String codcargo = String.valueOf(cargo);
          LocalDate data_compra = LocalDate.now();
          DateTimeFormatter hr = DateTimeFormatter.ofPattern("HH:mm:ss");
          LocalDateTime hr_nf = LocalDateTime.now();
          String hr_compra = hr_nf.format(hr);
          
          Collections.sort(itens);
          
            System.out.println(data_compra+codcargo+codclie+hr_compra);
         
         ///////grava a nota fiscal//////   
          try
          {
           String insert_sql="insert into notafiscal (cod_cli,cod_func,dtcompra_nota, hr_nota) values ('" + codclie + "','" + codcargo + "','" + data_compra + "','" + hr_compra +"')";   
           con_clientes.statement.executeUpdate(insert_sql);

           
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "Erro na gravação!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
          
          
          ////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!precisa colaetar o cod_nota para colocar na tabela itens fiscal!!!!!!!!!!!!////////////////
          
            try {
            String insert_sql = "select cod_nota from notafiscal where cod_cli like '"+ codclie + "' and cod_func like '"+ codcargo + "' and dtcompra_nota like '"+data_compra+"' and hr_nota like '"+hr_compra+"'";           
            
            con_clientes.executaSQL(insert_sql);
            
            if (con_clientes.resultset.next()) {
            codigonota = con_clientes.resultset.getInt("cod_nota");
            System.out.println(codigonota);

         } else {
           System.out.println("A consulta não retornou resultados.");
        }
            
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
          
          
          ///////grava o itens fiscal (quantidade e etc)////////
          try
          {
              
              int ultimo = -1;
              int n = 1;
              
              System.out.println(itens);
              
            for(int produto : itens){
                
                System.out.println(produto);
                
                String insert_sql;
                
                if(ultimo == produto){
                    n++;
                    insert_sql="UPDATE itensnfiscal SET qtcompra='"+ n +"' WHERE cod_nota='"+codigonota+"' and cod_pro='"+produto+"'";
                    con_clientes.statement.executeUpdate(insert_sql);
                }else{
                    n = 1;
                    insert_sql="insert into itensnfiscal (cod_nota,cod_pro,qtcompra) values ('" + codigonota + "','" + produto + "','"+n+"')";                    
                    con_clientes.statement.executeUpdate(insert_sql);
                }
                System.out.println(insert_sql);
                ultimo = produto; 

            }
           
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "Erro na gravação!" + errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
            frm_notaf mostra = new frm_notaf(cargo, codigonota);
            mostra.setVisible(true);
        }});
        
        
        backgroundPanel.add(voltar);
        backgroundPanel.add(cod);
        backgroundPanel.add(txtcod);
        backgroundPanel.add(codcli);
        backgroundPanel.add(txtcodcli);
        backgroundPanel.add(adicionar);
        backgroundPanel.add(nfiscal);
        
        backgroundPanel.add(total);
         
        setSize(670,650);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        preencherTabela();   
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
       
    }
    public double calculartotal() {
    DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
    double total = 0;
    for (int i = 0; i < modelo.getRowCount(); i++) {
        total += Double.parseDouble(modelo.getValueAt(i, 1).toString());
        qtcompras=i;
    }
    return total;
}
}