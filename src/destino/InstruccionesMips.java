/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import java.util.ArrayList;

/**
 * @author cano98
 */
public class InstruccionesMips {
    
    private int rc = 0;
    private ArrayList<Elemento> registros = new ArrayList<Elemento>();
    private ArrayList<Elemento> argumentos = new ArrayList<Elemento>();
    private ArrayList<Elemento> salvados = new ArrayList<Elemento>();
    public ArrayList<Elemento> stack = new ArrayList<Elemento>();
    
    private boolean mul = false;
    private boolean div = false;
    private int ultimoRA = 0;
    
	
	/**
	Las llamadas en el constructor es para preparar los registros
	con los que se controla el flujo del programa
	*/
    public InstruccionesMips(){
        cargarRegistrosT();
        cargarRegistrosA();
        cargarRegistrosS();
    }
    
	
	/*
		obtiene el equivalente en mips para una estructura de control IF
	*/
    public String getIf(String line){
        String mips = "";
        mips = construirIf(line);
        return mips;
    }
    
	/*
		Construye el equivalente en mips para una estructura de control IF
	*/
    private String construirIf(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "beq " +getRegistro(arr[1])+", 1" + ", " + arr[3]+ "\n";
        liberarRegistro(arr[1]);
        return mips;
    }
    
	/*
		Inicializa los registros temporales de la lista -salvados
		Esta lista simula los registros $s0 - $s7 que son usados en mips
	*/
    private void cargarRegistrosS(){
        Elemento r = new Elemento();
        r.arg1 = "$s0";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s1";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s2";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s3";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s4";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s5";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s6";
        salvados.add(r);
        r = new Elemento();
        r.arg1 = "$s7";
        salvados.add(r);
    }
    
    /*
		Inicializa los registros temporales de la lista -registros
		Esta lista simula los registros $t0 - $t7 que son usados en mips
	*/
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
    
	/*
		Inicializa los registros temporales de la lista -registros
		Esta lista simula los registros $a0 - $a3 que son usados en mips
	*/
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
    
	/*
		Obtiene el equivalente en mips de obtencion de parametros de una
		funcion y guardado en la pila
	*/
    public String getParametro(String line){
        String mips = "";
        mips = construirParametro(line);
        return mips;
    }
    
	/*
		Construye el equivalente en mips de obtencion de parametros de una
		funcion y guardado en la pila
	*/
    private String construirParametro(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "move "+ guardarArgumento("param")+ ", "+getRegistro(arr[1])+ "\n";
        liberarRegistrosParametro(arr[1]);
        return mips;
    }
    
	/*
		Toma la lista de registros temporales y los libera de uso
		esto permite que no sean reservados sin razón al iniciar una funcion en mips
	*/
    void liberarRegistrosParametro(String aLiberar){
        String paraLiberar = String.valueOf(Integer.parseInt(aLiberar.substring(1)) - 1);
        int contador = Integer.parseInt(aLiberar.substring(1));
        while(contador>=0){
            liberarRegistro("t"+String.valueOf(contador));
            contador--;
        }
    }
    
	/*
		Recibe un identificador y lo asigna al ultimo registro de argumento que aun
		no ha sido reservado
	*/
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
    
	/*
		Construye y retorna una funcion predeterminada para imprimir en mips
	*/
    public String getFuncionPrint(){
        String mips = "";
        mips += "print:\n";
        mips += construirSave();
        mips += "li $v0, 1 \n";
        mips += "syscall\n";
        mips += "addi $sp, $sp, " + String.valueOf((stack.size()-1)*4 - ultimoRA*4) +"\n";
        mips += "lw $t0, 0($sp)\n";
        mips += "move $ra, $t0\n";
        mips += "jr $ra\n\n";
        eliminarScope();
        return mips;
    }
    
 
    /*
		Construye y retorna el equivalente en mips para realizar una llamada
		a una sub rutina
	*/
    public String getCall(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += getSalvarRegistrosTemporales();
        mips += "jal "+arr[3] + "\n";    
        mips += getCargarRegistrosTemporales();
        mips += "move "+guardarRegistro(arr[0])+", $v0 \n";
        argumentos = new ArrayList<Elemento>();
        cargarRegistrosA();
        return mips;
    }
    
