package GridAndUnit;
import java.util.HashSet;
import java.util.Set;

public class Grid {
    protected Unit[] rows;
    protected Unit[] columns;
    protected Unit[] blocks;
    protected int GridConflicts;
    protected int EmptyFieldsCount;

    public Grid(){
        this.GridConflicts=0;
        this.rows=new Unit[9];
        this.columns=new Unit[9];
        this.blocks=new Unit[9];
        this.EmptyFieldsCount=81;
        FillUnits(this.rows);
        FillUnits(this.columns);
        FillUnits(this.blocks);
    }

    public Grid(Grid other){
        this.GridConflicts=other.getGridConflicts();
        this.EmptyFieldsCount=other.EmptyFieldsCount;

        this.rows=new Unit[9];
        this.columns=new Unit[9];
        this.blocks=new Unit[9];
        FillUnits(this.rows);
        FillUnits(this.columns);
        FillUnits(this.blocks);
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                this.rows[i].write(j, other.rows[i].read(j));
                this.rows[i].copy(other.rows[i]);

                this.columns[i].write(j, other.columns[i].read(j));
                this.columns[i].copy(other.columns[i]);

                this.blocks[i].write(j, other.blocks[i].read(j));
                this.blocks[i].copy(other.blocks[i]);
            }
        }
    }


    public void FillUnits(Unit[] units){
        for(int i=0;i<units.length;i++){
            units[i]=new Unit();
        }
    }


    public void write(int x,int y,int number){
        int Block=((y/3)*3)+(x/3);
        int BlockIndex=((y%3)*3)+(x%3);

        if(this.rows[y].read(x)==0) EmptyFieldsCount-=1;
        if(number==0) EmptyFieldsCount+=1;

        this.GridConflicts-=this.rows[y].getConflicts();
        this.GridConflicts-=this.columns[x].getConflicts();
        this.GridConflicts-=this.blocks[Block].getConflicts();


        this.rows[y].write(x,number);
        this.rows[y].setGridIndex(x,this.CellIndexByRow(x,y));
        this.columns[x].write(y,number);
        this.columns[x].setGridIndex(y,CellIndexByRow(x,y));
        this.blocks[Block].write(BlockIndex,number);
        this.blocks[Block].setGridIndex(BlockIndex,CellIndexByRow(x,y));

        this.GridConflicts+=this.rows[y].getConflicts();
        this.GridConflicts+=this.columns[x].getConflicts();
        this.GridConflicts+=this.blocks[Block].getConflicts();

    }

    public void write(int cellIndex,int number){
        write(cellIndex%9,cellIndex/9,number);
    }

    public int CellIndexByRow(int x,int y){
        return y*9+x;
    }

    public int getRowByCellIndex(int cellIndex){
        return cellIndex/9;
    }

    public int getColumnByCellIndex(int cellIndex){
        return cellIndex%9;
    }

    public int getblockByCellIndex(int cellIndex){
        return ((getRowByCellIndex(cellIndex)/3)*3)+(getColumnByCellIndex(cellIndex)/3);
    }



    public int[] getGridIndicesForRow(int rowIndex){
        return rows[rowIndex].getGridIndices();
    }

    public int getRowByIndex(int index) {
        return index / 9;
    }


    public int getColumnByIndex(int index) {
        return index % 9;
    }


    public int getBlockByIndex(int index) {
        return (this.getRowByIndex(index) / 3) * 3 +
                (this.getColumnByIndex(index) / 3);
    }

    public int[] getRowForIndex(int index) {
        return this.rows[this.getRowByIndex(index)].getGridIndices();
    }


    public int[] getColumnForIndex(int index) {
        return this.columns[this.getColumnByIndex(index)].getGridIndices();
    }


    public int[] getBlockForIndex(int index) {
        return this.blocks[this.getBlockByIndex(index)].getGridIndices();
    }


    public int read(int index){
        return this.rows[getRowByCellIndex(index)].read(getColumnByCellIndex(index));
    }



    public Set<Integer> getEmptyCells(){
        Set<Integer> emptyFields=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(rows[i].read(j)==0) {
                    emptyFields.add(CellIndexByRow(j,i));
                }
            }
        }
        return emptyFields;
    }

    public int getGridConflicts(){
        return GridConflicts;
    }

    public String toString(){
        String str="";
        for(int i=0;i<9;i++){
            if(i%3==0) {
                if(i>0 && i<9) {
                    str+="|-------|-------|-------|\n";
                }else {
                    str+="|-----------------------|\n";
                }
            }
            str+=rows[i].print()+"\n";
        }
        str+="|-----------------------|";
        return str;
    }

    public Grid getgrid() {
        return this;
    }
}
