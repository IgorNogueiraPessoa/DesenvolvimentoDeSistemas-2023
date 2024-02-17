package com.mycompany.exercicio_cinco;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class exercicio_cinco {
    public static void main (String[] args)
    {
      double alt, base, res;     
     alt=Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo."));
     base=Double.parseDouble(JOptionPane.showInputDialog("Digite a base do triângulo"));
     res=hipotenusa(alt,base);
     DecimalFormat df = new DecimalFormat("#.##");
     JOptionPane.showMessageDialog(null,"O valor da hipotenusa é: "+df.format(res));
    }
    
    static double hipotenusa(double altu, double base_)
    {
    float result = (float) Math.sqrt(altu*altu + base_*base_);  
    return result;
    }
}
