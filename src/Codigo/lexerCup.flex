
package Codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

carac_espaciado=[ \t\r\n]*
saltoLinea=[\n]

letras=[a-zA-Z]+
cero= 0
dígitos = [0-9]
digLim = [1-9]


caracteres_string = [^\n\"]+
caracteres_Char = [a-zA-Z]
caracteres_comentario_linea=[^\n]+
caracteres_comentario_bloque= [^(\*@)]+
simboloString=[\"]
simboloChar=[\']
simboloNegativo=[\-]


identificador= ("_" | {letras})("_"| {letras} | {dígitos})*
string= {simboloString}{caracteres_string}{simboloString}
character = {simboloChar} {caracteres_Char} {simboloChar}

comentario_bloque = "@*"{caracteres_comentario_bloque}"*@"
comentario_linea = "@"{caracteres_comentario_linea}{saltoLinea}
int= ({simboloNegativo}? {digLim}{dígitos}*) | {cero}
float = {simboloNegativo}? {int}"."{dígitos}*


%{
    private Symbol symbol(int type, Object value){
        /*System.out.println("Analizo: " + value);*/
        return new Symbol(type,yyline,yycolumn,value);
    }

    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
%}
%%


{saltoLinea} {/**/}
{carac_espaciado} {/*Ignore*/}

"#" {return new Symbol(sym.Delimitador, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

"=" {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
"return" {return new Symbol(sym.Return, yychar, yyline, yytext());}
"input" {return new Symbol(sym.Input, yychar, yyline, yytext());}
">>" {return new Symbol(sym.Simbolo_input, yychar, yyline, yytext());}
"print" {return new Symbol(sym.Print, yychar, yyline, yytext());}
/*
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
*/
"null" {return new Symbol(sym.Null, yychar, yyline, yytext());}
/*"'" {return new Symbol(sym.Char, yychar, yyline, yytext());}*/
"[" {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
"]" {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
(",") {return new Symbol(sym.Coma, yychar, yyline, yytext());}
"true" {return new Symbol(sym.True, yychar, yyline, yytext());}
"false" {return new Symbol(sym.False, yychar, yyline, yytext());}
"if" {return new Symbol(sym.If, yychar, yyline, yytext());}
"else" {return new Symbol(sym.Else, yychar, yyline, yytext());}
"do" {return new Symbol(sym.Do, yychar, yyline, yytext());}
"while" {return new Symbol(sym.While, yychar, yyline, yytext());}
"switch" {return new Symbol(sym.Switch, yychar, yyline, yytext());}
"case" {return new Symbol(sym.Case, yychar, yyline, yytext());}
"break" {return new Symbol(sym.Break, yychar, yyline, yytext());}
"default" {return new Symbol(sym.Default, yychar, yyline, yytext());}
":" {return new Symbol(sym.Dos_puntos, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"^" {return new Symbol(sym.Potencia, yychar, yyline, yytext());}
"%" {return new Symbol(sym.Modulo, yychar, yyline, yytext());}
"++" {return new Symbol(sym.Unario_positivo, yychar, yyline, yytext());}
"--" {return new Symbol(sym.Unario_negatico, yychar, yyline, yytext());}

"<" {return new Symbol(sym.Menor, yychar, yyline, yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
"==" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.Diferente, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.Menor_igual, yychar, yyline, yytext());}
">=" {return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());}

"&" {return new Symbol(sym.Conjuncion, yychar, yyline, yytext());}
"|" {return new Symbol(sym.Disyuncion, yychar, yyline, yytext());}
"!" {return new Symbol(sym.Negacion, yychar, yyline, yytext());}


"int" {return new Symbol(sym.T_int, yychar, yyline, yytext());}
"float" {return new Symbol(sym.T_float, yychar, yyline, yytext());}
"bool" {return new Symbol(sym.T_bool, yychar, yyline, yytext());}
"char" {return new Symbol(sym.T_char, yychar, yyline, yytext());}
"string" {return new Symbol(sym.T_string, yychar, yyline, yytext());}
"void" {return new Symbol(sym.T_void, yychar, yyline, yytext());}
"StringToInt" {return new Symbol(sym.String_to_int, yychar, yyline, yytext());}

{identificador} {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
{string} {return new Symbol(sym.String, yychar, yyline, yytext());}
{character} {return new Symbol(sym.Character, yychar, yyline, yytext());}
{comentario_bloque} {/*ignore*/}
{comentario_linea} {/*ignore*/}


{int} {return new Symbol(sym.Int, yychar, yyline, yytext());}
{float} {return new Symbol(sym.Float, yychar, yyline, yytext());}

 . {return new Symbol(sym.Error, yychar, yyline, yytext());} /*retorna un error en cualquier otro caso*/