package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Board getBoard() {
        return board;
    }
    public Piece(Board board) {
        this.board = board;
        position = null;
    }
}
