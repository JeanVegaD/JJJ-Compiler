.data

.text

.globl main

enteros:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1
#Declaracion de variable enteroNor Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1
lw $t1, 4(sp) 
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

lw $t2, 4(sp) 
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

lw $t6, 28(sp) 
lw $t7, 8(sp) 
add , $t6, $t7
#Declaracion de variable enteroCom Stack position 11
sub $sp, $sp, 4 
sw , 0($sp) 

li $t6, 0
li $t7, $t6
addi $sp, $sp, 44
lw $s0, 0($sp)
move $ra, $s0
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
lw $t1, 4(sp) 
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
li $t7, $t6
addi $sp, $sp, 36
lw $s0, 0($sp)
move $ra, $s0
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
li $t1, $t0
addi $sp, $sp, 32
lw $s0, 0($sp)
move $ra, $s0
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

lw $t0, 28(sp) 
lw $t1, 24(sp) 
or $t2, $t0, $t1
#Declaracion de variable booleanoVVV Stack position 9
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 36
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

stringsYchars:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, "abc"
#Declaracion de variable cadena Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 4(sp) 
#Declaracion de variable cadenaV Stack position 3
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 'a'
#Declaracion de variable caracter Stack position 4
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 16
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

arrays:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
li $t1, $t0
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

whileFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
#Declaracion de variable num Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 4(sp) 
li $t1, 5
slt $t2, $t0, $t1
whileFoo_While0:
beq $t2, 1, ciclo_whileFoo_While0
goto end_whileFoo_While0
ciclo_whileFoo_While0:
lw $t0, 4(sp) 
li $t1, 1
add $t2, $t0, $t1
#Declaracion de variable num Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

goto whileFoo_While0:
end_whileFoo_While0:
lw $t0, 8(sp) 
li $t1, $t0
addi $sp, $sp, 12
lw $s0, 0($sp)
move $ra, $s0
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
lw $t0, 4(sp) 
li $t1, 1
add $t2, $t0, $t1
#Declaracion de variable num Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 2
li $t1, $t0
param t5
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t2, 12(sp) 
li $t3, 5
slt $t4, $t2, $t3
lw $t2, 12(sp) 
li $t3, 4
slt $t5, $t2, $t3
and $t2, $t4, $t5
beq $t2, 1, doWhileFoo_doWhile0
goto end_doWhileFoo_doWhile0
end_doWhileFoo_doWhile0:
lw $t2, 12(sp) 
li $t3, $t2
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

switchFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 16(sp) 
lw $t1, 12(sp) 
lw $t2, 12(sp) 
switchFoo_switch0:
switchFoo_switch0_case0:
li $t3, 1
lw $t4, 12(sp) 
li $t5, 1
add $t6, $t4, $t5
#Declaracion de variable num Stack position 5
sub $sp, $sp, 4 
sw $t6, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case0:
switchFoo_switch0_case1:
li $t4, 2
lw $t5, 16(sp) 
li $t6, 1
sub $t7, $t5, $t6
#Declaracion de variable num Stack position 6
sub $sp, $sp, 4 
sw $t7, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case1:
switchFoo_switch0_case2:
li $t5, 3
lw $t6, 20(sp) 
li $t7, 1
mul $t6, $t7
#Declaracion de variable num Stack position 7
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case2:
switchFoo_switch0_case3:
li , 4
lw , 24(sp) 
li , 1
div , 
#Declaracion de variable num Stack position 8
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case3:
switchFoo_switch0_case4:
li , 5
lw , 28(sp) 
li , 1
#Declaracion de variable num Stack position 9
sub $sp, $sp, 4 
sw , 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case4:
switchFoo_switch0_default0:
goto end_switchFoo_switch0
end_switchFoo_switch0_default0:
end_switchFoo_switch0:
li , 0
li , t22
addi $sp, $sp, 24
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

