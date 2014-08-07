package tests.pieces;

import java.util.ArrayList;

import pieces.Queen;
import pieces.Piece.Colour;

import chess.Board;

import junit.framework.TestCase;

public class QueenTest extends TestCase {

    public void testToString() {
        Queen queen = new Queen(Colour.WHITE);
        assertEquals("Q", queen.toString());
   }

    public void testGetAvailableMoves()
    {
        Board board = new Board();
        Queen queen = new Queen(Colour.WHITE);
        board.setPosition("a1", queen);
        board.setPosition("a5", new Queen(Colour.BLACK)); // attenzione non deve scavalcare
        ArrayList<String> moves = queen.getPossibleMoves(board);

//        System.out.println("Test regina: ");
//        System.out.println(board.toString());
//        { int i=0;
//        while(i < moves.size()){
//            System.out.println(moves.get(i));
//            i++;
//        }}

        assertFalse(moves.contains("a1"));
        assertTrue(moves.contains("h1"));
        assertTrue(moves.contains("a5"));
        assertFalse(moves.contains("a8"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("h8"));
    }
}
