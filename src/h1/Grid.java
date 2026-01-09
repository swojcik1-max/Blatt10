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
        if(cells != null){
            for(Cell a : cells) {
                if(a == null){
                    continue;
                }
                for (int r = 0; r < gridRows; r++) {
                    for (int c = 0; c < gridCols; c++) {
                        if (r == a.getIndexRow() && c == a.getIndexCol()) {
                            //System.out.println("Yessirski");
                            gridArray[r][c].setAlive(a.getAlive());
                        }
                    }
                }
            }
        }
        //have to update the 2d array of Cells given that we just added new Cells to the 2d array
        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen(){

        for(int r = 0 ; r < gridArray.length ; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {

                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
        //rows are .length
        //columns are [0].length
        for(int r = 0 ; r < gridArray.length ; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c].setAlive(gridArray[r][c].getIsAliveNextGen());
            }
        }
    }
    public void computeGeneration(int n){
        if(n <= 0){
            return;
        }
        for(int i = 0 ; i<n ; i++){
            computeNextGen();
        }
    }
    /*public String toStringAliveTest(){
        String end = "";
        for (int r = 0; r < getGridArray().length; r++) {
            boolean track = false;
            for (int c = 0; c < getGridArray()[0].length; c++) {
                System.out.print( "  " + getGridArray()[r][c].getAlive());
                if(c == getGridArray()[0].length-1){
                    track = true;
                }
                if(track){
                    System.out.println();
                }
            }
        }
        return end;
    }

     */
}
