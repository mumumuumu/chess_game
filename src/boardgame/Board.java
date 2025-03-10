package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int columns, int rows) {
        if (rows < 1 || columns < 1){
            throw new BoardExpection("Erro ao criar tabuleiro necessário ao menos uma coluna e uma linha");
        }
        this.columns = columns;
        this.rows = rows;
        pieces =  new Piece[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


    public Piece piece(int row, int column){
        if(!positionExists(row,column)){
            throw new BoardExpection(("Position not on the board"));
        }
        return pieces[getRows()][getColumns()];
    }
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){throw new BoardExpection("Já tem uma peça nessa posição" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExists(int row, int column){
        return row > 0 && row < rows && column >=0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());

    }
    public boolean thereIsAPiece(Position position){ if(!positionExists(position)){
        throw new BoardExpection(("Position not on the board"));
    }
        return piece(position) != null;
    }
}
