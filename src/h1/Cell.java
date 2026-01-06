package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;
    //need the constructor first before any methods.
    public Cell(int indexRow, int indexCol, boolean alive){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }
    public Cell(int indexRow, int indexCol){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        alive = false;
    }

    public int getIndexRow(){
        return indexRow;
    }
    public void setIndexRow(int input){
        indexRow = input;
    }
    public int getIndexCol(){
        return indexCol;
    }
    public void setIndexCol(int input){
        indexCol = input;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean tF){
        alive = tF;
    }
    public void setNumOfLivingNeighbors(int numOfLivingNeighbors) {
        this.numLivingNeighbors = numOfLivingNeighbors;
    }
    public int getNumOfLivingNeighbors(){
        return numLivingNeighbors;
    }
    public boolean getIsAliveNextGen(){
        return isAliveNextGen;
    }
    public void setIsAliveNextGen(boolean tF){
        isAliveNextGen = tF;
    }


    public void countLivingNeighbors(Cell[][] gridArray){
        int counter = 0;
        int rowT ;
        int colT ;
        for(int row = -1 ; row <= 1 ; row++){
            for(int col = -1 ; col <= 1 ; col++){
                if(row == 0 && col == 0){
                    continue;
                }
                rowT = indexRow + row;
                colT = indexCol + col;
                if(rowT >= 0 && rowT < gridArray.length){
                    if(colT >= 0 && colT < gridArray[0].length){
                        if(gridArray[rowT][colT].getAlive()){
                            counter++;
                        }
                    }
                }
            }
        }
        this.numLivingNeighbors = counter;
        decideNextStatus();
    }
    private void decideNextStatus(){
        if(this.alive){
            if (this.numLivingNeighbors == 2 || this.numLivingNeighbors == 3) {
                this.isAliveNextGen = true;
            }
        } else {
            this.isAliveNextGen = (this.numLivingNeighbors == 3);
        }

    }
}
