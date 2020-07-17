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
public class cuadruplos {
    private String tn;
    private String left;
    private String op;
    private String right;
    private String labelPadre;
    
    public cuadruplos (String tn, String left, String op, String right, String labelPadre){
        this.tn=tn;
        this.left=left;
        this.op=op;
        this.right=right;
        this.labelPadre=labelPadre;
    }
    
    public cuadruplos(String tn,String left,String labelPadre){
        this.tn=tn;
        this.left=left;
        this.op=null;
        this.right=null;
        this.labelPadre=labelPadre;
    }

    public String getTn() {
        return tn;
    }

    public String getLeft() {
        return left;
    }

    public String getOp() {
        return op;
    }

    public String getRight() {
        return right;
    }

    public String getLabelPadre() {
        return labelPadre;
    }

    public String getLine(){
        return tn + " = " + left; 
    }
    
    
    
           
}
