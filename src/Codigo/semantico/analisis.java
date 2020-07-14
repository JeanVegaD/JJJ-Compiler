package Codigo.semantico;
import java.util.ArrayList; // import the ArrayList class

public class analisis {
    
    private ArrayList<ArrayList<String>> tablaSimbolos = new ArrayList<ArrayList<String>>();
    //Estructura 
    //ID    TIPO    BLOQUE_PADRE    AUX     INCIALIZACION
    
    private ArrayList<ArrayList<String>> tablaBloques = new ArrayList<ArrayList<String>>();
    //Estructura 
    //ID    TIPO    BLOQUE_PADRE    AUX     RETURN
    
    
    //temporales 
    private String currentBlock="";
    private ArrayList<ArrayList<String>> tablaSimbolosActual = new ArrayList<ArrayList<String>>();
    private String temp_type;
    
    //private ArrayList<String> tipos_param_func_temp = new ArrayList<String>();
   
    
    public void  analisis(){
        tablaSimbolos=null;
        tablaBloques=null;

        
    }
    

    /*
    * Imprime la tabla con formato 
    */
    public void imprimir_tabla(ArrayList<ArrayList<String>> tabla){
        System.out.println("===============");
        for (int i = 0; i < tabla.size(); i++) {
            System.out.println(tabla.get(i).get(0) + "\t\t" + tabla.get(i).get(1)+ "\t\t" +tabla.get(i).get(2));
         }
        System.out.println("===============");
    }
    
    
    
    /**
     * E: ID_del simbolo padre_del_simbolo
     * S: True si encuentra el id en la tabla de simbolos
     */
    public boolean buscar_id_simbolos(String identificador, String padre,ArrayList<ArrayList<String>> tablaBusqueda){
        if(tablaBusqueda!=null){
            boolean flag=false;
            for (int i = 0; i < tablaBusqueda.size(); i++) {
                if(tablaBusqueda.get(i).get(0).equals(identificador) 
                        && tablaBusqueda.get(i).get(2).equals(padre)){
                    flag=true;
                    break;
                }
             }
            return flag;
        }
        else{
            return false;
        }
    }
    
    
    /**
     * E: ID_del simbolo padre_del_bloque
     * S: True si encuentra el id en la tabla de bloques
     */
    public boolean buscar_id_bloques(String identificador, String padre){
        if(tablaBloques!=null){
            boolean flag=false;
            for (int i = 0; i < tablaBloques.size(); i++) {
                if(tablaBloques.get(i).get(0).equals(identificador) 
                        && tablaBloques.get(i).get(2).equals(padre)){
                    flag=true;
                    break;
                }
             }
            return flag;
        }
        else{
            return false;
        }
    }
    
    /*
    * Obtiene el tipo de varaible segun identificador
    */
 
    public String get_tipo_var(String id){
        String res="null";
        for (int i = 0; i < tablaSimbolosActual.size(); i++) {
            if(tablaSimbolosActual.get(i).get(0).equals(id)){
                res= tablaSimbolosActual.get(i).get(1);
            }
        }
        return res;
    }
        
