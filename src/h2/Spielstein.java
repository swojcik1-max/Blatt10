package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol){
        currentRow = indexRow;
        currentCol = indexCol;
        this.brett = brett;
    }
    //Getter and Setter methods for Spielstein
    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }
    //checks if the player is on the edge of the board and returns true if they will fall with their next move
    private boolean movesOut(){
        Feld currentFeld = brett.getBrett()[getCurrentRow()][getCurrentCol()];
        char currentFeldDirection = currentFeld.getDirection();
        int tempDim = brett.getDim();
            if(getCurrentRow() == 0 && currentFeldDirection == 'U'){
                return true;
            } else if(getCurrentRow() == tempDim && currentFeldDirection == 'D'){
                return true;
            }else if(getCurrentCol() == 0 && currentFeldDirection == 'L'){
                return true;
            }else if(getCurrentCol() == tempDim && currentFeldDirection == 'R'){
                return true;
            }else {
                return false;
            }


    }
    //checks the direction of the current Feld and moves to the next square based off this
    //if on the edge + that direction, doesn't move anymore for rest of turn
    //if boese then stop turn.
    public void go(int n){
        Feld current = brett.getBrett()[getCurrentRow()][getCurrentCol()];
        char currentFeldDirection = current.getDirection();
        for(int i = 0 ; i < n ; i++){
            if(movesOut()){
                return;
            }
            if(current.getBoese()){
                return;
            }
            if( currentFeldDirection == 'U'){
                currentRow+=1;
            } else if( currentFeldDirection == 'D'){
                currentRow-=1;
            }else if( currentFeldDirection == 'L'){
                currentCol-=1;
            }else if(currentFeldDirection == 'R') {
                currentCol += 1;
            }
        }
    }
}



