
package Codigo;
import java_cup.runtime.symbol;
%%
%class LexerCup
%type java_cup.runtime.symbol
%cup
%full
%line
%char

letras=[a-zA-Z_]+
digitos=[0-9]+
carac_espaciado= [ \t \r \n]+
simbolos=[^a-zA-Z_0-9\n]

espacio=[ ]+
simbolo_string=[\"]
simbolo_decimal=[.]

simbolo_cometario_l=[@]
simbolo_cometario_a=[@*]
simbolo_cometario_c=[*@]

salto_linea=[\n]


%{
    private Symbol(int type, Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }

    private Symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
%}
%%
{carac_espaciado} {/*Ignore*/}
"#" {return new Symbol(sys.Delimitador, yychar, yyline, yytext());}
"{" {return new Symbol(sys.Llave_a, yychar, yyline, yytext());}
"}" {return new Symbol(sys.Lave_c, yychar, yyline, yytext());}
"@" {return new Symbol(sys.Comentario_l, yychar, yyline, yytext());}
"@*" {return new Symbol(sys.Comentario_b_a, yychar, yyline, yytext());}
"*@" {return new Symbol(sys.Comentario_b_c, yychar, yyline, yytext());}
"=" {return new Symbol(sys.Asignacion, yychar, yyline, yytext());}
"main" {return new Symbol(sys.Main, yychar, yyline, yytext());}
"return" {return new Symbol(sys.Return, yychar, yyline, yytext());}
"input" {return new Symbol(sys.Input, yychar, yyline, yytext());}
">>" {return new Symbol(sys.Simbolo_input, yychar, yyline, yytext());}
"print" {return new Symbol(sys.Print, yychar, yyline, yytext());}
/*
"-" {return new Symbol(sys.Resta, yychar, yyline, yytext());}
*/
"null" {return new Symbol(sys.Null, yychar, yyline, yytext());}

"“" {return new Symbol(sys.String_a, yychar, yyline, yytext());}
"”" {return new Symbol(sys.String_c, yychar, yyline, yytext());}
"'" {return new Symbol(sys.Char, yychar, yyline, yytext());}

"[" {return new Symbol(sys.Corchete_a, yychar, yyline, yytext());}
"]" {return new Symbol(sys.Corchete_c, yychar, yyline, yytext());}
"(" {return new Symbol(sys.Parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sys.Parentesis_b, yychar, yyline, yytext());}
"," {return new Symbol(sys.Coma, yychar, yyline, yytext());}
"true" {return new Symbol(sys.True, yychar, yyline, yytext());}
"false" {return new Symbol(sys.False, yychar, yyline, yytext());}
"if" {return new Symbol(sys.If, yychar, yyline, yytext());}
"else" {return new Symbol(sys.Else, yychar, yyline, yytext());}
"do" {return new Symbol(sys.Do, yychar, yyline, yytext());}
"while" {return new Symbol(sys.While, yychar, yyline, yytext());}
"switch" {return new Symbol(sys.Switch, yychar, yyline, yytext());}
"case" {return new Symbol(sys.Case, yychar, yyline, yytext());}
"break" {return new Symbol(sys.Break, yychar, yyline, yytext());}
"default" {return new Symbol(sys.Default, yychar, yyline, yytext());}
":" {return new Symbol(sys.Dos_puntos, yychar, yyline, yytext());}
"+" {return new Symbol(sys.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sys.Resta, yychar, yyline, yytext());}
"/" {return new Symbol(sys.Division, yychar, yyline, yytext());}
"*" {return new Symbol(sys.Multiplicacion, yychar, yyline, yytext());}
"^" {return new Symbol(sys.Potencia, yychar, yyline, yytext());}
"%" {return new Symbol(sys.Modulo, yychar, yyline, yytext());}
"++" {return new Symbol(sys.Unario_positivo, yychar, yyline, yytext());}
"--" {return new Symbol(sys.Unario_negatico, yychar, yyline, yytext());}

"<" {return new Symbol(sys.Menor, yychar, yyline, yytext());}
">" {return new Symbol(sys.Mayo, yychar, yyline, yytext());}
"==" {return new Symbol(sys.Igual, yychar, yyline, yytext());}
"!=" {return new Symbol(sys.Diferente, yychar, yyline, yytext());}
"<=" {return new Symbol(sys.Menor_igual, yychar, yyline, yytext());}
">=" {return new Symbol(sys.Mayor_igual, yychar, yyline, yytext());}

"&" {return new Symbol(sys.Conjuncion, yychar, yyline, yytext());}
"|" {return new Symbol(sys.Disyuncion, yychar, yyline, yytext());}
"!" {return new Symbol(sys.Negacion, yychar, yyline, yytext());}


"int" {return new Symbol(sys.T_int, yychar, yyline, yytext());}
"float" {return new Symbol(sys.T_float, yychar, yyline, yytext());}
"bool" {return new Symbol(sys.T_bool, yychar, yyline, yytext());}
"char" {return new Symbol(sys.T_char, yychar, yyline, yytext());}
"string" {return new Symbol(sys.T_string, yychar, yyline, yytext());}
    /*"array" {return new Symbol(sys.T_array, yychar, yyline, yytext());}*/
"void" {return new Symbol(sys.T_void, yychar, yyline, yytext());}


{simbolo_cometario_l}({letras}|{digitos}|{simbolos}|{espacio})*  {return new Symbol(sys.Comentario, yychar, yyline, yytext());}
{simbolo_cometario_a}({letras}|{digitos}|{simbolos}|{espacio}|{salto_linea})* {return new Symbol(sys.Comentario, yychar, yyline, yytext());}

{letras}({letras}|{digitos})* {return new Symbol(sys.Identificador, yychar, yyline, yytext());}

{digitos} {return new Symbol(sys.Int, yychar, yyline, yytext());}
{digitos}{simbolo_decimal}{digitos} {return new Symbol(sys.Float, yychar, yyline, yytext());}
{simbolo_string}({letras}|{digitos}|{simbolos}|{espacio})*{simbolo_string}  {return new Symbol(sys.String, yychar, yyline, yytext());}




 . {return new Symbol(sys.Error, yychar, yyline, yytext());} /*retorna un error en cualquier otro caso*/