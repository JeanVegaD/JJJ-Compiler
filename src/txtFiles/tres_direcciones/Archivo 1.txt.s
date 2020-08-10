.data

.text

.globl main

print:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $v0, 1 
syscall
addi $sp, $sp, 0
lw $t0, 0($sp)
move $ra, $t0
jr $ra

enteros:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1
#Declaracion de variable enteroNor Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1
lw $t1, 0($sp) 
add $t2, $t0, $t1
#Declaracion de variable enteroVar Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
add $t2, $t0, $t1
#Declaracion de variable enteroSum Stack position 4
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
li $t2, 1
add $t3, $t1, $t2
add $t1, $t3, $t0
#Declaracion de variable enteroSum1 Stack position 5
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t0, 2
li $t1, 1
sub $t2, $t0, $t1
#Declaracion de variable enteroRes Stack position 6
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
mul $t0, $t1
#Declaracion de variable enteroMul Stack position 7
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

lw $t2, 0($sp) 
li $t3, 1
add $t4, $t2, $t3
#Declaracion de variable enteroSum2 Stack position 8
sub $sp, $sp, 4 
sw $t4, 0($sp) 

li $t2, 1
li $t3, 1
div $t2, $t3
#Declaracion de variable enteroDiv Stack position 9
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t4, 1
li $t5, 1
#Declaracion de variable enteroPow Stack position 10
sub $sp, $sp, 4 
sw , 0($sp) 

lw $t6, 24($sp) 
lw $t7, 4($sp) 
add , $t6, $t7
#Declaracion de variable enteroCom Stack position 11
sub $sp, $sp, 4 
sw , 0($sp) 

li $t6, 0
move $t7, $t6
add $sp, $sp, 40
lw $t0, 0($sp)
move $v0, $t7
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

flotantes:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1.0
#Declaracion de variable flotanteNor Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1.0
lw $t1, 0($sp) 
add $t2, $t0, $t1
#Declaracion de variable flotanteVar Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
add $t2, $t0, $t1
#Declaracion de variable flotanteSum Stack position 4
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
li $t2, 1.0
add $t3, $t1, $t2
add $t1, $t3, $t0
#Declaracion de variable flotanteSum1 Stack position 5
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t0, 2.0
li $t1, 1.0
sub $t2, $t0, $t1
#Declaracion de variable flotanteRes Stack position 6
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
mul $t0, $t1
#Declaracion de variable flotanteMul Stack position 7
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t2, 1.0
li $t3, 1.0
div $t2, $t3
#Declaracion de variable flotanteDiv Stack position 8
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t4, 1.0
li $t5, 1.0
#Declaracion de variable flotanteMod Stack position 9
sub $sp, $sp, 4 
sw , 0($sp) 

li $t6, 0
move $t7, $t6
add $sp, $sp, 32
lw $t0, 0($sp)
move $v0, $t7
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

relacionales:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1
li $t1, 1
seq $t2, $t0, $t1
#Declaracion de variable booleanoEeq Stack position 2
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
seq $t2, $t0, $t1
li $t0, 2
li $t1, 1
sgt $t3, $t0, $t1
and $t0, $t2, $t3
#Declaracion de variable booleanoCombinado Stack position 3
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1
li $t1, 1
sne $t2, $t0, $t1
#Declaracion de variable booleanoNeq Stack position 4
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
slt $t2, $t0, $t1
#Declaracion de variable booleanoLet Stack position 5
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sgt $t2, $t0, $t1
#Declaracion de variable booleanoGet Stack position 6
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sle $t2, $t0, $t1
#Declaracion de variable booleanoLeq Stack position 7
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sge $t2, $t0, $t1
#Declaracion de variable booleanoGeq Stack position 8
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0
move $t1, $t0
add $sp, $sp, 28
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