    /*
    * Obtiene el tipo de funcion segun identificador
    */
    public String get_tipo_func(String id){
        String res="null";
        for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(id) && tablaBloques.get(i).get(2).equals("root")){
                res= tablaBloques.get(i).get(1);
            }
        }
        return res;
    }
    
    
    
    /*
    * Establece el bloque actual en que se encnuntra la declaracion
    */
    public void set_id_current_block(String id){
        currentBlock=id;
        if(!currentBlock.equals("null")){
            get_current_symbol_table();
        }
        System.out.println("Estoy en el bloque: "+ id);
        
    }
    
    public String get_parent_block(String id){
        String res="";
        if(tablaBloques.size()>0){
            for (int i = 0; i < tablaBloques.size(); i++) {
                if(tablaBloques.get(i).get(0).equals(id)){
                    res= tablaBloques.get(i).get(2);
                    break;
                }
            }
            //System.out.println("Bloclk= "+ id+" padre: " + res);
            return res;

        }else{
            return "root";
        }
    }
   

    
    public void get_current_symbol_table(){
        String tempBlock=currentBlock;
        tablaSimbolosActual.clear();
        do{
            for (int i = 0; i < tablaSimbolos.size(); i++) {
                if(tablaSimbolos.get(i).get(2).equals(tempBlock)){
                    tablaSimbolosActual.add(tablaSimbolos.get(i));
                }
            }
            tempBlock=get_parent_block(tempBlock);
            
        }while(!tempBlock.equals("root"));
            
        
    }
    
    
    
    
    public void dec_main(){
        //System.out.println("Main");
    }
    
    
    /*Establece el temporal de las funciones*/
    public void  set_temp_type(String tipo){
        temp_type=tipo;
        
    }
    
    public boolean dec_func(Object id){
        if(!buscar_id_bloques(id.toString(),"root")){
            ArrayList<String>  temp =  new ArrayList<String>();
            temp.add(id.toString());
            temp.add(temp_type);
            temp.add("root");
            temp.add("func");
            temp.add("false");
            tablaBloques.add(temp);
            System.out.println("Funcion: " + id + " agregada a la tabla de simbolos");
            return true;
        }
        else{
            System.out.println("Funcion: " + id + " ya existe");
            return false;
        }
    }
    
    public void dec_func_aux(Object id,Object tipo){
        if(!currentBlock.equals("null")){
            for (int i = 0; i < tablaBloques.size(); i++) {
                if(tablaBloques.get(i).get(0).equals(id)){
                    tablaBloques.get(i).set(1, tipo.toString());
                    break;
                }
            }
        }
        
        
    }
    
    
    public void set_funcionConReturn(){
       for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(currentBlock) ){
               tablaBloques.get(i).set(4, "true");
                break;
            }
        }
    }
    
    public boolean get_returnFuncion(String id){
        boolean res =false;
        for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(id)){
                if(tablaBloques.get(i).get(4).equals("false") && tablaBloques.get(i).get(1).equals("void")){
                    res=true;
                }
                else if (tablaBloques.get(i).get(4).equals("false")){
                    res=false;
                }
                else{
                    res=true;
                }
                break;
            }
        }
        return res;
    }
    

    /*
    * Funciona que valida la declaracion de funciones con parametros
    */
    public String dec_func_param(Object id,Object parametros){
         String res="";
        if(!currentBlock.equals("null")){
            String[] params = parametros.toString().split(",");
            for (String p : params){
                String[] unit_param = p.split(" ");
                if(!buscar_id_simbolos(unit_param[1],id.toString(),tablaSimbolos)){
                    ArrayList<String>  temp_vars =  new ArrayList<String>();
                    temp_vars.add(unit_param[1]);
                    temp_vars.add(unit_param[0]);
                    temp_vars.add(id.toString());
                    temp_vars.add("param");
                    tablaSimbolos.add(temp_vars);
                }else{
                    res+="El identificador : '"+unit_param[1] + "' ya se encuntra definido \n";

                }
            }
            return res;
        }
        return res;
    }
    
    
    /*Valida la existencia de la funcion dentro del archivo*/
    public String func_call(Object id){
        String res= "";
        if(buscar_id_bloques(id.toString(),"root")){
            if(get_cant_param_func(id.toString())==0){
                return res;
            }else{
                res+= "'" + id.toString() + "' espera "+get_cant_param_func(id.toString())+ " parametros y esta recibiendo "+ 0 + " parametros \n" ;
                return res;
            }
            
         }
        else{
            res+= "El identificador '" + id.toString() + "' no se ha declarado";
             return res;
         }
    }
    
 
    
    /*
    *Obtiene la cantidad de parametros de una funcion
    */
    public int get_cant_param_func(String idFunc){
        int res=0;
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if(tablaSimbolos.get(i).get(2).equals(idFunc) && tablaSimbolos.get(i).get(3).equals("param")){
                res+=1;
            }
        }
        return res;
    }
    
    /*
    *Obtiene los tipos de parametros de una funcion
    */
    public ArrayList<String> get_tipos_param_func(String idFunc){
        ArrayList<String> res =  new ArrayList<>();
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if(tablaSimbolos.get(i).get(2).equals(idFunc) && tablaSimbolos.get(i).get(3).equals("param")){
                res.add(tablaSimbolos.get(i).get(1));
            }
        }
       
        return res;
    }
    
    
    /*Valida la existencia de la funcion junto con sus parametros*/
    
    
    /***************************************FALTA POR TERMIANR************************************************/
    
    
    public String func_call_params(Object id, Object parametros){
        //imprimir_tabla(tablaBloques);
        String res= "";
         if(buscar_id_bloques(id.toString(),"root")){
            String[] params = parametros.toString().split(",");
            ArrayList<String> tipos_param_func_temp =  new ArrayList<String>();
            for (int i = 0; i < params.length; i++){
                String[] p_t = params[i].split(" ");
                tipos_param_func_temp.add(p_t[0]);
            }
 
            if(get_cant_param_func(id.toString())!=params.length){
                res+= "'" + id.toString() + "' espera "+get_cant_param_func(id.toString())+ " parametros y esta recibiendo "+params.length + " parametros \n" ;
            }
            
            ArrayList<String> prueba= get_tipos_param_func(id.toString());
            if(!prueba.equals(tipos_param_func_temp)){
                res+= "Los argumentos no coinciden con la función: '" + id.toString();
            }

            //System.out.println("funcion recibe: "+ prueba);
            //System.out.println("funcion envia: "+ tipos_param_func_temp);
            //tipos_param_func_temp.clear();
            return res;
         }
         else{
              res+= "El identificador '" + id.toString() + "' no se ha declarado";
              return res;
         }
    }
    /**********************************************************************************************************/
    
    
    /* Añade un tipo de parametro a la lista temporal*/
   /* public void add_param_type_temp(String type){
        tipos_param_func_temp.add(type);
    }*/
    
    
    
    public boolean existeVariable_aux(String identificador,ArrayList<ArrayList<String>> tablaBusqueda){
        if(tablaBusqueda!=null){
            boolean flag=false;
            for (int i = 0; i < tablaBusqueda.size(); i++) {
                if(tablaBusqueda.get(i).get(0).equals(identificador) ){
                    flag=true;
                    break;
                }
             }
            return flag;
        }
        else{
            return false;
        }
    }
    /*Verifica si la variable ingresada pertenece al bloque*/
    public boolean existeVariable(String id){
        return existeVariable_aux(id,tablaSimbolosActual);
    }

    /*crea una nueva variable*/
    public void setVar(String id, String tipo){
        ArrayList<String>  temp_vars =  new ArrayList<String>();
        temp_vars.add(id);
        temp_vars.add(tipo);
        temp_vars.add(currentBlock);
        temp_vars.add("var");
        temp_vars.add("true");
        tablaSimbolos.add(temp_vars);
        System.out.println("Varaiable: "+id+" creada");
        get_current_symbol_table();
        
    } 
    
     /*crea una nueva variable sin inicializar*/
    public void setVar_Aux(String id, String tipo){
        ArrayList<String>  temp_vars =  new ArrayList<String>();
        temp_vars.add(id);
        temp_vars.add(tipo);
        temp_vars.add(currentBlock);
        temp_vars.add("var");
        temp_vars.add("false");
        tablaSimbolos.add(temp_vars);
        System.out.println("Varaiable: "+id+" creada");
        get_current_symbol_table();
        
    }
    
     /*Inicializa una variable*/
    public void init_var(String id){
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if(tablaSimbolos.get(i).get(0).equals(id) && tablaSimbolos.get(i).get(2).equals(currentBlock)){
                tablaSimbolos.get(i).set(4, "true");
            }
        }
    }
    
     /*verifica si la variable esta inicializada*/
    public String var_inicializada(String id){
        String res="";
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if(tablaSimbolos.get(i).get(0).equals(id)){
                res= tablaSimbolos.get(i).get(4);
            }
        }
        return res;
    }
     
    /*creaun nuevo bloque*/
    public void new_block(String id){
        String nuevoID =  obtenerIdBloque(id);
        ArrayList<String>  temp =  new ArrayList<String>();
        temp.add(nuevoID);
        temp.add("");
        temp.add(currentBlock);
        temp.add(id);
        tablaBloques.add(temp);
        System.out.println("bloque: " + nuevoID + " agregada a la tabla de simbolos");
        set_id_current_block(nuevoID);
        
    }
    
    public void new_block_aux(String id,String tipo){
        String nuevoID =  obtenerIdBloque(id);
        ArrayList<String>  temp =  new ArrayList<String>();
        temp.add(nuevoID);
        temp.add(tipo);
        temp.add(currentBlock);
        temp.add(id);
        tablaBloques.add(temp);
        System.out.println("bloque: " + nuevoID + " agregada a la tabla de simbolos");
        set_id_current_block(nuevoID);
    }
    
    public void backBlock(){
        for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(currentBlock)){
                set_id_current_block(tablaBloques.get(i).get(2));
                break;
            }
        }
    }
    
    public String get_tipo_currentBlock(){
        String res="";
        for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(currentBlock)){
                res=tablaBloques.get(i).get(1);
                break;
            }
        }
        return res;
        
    }
    
    
    public boolean existeBloque(String n_boque){
        boolean res=false;
        for (int i = 0; i < tablaBloques.size(); i++) {
            if(tablaBloques.get(i).get(0).equals(n_boque)){
                res=true;
                break;
            }
        }
        return res;
    }
    
    
    public String obtenerIdBloque(String n_boque){
        String temp= currentBlock+"_"+n_boque;
        int n=0;
        String compare= currentBlock+"_"+n_boque+n;
        while(existeBloque(compare)){
            n+=1;
            compare=temp + n;
            
        }
        return temp+n;
    }
    
    
   
}
