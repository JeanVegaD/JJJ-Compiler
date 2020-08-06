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
add $t4, $t3, $t0
#Declaracion de variable enteroSum1 Stack position 5
sub $sp, $sp, 4 
sw $t4, 0($sp) 

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

lw $t0, 4(sp) 
li $t1, 1
add $t2, $t0, $t1
#Declaracion de variable enteroSum2 Stack position 8
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
div $t0, $t1
#Declaracion de variable enteroDiv Stack position 9
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable enteroPow Stack position 10
sub $sp, $sp, 4 
sw , 0($sp) 

lw $t0, 28(sp) 
lw $t1, 8(sp) 
add $t2, $t0, $t1
#Declaracion de variable enteroCom Stack position 11
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 44
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

flotantes:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t2, 1.0
#Declaracion de variable flotanteNor Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
lw $t1, 4(sp) 
add $t2, $t0, $t1
#Declaracion de variable flotanteVar Stack position 4
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
add $t2, $t0, $t1
#Declaracion de variable flotanteSum Stack position 5
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
li $t2, 1.0
add $t3, $t1, $t2
add $t4, $t3, $t0
#Declaracion de variable flotanteSum1 Stack position 6
sub $sp, $sp, 4 
sw $t4, 0($sp) 

li $t0, 2.0
li $t1, 1.0
sub $t2, $t0, $t1
#Declaracion de variable flotanteRes Stack position 7
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1.0
li $t1, 1.0
mul $t0, $t1
#Declaracion de variable flotanteMul Stack position 8
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t0, 1.0
li $t1, 1.0
div $t0, $t1
#Declaracion de variable flotanteDiv Stack position 9
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

li $t0, 1.0
li $t1, 1.0
#Declaracion de variable flotanteMod Stack position 10
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 36
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

relacionales:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t2, 1
li $t3, 1
#Declaracion de variable booleanoEeq Stack position 4
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
li $t2, 2
li $t3, 1
#Declaracion de variable booleanoCombinado Stack position 5
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable booleanoNeq Stack position 6
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable booleanoLet Stack position 7
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable booleanoGet Stack position 8
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable booleanoLeq Stack position 9
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 1
li $t1, 1
#Declaracion de variable booleanoGeq Stack position 10
sub $sp, $sp, 4 
sw , 0($sp) 

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
li $t2, true
#Declaracion de variable booleanoT Stack position 5
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, false
#Declaracion de variable booleanoF Stack position 6
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, true
li $t1, true
li $t2, 1
li $t3, 2
#Declaracion de variable booleanoCombinado Stack position 7
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, true
li $t1, true
#Declaracion de variable booleanoCTT Stack position 8
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, true
li $t1, true
#Declaracion de variable booleanoDTT Stack position 9
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, false
li $t1, true
#Declaracion de variable booleanoCFT Stack position 10
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, false
li $t1, true
#Declaracion de variable booleanoDFT Stack position 11
sub $sp, $sp, 4 
sw , 0($sp) 

lw $t0, 28(sp) 
lw $t1, 24(sp) 
#Declaracion de variable booleanoVVV Stack position 12
sub $sp, $sp, 4 
sw , 0($sp) 

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
li $t2, "abc"
#Declaracion de variable cadena Stack position 6
sub $sp, $sp, 4 
sw $t2, 0($sp) 

lw $t0, 4(sp) 
#Declaracion de variable cadenaV Stack position 7
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 'a'
#Declaracion de variable caracter Stack position 8
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
li $t2, 0
li $t3, $t2
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

whileFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t4, 0
#Declaracion de variable num Stack position 8
sub $sp, $sp, 4 
sw $t4, 0($sp) 

lw $t0, 4(sp) 
li $t1, 5
whileFoo_While0:
If 
goto end_whileFoo_While0
ciclo_whileFoo_While0:
lw $t2, 4(sp) 
li $t3, 1
add $t4, $t2, $t3
#Declaracion de variable num Stack position 9
sub $sp, $sp, 4 
sw $t4, 0($sp) 

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
li $t2, 0
#Declaracion de variable num Stack position 9
sub $sp, $sp, 4 
sw $t2, 0($sp) 

doWhileFoo_doWhile0:
lw $t0, 4(sp) 
li $t1, 1
add $t2, $t0, $t1
#Declaracion de variable num Stack position 10
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
lw $t4, 12(sp) 
li $t5, 4
If 
goto end_doWhileFoo_doWhile0
end_doWhileFoo_doWhile0:
lw $t6, 12(sp) 
li $t7, $t6
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

switchFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t8, 48(sp) 
lw $t9, 16(sp) 
lw $t10, 16(sp) 
switchFoo_switch0:
switchFoo_switch0_case0:
li $t11, 1
lw $t12, 16(sp) 
li $t13, 1
add $t14, $t12, $t13
#Declaracion de variable num Stack position 13
sub $sp, $sp, 4 
sw $t14, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case0:
switchFoo_switch0_case1:
li $t0, 2
lw $t1, 20(sp) 
li $t2, 1
sub $t3, $t1, $t2
#Declaracion de variable num Stack position 14
sub $sp, $sp, 4 
sw $t3, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case1:
switchFoo_switch0_case2:
li $t0, 3
lw $t1, 24(sp) 
li $t2, 1
mul $t1, $t2
#Declaracion de variable num Stack position 15
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case2:
switchFoo_switch0_case3:
li $t0, 4
lw $t1, 28(sp) 
li $t2, 1
div $t1, $t2
#Declaracion de variable num Stack position 16
sub $sp, $sp, 4 
mflo $s0
sw $s0, 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case3:
switchFoo_switch0_case4:
li $t0, 5
lw $t1, 32(sp) 
li $t2, 1
#Declaracion de variable num Stack position 17
sub $sp, $sp, 4 
sw , 0($sp) 

goto end_switchFoo_switch0
end_switchFoo_switch0_case4:
switchFoo_switch0_default0:
goto end_switchFoo_switch0
end_switchFoo_switch0_default0:
end_switchFoo_switch0:
li $t0, 0
li $t1, $t0
addi $sp, $sp, 24
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

parametros:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t2, 52(sp) 
lw $t3, 52(sp) 
lw $t4, 52(sp) 
lw $t5, 52(sp) 
lw $t6, 52(sp) 
lw $t7, 52(sp) 
lw $t8, 52(sp) 
lw $t9, 52(sp) 
lw $t10, 24(sp) 
lw $t11, 52(sp) 
lw $t12, 52(sp) 
#Declaracion de variable miCadena Stack position 14
sub $sp, $sp, 4 
sw $t12, 0($sp) 

lw $t0, 56(sp) 
#Declaracion de variable miEntero Stack position 15
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 60(sp) 
#Declaracion de variable miFlotante Stack position 16
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 36(sp) 
#Declaracion de variable miCaracter Stack position 17
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 68(sp) 
#Declaracion de variable miBooleano Stack position 18
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 24
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t2, 56(sp) 
lw $t3, 24(sp) 
li $t4, 1
li $t5, 10
li $t6, 5
li $t7, 8
li $t8, true
If 
goto foo_else0
foo_if0:
li $t9, "GET"
li $t10, $t9
param t11
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t11, true
li $t12, false
If 
goto foo_if0_else0
foo_if0_if0:
li $t13, "logica"
li $t14, $t13
param t17
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if0_if0:
foo_if0_else0:
lw $t15, 32(sp) 
li $t16, $t15
param t20
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if0_if0:
end_foo_if0_if0:
goto end_foo_if0:
foo_else0:
end_foo_if0:
lw $t17, 36(sp) 
li $t18, 10
If 
goto foo_else1
foo_if1:
li $t19, "LET"
li $t20, $t19
param t26
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t21, 1
li $t22, 2
If 
goto foo_if1_else0
foo_if1_if0:
li $t23, "relacional"
li $t24, $t23
param t32
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if1_if0:
foo_if1_else0:
end_foo_if1_if0:
li $t25, true
li $t26, false
If 
goto foo_if1_else1
foo_if1_if1:
li $t27, "logica"
li $t28, $t27
param t38
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_if1_if1:
foo_if1_else1:
end_foo_if1_if1:
goto end_foo_if1:
foo_else1:
li $t29, "EEQ"
li $t30, $t29
param t41
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t31, 1
li $t32, 1
add $t33, $t31, $t32
li $t34, 5
If 
goto foo_else1_else0
foo_else1_if0:
li $t35, t48
param t49
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t36, 3
li $t37, 3
param t52
jal foo
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if0:
foo_else1_else0:
end_foo_else1_if0:
li $t38, 1
li $t39, 1
add $t40, $t38, $t39
li $t41, 5
li $t42, true
If 
goto foo_else1_else1
foo_else1_if1:
li $t43, t61
param t62
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if1:
foo_else1_else1:
li $t44, t64
param t65
jal print
sub $sp, $sp, 4
sw $ra, 0($sp)
goto end_foo_else1_if1:
end_foo_else1_if1:
goto end_foo_if1:
end_foo_if1:
li $t45, 0
li $t46, $t45
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t47, "hola"
li $t48, 1
li $t49, 1.0
li $t50, 'a'
li $t51, true
li $t52, "hola"
li $t53, 1
li $t54, 1.0
li $t55, 'a'
li $t56, true
param t5
param t6
param t7
param t8
param t9
jal parametros
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t57, 10
li $t58, 10
param t12
jal switchFoo
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t59, 10
li $t60, 10
param t15
jal foo
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t61, 0
#Declaracion de variable n Stack position 30
sub $sp, $sp, 4 
sw $t61, 0($sp) 

jal doWhileFoo
sub $sp, $sp, 4
sw $ra, 0($sp)
#Declaracion de variable n Stack position 32
sub $sp, $sp, 4 
sw , 0($sp) 

li $t0, 0
li $t1, $t0
addi $sp, $sp, 8
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

