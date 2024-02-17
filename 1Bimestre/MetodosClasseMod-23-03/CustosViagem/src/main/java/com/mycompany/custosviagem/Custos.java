
package com.mycompany.custosviagem;

import javax.swing.JOptionPane;


public class Custos {
    private double totalPercurso;
            
     public Custos(){
     this(0);
    }
     
    public Custos (double totalPercurso){
    this.totalPercurso = totalPercurso;
    }
    
    //get e set

    public double getTotalPercurso() {
        return totalPercurso;
    }

    public void setTotalPercurso(double totalPercurso) {
        this.totalPercurso = totalPercurso;
    }
    
    //métodos específicos
    public void calcularViagem(Percurso p){ //recebendo parametro classe
       this.setTotalPercurso((p.getKmPercorrido()*p.getValorCombustivel())+p.getValorPedagio());//setando a operação para o calculo do custo da viagem no total percurso
       JOptionPane.showMessageDialog(null,"Custo total da viagem: "+this.getTotalPercurso());
    }

      
}
