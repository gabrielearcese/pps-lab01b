package e2;

import java.util.Random;

public class PiecesImpl implements Pieces{

    public static final int SIZE = 5;
    private final Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;
    private final Random random = new Random();

    public PiecesImpl() {
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(SIZE),this.random.nextInt(SIZE));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public void moveKnight(int row, int col){
        this.knight = new Pair<>(row,col);
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawn;
    }

    @Override
    public boolean areInTheSamePosition(){
        if(getKnightPosition() == getPawnPosition()){
            return true;
        }else{
            return false;
        }
    }
}
