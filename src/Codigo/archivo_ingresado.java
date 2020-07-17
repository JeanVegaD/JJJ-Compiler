/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java_cup.runtime.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


//Clase encargada de manejer la todo el contenido del archivo ingresado
public class archivo_ingresado {
    private File archivo;
    private String nombre;
    private String data;
    private String tokens_archivo;
   
    
    private static String htmlConfig = "<style> "
            + ".textoNormal{"
            + "color:#fafafa;"
            + "font-family: Arial, Helvetica, sans-serif;"
            + "}"
            + ".textoVerde{"
            + "color:#27C93F;"
            + "font-family: Arial, Helvetica, sans-serif;"
            + "}"
            + ".textoRojo{"
            + "color:#f44336;"
            + "font-family: Arial, Helvetica, sans-serif;"
            + "}"
            + "</style>";
    
    private String reporte_consola = "";
    private static String reporte_errores = "";
    private static boolean errores = false;
    
    
    
    public archivo_ingresado(){
        
    }
    
    /*
    E:Archivo seleccioando en el JFileChooser
    S:Void
    R:No aplica
    
    Se encarga de establecer todos los campos necesarios para el funcionamiento de la clase
    */
    public void set_Archivo(JFileChooser file){
        this.archivo=file.getSelectedFile();
        this.nombre=this.archivo.getName();
        this.data=file_to_String(this.archivo.getPath());
    }
    
    
    /*
    E:String con la direccion del archivo
    S:String con el contenido del archivo
    R:Debe ingresar una ruta valida
    
   |Se encarga en obtener el texto del archivo y tranformarlo en una variable de tipo string
    */
   private String file_to_String(String path)
  { 
       String data = "";
        try {
           
            data = new String(Files.readAllBytes(Paths.get(path))); 
            
        } catch (IOException ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
  } 
    
   
   /*
    E:No aplica
    S:No aplica
    R:Se debe ejecutar esta funcion antes de correr el programa
    
    Se encarga de generar la clase Lexer.java necesaria para el reconocmiento de tokens 
    */
   public void generar(String ruta1, String ruta2, String[] rutaS){
       //String rutaLexer="src/Codigo/Lexer.flex";
       File archivoLexer;
       archivoLexer= new File(ruta1);
       JFlex.Main.generate(archivoLexer);
       archivoLexer= new File(ruta2);
       JFlex.Main.generate(archivoLexer);
        try {
            java_cup.Main.main(rutaS);
        } catch (IOException ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Path rutaSyms = Paths.get("src/Codigo/sym.java");
        Path rutaSyntax = Paths.get("src/Codigo/Sintax.java");
        if(Files.exists(rutaSyms)){
           try {
               Files.delete(rutaSyms);
           } catch (IOException ex) {
               Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        if(Files.exists(rutaSyntax)){
           try {
               Files.delete(rutaSyntax);
           } catch (IOException ex) {
               Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        try {
            Files.move(Paths.get(System.getProperty("user.dir")+ "/sym.java"), Paths.get("src/Codigo/sym.java"));
            Files.move(Paths.get(System.getProperty("user.dir")+  "/Sintax.java"), Paths.get("src/Codigo/Sintax.java"));
        } catch (IOException ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       reporte_consola+= "<h3 class='textoNormal'>Se han generado los siguientes archivos: </h3>"
               + "<ul class='textoNormal'>\n" +
                "  <li>Lexer.java</li>\n" +
                "  <li>LexerCup.java</li>\n" +
                "  <li>Sintax.java</li>\n" +
                "  <li>sym.java.java</li>\n" +
                "</ul>"; ;

   }
   
   
   /*
    E:Ruta de un archivo de texto
    S:String con los tokens encontrados en el archivo rencocidos por la gramatica 
    R:No aplica
    
    Se encarga de reconocer los tokens presentes en el archivo mediante la clase Lexer.java que se creoo 
    */
   public void analizarTokens(){
       
        try {
            Reader lector = new BufferedReader(new FileReader(this.archivo.getPath()));
            Lexer lexer = new Lexer(lector);
            String resuladoLexer="";
            while(true){
                Tokens toks = lexer.yylex();
                if(toks==null){
                    this.tokens_archivo=resuladoLexer;
                    reporte_consola+= "<h2 class='textoVerde'> Análisis léxico realizado </h2>";
                    return;
                }
                switch(toks){
                    case ERROR:
                        resuladoLexer += "["+ lexer.lexemas +  "," +"Token no recnocido] \n";
                        break;
                    default:
                        resuladoLexer +="[" + lexer.lexemas +  ","+ toks + "]\n";
                        break;
                }
            }  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
            reporte_consola+= "<h3 class='textoRojo'>ERROR: Análisis léxico NO realizado </h3>";
        } catch (IOException ex) {
            reporte_consola+= "<h3 class='textoRojo'>ERROR: Análisis léxico NO realizado </h3>";
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
        
   
   /*
    E:String con los tokens analizados
    S:Archivo de texto 
    R:No aplica
    
    Se encarga de crear un arhcivo txt con los tokens analizados
    */
   public void escribirTokensArchivo(){
       FileWriter myWriter;
        try {
            myWriter = new FileWriter("src/txtFiles/tokens/tokens_"+ archivo.getName().substring(0, archivo.getName().lastIndexOf('.')) + ".txt" );
            myWriter.write(this.tokens_archivo);
            myWriter.close();
            reporte_consola+= "<h3 class='textoNormal'>Se ha generado el archivo con los tokens</h3>";
        } catch (IOException ex) {
            reporte_consola+= "<h3 class='textoRojo'>ERROR: NO se ha generado el archivo con los tokens  </h3>";
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }
   
   
  
   
   /*
    E:Ruta de un archivo de texto
    S:String con los tokens encontrados en el archivo rencocidos por la gramatica 
    R:No aplica
    
    Se encarga de reconocer los tokens presentes en el archivo mediante la clase Lexer.java que se creoo 
    */
   public void analizarSintax(){
       
        try {
            Reader lector = new BufferedReader(new FileReader(this.archivo.getPath()));
            Sintax sin = new Sintax(new Codigo.LexerCup(lector));
            try {
                sin.parse();
                reporte_consola+= "<h2 class='textoVerde'> Análisis sintáctico realizado </h2>";
                reporte_consola+= "<h2 class='textoVerde'> Análisis semántico realizado </h2>";
                resultadoCompilacion();
                reporte_consola += reporte_errores;
                reporte_consola += "<br> <br>";
                
            } catch (Exception ex) {
                //Symbol sym = sin.getS();
                //if(sym.value == null){flag = false;}
                //reporte_consola += ("X Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"\n");
                //System.err.println("Error al analizar codigo");
                //Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
            reporte_consola+= "<h3 class='textoRojo'> ERROR: Análisis sintáctico NO realizado </h3>";
        } catch (IOException ex) {
            reporte_consola+= "<h3 class='textoRojo'> ERROR: Análisis sintáctico NO realizado </h3>";
            Logger.getLogger(archivo_ingresado.class.getName()).log(Level.SEVERE, null, ex);
        }
              
   }
   
   
   /*
    E:String con los errores encontrados 
    S:Reportar errores en consola 
    R:No aplica
    */
   public static  void reportarError(String tipo, int columna, int linea, Object valor){
       errores=true;
       reporte_errores += "<p class='textoRojo'> <b>Error "+tipo+ "</b>:  "
               + " línea: " + linea +","
               + " columna: "+columna +","
               + " cerca de: "+valor
               + "</p>";
   }
   
   /*
    E:String con los errores encontrados 
    S:Reportar errores en consola 
    R:No aplica
    */
   public static  void reportarError_Semantico(String tipo, int columna, int linea,String info){
       errores=true;
       reporte_errores += "<p class='textoRojo'> <b>Error "+tipo+ "</b>:  "
               + " línea: " + linea +","
               + " columna: "+columna +","
               + " informacion: "+info 
               + "</p>";
   }
   
   
   /*
    E:ninguna
    S:Indica el estado de la compilacion
    R:No aplica
    */
   public void resultadoCompilacion(){
       if(!errores){
           reporte_errores += "<h2 class='textoVerde'>Compilacíon completada</h2>";
       }
       else{
           reporte_errores += "<h2 class='textoRojo'>Fallo al compilar</h2>";
       }
   }
   
   
   public void limpiarConsola(){
        errores=false;
        reporte_errores="";
        reporte_consola="";
        reporte_consola+=htmlConfig;
        reporte_consola+= "<h1 class='textoNormal'>Compilación iniciada</h1>";
   }
   
   
    /*
    E:No aplica
    S:String con el nombre del archivo
    R:No aplica
    */
    public String get_Nombre_Archivo(){
        return this.nombre;
    }
    
    /*
    E:No aplica
    S:String con el el contenido del archivo
    R:No aplica
    */
    public String get_Data(){
        return this.data;
    }
    
    /*
    E:No aplica
    S:String con los tokens encontrados
    R:No aplica
    */
    public String get_Tokens(){
        return this.tokens_archivo;
    }
    
    
    /*
    E:No aplica
    S:String con el reporte de la consola
    R:No aplica
    */
    public String get_reporteConsola(){
        
        return this.reporte_consola;
        
    }
    
    
    
}