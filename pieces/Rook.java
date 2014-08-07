package pieces;

import java.util.ArrayList;

import chess.Board;

public class Rook extends Piece {

    public Rook(Colour colour) {
        super(colour);
    }

    public String getName()
    {
        return "r";
    }

    public double getBaseStrength()
    {
        return 5.0;
    }

    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        for (int x=-1; x<=1; x++) {
            for (int y=-1; y<=1; y++) {
                if ( !(x==0 && y==0) && !(Integer.compareUnsigned(x, y)==0) ) {
                    continueDirection(moves, from, x, y, board);
                }
            }
        }
        return moves;
    }
}