logicas:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1 #Booleano true
#Declaracion de variable booleanoT Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0 #Booleano false
#Declaracion de variable booleanoF Stack position 3
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
li $t2, 1
li $t3, 2
seq $t4, $t2, $t3
or $t2, $t1, $t4
and $t1, $t2, $t0
#Declaracion de variable booleanoCombinado Stack position 4
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
and $t2, $t0, $t1
#Declaracion de variable booleanoCTT Stack position 5
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
or $t2, $t0, $t1
#Declaracion de variable booleanoDTT Stack position 6
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0 #Booleano false
li $t1, 1 #Booleano true
and $t2, $t0, $t1
#Declaracion de variable booleanoCFT Stack position 7
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0 #Booleano false
li $t1, 1 #Booleano true
or $t2, $t0, $t1
#Declaracion de variable booleanoDFT Stack position 8
sub $sp, $sp, 4 
sw $t2, 0($sp) 

lw $t0, 24($sp) 
lw $t1, 20($sp) 
or $t2, $t0, $t1
#Declaracion de variable booleanoVVV Stack position 9
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0
move $t1, $t0
add $sp, $sp, 32
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

stringsYchars:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, "abc"
#Declaracion de variable cadena Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
#Declaracion de variable cadenaV Stack position 3
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 'a'
#Declaracion de variable caracter Stack position 4
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0
move $t1, $t0
add $sp, $sp, 12
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

arrays:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
move $t1, $t0
add $sp, $sp, 0
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

whileFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
#Declaracion de variable num Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
li $t1, 5
slt $t2, $t0, $t1
whileFoo_While0:
beq $t2, 1, ciclo_whileFoo_While0
goto end_whileFoo_While0
ciclo_whileFoo_While0:
lw $t0, 0($sp) 
li $t1, 1
add $t2, $t0, $t1
sw $t2, 0($sp) 
goto whileFoo_While0:
end_whileFoo_While0:
lw $t0, 0($sp) 
move $t1, $t0
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

doWhileFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
#Declaracion de variable num Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

doWhileFoo_doWhile0:
lw $t0, 0($sp) 
li $t1, 1
add $t2, $t0, $t1
sw $t2, 0($sp) 
li $t0, 2
move $t1, $t0
move $a0, $t1
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
lw $t0, 0($sp) 
li $t1, 5
slt $t3, $t0, $t1
lw $t0, 0($sp) 
li $t1, 4
slt $t4, $t0, $t1
and $t0, $t3, $t4
beq $t0, 1, doWhileFoo_doWhile0
goto end_doWhileFoo_doWhile0
end_doWhileFoo_doWhile0:
lw $t0, 0($sp) 
move $t1, $t0
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

switchFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 0($sp) 
lw $t1, 0($sp) 
switchFoo_switch0:
switchFoo_switch0_case0:
li $t2, 1
lw $t3, 0($sp) 
li $t4, 1
add $t5, $t3, $t4
#Declaracion de variable num Stack position 2
sub $sp, $sp, 4 
sw $t5, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case0:
switchFoo_switch0_case1:
li $t3, 2
lw $t4, 0($sp) 
li $t5, 1
sub $t6, $t4, $t5
sw $t6, 0($sp) 
goto end_switchFoo_switch0
end_switchFoo_switch0_case1:
switchFoo_switch0_case2:
li $t4, 3
lw $t5, 0($sp) 
li $t7, 1
mul $t5, $t7
sw , 0($sp) 
goto end_switchFoo_switch0
end_switchFoo_switch0_case2:
switchFoo_switch0_case3:
li , 4
lw , 0($sp) 
li , 1
div , 
sw , 0($sp) 
goto end_switchFoo_switch0
end_switchFoo_switch0_case3:
switchFoo_switch0_case4:
li , 5
lw , 0($sp) 
li , 1
sw , 0($sp) 
goto end_switchFoo_switch0
end_switchFoo_switch0_case4:
switchFoo_switch0_default0:
goto end_switchFoo_switch0
end_switchFoo_switch0_default0:
end_switchFoo_switch0:
li , 0
li , t22
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, 
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

parametros:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 0($sp) 
lw $t1, 0($sp) 
lw $t2, 0($sp) 
lw $t3, 0($sp) 
lw $t4, 0($sp) 
lw $t5, 0($sp) 
#Declaracion de variable miCadena Stack position 2
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

lw $t5, 4($sp) 
#Declaracion de variable miEntero Stack position 3
sub $sp, $sp, 4 
sw $t5, 0($sp) 

