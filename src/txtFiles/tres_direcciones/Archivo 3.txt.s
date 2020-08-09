.data

.text

.globl main

print:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $v0, 1 
syscall
addi $sp, $sp, 8
lw $s0, 0($sp)
move $ra, $s0
jr $ra

funcionnueva:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1
#Declaracion de variable numero Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 123
lw $t1, 0($sp) 
add $t2, $t0, $t1
#Declaracion de variable var Stack position 3
sub $sp, $sp, 4 
sw $t2, 0($sp) 

lw $t0, 0($sp) 
lw $t1, 4($sp) 
add $t2, $t0, $t1
#Declaracion de variable super Stack position 4
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 3
add $t2, $t0, $t1
sw $t2, 8($sp) 
li $t0, 1
move $t1, $t0
addi $sp, $sp, 12
lw $s0, 0($sp)
move $v0, $t1
move $ra, $s0
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 5
move $t1, $t0
move $a0, $t1
jal print
li $t0, 0
#Declaracion de variable in Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0
move $t1, $t0
addi $sp, $sp, 4
lw $s0, 0($sp)
move $v0, $t1
move $ra, $s0
jr $ra
#Fin de funcion 

end: 
li $v0,10 
syscall