parametros:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 16(sp) 
lw $t1, 16(sp) 
lw $t2, 16(sp) 
lw $t3, 16(sp) 
lw $t4, 16(sp) 
lw $t5, 16(sp) 
lw $t6, 16(sp) 
lw $t7, 16(sp) 
lw , 16(sp) 
lw , 16(sp) 
lw , 16(sp) 
#Declaracion de variable miCadena Stack position 5
sub $sp, $sp, 4 
sw , 0($sp) 

lw , 20(sp) 
#Declaracion de variable miEntero Stack position 6
sub $sp, $sp, 4 
sw , 0($sp) 

lw , 24(sp) 
#Declaracion de variable miFlotante Stack position 7
sub $sp, $sp, 4 
sw , 0($sp) 

lw , 28(sp) 
#Declaracion de variable miCaracter Stack position 8
sub $sp, $sp, 4 
sw , 0($sp) 

lw , 32(sp) 
#Declaracion de variable miBooleano Stack position 9
sub $sp, $sp, 4 
sw , 0($sp) 

li , 0
li , t10
addi $sp, $sp, 24
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 16(sp) 
lw $t1, 12(sp) 
li $t2, 0
#Declaracion de variable variable Stack position 5
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t2, 1
li $t3, 10
sgt $t4, $t2, $t3
li $t2, 5
li $t3, 8
seq $t5, $t2, $t3
and $t2, $t4, $t5
li $t3, 1 #Booleano true
or $t4, $t2, $t3
beq $t4, 1, foo_if0
goto foo_else0
foo_if0:
li $t2, "GET"
li $t3, $t2
param t12
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t4, 1 #Booleano true
li $t5, 0 #Booleano false
and $t6, $t4, $t5
beq $t6, 1, foo_if0_if0
goto foo_if0_else0
foo_if0_if0:
li $t4, "logica"
li $t5, $t4
param t18
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if0_if0:
foo_if0_else0:
lw $t6, 24(sp) 
li $t7, $t6
param t21
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if0_if0:
end_foo_if0_if0:
goto end_foo_if0:
foo_else0:
end_foo_if0:
lw , 28(sp) 
li , 10
slt , , 
beq , 1, foo_if1
goto foo_else1
foo_if1:
li , "LET"
li , t26
param t27
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li , 1
li , 2
slt , , 
beq , 1, foo_if1_if0
goto foo_if1_else0
foo_if1_if0:
li , "relacional"
li , t32
param t33
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if1_if0:
foo_if1_else0:
end_foo_if1_if0:
li , 1 #Booleano true
li , 0 #Booleano false
or , , 
beq , 1, foo_if1_if1
goto foo_if1_else1
foo_if1_if1:
li , "logica"
li , t38
param t39
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if1_if1:
foo_if1_else1:
end_foo_if1_if1:
goto end_foo_if1:
foo_else1:
li , "EEQ"
li , t41
param t42
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li , 1
li , 1
add , , 
li , 5
slt , , 
beq , 1, foo_else1_if0
goto foo_else1_else0
foo_else1_if0:
li , t49
param t50
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li , 3
li , 3
param t53
jal foo
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if0:
foo_else1_else0:
end_foo_else1_if0:
li , 1
li , 1
add , , 
li , 5
slt , , 
li , 1 #Booleano true
and , , 
beq , 1, foo_else1_if1
goto foo_else1_else1
foo_else1_if1:
li , t62
param t63
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if1:
foo_else1_else1:
li , t65
param t66
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if1:
end_foo_else1_if1:
goto end_foo_if1:
end_foo_if1:
li , 0
li , t68
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 10
li $t1, 10
param t1
jal switchFoo
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t2, 10
li $t3, 10
param t4
jal foo
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t4, 0
#Declaracion de variable n Stack position 19
sub $sp, $sp, 4 
sw $t4, 0($sp) 

jal doWhileFoo
sub $sp, $sp, 4
sw $ra, 0($sp)
#Declaracion de variable n Stack position 21
sub $sp, $sp, 4 
sw , 0($sp) 

li $t4, 0
li $t5, $t4
addi $sp, $sp, 8
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

end: 
li $v0,10 
syscall