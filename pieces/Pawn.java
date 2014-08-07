package pieces;

import java.util.ArrayList;

import chess.Board;

public class Pawn extends Piece {

    public Pawn(Colour colour) {
        super(colour);
    }

    public String getName()
    {
        return "p";
    }

    public double getBaseStrength()
    {
        return 0.5;
    }


    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        { int x=0;
            for (int y=1; y<=2; y++) {
                if ( board.isValidDirection(from, x, y) ) {
                    moves.add(board.getMoveDirection(from, x, y));
                }
            }
        }

        // implementing the diagonal move only to eat
        for (int x=-1; x<=1; x++) {
            { int y=1;
                if (// board.getPosition(board.getMoveDirection(from, x, y)) != null && // maybe redundant
                        board.getPosition(board.getMoveDirection(from, x, y)).getColour() != this.getColour() && 
                        board.isValidDirection(from, x, y) && 
                        x!=0) {
                    moves.add(board.getMoveDirection(from, x, y));
                }
            }
        }
        return moves;
    }
}
