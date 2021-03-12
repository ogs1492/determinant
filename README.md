# Determinant Test
A small program to test the speed of recursively calculating determinants

There are four functions: generateMinor (creates a minor of a matrix), determinant (finds the determinant of a given matirx), generateMatrix (grenerates a random matrix with vallues from 0 to 99), and runTests (calculates determiantns of a specified number or NxN matrices ad prints out the total and average time).

Theoretically, due to the recursive nature of the definition of the determinant, the number of operations needed to find the determiant of a larger matrix should be much greater than smaller matrices.
Running the tests shows that increasing the dimensions of a matrix by one increases the amount of time needed by a factor of ten.
