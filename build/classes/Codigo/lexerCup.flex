
package Codigo;
import java_cup.runtime.symbol;
%%
%class LexerCup
%type java_cup.runtime.symbol
%cup
%full
%line
%char

carac_espaciado= [ \t \r]+
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
    private Symbol(int type, Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }

    private Symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
%}
%%
{saltoLinea} {/**/}
{carac_espaciado} {/*Ignore*/}
"#" {return new Symbol(sys.Delimitador, yychar, yyline, yytext());}
"{" {return new Symbol(sys.Llave_a, yychar, yyline, yytext());}
"}" {return new Symbol(sys.LLave_c, yychar, yyline, yytext());}

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
"'" {return new Symbol(sys.Char, yychar, yyline, yytext());}
"[" {return new Symbol(sys.Corchete_a, yychar, yyline, yytext());}
"]" {return new Symbol(sys.Corchete_c, yychar, yyline, yytext());}
"(" {return new Symbol(sys.Parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sys.Parentesis_c, yychar, yyline, yytext());}
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
">" {return new Symbol(sys.Mayor, yychar, yyline, yytext());}
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
"void" {return new Symbol(sys.T_void, yychar, yyline, yytext());}
"StringToInt" {return new Symbol(sys.String_to_int, yychar, yyline, yytext());}

{identificador} {return new Symbol(sys.Identificador, yychar, yyline, yytext());}
{string} {return new Symbol(sys.String, yychar, yyline, yytext());}
{character} {return new Symbol(sys.Character, yychar, yyline, yytext());}
{comentario_bloque} {eturn new Symbol(sys.Comentario, yychar, yyline, yytext());}
{comentario_linea} {eturn new Symbol(sys.Comentario, yychar, yyline, yytext());}


{int} {return new Symbol(sys.Int, yychar, yyline, yytext());}
{float} {return new Symbol(sys.Float, yychar, yyline, yytext());}

 . {return new Symbol(sys.Error, yychar, yyline, yytext());} /*retorna un error en cualquier otro caso*/