package tests.pieces;

import java.util.ArrayList;

import pieces.Pawn;
import pieces.Rook;
import pieces.Bishop;
import pieces.Piece.Colour;

import chess.Board;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

    public void testToString() {
        Board board = new Board();
        Pawn pawn = new Pawn(Colour.WHITE);
        assertEquals("P", pawn.toString());
        board.setPosition("d5", new Pawn(Colour.BLACK));
        assertEquals( "p", board.getPosition("d5").toString() );
    }

    public void testGetAvailableMovesPawn()
    {
        Board board = new Board();
        Pawn pawn = new Pawn(Colour.BLACK);
        board.setPosition("d5", pawn);
        board.setPosition("c6", new Bishop(Colour.BLACK));
        board.setPosition("e6", new Bishop(Colour.WHITE));
        board.setPosition("h6", new Rook(Colour.WHITE));
        board.setPosition("d8", new Bishop(Colour.WHITE)); 
        ArrayList<String> moves = pawn.getPossibleMoves(board);
        
//        System.out.println(board.toString());
//        { int i=0;
//        while(i < moves.size()){
//            System.out.println(moves.get(i));
//            i++;
//        }}

        assertEquals(3, moves.size());
        assertFalse(moves.contains("d5"));
        assertFalse(moves.contains("c5"));
        assertFalse(moves.contains("d4"));
        assertFalse(moves.contains("d3"));

        assertFalse(moves.contains("c4"));
        assertFalse(moves.contains("e4"));
        assertFalse(moves.contains("c5"));
        assertFalse(moves.contains("e5"));
        assertFalse(moves.contains("c6"));
        assertTrue(moves.contains("d6"));
        assertTrue(moves.contains("e6"));
    }

    public void testGetAvailableMovesPawnCorner()
    {
        Board board = new Board();
        board.setPosition("a1", new Pawn(Colour.BLACK));
        ArrayList<String> moves = board.getPosition("a1").getPossibleMoves(board);

//        System.out.println(board.toString());
//        { int i=0;
//        while(i < moves.size()){
//            System.out.println(moves.get(i));
//            i++;
//        }}

        assertEquals(2, moves.size());
        assertFalse(moves.contains("b1"));
        assertFalse(moves.contains("b2"));
        assertTrue(moves.contains("a3"));
        assertTrue(moves.contains("a2"));
    }

    public void testGetBaseStrength()
    {
        Pawn pawn = new Pawn(Colour.BLACK);
        assertEquals(0.5, pawn.getBaseStrength());
    }
}
