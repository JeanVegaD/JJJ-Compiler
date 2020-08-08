/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    private ArrayList<Elemento> stack = new ArrayList<Elemento>();
    private  InstruccionesMips instruccion = new InstruccionesMips();
    private int stackPointer = 0;
    private int framePoiner = 0;
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
            bwr = new BufferedWriter(new FileWriter(new File("src\\txtFiles\\tres_direcciones\\"+ nombre+".s")));
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
    
    public void iniciar(String nombre) throws IOException 
    {  
            BufferedReader br= abrirArchivo();  //creates a buffering character input stream  
            String line;  
            sb.append(instruccion.getHeader());
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
    
    private String crearMipsEnd(){
        String mips = "";
        mips += "end: \n";
	mips += "li $v0,10 \n";
	mips += "syscall";
        return mips;
    }
    
    private void prepararScopeDeFuncion(BufferedReader br) throws IOException{
        //Aqui trabajo el segmento de una funcion y creo el codigo
        String line;
        boolean noEsFinDeFuncion = true;
        guardarRA();
        while(noEsFinDeFuncion)  //Se inicia la lectura de loq ue hay dentro de una funcion
            {  
                line=br.readLine();
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
    
    private void guardarRA(){
        sb.append(instruccion.getRASave());
    }
    
    private boolean esLineaValida(String line){
        if((line == null) || line.split(" ",0)[0].equals("") || line.equals("") ){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    private void analizar3D(String line, BufferedReader br){
        if(esPop(line)){
            crearPop(line);
        }
        if(esInstruccion(line)){
            crearInstruccion(line);
        }
        if(esPalabra(line, "return")){
            hacerRetorno(line);
        }
        if(esCall(line)){
            crearCall(line);
        }
        if(esPalabra(line, "if")){
            crearIf(line);
        }
        if(esEtiqueta(line)){
            crearEtiqueta(line);
        }
        if(esPalabra(line, "goto")){
            crearSalto(line);
        }
        if(esPalabra(line, "param")){
            crearParametro(line);
        }
        if(esDeclaracion(line)){ 
            crearDeclaracion(line);
        }
    }
    
    private void crearCall(String line){
        sb.append(instruccion.getCall(line));
        guardarRA();
    }
    
    
    private boolean esPop(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length == 3 && Character.isLetter(arr[2].charAt(0)) && !arr[2].equals("true") && !arr[2].equals("false") && (arr[2].charAt(0) != 't')){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void crearPop(String line){
        sb.append(instruccion.getPop(line));
    }
    
    private void crearParametro(String line){
        sb.append(instruccion.getParametro(line));
    }
    
    private void crearSalto(String line){
        sb.append(line+"\n");
    }
    
    public boolean esPalabra(String line, String etiqueta){
        String[] arr = line.split(" ", 0);
        if(arr[0].equals(etiqueta)){
            return true;
        }
        else{
            return false;
        }
    }

    
    public void crearEtiqueta(String line){
        sb.append(line+"\n");
    }
    
    public boolean esEtiqueta(String line){
        String[] arr = line.split(" ", 0);
        if(arr.length == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void crearIf(String line){
        sb.append(instruccion.getIf(line));
    }
    
    public void hacerRetorno(String line){
        String[] arr = line.split(" ", 0);
        sb.append(instruccion.getRetorno());
    }
    
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
    
    
    
    
    private void crearDeclaracion(String line){
        sb.append(instruccion.getDeclaracion(line));
        //aqui se reinicia el uso de los registros
    }
    
    
    private void crearInstruccion(String line){
        sb.append(instruccion.getInstruccion(line));

    }
    
    private boolean esDeclaracion(String line){
        String[] arr = line.split(" ", 0);
        if((arr.length == 3) && arr[2].substring(0,1).equals("t") && !arr[0].substring(0,1).equals("t")){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean esInstruccion(String line){
        String[] arr = line.split(" ", 0);
        if(arr[0].substring(0,1).equals("t") && !esPop(line)){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    private boolean esBeginFuncion(String line)
    {
        String[] arr = line.split(" ", 0);
        if(arr[0].equals("func") && arr[1].equals("begin")){
            agregarLineaMips(line.split(" ")[2]+ ":" + "\n");
            return true;
        }
        else{
            return false;
        }
    }    
    
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
    
    private void agregarLineaMips(String mipsline){
        sb.append(mipsline);
    }
    
}
