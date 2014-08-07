package pieces;

import java.util.ArrayList;

import chess.Board;

public class Knight extends Piece {

    public Knight(Colour colour) {
        super(colour);
    }

    public String getName()
    {
        return "n";
    }

    public double getBaseStrength()
    {
        return 2.5;
    }

    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        for(int x=-1; x<=1; x+=2){
            for(int y=-3; y<=3; y+=6){
                if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
            }
        }

        for(int y=-1; y<=1; y+=2){
            for(int x=-3; x<=3; x+=6){
                if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
            }
        }
        
        return moves;
    }
}
