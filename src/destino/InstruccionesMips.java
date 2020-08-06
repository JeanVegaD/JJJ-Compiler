/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import java.util.ArrayList;

/**
 *
 * @author cano98
 */
public class InstruccionesMips {
    
    private int rc = 0;
    private ArrayList<Elemento> registros = new ArrayList<Elemento>();
    private ArrayList<Elemento> stack = new ArrayList<Elemento>();
    
    private boolean mul = false;
    private boolean div = false;
    private int ultimoRA = 0;
    
    public InstruccionesMips(){

    }
    
    public String getCall(String line){
        String[] arr = line.split(" ", 0);
        String instruccionMips = "jal "+arr[3] + "\n";      
        return instruccionMips;
    }
    
    public String getRASave(){
        String instruccionMips = "";
        instruccionMips = construirSave();        
        return instruccionMips;
    }
    
    private void eliminarScope(){
        stack.subList(ultimoRA, stack.size()-1).clear();
        int i = 0;
        for(i = stack.size()-1; stack.get(i).identificador.equals("ra"); i--){
            ultimoRA = stack.get(i).pos;
        }
    }
    
    public String getRetorno(){
        String mips = "";
        mips = construirRetorno();
        eliminarScope();
        return mips;
    }
    
    private String construirRetorno(){
        String mips = "";
        mips += "addi $sp, $sp, " + String.valueOf(stack.size()*4 - ultimoRA*4) +"\n";
        mips += "lw $s0, 0($sp)\n";
        mips += "move $ra, $s0\n";
        mips += "jr $ra\n";
        return mips;
    }
    
    
    public String getHeader(){
        String mips = "";
        mips += ".data\n\n";
        mips += ".text\n\n";
        mips += ".globl main\n\n";
        return mips;
    }
    
    private String construirSave(){
        String mips = "";
        mips += "sub $sp, $sp, 4\n";
        mips += "sw $ra, 0($sp)\n";
        Elemento ra = new Elemento();
        ra.identificador = "ra";
        ra.pos = stack.size();
        stack.add(ra);
        ultimoRA = ra.pos;
        return mips;
    }
    
    public String getPop(String line){
        String instruccionMips = "";
        instruccionMips = construirPop(line);
        return instruccionMips;
    }
    
    private String construirPop(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "lw " + guardarRegistro(arr[0]) + ", " + String.valueOf(stack.size()*4 - getVariable(arr[2]).pos*4) + "(sp) \n";
        return mips;
    }
    
    private Elemento getVariable(String id){
        Elemento variable = new Elemento();
        for( Elemento e : stack){
            if(e.identificador.equals(id)){
                return e;
            }
        }
        return variable;
    }
    
    //Genera una declaracion en mips a partir del 3d
    public String getDeclaracion(String line){
        String instruccionMips = "";
        instruccionMips = construirDeclaracion(line); 
        return instruccionMips;
    }
    
    //Esto es un push en la pila
    public String construirDeclaracion(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        Elemento ne = new Elemento();
        ne.identificador = arr[0];  //Identificador del elemento en la pila
        ne.arg1 = arr[2];           //valor a asignar
        ne.pos = stack.size();      //Posicion del elemento en la pila
        stack.add(ne);
        
        mips += "#Declaracion de variable " + arr[0] +" Stack position " +String.valueOf(stack.size()) +  "\n";
        mips += "sub $sp, $sp, 4 \n";
        if(mul || div){
            mips += "mflo $s0\n";
            mips += "sw $s0, 0($sp) \n\n";
            if(mul)mul=false;
            if(div)div=false;
        }
        else{
            mips += "sw " + getRegistro(arr[2]) + ", 0($sp) \n\n";
        }
        resetRegistros();
        return mips;
    }
    
    public void resetRegistros(){
        registros = new ArrayList<Elemento>();
        rc = 0;
    }
    
    //Este metodo es para construir una instruccion mips a partir de el 3d
    public String getInstruccion(String line){
        String instruccionMips = "";
        instruccionMips = construirInstruccion(line); 
        return instruccionMips;
    }
    
    
    private String construirInstruccion(String line){
        String tipo = "";
        String[] arr = line.split(" ", 0);
        if(arr.length > 3){
            tipo = seleccionarPorOperacion(line);
        }
        else{
            tipo = seleccionarPorValor(line);
        }
        return tipo;
    }
    
    //Construlle una instruccion del tipo cuaduple dependiendo de la operacion realizada
    private String seleccionarPorOperacion(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        String op = arr[3];
        if(op.equals("+")){
            mips = "add "+ guardarRegistro(arr[0]) + ", " +  getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            return mips;
        }
        if(op.equals("-")){
            mips = "sub "+ guardarRegistro(arr[0]) + ", " + getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            return mips;
        }
        if(op.equals("*")){
            mips = "mul "+ getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            mul = true;
            return mips;
        }
        if(op.equals("/")){
            mips = "div "+ getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            div = true;
            return mips;
        }
        return mips;
    }
    
    //Construlle una instruccion dependiendo si es una declaracion o 
    private String seleccionarPorValor(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        String reg = getRegistro(arr[2]);
        if(reg.equals("")){ //Si el registro no existe se agregar uno nuevo en uso
            mips = "li "+ guardarRegistro(arr[0]) + ", " + arr[2] +  "\n";
        }
        else{
            mips = "li "+ guardarRegistro(arr[0]) + ", " + reg +  "\n";
        }        
        return mips;
    }
    
    //reg = t1, t2, t3, ...
    private String getRegistro(String reg){
        String registro = "";
        for (Elemento e : registros){
            if(e.identificador.equals(reg)){
                registro = e.arg1;
            }
        }
        return registro;
    }
    
    private String guardarRegistro(String reg){
        Elemento nr = new Elemento(); //Nuevo registro
        nr.identificador=reg;
        nr.arg1 = "$t" + String.valueOf(rc);
        rc++;
        registros.add(nr);
        return nr.arg1;
    }
}
