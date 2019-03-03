package IndividualAndPopulation;
import java.util.Iterator;
import java.util.TreeSet;

public class Population
{
    private double totFitness;
    private TreeSet<Individuals> populus;
    private int sizeOfPopulation;

    public Population()
    {
        this.totFitness=0.0;
        this.populus=new TreeSet<>();
        this.sizeOfPopulation= 1000;
    }

    public Population(Population diff)
    {
        this();
        this.totFitness=diff.totFitness;
        Iterator<Individuals> iterator=diff.populus.iterator();
        while(iterator.hasNext())
        {
            this.populus.add(new Individuals(iterator.next()));
        }

    }

    public void creatrandomIndividuals()
    {
        for(int i=0;i<sizeOfPopulation;i++)
        {
            this.add(new Individuals());
        }
    }

    public void add(Individuals i)
    {
        if(this.populus.size()<this.sizeOfPopulation)
        {
            this.totFitness+=i.getFitness();
            this.populus.add(i);
        }
    }

    public void add(Individuals[] individuals)
    {
        for(Individuals indi:individuals)
        {
            this.add(indi);
        }
    }

    public Individuals[] get(int numb){
        Individuals[] fitIndividual= new Individuals[numb];
        int point=0;
        if(fitIndividual.length>0){
            for(Individuals individual :populus){
                fitIndividual[point]=new Individuals();
                if(++point==fitIndividual.length)break;
            }
        }
        return fitIndividual;
    }

    public double getTotalFitness(){
        return this.totFitness;
    }

    public double getAvgFitness() {return this.totFitness/(double) this.populus.size();}

    public boolean isFull() { return this.populus.size()==this.sizeOfPopulation;}

    public Individuals getBestIndividual(){
        return this.populus.first();
    }

    public TreeSet getPopulus() {
        return this.populus;
    }

    public boolean testingFirstPopulation() {
    	this.creatrandomIndividuals();
        double BestFitness=this.getBestIndividual().getFitness();
        int ctr=0;

        TreeSet<Individuals> tree=getPopulus();
        Iterator<Individuals> iterator=tree.iterator();
        while(iterator.hasNext()) {
            double IndividualFitness=iterator.next().getFitness();
            if(IndividualFitness<=BestFitness && IndividualFitness<1) ctr++;
        }
        return sizeOfPopulation==ctr;
    }
}
