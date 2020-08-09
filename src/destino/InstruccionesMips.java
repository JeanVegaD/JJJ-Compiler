/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import java.util.ArrayList;

/**
 * to do
 * parametros al inicio de una funcion void foo(String param1, int param2, ...){}
 * parametros al llamar una funcion foo(p1, p2, ...);
 * liberar registros en el tipo de instruccion li $t0, $t1
 * trabajar el 3d param t0
 * Strings de todo tipo
 * inputs
 * prints
 * arreglos, fuck this shit is crazy
 * revisar que la pila se está controlando correctamente
 * 
 * @author cano98
 */
public class InstruccionesMips {
    
    private int rc = 0;
    private ArrayList<Elemento> registros = new ArrayList<Elemento>();
    private ArrayList<Elemento> argumentos = new ArrayList<Elemento>();
    public ArrayList<Elemento> stack = new ArrayList<Elemento>();
    
    private boolean mul = false;
    private boolean div = false;
    private int ultimoRA = 0;
    
    public InstruccionesMips(){
        cargarRegistrosT();
        cargarRegistrosA();
    }
    
    public String getIf(String line){
        String mips = "";
        mips = construirIf(line);
        return mips;
    }
    
    private String construirIf(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        //if t16 goto foo_if0_if0
        mips += "beq " +getRegistro(arr[1])+", 1" + ", " + arr[3]+ "\n";
        liberarRegistro(arr[1]);
        return mips;
    }
    
    
    private void cargarRegistrosT(){
        Elemento r = new Elemento();
        r.arg1 = "$t0";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t1";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t2";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t3";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t4";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t5";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t6";
        registros.add(r);
        r = new Elemento();
        r.arg1 = "$t7";
        registros.add(r);
    }
    
    private void cargarRegistrosA(){
        Elemento r = new Elemento();
        r.arg1 = "$a0";
        argumentos.add(r);
        r = new Elemento();
        r.arg1 = "$a1";
        argumentos.add(r);
        r = new Elemento();
        r.arg1 = "$a2";
        argumentos.add(r);
        r = new Elemento();
        r.arg1 = "$a3";
        argumentos.add(r);
    }
    
    public String getParametro(String line){
        String mips = "";
        mips = construirParametro(line);
        return mips;
    }
    
    private String construirParametro(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "move "+ guardarArgumento("pparam")+ ", "+getRegistro(arr[1])+ "\n";
        liberarRegistro(arr[1]);
        return mips;
    }
    
    private String guardarArgumento(String id){
        String ar = "";
        for(Elemento e : argumentos){
            if(e.identificador.equals("")){
                e.identificador = id;
                ar = e.arg1;
                return ar;
            }   
        }
        return ar;
    }
    
    public String getFuncionPrint(){
        String mips = "";
        mips += "print:\n";
        mips += "sub $sp, $sp, 4\n";
        mips += "sw $ra, 0($sp)\n";
        mips += "li $v0, 1 \n";
        mips += "syscall\n";
        mips += "addi $sp, $sp, 8\n";
        mips += "lw $s0, 0($sp)\n";
        mips += "move $ra, $s0\n";
        mips += "jr $ra\n\n";
        return mips;
    }
    
    public String getFuncionInput(String line){
        String[] arr = line.split(" ", 0);
        String mips = "";
        mips += "input:\n";
        mips += "sub $sp, $sp, 4\n";
        mips += "sw $ra, 0($sp)\n";
        mips += "li $v0, 5";
        mips += "syscall\n\n";
        mips += "move " + guardarRegistro(arr[0])+ ", $v0 \n";
        mips += "addi $sp, $sp, 8";
        mips += "lw $s0, 0($sp)";
        mips += "move $ra, $s0";
        mips += "jr $ra";
        return mips;
    }
    
    public String getCall(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips = "jal "+arr[3] + "\n";    
        argumentos = new ArrayList<Elemento>();
        cargarRegistrosA();
        return mips;
    }
    
    public String getRASave(){
        String instruccionMips = "";
        instruccionMips = construirSave();        
        return instruccionMips;
    }
    
    private void eliminarScope(){
        stack.subList(ultimoRA, stack.size()).clear();
        int i = 0;
        if(stack.size() != 0){
            for(i = stack.size()-1; stack.get(i).identificador.equals("ra"); i--){
                ultimoRA = stack.get(i).pos;
            }
        }
    }
    
    public String getRetorno(){
        String mips = "";
        mips = construirRetorno();
        eliminarScope();
        resetRegistros();
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
        liberarRegistro(arr[2]);
        return mips;
    }
    
    public void resetRegistros(){
        registros = new ArrayList<Elemento>();
        cargarRegistrosT();
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
            mips = construirOperacion("add ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("-")){
            mips = construirOperacion("sub ",arr[0],arr[2],arr[4]);
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
        if(op.equals("==")){
            mips = construirOperacion("seq ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("<")){
            mips = construirOperacion("slt ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals(">")){
            mips = construirOperacion("sgt ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals(">=")){
            mips = construirOperacion("sge ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("<=")){
            mips = construirOperacion("sle ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("!=")){
            mips = construirOperacion("sne ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("&")){
            mips = construirOperacion("and ",arr[0],arr[2],arr[4]);
            return mips;
        }
        if(op.equals("|")){
            mips = construirOperacion("or ",arr[0],arr[2],arr[4]);
            return mips;
        }
        return mips;
    }
    
    private String construirOperacion(String ins, String r1, String r2, String r3){
        String mips = "";
        mips = ins+ guardarRegistro(r1) +", " + getRegistro(r2) + ", " +getRegistro(r3) +  "\n";
        liberarRegistro(r2);
        liberarRegistro(r3);
        return mips;
    }
    
    private int liberarRegistro(String id){
        for(int i = 0; i<8; i++){
            if(registros.get(i).identificador.equals(id)){
            registros.get(i).identificador = "";
            return 0;
            }
        }
        return 0;
    }
    //Construlle una instruccion dependiendo si es una declaracion o 
    private String seleccionarPorValor(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        String reg = getRegistro(arr[2]);
        if(reg.equals("")){ //Si el registro no existe se agregar uno nuevo en uso
            if(arr[2].equals("true")){
                mips = "li "+ guardarRegistro(arr[0]) + ", 1 #Booleano true\n";
            }
            else if(arr[2].equals("false")){
                mips = "li "+ guardarRegistro(arr[0]) + ", 0 #Booleano false\n";
            }
            else{
                mips = "li "+ guardarRegistro(arr[0]) + ", " + arr[2] +  "\n";                
            }
        }
        else{
            mips = "move "+ guardarRegistro(arr[0]) + ", " + reg +  "\n";
            liberarRegistro(arr[2]);
        }        
        return mips;
    }
    
    //reg = t1, t2, t3, ...
    private String getRegistro(String id){
        String registro = "";
        for (Elemento e : registros){
            if(e.identificador.equals(id)){
                registro = e.arg1;
            }
        }
        return registro;
    }
    
    private String guardarRegistro(String id){
        Elemento nr = new Elemento(); //Nuevo registro
        for (Elemento e : registros){
            if(e.identificador.equals("")){
                e.identificador = id;
                nr = e;
                return nr.arg1;
            }
        }
        return nr.arg1;
    }
}
