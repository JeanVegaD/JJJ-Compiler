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
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1
lw $t1, 0($sp) 
add $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
add $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
li $t2, 1
add $t3, $t1, $t2
add $t1, $t3, $t0
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t0, 2
li $t1, 1
sub $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
mult $t0, $t1
mflo $t0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
li $t1, 1
add $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
div $t0, $t1
mflo $t0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 20($sp) 
lw $t1, 0($sp) 
add $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0
move $t1, $t0
add $sp, $sp, 36
lw $t0, 0($sp)
move $v0, $t1
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
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
seq $t2, $t0, $t1
li $t0, 2
li $t1, 1
sgt $t3, $t0, $t1
and $t0, $t2, $t3
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1
li $t1, 1
sne $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
slt $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sgt $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sle $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1
li $t1, 1
sge $t2, $t0, $t1
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
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 0 #Booleano false
sub $sp, $sp, 4 
sw $t0, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
li $t2, 1
li $t3, 2
seq $t4, $t2, $t3
or $t2, $t1, $t4
and $t1, $t2, $t0
sub $sp, $sp, 4 
sw $t1, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
and $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 1 #Booleano true
li $t1, 1 #Booleano true
or $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0 #Booleano false
li $t1, 1 #Booleano true
and $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

li $t0, 0 #Booleano false
li $t1, 1 #Booleano true
or $t2, $t0, $t1
sub $sp, $sp, 4 
sw $t2, 0($sp) 

lw $t0, 24($sp) 
lw $t1, 20($sp) 
or $t2, $t0, $t1
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

whileFoo:
sub $sp, $sp, 4
sw $ra, 0($sp)
li $t0, 0
sub $sp, $sp, 4 
sw $t0, 0($sp) 

lw $t0, 0($sp) 
li $t1, 5
slt $t2, $t0, $t1
whileFoo_While0:
beq $t2, 1, ciclo_whileFoo_While0
j end_whileFoo_While
ciclo_whileFoo_While0:
lw $t0, 0($sp) 
li $t1, 1
add $t2, $t0, $t1
sw $t2, 0($sp) 
j whileFoo_While0
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
jal print
move $t0, $v0 
lw $t1, 0($sp) 
li $t2, 5
slt $t3, $t1, $t2
lw $t1, 0($sp) 
li $t2, 4
slt $t4, $t1, $t2
and $t1, $t3, $t4
beq $t1, 1, doWhileFoo_doWhile0
j end_doWhileFoo_doWhile
end_doWhileFoo_doWhile0:
lw $t1, 0($sp) 
move $t2, $t1
add $sp, $sp, 4
lw $t0, 0($sp)
move $v0, $t2
move $ra, $t0
add $sp, $sp, 4
jr $ra
#Fin de funcion 

foo:
sub $sp, $sp, 4
sw $ra, 0($sp)
sub $sp, $sp, 4
sw $a0, 0($sp)
lw $t0, 0($sp) 
li $t1, 0
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
j foo_else
foo_if0:
li $t1, 1 #Booleano true
li $t2, 0 #Booleano false
and $t3, $t1, $t2
beq $t3, 1, foo_if0_if0
j foo_if0_else
foo_if0_if0:
li $t1, 1
sub $sp, $sp, 4 
sw $t1, 0($sp) 

j end_foo_if0_if0
foo_if0_else0:
li $t1, 1
sw $t1, 0($sp) 
j end_foo_if0_if0
end_foo_if0_if0:
j end_foo_if0
foo_else0:
end_foo_if0:
lw $t1, 8($sp) 
li $t2, 10
slt $t3, $t1, $t2
beq $t3, 1, foo_if1
j foo_else
foo_if1:
li $t1, 1
li $t2, 2
slt $t3, $t1, $t2
beq $t3, 1, foo_if1_if0
j foo_if1_else
foo_if1_if0:
li $t1, 1
sw $t1, 0($sp) 
j end_foo_if1_if0
foo_if1_else0:
end_foo_if1_if0:
li $t1, 1 #Booleano true
li $t2, 0 #Booleano false
or $t3, $t1, $t2
beq $t3, 1, foo_if1_if1
j foo_if1_else
foo_if1_if1:
li $t1, 1
sw $t1, 0($sp) 
j end_foo_if1_if1
foo_if1_else1:
end_foo_if1_if1:
j end_foo_if1
foo_else1:
li $t1, 1
li $t2, 1
add $t3, $t1, $t2
li $t1, 5
slt $t2, $t3, $t1
beq $t2, 1, foo_else1_if0
j foo_else1_else
foo_else1_if0:
li $t1, 1
sw $t1, 0($sp) 
li $t1, 3
li $t2, 3
move $a0, $t2
jal foo
move $t0, $v0 
j end_foo_else1_if0
foo_else1_else0:
end_foo_else1_if0:
li $t1, 1
li $t2, 1
add $t3, $t1, $t2
li $t1, 5
slt $t2, $t3, $t1
li $t1, 1 #Booleano true
and $t3, $t2, $t1
beq $t3, 1, foo_else1_if1
j foo_else1_else
foo_else1_if1:
li $t1, 1
sw $t1, 0($sp) 
j end_foo_else1_if1
foo_else1_else1:
li $t1, 1
sw $t1, 0($sp) 
j end_foo_else1_if1
end_foo_else1_if1:
j end_foo_if1
end_foo_if1:
li $t1, 0
move $t2, $t1
add $sp, $sp, 12
lw $t0, 0($sp)
move $v0, $t2
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
jal foo
move $t0, $v0 
li $t1, 0
sub $sp, $sp, 4 
sw $t1, 0($sp) 

move $s0, $t0
jal doWhileFoo
move $t0, $s0
move $t1, $v0 
sw $t1, 0($sp) 
li $t1, 0
move $t2, $t1
jal end
#Fin de funcion 

end: 
li $v0,10 
syscall