package App;
import GridAndUnit.Grid;
import IndividualAndPopulation.Individuals;
import InputGrid.Reader;
import Prep.Problem;

public class Application {
    private Grid grid;
    private Problem presolvedgrid;
    private static Application data=null;
    private Reader reader;
    private Application() {
        System.out.println("Starting Sudoku Solver:");
        reader=new Reader("Grid1.txt");
        grid=reader.reader();
        System.out.println("The Grid we are trying to solve:");
        System.out.println(grid);
    }

    public static Application getinstance() {
        if(data==null) data=new Application();
        return data;
    }

    public Grid getGrid() {
        return grid;
    }

    public Problem getPreSolvedGrid() {
        presolvedgrid=new Problem(grid);
        return presolvedgrid;
    }

    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        Application SudokuToSolve=Application.getinstance();
        Grid grid=SudokuToSolve.getGrid();

        GeneticSolver world=new GeneticSolver();
        Individuals solution=world.findSolution();
        System.out.println("\nThe Sudoku after Eleminations are Performed: ");
        System.out.println(Application.getinstance().getPreSolvedGrid());
        System.out.println("The Solution to your Sudoku Problem is: ");
        if(solution!=null)System.out.println(solution);
    }

}
