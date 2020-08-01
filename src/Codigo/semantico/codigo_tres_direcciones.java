


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
    private ArrayList<cuadruplos> pilaLiteral = new ArrayList<cuadruplos>();
    
    private int contadorLabel_block=0;
    private String current_Label="";
    private String code3d="";
    
    private boolean activo=true;
    
    private ArrayList<String> pilaForStaments = new ArrayList<String>();
    private ArrayList<String> pilaCode3d = new ArrayList<String>();
    
    private ArrayList<String> pilaCase = new ArrayList<String>();
    public codigo_tres_direcciones(){
        
    }
    
    
    public void Activacion3d(boolean act){
        this.activo=act;
    }
    
    public void setLit(String lit){
        if(activo){
             String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,lit,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
            pilaLiteral.add(left);
        }
       
        
    }
    
    public void set_lit_arimetico_un(String op, String id){
        if(activo){
            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,id,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";

            String t2="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos temp= new cuadruplos(t2,left.getTn(),op,"1",current_Label);
            tablaSimbolos.add(temp);
            code3d+=temp.getCompleteLine()+ "\n";
            pilaLiteral.add(temp);
        }
        
  
    }
    
    public void newFunc(String identificador){
        if(activo){
            contadorLabel_block=0;
            current_Label=identificador;
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(identificador);
            temp.add("root");
            code3d+="func begin "+ identificador + "\n";
        }
        
    }
    
    
    public void newFunc_params(String parametros){
        if(activo){
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
        
     

    }
    
    public void closeFunc(){
        if(activo){
            code3d+="end func"+ "\n\n\n";
        }
        
    }
    
    
    
     public void param_op_param(String p1,String op, String p2){
         if(activo){
            /*String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,p1,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";


            String t2="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos right= new cuadruplos(t2,p2,current_Label);         
            tablaSimbolos.add(right);
            code3d+=right.getLine() + "\n";*/

            String inpila2=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);
            String inpila1=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);

            String t3="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos temp= new cuadruplos(t3,inpila1,op,inpila2,current_Label);
            tablaSimbolos.add(temp);
            code3d+= temp.getCompleteLine() + "\n";   
            pila.add(temp);
        }
        
     }
    
     public void exp_op_param(String p1,String op ){
         if(activo){
            /* String t="t"+contadorLabel_block;
        contadorLabel_block+=1;
        cuadruplos left= new cuadruplos(t,p1,current_Label);
        tablaSimbolos.add(left);
        code3d+=left.getLine() + "\n";*/
       
        String parampila=pilaLiteral.get(pilaLiteral.size()-1).getTn();
        pilaLiteral.remove(pilaLiteral.size()-1);
        
        String t3="t"+contadorLabel_block;
        contadorLabel_block+=1;
        
        String inpila=pila.get(pila.size()-1).getTn();
        cuadruplos temp= new cuadruplos(t3,parampila,op,inpila,current_Label);
        pila.remove(pila.size()-1);
        tablaSimbolos.add(temp);
        code3d+= temp.getCompleteLine() + "\n";   
        pila.add(temp);
        }
       
     }
     
     public void param_op_exp(String p1,String op){
         if(activo){
            /*String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,p1,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";*/

            String parampila=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);

            String t3="t"+contadorLabel_block;
            contadorLabel_block+=1;

            String inpila=pila.get(pila.size()-1).getTn();
            cuadruplos temp= new cuadruplos(t3,inpila,op,parampila,current_Label);
            pila.remove(pila.size()-1);
            tablaSimbolos.add(temp);
            code3d+= temp.getCompleteLine() + "\n";   
            pila.add(temp);
        }
        
     }
     
     public void exp_op_exp(String op){
         if(activo){
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
        
     }
     
     
     public void decVar(String idvar){
         if(activo){
            cuadruplos left= new cuadruplos(idvar,"0",current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
        }
        
     }
     
     
     public void asginarVar(String idvar){
         if(activo){
             //String t="t"+contadorLabel_block;
            //contadorLabel_block+=1;
            String inpila=pila.get(pila.size()-1).getTn();
            pila.remove(pila.size()-1);
            cuadruplos left= new cuadruplos(idvar,inpila,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
        }
        
     }
     
     public void asginarVar_lit(String idvar){
         if(activo){
            //String t="t"+contadorLabel_block;
            //contadorLabel_block+=1;
            String inpila=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);
            cuadruplos left= new cuadruplos(idvar,inpila,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
        }
        
     }
      public void asginarVarCast(String idvar){
          if(activo){
            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            String cargafunc= "call " + "StringToInt"; 
            cuadruplos left= new cuadruplos(t,cargafunc,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
              
             
            cuadruplos left2= new cuadruplos(idvar,left.getTn(),current_Label);
            tablaSimbolos.add(left2);
            code3d+=left2.getLine() + "\n";
        }
      }
     
     
     public void asignarFuncion(String id){
         if(activo){
            /*
            param t1
            param t2
            t3 = call dot_prod 2*/
            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            String cargafunc= "call " + id; 
            cuadruplos left= new cuadruplos(t,cargafunc,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
            pilaLiteral.add(left);
        }
         

     }
     
     
   public void asignarFuncionParams(String id, String parametros){
       if(activo){
             String[] params = parametros.toString().split(",");

            ArrayList<cuadruplos> paramsTemp =  new ArrayList<>();
            for (String p : params){
                String[] unit_param = p.split(" ");
                String t1="t"+contadorLabel_block;
                contadorLabel_block+=1;
                cuadruplos newLoad =  new cuadruplos(t1,unit_param[1], current_Label);
                tablaSimbolos.add(newLoad);
                paramsTemp.add(newLoad);
                code3d+=newLoad.getLine() + "\n";
            }

            for (int i=0; i<paramsTemp.size(); i++ ){
                String print= "param "+ paramsTemp.get(i).getTn();
                code3d+=print + "\n";
            }



            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            String cargafunc= "call " + id + " " + paramsTemp.size(); 
            cuadruplos left= new cuadruplos(t,cargafunc,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";
            pilaLiteral.add(left);
        }
       
       

     }
   
     public void getExpToLit(){
         if(activo){
            cuadruplos inpila2=pila.get(pila.size()-1);
            pila.remove(pila.size()-1);
            pilaLiteral.add(inpila2);
        }
        
     }
        

   
     
    public boolean existeLabel(String n_boque){
         boolean res=false;
        if(activo){
             for (int i = 0; i < tablaEtiquetas.size(); i++) {
                if(tablaEtiquetas.get(i).get(0).equals(n_boque)){
                    res=true;
                    break;
                }
            }
        }
       
       
        return res;
    }
     
    public String obtenerIdBloque(String n_boque){
        String res="";
        if(activo){
            String temp= current_Label+"_"+n_boque;
            int n=0;
            String compare= current_Label+"_"+n_boque+n;
            while(existeLabel(compare)){
                n+=1;
                compare=temp + n;

            }
            res =temp+n;
        }
        return res;
    }
     
     
     
     public String nuevoBloque(String bloque){
         String res="";
         if(activo){
            String nuevoID = obtenerIdBloque(bloque);
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(nuevoID);
            temp.add(current_Label);
            tablaEtiquetas.add(temp);
            code3d+=nuevoID+ ":" + "\n";
            current_Label=nuevoID;
            res= current_Label;
        }
         return res;
        
         
     }
     
     public void cierreBloque(){
         if(activo){
             for (int i = 0; i < tablaEtiquetas.size(); i++) {
                if(tablaEtiquetas.get(i).get(0).equals(current_Label)){
                    System.out.println("Codigo.semantico.codigo_tres_direcciones.cierreBloque()");
                    current_Label= tablaEtiquetas.get(i).get(1);
                    break;
                }
            }
        }
        

     }
     
    public void gotoEnd(String bloque){
        if(activo){
            code3d+="goto " +"end_"+bloque+ ":" + "\n";
        }
        
    }
     
    public void endEstrcutura(String bloque){
        if(activo){
             code3d+="end_"+bloque+ ":" + "\n";
        
        }
       
  
    }
    
    
    public void gotoIF(){
        if(activo){
            code3d+="if "+pilaLiteral.get(pilaLiteral.size()-1).getTn() + " goto "+ obtenerIdBloque("if")  + "\n";
            pilaLiteral.remove(pilaLiteral.size()-1);
            code3d+="goto " + obtenerIdBloque("else")+ "\n";
        }
        
    
    }
    
    
    public void gotDoWhile(String endBloque){
        if(activo){
               code3d+="if "+pilaLiteral.get(pilaLiteral.size()-1).getTn() + " goto "+ endBloque  + "\n";
            pilaLiteral.remove(pilaLiteral.size()-1);
            code3d+="goto " + "end_"+ endBloque + "\n";
        }
        
    }
    
    
    public void gotoWhile(String endBloque){
        if(activo){
            code3d+="if "+pilaLiteral.get(pilaLiteral.size()-1).getTn() + " goto "+ "ciclo_"+endBloque   + "\n";
            pilaLiteral.remove(pilaLiteral.size()-1);
            code3d+="goto " + "end_"+ endBloque + "\n";
            code3d+= "ciclo_"+endBloque + ":" + "\n";
        }
        
    } 
    
    public void gotoUp(String bloque){
        if(activo){
             code3d+="goto "+bloque+ ":" + "\n";
        }
       
    }
    
    
    public void stamet1For(){
         if(activo){
            String nuevoID = obtenerIdBloque("dec_for");
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(nuevoID);
            temp.add(current_Label);
            tablaEtiquetas.add(temp);
            code3d+=nuevoID+ ":" + "\n";
            //current_Label=nuevoID;
        } 
    }
    

    
    public void stament2For(){
        if(activo){
            String nuevoID = obtenerIdBloque("cond");
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(nuevoID);
            temp.add(current_Label);
            tablaEtiquetas.add(temp);
            code3d+=nuevoID+ ":" + "\n";
        } 
    }
    
   public void stament2For_aux(){
       if(activo){
            code3d+="ifFalse "+pilaLiteral.get(pilaLiteral.size()-1).getTn() + " goto "+ "end_"+ current_Label   + "\n";
       }
    }
   
    public void guardarStamentFor(){
        if(activo){
           pilaCode3d.add(code3d);
           code3d="";
           
        }   
   }
   
   public void guardarStamentFor_aux(){
       if(activo){
           pilaForStaments.add(code3d);
           code3d = pilaCode3d.get(pilaCode3d.size()-1);
           pilaCode3d.remove(pilaCode3d.size()-1);
           //pilaForStaments.add
                   
       }
   }
   
    public void finFor(){
       if(activo){
           code3d+= "aumento_"+current_Label + ":" + "\n";
           code3d+= pilaForStaments.get(pilaForStaments.size()-1);
           pilaForStaments.remove(pilaForStaments.size()-1);
           code3d+="goto "+ current_Label   + "\n";
           endEstrcutura(current_Label);
            
       }
    }
    
    
    public void initswitch(){
        if(activo){
            pilaCase.add(pilaLiteral.get(pilaLiteral.size()-1).getTn());
            pilaLiteral.remove(pilaLiteral.size()-1);
        } 
    }
    
    public void caseStatment(String tipo){
        if(activo){
            String nuevoID = obtenerIdBloque(tipo);
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(nuevoID);
            temp.add(current_Label);
            tablaEtiquetas.add(temp);
            code3d+=nuevoID+ ":" + "\n";            
            pilaCase.add(nuevoID);
        } 
    }
    
    public void condCaseStament(){
         if(activo){
            code3d+="ifFalse "+pilaLiteral.get(pilaLiteral.size()-1).getTn() + "==" + pilaCase.get(pilaCase.size()-2) + " goto "+ "end_"+ pilaCase.get(pilaCase.size()-1)   + "\n";
            pilaLiteral.remove(pilaLiteral.size()-1);
        } 
    }
    
    public void endcaseStatment(){
        if(activo){
           code3d+="goto " + "end_"+ current_Label + "\n";
           String casestring = pilaCase.get(pilaCase.size()-1);
           pilaCase.remove(pilaCase.size()-1);
           endEstrcutura(casestring);
        } 
    }
    
    
    public void escribir(){
        if(activo){
            String inpila=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);
            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,inpila,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";

            String print= "param "+ left.getTn();
            code3d+=print + "\n";

            String t2="t"+contadorLabel_block;
            contadorLabel_block+=1;
            String cargafunc= "call print 1 " ; 
            cuadruplos left2= new cuadruplos(t2,cargafunc,current_Label);
            tablaSimbolos.add(left2);
            code3d+=left2.getLine() + "\n";
        }
        
    }
    
    public void leer(String idvar){
        if(activo){
            cuadruplos left= new cuadruplos(idvar,"0",current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";

            String t2="t"+contadorLabel_block;
            contadorLabel_block+=1;
            String cargafunc= "call input" ; 
            cuadruplos left2= new cuadruplos(t2,cargafunc,current_Label);
            tablaSimbolos.add(left2);
            code3d+=left2.getLine() + "\n";


            cuadruplos left3= new cuadruplos(idvar,left2.getTn(),current_Label);
            tablaSimbolos.add(left3);
            code3d+=left3.getLine() + "\n";
        }
        
    }
    
    
    public void retornar(){
        if(activo){
            String inpila=pilaLiteral.get(pilaLiteral.size()-1).getTn();
            pilaLiteral.remove(pilaLiteral.size()-1);
            String t="t"+contadorLabel_block;
            contadorLabel_block+=1;
            cuadruplos left= new cuadruplos(t,inpila,current_Label);
            tablaSimbolos.add(left);
            code3d+=left.getLine() + "\n";

            String print= "return "+ left.getTn();
            code3d+=print + "\n";
        }
        
    }
    
    
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