lw $t5, 8($sp) 
#Declaracion de variable miFlotante Stack position 4
sub $sp, $sp, 4 
sw $t5, 0($sp) 

lw $t5, 12($sp) 
#Declaracion de variable miCaracter Stack position 5
sub $sp, $sp, 4 
sw $t5, 0($sp) 

lw $t5, 16($sp) 
#Declaracion de variable miBooleano Stack position 6
sub $sp, $sp, 4 
sw $t5, 0($sp) 

li $t5, 0
move $t6, $t5
add $sp, $sp, 20
lw $t0, 0($sp)
move $v0, $t6
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 0($sp) 
li $t1, 0
#Declaracion de variable variable Stack position 2
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t1, 1
li $t2, 10
sgt $t3, $t1, $t2
li $t1, 5
li $t2, 8
seq $t4, $t1, $t2
and $t1, $t3, $t4
li $t2, 1 #Booleano true
or $t3, $t1, $t2
beq $t3, 1, foo_if0
goto foo_else0
foo_if0:
li $t1, "GET"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
li $t1, 1 #Booleano true
li $t2, 0 #Booleano false
and $t3, $t1, $t2
beq $t3, 1, foo_if0_if0
goto foo_if0_else0
foo_if0_if0:
li $t1, "logica"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_if0_if0:
foo_if0_else0:
lw $t1, 4($sp) 
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_if0_if0:
end_foo_if0_if0:
goto end_foo_if0:
foo_else0:
end_foo_if0:
lw $t1, 4($sp) 
li $t2, 10
slt $t3, $t1, $t2
beq $t3, 1, foo_if1
goto foo_else1
foo_if1:
li $t1, "LET"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
li $t1, 1
li $t2, 2
slt $t3, $t1, $t2
beq $t3, 1, foo_if1_if0
goto foo_if1_else0
foo_if1_if0:
li $t1, "relacional"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_if1_if0:
foo_if1_else0:
end_foo_if1_if0:
li $t1, 1 #Booleano true
li $t2, 0 #Booleano false
or $t3, $t1, $t2
beq $t3, 1, foo_if1_if1
goto foo_if1_else1
foo_if1_if1:
li $t1, "logica"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_if1_if1:
foo_if1_else1:
end_foo_if1_if1:
goto end_foo_if1:
foo_else1:
li $t1, "EEQ"
move $t2, $t1
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
li $t1, 1
li $t2, 1
add $t3, $t1, $t2
li $t1, 5
slt $t2, $t3, $t1
beq $t2, 1, foo_else1_if0
goto foo_else1_else0
foo_else1_if0:
li $t1, t49
move $a0, $t1
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
li $t1, 3
li $t2, 3
move $a0, $t2
#Aqui se salvan los registros temporales
jal foo
#Aqui se restauran los registros temporales
goto end_foo_else1_if0:
foo_else1_else0:
end_foo_else1_if0:
li $t2, 1
li $t3, 1
add $t4, $t2, $t3
li $t2, 5
slt $t3, $t4, $t2
li $t2, 1 #Booleano true
and $t4, $t3, $t2
beq $t4, 1, foo_else1_if1
goto foo_else1_else1
foo_else1_if1:
li $t2, t62
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_else1_if1:
foo_else1_else1:
li $t2, t65
move $a0, $t2
#Aqui se salvan los registros temporales
jal print
#Aqui se restauran los registros temporales
goto end_foo_else1_if1:
end_foo_else1_if1:
goto end_foo_if1:
end_foo_if1:
li $t2, 0
move $t3, $t2
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, $t3
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 10
li $t1, 10
move $a0, $t1
#Aqui se salvan los registros temporales
jal switchFoo
#Aqui se restauran los registros temporales
li $t1, 10
li $t2, 10
move $a0, $t2
#Aqui se salvan los registros temporales
jal foo
#Aqui se restauran los registros temporales
li $t2, 0
#Declaracion de variable n Stack position 2
sub $sp, $sp, 4 
sw $t2, 0($sp) 

#Aqui se salvan los registros temporales
jal doWhileFoo
#Aqui se restauran los registros temporales
sw , 0($sp) 
li $t2, 0
move $t3, $t2
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, $t3
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

end: 
li $v0,10 
syscall