package App;

import GeneticAlgo.Crossover;
import GeneticAlgo.Mutation;
import GeneticAlgo.Selection;
import IndividualAndPopulation.Individuals;
import IndividualAndPopulation.Population;

import java.util.ArrayList;
import java.util.Iterator;

public final class GeneticSolver {

    public Population population;
    public Population PreviousPopulation;
    public Population restartPopulation;
    public Population generationElites;
    public ArrayList<Double> bestFitnessForGeneration;
    public int generation;

    private Mutation mutation;
    private Crossover crossover;
    private Selection selection;
    private int populationSize;

    public GeneticSolver() {
        this.crossover=new Crossover(2);
        this.selection=new Selection();
        this.mutation=new Mutation();
        this.populationSize = 1000;
        this.population = new Population();
        this.population.creatrandomIndividuals();
        this.PreviousPopulation = new Population(this.population);
        this.restartPopulation = new Population(this.population);
        this.generationElites = new Population();
        this.bestFitnessForGeneration = new ArrayList<>();
        this.generation = 1;
    }

    private void restart() {
        System.out.println("The Problem is restarting:");
        if (this.generationElites.isFull()) {
            this.restartPopulation = new Population(this.generationElites);
            this.generationElites = new Population();
        } else {
            this.generationElites.add(this.population.get(this.populationSize / 20));
        }
        this.population = new Population(this.restartPopulation);
        this.bestFitnessForGeneration = new ArrayList<>();
        this.generation = 1;

    }

    public Individuals findSolution() {
        while (this.population.getBestIndividual().getGridConflicts() > 0) {
            this.Evolution();
            this.bestFitnessForGeneration.add(this.population.getBestIndividual().getFitness());

//            System.out.println(population.getAvgFitness());

            if (this.bestFitnessForGeneration.size()  >= 20 &&
                    this.population.getBestIndividual().getFitness() <= this.bestFitnessForGeneration.get(this.bestFitnessForGeneration.size() - 20)) {
                this.restart();
            }
        }
        return this.population.getBestIndividual();
    }

    private void Evolution() {
        Population newPopulation = new Population();
        this.addElites(newPopulation);
        this.addDescendants(newPopulation);
        this.PreviousPopulation = this.population;
        this.population = newPopulation;
        this.generation += 1;
    }

    private void addElites(Population newPopulation) {
        newPopulation.add(this.population.get(2));
    }

    private void addDescendants(Population newPopulation) {
        int counter = 2;
        Iterator<Individuals> iterator=this.PreviousPopulation.getPopulus().iterator();
        while(iterator.hasNext()) {
            Individuals carryovers=iterator.next();
            this.crossover.setChild(carryovers);
            while(this.crossover.needsParent()) {
                this.crossover.addingParent(this.selection.select(this.population));
            }
            newPopulation.add(this.mutation.mutateIndividual(this.crossover.crossOver()));
            if (++counter == this.populationSize) break;
        }
    }

    public Population getBackupPopulation(){
        return this.PreviousPopulation;
    }

    public Population getevolvedPopulation(){
        return this.population;
    }

    public boolean testingEvolution(){
        Evolution();
        return this.getBackupPopulation().getBestIndividual().getFitness()<this.getevolvedPopulation().getBestIndividual().getFitness()+2;
    }

}
