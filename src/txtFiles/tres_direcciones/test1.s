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
lw $t0, 0($sp) 
li $t1, 2
sub $sp, $sp, 4 
sw $t1, 0($sp) 

lw $t1, 4($sp) 
li $t2, 10
seq $t3, $t1, $t2
beq $t3, 1, test1_if0
goto test1_else0
test1_if0:
li $t1, 0
sw $t1, 0($sp) 
goto end_test1_if0:
test1_else0:
li $t2, 1
sw $t2, 0($sp) 
goto end_test1_if0:
end_test1_if0:
lw $t3, 0($sp) 
move $t4, $t3
add $sp, $sp, 8
lw $t0, 0($sp)
move $v0, $t4
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
li $t1, 10
move $a0, $t1
sw , 0($sp) 
li $t0, 1
move $t1, $t0
jal end
#Fin de funcion 

end: 
li $v0,10 
syscall