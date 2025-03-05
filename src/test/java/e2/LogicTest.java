package e2;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  public static final int BOARD_SIZE = 5;
  public static final int INITIAL_ROW = 0;
  public static final int INITIAL_COL = 0;
  public static final int LAST_ROW = 4;
  public static final int LAST_COL = 4;
  public static final int ONE_SQUARE_MOVE = 1;
  public static final int TWO_SQUARE_MOVE = 2;
  public static final int THREE_SQUARE_MOVE = 3;
  private Random random;
  private LogicsImpl logics;
  private PiecesImpl pieces;
  private int row;
  private int col;


  @BeforeEach
  void setUp() {
    logics = new LogicsImpl(BOARD_SIZE);
    random = new Random();
    row = random.nextInt(2) + 1;
    col = (row == 1) ? 2 : 1;
    pieces = new PiecesImpl();
  }

  @Test
  public void test() {
    assert(true);
    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);
  }

  @Test
  void testInitialPositionsAreDifferent() {
    assertNotEquals(pieces.getKnightPosition(),pieces.getPawnPosition());
  }

  @Test
  void testAreInTheSamePosition(){
    if(pieces.areInTheSamePosition()){
      assertEquals(pieces.getKnightPosition(),pieces.getPawnPosition());
    }else{
      assertNotEquals(pieces.getKnightPosition(),pieces.getPawnPosition());
    }
  }

  @Test
  void testKnightCannotMoveOutOfBounds() {
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(-1, 0));
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(BOARD_SIZE, 0));
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(0, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(0, BOARD_SIZE));
  }

  @Test
  void testKnightCannotMoveIllegallyFromTheTop(){
    pieces.moveKnight(INITIAL_ROW, INITIAL_COL);
    assertFalse(logics.hit(INITIAL_ROW, INITIAL_COL + 1));
    assertFalse(logics.hit(INITIAL_ROW, INITIAL_COL + 2));
    assertFalse(logics.hit(INITIAL_ROW, INITIAL_COL + 3));
    assertFalse(logics.hit(INITIAL_ROW + 1, INITIAL_COL));
    assertFalse(logics.hit(INITIAL_ROW + 2, INITIAL_COL));
    assertFalse(logics.hit(INITIAL_ROW + 3, INITIAL_COL));
  }

  @Test
  void testKnightCannotMoveIllegallyFromTheBottom(){
    pieces.moveKnight(LAST_ROW, LAST_COL);
    assertFalse(logics.hit(LAST_ROW, LAST_COL - ONE_SQUARE_MOVE));
    assertFalse(logics.hit(LAST_ROW, LAST_COL - TWO_SQUARE_MOVE));
    assertFalse(logics.hit(LAST_ROW, LAST_COL - THREE_SQUARE_MOVE));
    assertFalse(logics.hit(LAST_ROW - ONE_SQUARE_MOVE, LAST_COL));
    assertFalse(logics.hit(LAST_ROW - TWO_SQUARE_MOVE, LAST_COL));
    assertFalse(logics.hit(LAST_ROW - THREE_SQUARE_MOVE, LAST_COL));
  }

  @Test
  void testKnightMoveCorrectlyFromTheTop(){
    pieces.moveKnight(INITIAL_ROW, INITIAL_COL);
    logics.hit(row,col);
  }

  @Test
  void testKnightMoveCorrectlyFromTheBottom(){
    pieces.moveKnight(LAST_ROW, LAST_COL);
    logics.hit(row,col);
  }
}
