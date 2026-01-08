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
        int r = getCurrentRow();
        int c =  getCurrentCol();
        int tempDim = brett.getDim();
        if(r<0 || r>=tempDim || c<0 || c>=tempDim){
            return false;
        }
        Feld currentFeld = brett.getBrett()[getCurrentRow()][getCurrentCol()];
        if(currentFeld == null){
            return false;
        }
        char currentFeldDirection = currentFeld.getDirection();
            if(r-1 < 0 && currentFeldDirection == 'U'){
                return true;
            } else if(r+1 >= tempDim && currentFeldDirection == 'D'){
                return true;
            }else if(c-1 < 0 && currentFeldDirection == 'L'){
                return true;
            }else if(c+1 >= tempDim && currentFeldDirection == 'R'){
                return true;
            }else {
                return false;
            }
            //bessere alternative
            //switch (dir) {
        //            case 'U': return (currentRow - 1) < 0;
        //            case 'D': return (currentRow + 1) >= dim;
        //            case 'L': return (currentCol - 1) < 0;
        //            case 'R': return (currentCol + 1) >= dim;
        //            default:  return false;
        //        }

    }
    //checks the direction of the current Feld and moves to the next square based off this
    //if on the edge + that direction, doesn't move anymore for rest of turn
    //if boese then stop turn.
    public void go(int n){

        for(int i = 0 ; i < n ; i++){
            Feld current = brett.getBrett()[getCurrentRow()][getCurrentCol()];
            if(current == null){
                continue;
            }
            if(current.getBoese()){
                continue;
            }
            char currentFeldDirection = current.getDirection();
            if(movesOut()){
                continue;
            }
            if( currentFeldDirection == 'U'){
                currentRow--;
            } else if( currentFeldDirection == 'D'){
                currentRow++;
            }else if( currentFeldDirection == 'L'){
                currentCol--;
            }else if(currentFeldDirection == 'R') {
                currentCol ++;
            }
        }
    }
}



