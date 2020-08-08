.data

.text

.globl main

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
move $t1, $t0
addi $sp, $sp, 4
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
#Declaracion de variable n Stack position 2
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0
move $t1, $t0
addi $sp, $sp, 8
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

end: 
li $v0,10 
syscall