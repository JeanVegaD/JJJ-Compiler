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

salvarTemporales:
sub $sp, $sp, 4
sw $ra, 0($sp)
move $s0, $t0
move $s1, $t1
move $s2, $t2
move $s3, $t3
move $s4, $t4
move $s5, $t5
move $s6, $t6
move $s7, $t7
addi $sp, $sp, 0
lw $t0, 0($sp)
move $ra, $t0
jr $ra

cargarTemporales:
sub $sp, $sp, 4
sw $ra, 0($sp)
move $t0, $s0
move $t1, $s1
move $t2, $s2
move $t3, $s3
move $t4, $s4
move $t5, $s5
move $t6, $s6
move $t7, $s7
addi $sp, $sp, 0
lw $t0, 0($sp)
move $ra, $t0
jr $ra

test1:
sub $sp, $sp, 4
sw $ra, 0($sp)
sub $sp, $sp, 4
sw $a0, 0($sp)
sub $sp, $sp, 4
sw $a1, 0($sp)
lw $t0, 4($sp) 
lw $t1, 0($sp) 
li $t2, 0
sub $sp, $sp, 4 
sw $t2, 0($sp) 

lw $t2, 8($sp) 
lw $t3, 4($sp) 
sgt $t4, $t2, $t3
lw $t2, 8($sp) 
li $t3, 1
seq $t5, $t2, $t3
and $t2, $t4, $t5
beq $t2, 1, test1_if0
j test1_else
test1_if0:
lw $t2, 8($sp) 
sw $t2, 0($sp) 
j end_test1_if0
test1_else0:
lw $t3, 4($sp) 
sw $t3, 0($sp) 
j end_test1_if0
end_test1_if0:
lw $t4, 0($sp) 
move $t5, $t4
add $sp, $sp, 12
lw $t0, 0($sp)
move $v0, $t5
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

main:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 10
li $t1, 5
li $t2, 10
li $t3, 5
move $a0, $t2
move $a1, $t3
lw $t0, 0($sp) 
move $t1, $t0
move $a2, $t1
li $t0, 1
move $t1, $t0
jal end
#Fin de funcion 

end: 
li $v0,10 
syscall