	/*
		Obtiene el equivalente en mips para guardar el registro de retorno de función
	*/
    public String getRASave(){
        String instruccionMips = "";
        instruccionMips = construirSave();        
        return instruccionMips;
    }
    
	/*
		Elimina elementos en el stack hasta encontrar el fp, y deja solamente el scope previo a una llamada
		de subrutina
	*/
    private void eliminarScope(){
        stack.subList(ultimoRA, stack.size()).clear();
        int i = 0;
        if(stack.size() != 0){
            for(i = stack.size()-1; stack.get(i).identificador.equals("ra"); i--){
                ultimoRA = stack.get(i).pos;
            }
        }
    }
    
	/*
		Obtiene el equivalente en mips de "return"
	*/
    public String getRetorno(String line){
        String mips = "";
        mips = construirRetorno(line);
        eliminarScope();
        resetRegistros();
        return mips;
    }
    
	
	/*
		Construye el equivalente en mips de "return"
	*/
    private String construirRetorno(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "add $sp, $sp, " + String.valueOf((stack.size()-1)*4 - ultimoRA*4) +"\n";
        mips += "lw $t0, 0($sp)\n";
        mips += "move $v0, "+getRegistro(arr[1])+"\n";
        mips += "move $ra, $t0\n";
        mips += "add $sp, $sp, 4\n";
        mips += "jr $ra\n";
        return mips;
    }
    
    /*
		Obtiene el las etiquetas del compilador de mips que son escnciales para el funcionamiento
	*/
    public String getHeader(){
        String mips = "";
        mips += ".data\n\n";
        mips += ".text\n\n";
        mips += ".globl main\n\n";
        return mips;
    }
    
	/*
		Construye el el guardado del registtro de retorno en la pila para mips
	*/
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
    
	/*
		
		Obtiene el equivalente en mips de invocar una variable creada en un scope
	*/
    public String getPop(String line){
        String instruccionMips = "";
        instruccionMips = construirPop(line);
        return instruccionMips;
    }
    
	
	/*
		Obtiene el codigo mips para guardar los argumentos recibidos en una funcion en la pila
	*/
    public String getArgumento(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "sub $sp, $sp, 4\n";
        mips += "sw $a"+arr[3]+", 0($sp)\n";
        Elemento ne = new Elemento();
        ne.identificador = arr[0];  //Identificador del elemento en la pila
        ne.arg1 = arr[2];           //valor a asignar
        ne.pos = stack.size();      //Posicion del elemento en la pila
        stack.add(ne);
        return mips;
    }
    
	/*
		Construye el codigo mips para poder sacar de la pila una variable que está siendo invocada
	*/
    private String construirPop(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        mips += "lw " + guardarRegistro(arr[0]) + ", " + String.valueOf((stack.size()-1)*4 - getVariable(arr[2]).pos*4) + "($sp) \n";
        return mips;
    }
    
	/*
		Retorna el elemento en la pila (atributo de clase) que tiene el id pasado
	*/
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
    
	/*
		Retorna la posicion del elemento en la pila que tiene el @id
	*/
    private int posicionEnPila(String id){
        int posicion = -1;
        for(Elemento e : stack){
            if(e.identificador.equals(id)){
                posicion = e.pos;
                return posicion;
            }
        }
        return posicion;
    }
    
