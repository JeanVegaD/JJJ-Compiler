package Codigo;
import static Codigo.Tokens.*;
%%
%class Lexer
%type Tokens

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
    public String lexemas;
%}
%%
{carac_espaciado} {/*Ignore*/}
"#" {lexemas=yytext(); return DELIMITADOR;}
"{" {lexemas=yytext(); return TERMINAL;}
"}" {lexemas=yytext(); return TERMINAL;}
"@" {lexemas=yytext(); return TERMINAL;}
"@*" {lexemas=yytext(); return TERMINAL;}
"*@" {lexemas=yytext(); return TERMINAL;}
"=" {lexemas=yytext(); return ASIGNACION;}
"main" {lexemas=yytext(); return RESERVADA;}
"return" {lexemas=yytext(); return RESERVADA;}
"input" {lexemas=yytext(); return RESERVADA;}
">>" {lexemas=yytext(); return TERMINAL;}
"print" {lexemas=yytext(); return RESERVADA;}
/*
"-" {lexemas=yytext(); return TERMINAL;}
*/
"null" {lexemas=yytext(); return RESERVADA;}

"“" {lexemas=yytext(); return TERMINAL;}
"”" {lexemas=yytext(); return TERMINAL;}
"'" {lexemas=yytext(); return TERMINAL;}

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
    /*"array" {lexemas=yytext(); return RESERVADA;}*/
"void" {lexemas=yytext(); return RESERVADA;}


{simbolo_cometario_l}({letras}|{digitos}|{simbolos}|{espacio})*  {lexemas=yytext(); return COMENTARIO;}
{simbolo_cometario_a}({letras}|{digitos}|{simbolos}|{espacio}|{salto_linea})* {simbolo_cometario_c} {lexemas=yytext(); return COMENTARIO;}

{letras}({letras}|{digitos})* {lexemas=yytext(); return IDENTIFICADOR;}
{digitos} {lexemas=yytext(); return LITERAL;}
{digitos}{simbolo_decimal}{digitos} {lexemas=yytext(); return LITERAL;}

{simbolo_string}({letras}|{digitos}|{simbolos}|{espacio})*{simbolo_string}  {lexemas=yytext(); return LITERAL;}




 . {return ERROR;} /*retorna un error en cualquier otro caso*/