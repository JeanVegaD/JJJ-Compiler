
package destino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cano98
 */
public class Analizador {
    
    private  InstruccionesMips instruccion = new InstruccionesMips();
    private int stackPointer = 0;
    private int framePoiner = 0;
    private boolean esMain=false;
    private StringBuffer sb=new StringBuffer(); //Aqui se va construyendo el codigo destino
    private int rc= 0; //Contador de registros
    
    public Analizador(){
        
    }
    
    private BufferedReader abrirArchivo(){
        FileReader fr=null;
        try {
            File file=new File("src\\txtFiles\\tres_direcciones\\c3drealizado.txt");    //creates a new file instance  
            fr = new FileReader(file); //reads the file
            return new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Analizador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    public void escribirBuffer(String nombre) {    
        BufferedWriter bwr = null;
        try {
            bwr = new BufferedWriter(new FileWriter(new File("src\\txtFiles\\tres_direcciones\\"+ nombre.substring(0, nombre.length()-4)+".s")));
            //write contents of StringBuffer to a file
            bwr.write(sb.toString());
            //flush the stream
            bwr.flush();
            //close the stream
            bwr.close();
        } catch (IOException ex) {
            Logger.getLogger(Analizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	/*
		Inicia la lectura linea por line del codigo 3d y construye su equivalente en mips
	*/
    public void iniciar(String nombre) throws IOException 
    {  
            BufferedReader br= abrirArchivo();  //creates a buffering character input stream  
            String line;  
            sb.append(instruccion.getHeader());
            sb.append(instruccion.getFuncionPrint());
            while((line=br.readLine())!=null)  
            {  
                if(esLineaValida(line)){
                    if(esBeginFuncion(line)){
                        prepararScopeDeFuncion(br);
                    }
                }
            }  
            sb.append(crearMipsEnd());
            escribirBuffer(nombre);
    }
    
	/*
		Construye el equivalente en mips para terminar la funcion main
	*/
    private String crearMipsEnd(){
        String mips = "";
        mips += "end: \n";
	mips += "li $v0,10 \n";
	mips += "syscall";
        return mips;
    }
    
	/*
		Analiza y construye una funcion en mips, únicamente analiza el código considerado parte de una funcion
	*/
    private void prepararScopeDeFuncion(BufferedReader br) throws IOException{
        //Aqui trabajo el segmento de una funcion y creo el codigo
        String line;
        boolean noEsFinDeFuncion = true;
        guardarRA();
        while(noEsFinDeFuncion)  //Se inicia la lectura de loq ue hay dentro de una funcion
            {  
                line=br.readLine();
                System.out.println(line);
                if(esLineaValida(line)){
                    if(esEndFuncion(line)){
                        noEsFinDeFuncion = false;
                    }
                    else{
                        analizar3D(line, br); 
                    }
                }
                else{
                    System.out.println("Es vacio");
                }
            }
    }
    
	/*
		Agregar al mips las instrucciones necesacira para guardar el registro $ra en la pila
	*/
    private void guardarRA(){
        sb.append(instruccion.getRASave());
    }
    
	/*
		Determina si la linea del 3D que está siendo analizada está vacia o no.
	*/
    private boolean esLineaValida(String line){
        if((line == null) || line.split(" ",0)[0].equals("") || line.equals("") ){
            return false;
        }
        else{
            return true;
        }
        
    }
    
	/*
		Permite determinar el tipo de accion proveniente de el 3D, y realizar una acción en consecuencia
	*/
    private void analizar3D(String line, BufferedReader br){
        if(esEtiqueta(line)){
            sb.append(line+"\n");
        }
        else if(esCall(line)){
            crearCall(line);
        }
        else if(esPop(line)){
            crearPop(line);
        }
        else if(esPalabra(line, "goto")){
            crearSalto(line);
        }
        else if(esInstruccion(line)){
            crearInstruccion(line);
        }
        else if(esPalabra(line, "return")){
            hacerRetorno(line);
        }
        
        else if(esPalabra(line, "if")){
            crearIf(line);
        }
        else if(esEtiqueta(line)){
            crearEtiqueta(line);
        }
        else if(esPalabra(line, "param")){
            crearParametro(line);
        }
        else if(esDeclaracion(line)){ 
            crearDeclaracion(line);
        }
        else if(esArgumento(line)){//esArgumento
            crearArgumento(line);
        }
        else if(esPalabra(line, "ifFalse")){
            crearEstructura(line);
        }
        else{
            sb.append("#Evento no capturado\n");
        }
    }
    
	/*
		Agrega al mips la estructura para construir un switch, do while
	*/
    private void crearEstructura(String line){
        sb.append(instruccion.getEstructura(line));
    }
    
	/*
		Determina si el codigo mips que se analiza corresponde parametro de una función
	*/
    private boolean esArgumento(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length == 4){
            if(arr[2].equals("param")){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    
    /*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips, un parametro de una función
	*/
    private void crearArgumento(String line){
        sb.append(instruccion.getArgumento(line));
    }
    
	/*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips, una llamada a subrutina
	*/
    private void crearCall(String line){
        sb.append(instruccion.getCall(line));
    }
    
    /*
		Determina si el codigo mips que se analiza corresponde al casteo de una variable
	*/
    private boolean esPop(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length == 3 && Character.isLetter(arr[2].charAt(0))  && !arr[2].equals("true") && !arr[2].equals("false") ){
            if(arr[2].length()>1)
            {
                if(Character.isLetter(arr[2].charAt(1)))return true;
                else return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    
	/*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips, invocación de variable
	*/
    public void crearPop(String line){
        sb.append(instruccion.getPop(line));
    }
    
	/*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips, parametros
	*/
    private void crearParametro(String line){
        sb.append(instruccion.getParametro(line));
    }
    
	/*
		Agregar el mips la estructura necesaria para saltar a una etiqueta
	*/
    private void crearSalto(String line){
        String[] arr = line.split(" ", 0);
        if(arr[1].charAt(arr[1].length()-1) == ':'){
            sb.append("j " + arr[1].substring(0, arr[1].length()-1) +"\n");
        }
        else{
            sb.append("j " + arr[1] +"\n");
        }
    }
    
	/*
		Determina si el 3D que está siendo analizado corresponde la etiqueta(palabra a comparar)
	*/
    public boolean esPalabra(String line, String etiqueta){
        String[] arr = line.split(" ", 0);
        if(arr[0].equals(etiqueta)){
            return true;
        }
        else{
            return false;
        }
    }

    /*
		Agrega al codigo mips la etiqueta
	*/
    public void crearEtiqueta(String line){
        sb.append(line+"\n");
    }
    
	/*
		Determina si el 3D que está siendo analizado corresponde a el nombre de una función
	*/
    public boolean esEtiqueta(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length == 1){
            return true;
        }
        else{
            return false;
        }
    }

	/*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips, un if
	*/
    public void crearIf(String line){
        sb.append(instruccion.getIf(line));
    }
    
	/*
		Construye el equivalente en mips para el retorno de el procedimiento main
	*/
    public void hacerRetorno(String line){
        if(esMain){
            sb.append("jal end\n");
            esMain = false;
        }
        else{
            sb.append(instruccion.getRetorno(line));
        }
    }
    
	/*
		Determina si el 3D que está siendo analizado corresponde a una llamada de subrutina
	*/
    private boolean esCall(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length>2){
            if(arr[2].equals("call")){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    
    
    /*
		Determina si el 3D que está siendo analizado corresponde a una declaracion
	*/
    private void crearDeclaracion(String line){
        sb.append(instruccion.getDeclaracion(line));
    }
    
    
	/*
		Agrega a la cadena de texto mips la estructura recibida del constructor de mips
	*/
    private void crearInstruccion(String line){
        sb.append(instruccion.getInstruccion(line));

    }
    
	
	/*
		Determina si la linea 3D que está siendo analizada corresponde a una declaracion
	*/
    private boolean esDeclaracion(String line){
        String[] arr = line.split(" ", 0);
        
        if((arr.length == 3) && arr[2].substring(0,1).equals("t") ){
            return true;
        }
        else{
            return false;
        }
    }
    
	
	/*
		Determina si la linea 3D que está siendo analizada corresponde a una instrucción
	*/
    private boolean esInstruccion(String line){
        String[] arr = line.split(" ", 0);
        if(arr[0].substring(0,1).equals("t") && !esPop(line) && !Character.isLetter(arr[0].charAt(1))){
            return true;
        }
        else{
            return false;
        }
    }
    
    /*
		Determina si es el inicio de una funcion en el 3D
	*/
    private boolean esBeginFuncion(String line)
    {
        String[] arr = line.split(" ", 0);
        if(arr[0].equals("func") && arr[1].equals("begin")){
            agregarLineaMips(line.split(" ")[2]+ ":" + "\n");
            if(arr[2].equals("main"))esMain = true;
            return true;
        }
        else{
            return false;
        }
    }    
    
	/*
		Determina si es el final de una funcion en el 3D
	*/
    private boolean esEndFuncion(String line)
    {
        String[] arr = line.split(" ", 0);
        if(arr[0].equals("end") && arr[1].equals("func")){
            agregarLineaMips("#Fin de funcion \n\n");
            //Agregar al codigo mips el procedimiento de retorno
            return true;
        }
        else{
            return false;
        }
    }  
    
	/*
		Agrega una nueva linea a la cadena de texto del codigo
	*/
    private void agregarLineaMips(String mipsline){
        sb.append(mipsline);
    }
    
}
