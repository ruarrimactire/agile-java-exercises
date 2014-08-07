package pieces;

import java.util.ArrayList;

import chess.Board;

public class Knight extends Piece {

    public Knight(Colour colour) {
        super(colour);
    }

    public String getName()
    {
        return "kn";
    }

    public double getBaseStrength()
    {
        return 6.0;
    }

    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        { int x = -1; int y =  3; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x =  1; int y =  3; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x = -1; int y = -3; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x =  1; int y = -3; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }

        { int x = -3; int y =  1; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x = -3; int y = -1; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x =  3; int y =  1; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }
        { int x =  3; int y = -1; 
            if ( board.isValidDirection(from, x, y) ) moves.add(board.getMoveDirection(from, x, y));
        }

        return moves;
    }
}
