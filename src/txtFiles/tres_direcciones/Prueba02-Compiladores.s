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

incremento2:
sub $sp, $sp, 4
sw $ra, 0($sp)
sub $sp, $sp, 4
sw $a0, 0($sp)
lw $t0, 0($sp) 
li $t1, 25
sub $sp, $sp, 4 
sw $t1, 0($sp) 

lw $t1, 0($sp) 
sub $sp, $sp, 4 
sw $t1, 0($sp) 

lw $t1, 8($sp) 
li $t2, 1
add $t3, $t1, $t2
move $t1, $t3
add $sp, $sp, 12
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

incremento:
sub $sp, $sp, 4
sw $ra, 0($sp)
sub $sp, $sp, 4
sw $a0, 0($sp)
sub $sp, $sp, 4
sw $a1, 0($sp)
lw $t0, 4($sp) 
lw $t1, 0($sp) 
li $t2, 1
li $t3, 2
div $t2, $t3
mfhi $t2
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t2, 2
li $t3, 2
mult $t2, $t3
mflo $t2
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t2, 2
li $t3, 2
div $t2, $t3
mflo $t2
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t2, 45
li $t3, 1 #Booleano true
li $t4, 45
li $t5, 1 #Booleano true
move $a0, $t4
move $a1, $t5
jal incremento
move $t0, $v0 
li $t1, 10
li $t2, 15
div $t1, $t2
mflo $t1
mult $t1, $t0
mflo $t0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
li $t1, -34
li $t2, 10
li $t3, 10
li $t4, 14
li $t5, 80
sub $t6, $t4, $t5
add $t4, $t6, $t3
li $t3, 5
add $t5, $t4, $t3
div $t5, $t2
mfhi $t2
div $t2, $t1
mflo $t1
sub $t2, $t1, $t0
sw $t2, 0($sp) 
li $t0, 85
move $t1, $t0
add $sp, $sp, 24
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 25
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 45
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

main_dec_for0:
li $t0, 0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

main_for0:
main_for0_cond0:
lw $t0, 0($sp) 
li $t1, 3
slt $t2, $t0, $t1
bne $t2, 1, end_main_for0
lw $t0, 8($sp) 
move $t1, $t0
move $a0, $t1
jal print
move $t0, $v0 
aumento_main_for0:
lw $t1, 0($sp) 
li $t2, 1
add $t3, $t1, $t2
sw $t3, 0($sp) 
j main_for0
end_main_for0:
lw $t1, 12($sp) 
li $t2, 23
sge $t3, $t1, $t2
li $t1, 0 #Booleano false
or $t2, $t3, $t1
beq $t2, 1, main_if0
j main_else0
main_if0:
lw $t1, 12($sp) 
sw $t1, 4($sp) 
j end_main_if0
main_else0:
li $t1, 1 #Booleano true
sub $sp, $sp, 4 
sw $t1, 0($sp) 

main_else0_doWhile0:
lw $t1, 8($sp) 
li $t2, 2
sle $t3, $t1, $t2
beq $t3, 1, main_else0_doWhile0_if0
j main_else0_doWhile0_else0
main_else0_doWhile0_if0:
lw $t1, 8($sp) 
li $t2, 2
mult $t1, $t2
mflo $t1
sw $t1, 8($sp) 
j end_main_else0_doWhile0_if0
main_else0_doWhile0_else0:
lw $t1, 8($sp) 
move $t2, $t1
move $a0, $t2
jal print
move $t0, $v0 
main_else0_doWhile0_else0_dec_for0:
li $t1, 0
sub $sp, $sp, 4 
sw $t1, 0($sp) 

main_else0_doWhile0_else0_for0:
main_else0_doWhile0_else0_for0_cond0:
lw $t1, 0($sp) 
li $t2, 3
slt $t3, $t1, $t2
bne $t3, 1, end_main_else0_doWhile0_else0_for0
lw $t1, 0($sp) 
move $t2, $t1
move $a0, $t2
jal print
move $t0, $v0 
aumento_main_else0_doWhile0_else0_for0:
lw $t1, 0($sp) 
li $t2, 1
add $t3, $t1, $t2
sw $t3, 0($sp) 
j main_else0_doWhile0_else0_for0
end_main_else0_doWhile0_else0_for0:
j end_main_else0_doWhile0_if0
end_main_else0_doWhile0_if0:
lw $t1, 12($sp) 
main_else0_doWhile0_switch0:
main_else0_doWhile0_switch0_case0:
li $t2, 1
seq $t3, $t2, $t1
bne $t3, 1, end_main_else0_doWhile0_switch0_case0
lw $t2, 12($sp) 
li $t3, 0
sgt $t4, $t2, $t3
sw $t4, 4($sp) 
j end_main_else0_doWhile0_switch0
end_main_else0_doWhile0_switch0_case0:
main_else0_doWhile0_switch0_case1:
li $t2, 2
seq $t3, $t2, $t1
bne $t3, 1, end_main_else0_doWhile0_switch0_case1
li $t2, 0 #Booleano false
sw $t2, 4($sp) 
j end_main_else0_doWhile0_switch0
end_main_else0_doWhile0_switch0_case1:
main_else0_doWhile0_switch0_default0:
li $t2, 1 #Booleano true
sw $t2, 4($sp) 
j end_main_else0_doWhile0_switch0
end_main_else0_doWhile0_switch0_default0:
end_main_else0_doWhile0_switch0:
lw $t2, 4($sp) 
beq $t2, 1, main_else0_doWhile0
j end_main_else0_doWhile0
end_main_else0_doWhile0:
j end_main_if0
end_main_if0:
lw $t2, 12($sp) 
move $t3, $t2
move $a0, $t3
jal print
move $t0, $v0 
li $t1, 5
move $t2, $t1
jal end
#Fin de funcion 

end: 
li $v0,10 
syscall