package h1;

public class Grid {
    private Cell [][] gridArray;

    //Getter and Setter for das OBJEKT ATTRIBUTE
    public Cell[][] getGridArray(){
        return gridArray;
    }
    public void setGridArray(Cell [][] gridArray){
        this.gridArray = gridArray;
    }
    public Grid(Cell[] cells, int gridRows, int gridCols){
        //setting the size of the grid that is to be filled with cells
        gridArray = new Cell[gridRows][gridCols];


        //all Cells created in Grid Array, default of dead
        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c] = new Cell(r,c,false);
            }
        }
        //setting the cells that are in the 1d array cells to alive in the 2d gridArray
        for(Cell a : cells) {
            if(a == null){
                continue;
            }
            for (int r = 0; r < gridRows; r++) {
                for (int c = 0; c < gridCols; c++) {
                    if (gridArray[r][c].getIndexRow() == a.getIndexRow() && gridArray[r][c].getIndexCol() == a.getIndexCol()) {
                        gridArray[r][c].setAlive(true);
                    }
                }
            }
        }
    }

    public void computeNextGen(){
        for(int a = 0 ; a < gridArray[0].length ; a++) {
            for (int i = 0; i < gridArray.length; i++) {
                gridArray[a][i].countLivingNeighbors(gridArray);
            }
        }
    }
    public void computerGeneration(int n){
        if(n <= 0){
            return;
        }
        for(int i = 0 ; i<n ; i++){
            computeNextGen();
            //rows are .length
            //columns are [0].length
            for(int r = 0 ; r < gridArray.length ; r++) {
                for (int c = 0; c < gridArray[0].length; c++) {
                    if(gridArray[r][c].getIsAliveNextGen()){
                        gridArray[r][c].setAlive(true);
                    }
                }
            }
        }
    }
}
