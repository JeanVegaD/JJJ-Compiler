/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.semantico;

/**
 *
 * @author Jean
 */
public class ln {
    private String l;
    private String valor ;
    
    public ln(String l,String valor){
        this.valor=valor;
        this.l=l;
    }
    
    
    public void imprimir(){
        System.out.println(l + "="+ valor);
    }
    
    
}
