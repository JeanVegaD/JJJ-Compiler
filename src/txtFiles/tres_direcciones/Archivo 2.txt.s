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

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
lw $t0, 4(sp) 
lw $t1, 4(sp) 
li $t2, 0
#Declaracion de variable variable Stack position 2
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
move $t3, $t2
move $a0, $t3
jal print
li $t2, 1 #Booleano true
li $t3, 0 #Booleano false
and $t4, $t2, $t3
beq $t4, 1, foo_if0_if0
goto foo_if0_else0
foo_if0_if0:
li $t2, "logica"
move $t3, $t2
move $a0, $t3
jal print
goto end_foo_if0_if0:
foo_if0_else0:
lw $t2, 8(sp) 
move $t3, $t2
move $a0, $t3
jal print
goto end_foo_if0_if0:
end_foo_if0_if0:
goto end_foo_if0:
foo_else0:
end_foo_if0:
lw $t2, 8(sp) 
li $t3, 10
slt $t4, $t2, $t3
beq $t4, 1, foo_if1
goto foo_else1
foo_if1:
li $t2, "LET"
move $t3, $t2
move $a0, $t3
jal print
li $t2, 1
li $t3, 2
slt $t4, $t2, $t3
beq $t4, 1, foo_if1_if0
goto foo_if1_else0
foo_if1_if0:
li $t2, "relacional"
move $t3, $t2
move $a0, $t3
jal print
goto end_foo_if1_if0:
foo_if1_else0:
end_foo_if1_if0:
li $t2, 1 #Booleano true
li $t3, 0 #Booleano false
or $t4, $t2, $t3
beq $t4, 1, foo_if1_if1
goto foo_if1_else1
foo_if1_if1:
li $t2, "logica"
move $t3, $t2
move $a0, $t3
jal print
goto end_foo_if1_if1:
foo_if1_else1:
end_foo_if1_if1:
goto end_foo_if1:
foo_else1:
li $t2, "EEQ"
move $t3, $t2
move $a0, $t3
jal print
li $t2, 1
li $t3, 1
add $t4, $t2, $t3
li $t2, 5
slt $t3, $t4, $t2
beq $t3, 1, foo_else1_if0
goto foo_else1_else0
foo_else1_if0:
li $t2, t49
move $a0, $t2
jal print
li $t2, 3
li $t3, 3
move $a0, $t3
jal foo
goto end_foo_else1_if0:
foo_else1_else0:
end_foo_else1_if0:
li $t3, 1
li $t4, 1
add $t5, $t3, $t4
li $t3, 5
slt $t4, $t5, $t3
li $t3, 1 #Booleano true
and $t5, $t4, $t3
beq $t5, 1, foo_else1_if1
goto foo_else1_else1
foo_else1_if1:
li $t3, t62
move $a0, $t3
jal print
goto end_foo_else1_if1:
foo_else1_else1:
li $t3, t65
move $a0, $t3
jal print
goto end_foo_else1_if1:
end_foo_else1_if1:
goto end_foo_if1:
end_foo_if1:
li $t3, 0
move $t4, $t3
addi $sp, $sp, 8
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

lw $t0, 4(sp) 
lw $t1, 4(sp) 
move $a0, $t1
jal foo
li $t1, 1
li $t2, 1
move $a0, $t2
jal foo
li $t2, 0
move $t3, $t2
addi $sp, $sp, 8
lw $s0, 0($sp)
move $ra, $s0
jr $ra
#Fin de funcion 

end: 
li $v0,10 
syscall