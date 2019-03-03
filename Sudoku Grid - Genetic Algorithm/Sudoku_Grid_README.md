# INFO6205_209Sudoku Solver:-


The objective of this project is to implement Genetic Algorithm to solve complex Sudoku Grids which are NP Hard Problems.

The puzzle for this project has been supplied in form of text file.

This can be changed to validate any new grid as required.


The Terminalogies defined:


- Grid:- Each grid is representated in 9 rows , 9 columns. Each cell has row represntation , block representation and column representation.

- 
Unit:-



Problem:- This Class presolves the Sudoku Grid feeded to the program.


Individual:- The individual is a partially solved sudoku grid.


Population:- Pool of Individuals that is the pool of parents. The fitter parents are selected as genotypes for the next Generation.


Crossover:- Uniform Crossover is performed between the genotypes to form phenotypes that are nearest to the possible solution of the puzzle.


Mutation:- Probability of Mutation used for solving the puzzles is >0.9.


Selection:- This Class checks the input individuals and selects the best individual from a population of gene pool. This selection is done against a fitness formula.

The Fitness Function : (216-gridconflicts)/216

The Selection method used is Roulette Wheel Selection.

Re-Starting the Problem: After every 20 generations if better solutions are not generated then the program restarts i.e, the Grid id feeded again to the Problem.
 
