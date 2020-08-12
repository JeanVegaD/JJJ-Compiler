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

funcionnueva:
sub $sp, $sp, 4
sw $ra, 0($sp)
sub $sp, $sp, 4
sw $a0, 0($sp)
sub $sp, $sp, 4
sw $a1, 0($sp)
sub $sp, $sp, 4
sw $a2, 0($sp)
lw $t0, 8($sp) 
lw $t1, 4($sp) 
lw $t2, 0($sp) 
lw $t3, 8($sp) 
sub $sp, $sp, 4 
sw $t3, 0($sp) 

li $t3, 123
lw $t4, 0($sp) 
add $t5, $t3, $t4
sub $sp, $sp, 4 
sw $t5, 0($sp) 

lw $t3, 0($sp) 
lw $t4, 4($sp) 
add $t5, $t3, $t4
sub $sp, $sp, 4 
sw $t5, 0($sp) 

lw $t3, 8($sp) 
lw $t4, 8($sp) 
mult $t3, $t4
mflo $v1
sw $v1, 8($sp) 
li $t3, 1
move $t4, $t3
add $sp, $sp, 24
lw $t0, 0($sp)
move $v0, $t4
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

funcion2:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 5
move $t1, $t0
add $sp, $sp, 0
lw $t0, 0($sp)
move $v0, $t1
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 1
li $t1, 2
mult $t0, $t1
sub $sp, $sp, 4 
mflo $v1
sw $v1, 0($sp) 

li $t0, 5
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
sw $t0, 4($sp) 
li $t1, 1
li $t2, 2
move $s0, $t0
move $s1, $t1
move $s2, $t2
jal funcion2
move $t0, $s0
move $t1, $s1
move $t2, $s2
move $t3, $v0 
add $t4, $t2, $t3
mult $t4, $t1
mflo $v1
sw $v1, 4($sp) 
li $t1, 1
lw $t2, 4($sp) 
li $t3, 3
li $t4, 1
lw $t5, 4($sp) 
li $t6, 3
move $a0, $t4
move $a1, $t5
move $a2, $t6
jal funcionnueva
move $t0, $v0 
move $s0, $t0
jal funcion2
move $t0, $s0
move $t1, $v0 
move $s0, $t0
move $s1, $t1
jal funcion2
move $t0, $s0
move $t1, $s1
move $t2, $v0 
add $t3, $t1, $t2
sub $sp, $sp, 4 
sw $t3, 0($sp) 

lw $t1, 0($sp) 
move $t2, $t1
move $a0, $t2
jal print
move $t0, $v0 
li $t1, 0
move $t2, $t1
jal end
#Fin de funcion 

end: 
li $v0,10 
syscall