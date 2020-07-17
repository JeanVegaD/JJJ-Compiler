


package Codigo.semantico;

import Codigo.archivo_ingresado;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Codigo.semantico.cuadruplos;

    


public class codigo_tres_direcciones {
    
    
    
     private ArrayList<cuadruplos> tablaSimbolos = new ArrayList<cuadruplos>();
    //Estructura 
    //T    LEFT    OP    RIGHT  LANBEL_PADRE   
    
    private ArrayList<ArrayList<String>> tablaEtiquetas = new ArrayList<ArrayList<String>>();
    //Estructura 
    //ID    ETIQUETA_PADRE  
    
   
    private ArrayList<cuadruplos> pila = new ArrayList<cuadruplos>();
    
    private int contadorLabel_block=0;
    private String current_Label="";
    private String code3d="";
    
    public codigo_tres_direcciones(){
        
    }
    
    public void newFunc(String identificador){
        contadorLabel_block=0;
        current_Label=identificador;
        ArrayList<String> temp =  new ArrayList<>();
        temp.add(identificador);
        temp.add("root");
        code3d+="func begin "+ identificador + "\n";
    }
    
    
    public void newFunc_params(String parametros){
        String[] params = parametros.toString().split(",");
        int cont=0;
        for (String p : params){
            String[] unit_param = p.split(" ");
            String tempcont="param["+cont+"]";
            cuadruplos newLoad =  new cuadruplos(unit_param[1], tempcont, current_Label);
            tablaSimbolos.add(newLoad);
            code3d+=newLoad.getLine() + "\n";
            cont+=1;
        }
        
        for (String p : params){
            String[] unit_param = p.split(" ");
            String t1="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos newLoad =  new cuadruplos(t1, unit_param[1], current_Label);
            tablaSimbolos.add(newLoad);
            code3d+=newLoad.getLine()+ "\n";
        }
     

    }
    
    public void closeFunc(){
        code3d+="end func"+ "\n\n\n";
    }
    
    
    
     public void param_op_param(String p1,String op, String p2){
        String t="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos left= new cuadruplos(t,p1,current_Label);
        tablaSimbolos.add(left);
        code3d+=left.getLine() + "\n";
        
    
        String t2="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos right= new cuadruplos(t2,p2,current_Label);         
        tablaSimbolos.add(right);
        code3d+=right.getLine() + "\n";
        
       
        String t3="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos temp= new cuadruplos(t3,left.getTn(),op,right.getTn(),current_Label);
        tablaSimbolos.add(temp);
        code3d+= temp.getCompleteLine() + "\n";   
        pila.add(temp);
     }
    
     public void exp_op_param(String p1,String op ){
        String t="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos left= new cuadruplos(t,p1,current_Label);
        tablaSimbolos.add(left);
        code3d+=left.getLine() + "\n";
        
        String t3="t"+contadorLabel_block;
        contadorLabel_block+=1;
        
        String inpila=pila.get(pila.size()-1).getTn();
        cuadruplos temp= new cuadruplos(t3,left.getTn(),op,inpila,current_Label);
        pila.remove(pila.size()-1);
        tablaSimbolos.add(temp);
        code3d+= temp.getCompleteLine() + "\n";   
        pila.add(temp);
     }
     
     public void param_op_exp(String p1,String op){
        String t="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos left= new cuadruplos(t,p1,current_Label);
        tablaSimbolos.add(left);
        code3d+=left.getLine() + "\n";
        
        String t3="t"+contadorLabel_block;
        contadorLabel_block+=1;
        
        String inpila=pila.get(pila.size()-1).getTn();
        cuadruplos temp= new cuadruplos(t3,inpila,op,left.getTn(),current_Label);
        pila.remove(pila.size()-1);
        tablaSimbolos.add(temp);
        code3d+= temp.getCompleteLine() + "\n";   
        pila.add(temp);
     }
     
     public void exp_op_exp(String op){
        String t1="t"+contadorLabel_block;
        contadorLabel_block+=1;
        
        String inpila=pila.get(pila.size()-1).getTn();
        pila.remove(pila.size()-1);
        
        String inpila2=pila.get(pila.size()-1).getTn();
        pila.remove(pila.size()-1);
        
        cuadruplos temp= new cuadruplos(t1,inpila2,op,inpila,current_Label);
        code3d+= temp.getCompleteLine() + "\n";   
        pila.add(temp);
     }
        
     /*
     
     public void load_lit_aux(String p1,String op){
            String l="l"+contadorLabel_block;
            cuadruplos left= new cuadruplos(l,p1);         
            //left.imprimir();
            contadorLabel_block+=1;
            cuadruplos temp= new cuadruplos(l,left,op,pila.get((pila.size()-1)));
            pila.remove(pila.size()-1);
            pila.add(temp);
     }
    
    */
     
     
    
     
     
             


    
    

    /*
    E:String con el codigo intermedio generado 
    S:Archivo de texto 
    R:No aplica
    
    Se encarga de crear un arhcivo txt con los tokens analizados
    */
   public void escribirCodigo3D(String name){
       FileWriter myWriter;
       
        try {
            myWriter = new FileWriter("src/txtFiles/tres_direcciones/c3d"+ name + ".txt" );
            myWriter.write(this.code3d);
            myWriter.close();
            //reporte_consola+= "<h3 class='textoNormal'>Se ha generado el archivo con los tokens</h3>";
        } catch (IOException ex) {
            //reporte_consola+= "<h3 class='textoRojo'>ERROR: NO se ha generado el archivo con los tokens  </h3>";
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }
   
}