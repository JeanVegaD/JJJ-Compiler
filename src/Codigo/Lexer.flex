package Codigo;
import static Codigo.Tokens.*;
%%
%class Lexer
%type Tokens

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
simbolo_string=[\"]

STRING [a-zA-Z_ ]+

%{
    public String lexemas;
%}
%%
{espacio} {/*Ignore*/}
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
"array" {lexemas=yytext(); return RESERVADA;}
"void" {lexemas=yytext(); return RESERVADA;}


{L}({L}|{D})* {lexemas=yytext(); return IDENTIFICADOR;}
{simbolo_string}{L}({L}|{D})* {simbolo_string}  {lexemas=yytext(); return LITERAL;}





 . {return ERROR;} /*retorna un error en cualquier otro caso*/