package Codigo;
import static Codigo.Tokens.*;
%%
%class Lexer
%type Tokens

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
int= ({simboloNegativo}? {digLim}{dígitos}*) | 0
float = {simboloNegativo}? {int}"."{dígitos}*


%{
    public String lexemas;
%}
%%


{saltoLinea} {/**/}
{carac_espaciado} {/*Ignore*/}
"#" {lexemas=yytext(); return DELIMITADOR;}
"{" {lexemas=yytext(); return TERMINAL;}
"}" {lexemas=yytext(); return TERMINAL;}


"=" {lexemas=yytext(); return ASIGNACION;}
"main" {lexemas=yytext(); return RESERVADA;}
"return" {lexemas=yytext(); return RESERVADA;}
"input" {lexemas=yytext(); return RESERVADA;}
">>" {lexemas=yytext(); return TERMINAL;}
"print" {lexemas=yytext(); return RESERVADA;}

"null" {lexemas=yytext(); return RESERVADA;}


"[" {lexemas=yytext(); return TERMINAL;}
"]" {lexemas=yytext(); return TERMINAL;}
"(" {lexemas=yytext(); return TERMINAL;}
")" {lexemas=yytext(); return TERMINAL;}
"," {lexemas=yytext(); return TERMINAL;}
"true" {lexemas=yytext(); return RESERVADA;}
"false" {lexemas=yytext(); return RESERVADA;}
"if" {lexemas=yytext(); return RESERVADA;}
"else" {lexemas=yytext(); return RESERVADA;}
"do" {lexemas=yytext(); return RESERVADA;}
"while" {lexemas=yytext(); return RESERVADA;}
"switch" {lexemas=yytext(); return RESERVADA;}
"case" {lexemas=yytext(); return RESERVADA;}
"break" {lexemas=yytext(); return RESERVADA;}
"default" {lexemas=yytext(); return RESERVADA;}
":" {lexemas=yytext(); return TERMINAL;}
"+" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"-" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"/" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"*" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"^" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"%" {lexemas=yytext(); return OPERADOR_ARITMETICO;}
"++" {lexemas=yytext(); return OPERADOR_UNARIO;}
"--" {lexemas=yytext(); return OPERADOR_UNARIO;}

"<" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
">" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
"==" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
"!=" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
"<=" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
">=" {lexemas=yytext(); return OPERADOR_RELACIONAL;}

"&" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
"|" {lexemas=yytext(); return OPERADOR_RELACIONAL;}
"!" {lexemas=yytext(); return OPERADOR_RELACIONAL;}

"int" {lexemas=yytext(); return RESERVADA;}
"float" {lexemas=yytext(); return RESERVADA;}
"bool" {lexemas=yytext(); return RESERVADA;}
"char" {lexemas=yytext(); return RESERVADA;}
"string" {lexemas=yytext(); return RESERVADA;}
"void" {lexemas=yytext(); return RESERVADA;}


{identificador} {lexemas=yytext(); return IDENTIFICADOR;}
{string} {lexemas=yytext(); return LITERAL;}
{character} {lexemas=yytext(); return LITERAL;}
{comentario_bloque} {lexemas=yytext(); return COMENTARIO;}
{comentario_linea} {lexemas=yytext(); return COMENTARIO;}

{int} {lexemas=yytext(); return LITERAL;}
{float} {lexemas=yytext(); return LITERAL;}


. {return ERROR;} /*retorna un error en cualquier otro caso*/