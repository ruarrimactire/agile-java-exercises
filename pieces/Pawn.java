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

        if(this.isWhite()){
            { int x=0; int y=-1;
                if ( board.isValidDirection(from, x, y) && board.getPosition(board.getMoveDirection(from, x, y)).isEmpty() ) 
                        moves.add(board.getMoveDirection(from, x, y));
            }
            { int x=0; int y=-2;
                if ( board.isValidDirection(from, x, y) && board.getPosition(board.getMoveDirection(from, x, y)).isEmpty() && board.getPosition(board.getMoveDirection(from, x, y+1)).isEmpty() ) 
                        moves.add(board.getMoveDirection(from, x, y));
            }
            // implementing the diagonal move only to eat
            for (int x=(-1); x<=1; x+=2) {
                {   int y=-1;
                    if (  board.isValidDirection(from, x, y) && 
                          board.getPosition(board.getMoveDirection(from, x, y)).isBlack()  ) {
                        moves.add(board.getMoveDirection(from, x, y));
                    }
                }
            }
        }
        else if(this.isBlack()){
            { int x=0; int y=1;
                if ( board.isValidDirection(from, x, y) && board.getPosition(board.getMoveDirection(from, x, y)).isEmpty() ) 
                        moves.add(board.getMoveDirection(from, x, y));
            }
            { int x=0; int y=2;
                if ( board.isValidDirection(from, x, y) && board.getPosition(board.getMoveDirection(from, x, y)).isEmpty() && board.getPosition(board.getMoveDirection(from, x, y-1)).isEmpty() ) 
                        moves.add(board.getMoveDirection(from, x, y));
            }
            // implementing the diagonal move only to eat
            for (int x=(-1); x<=1; x+=2) {
                {   int y=1;
                    if (  board.isValidDirection(from, x, y) && 
                          board.getPosition(board.getMoveDirection(from, x, y)).isWhite()  ) {
                        moves.add(board.getMoveDirection(from, x, y));
                    }
                }
            }
        }
        return moves;
    }
}
