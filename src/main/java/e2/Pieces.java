package e2;

public interface Pieces {


    Pair<Integer, Integer> getKnightPosition();

    Pair<Integer, Integer> getPawnPosition();

    void moveKnight(int row, int col);

    boolean areInTheSamePosition();
}
