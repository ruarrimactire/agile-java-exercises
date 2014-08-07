package tests;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import tests.chess.BoardTest;
import tests.chess.GameTest;
import tests.pieces.KingTest;
import tests.pieces.PieceTest;
import tests.pieces.QueenTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(GameTest.class);
        suite.addTestSuite(BoardTest.class);
        suite.addTestSuite(KingTest.class);
        suite.addTestSuite(QueenTest.class);
        return suite;
    }

    public static void main(String [] args) {
        TestResult nuovo = new TestResult();
        suite().run(nuovo);
        
        System.out.println("Errors: \t" + nuovo.errorCount() );
        if(nuovo.errors().hasMoreElements())
            System.out.println(nuovo.errors().nextElement().toString() );
        System.out.println("Failures:\t" + nuovo.failureCount() );
        if(nuovo.failures().hasMoreElements())
            System.out.println(nuovo.failures().nextElement().toString() );
    }

}
