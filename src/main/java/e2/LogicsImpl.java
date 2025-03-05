package e2;

import java.util.*;

public class LogicsImpl implements Logics {

	private final int size;
	private PiecesImpl pieces;

	public LogicsImpl(int size){
		this.size = size;
		this.pieces = new PiecesImpl();
	}

	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.pieces.getKnightPosition().getX();
		int y = col-this.pieces.getKnightPosition().getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.pieces.moveKnight(row, col);
			return this.pieces.getPawnPosition().equals(this.pieces.getKnightPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.pieces.getKnightPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pieces.getPawnPosition().equals(new Pair<>(row,col));
	}

}