    //Esto es un push en la pila
    public String construirDeclaracion(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        int variable = posicionEnPila(arr[0]);
        if(variable == -1){
            Elemento ne = new Elemento();
            ne.identificador = arr[0];  //Identificador del elemento en la pila
            ne.arg1 = arr[2];           //valor a asignar
            ne.pos = stack.size();      //Posicion del elemento en la pila
            stack.add(ne);
            mips += "sub $sp, $sp, 4 \n";
  
                String r = getRegistro(arr[2]);
                if(r.equals("")){ //Si no lo encuentra asume que viene de un retorno
                    mips += "sw $v0, 0($sp) \n\n";
                }else{
                    mips += "sw " + getRegistro(arr[2]) + ", 0($sp) \n\n";
                //}
            }
            liberarRegistro(arr[2]);
            return mips;
        }
        else{

                mips += "sw "+getRegistro(arr[2])+", "+String.valueOf((stack.size()-1)*4 - variable*4)+"($sp) \n";
                liberarRegistro(arr[2]);
                return mips;

        }
    }
    
	/*
		Obtiene el equivalente en mips de una case y do while
	*/
    public String getEstructura(String line){
        String mips = "";
        String[] arr = line.split(" ", 0);
        if(arr.length == 4){
            mips += "bne " +getRegistro(arr[1])+", 1" + ", " + arr[3]+ "\n";
            liberarRegistro(arr[1]);
            return mips;
        }
        else{
            mips = "seq "+ guardarRegistro(arr[0]) +", " + getRegistro(arr[1]) + ", " +getRegistro(arr[3]) +  "\n";
            liberarRegistro(arr[1]);
            mips += "bne " +getRegistro(arr[0])+", 1" + ", " + arr[5]+ "\n";
            liberarRegistro(arr[0]);
            return mips;
        }
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
    
	/*
		Obtiene EL CODIGO MIPS QUE SE ENCARGA DE SALVAR LOS REGISTROS TEMPORALES al llamar una subrutina
	*/
    public String getSalvarRegistrosTemporales(){
        String mips = "";
        int i = 0;
        for(Elemento t : registros){
            if(!t.identificador.equals("")){
                salvados.get(i).identificador = t.identificador;
                t.identificador = "";
                mips += "move "+salvados.get(i).arg1+", "+t.arg1+"\n";
                i++;
            }
        }
        return mips;
    }
    
	/*
		Obtiene EL CODIGO MIPS QUE SE ENCARGA DE cargar LOS REGISTROS TEMPORALES después de llamar una subrutina
	*/
    public String getCargarRegistrosTemporales(){
        String mips = "";
        int i = 0;
        for(Elemento s : salvados){
            if(!s.identificador.equals("")){
                registros.get(i).identificador = s.identificador;
                s.identificador = "";
                mips += "move "+registros.get(i).arg1+", "+s.arg1+"\n";
                i++;
            }
        }
        return mips;
    }
    
	/*
		Construye el codigo mips para una asignacion comun de registros o movimientos entre registros
	*/
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
            mips += "mult "+ getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            liberarRegistro(arr[2]);
            liberarRegistro(arr[4]);
            mips += "mflo "+ guardarRegistro(arr[0]) + "\n";
            mul = true;
            return mips;
        }
        if(op.equals("/")){
            mips += "div "+ getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            liberarRegistro(arr[2]);
            liberarRegistro(arr[4]);
            mips += "mflo "+ guardarRegistro(arr[0])+ "\n";
            div = true;
            return mips;
        }
        if(op.equals("%")){
            mips += "div "+ getRegistro(arr[2]) + ", " +getRegistro(arr[4]) +  "\n";
            liberarRegistro(arr[2]);
            liberarRegistro(arr[4]);
            mips += "mfhi "+ guardarRegistro(arr[0])+ "\n";
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
    //Construye una instruccion dependiendo si es una declaración o una asignacion
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
    
    /*
		Obtiene el id del registro en la pila con el conincide el id
	*/
    private String getRegistro(String id){
        String registro = "";
        for (Elemento e : registros){
            if(e.identificador.equals(id)){
                registro = e.arg1;
            }
        }
        return registro;
    }
    
	/*
		Almacena en la lista de registros un nuevo registro con id solicitado
	*/
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
