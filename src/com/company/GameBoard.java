package com.company;

public class GameBoard {
    public String[][] forceFour = new String[6][7];
    static int counter = 0;
    private String lastSign = "";

    public String setSign(int column, String sign) {
        this.initializeBoard();
        if (column > 6 || column < 0) {
            return "Not existent column ";
        }
        if (!sign.equals("o") && !sign.equals("x")) {
            return "Invalid sign";
        }
        if (sign.equals(lastSign)) {
            return "This is not your turn";
        }
        if (!forceFour[0][column].equals("free")) {
            return "Column already occupied";
        }
        if (this.rowWin() || this.columnWin() || this.diagonalWin()) {
            return "Win";
        }
        for (int i = 5; i>=0 ; i--) {
            if (forceFour[i][column].equals("free")) {
                forceFour[i][column] = sign;
                counter++;
                this.lastSign = sign;
            }
            break;
        }
        if (counter == 42)
            return "Draw";
        return "";
    }

    private boolean rowWin() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (forceFour[i][j].equals("x") && forceFour[i][1 + j].equals("x") && forceFour[i][2 + j].equals("x") && forceFour[i][3+j].equals("x")) {
                    return true;
                }
                if (forceFour[i][j].equals("o") && forceFour[i][1 + j].equals("o") && forceFour[i][2 + j].equals("o") && forceFour[i][3+j].equals("o")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean columnWin(){
        for (int i=0; i<7;i++){
            for (int j=0; j<2;j++){
                if (forceFour[j][i].equals("x") && forceFour[1+j][i].equals("x")) {
                    return true;
                }
                if (forceFour[j][i].equals("o") && forceFour[1+j][i].equals("o")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalWin(){
        return false;
    }

    public void showGameBoard(){
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                System.out.print(forceFour[i][j] +"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void initializeBoard(){
        for (int i=0;i<6;i++) {
            for (int j = 0; j < 7; j++) {
                if (this.forceFour[i][j]==null)
                    this.forceFour[i][j]="free";
            }
        }
    }

    public void resetBoard() {
        for (int i=0;i<6;i++) {
            for (int j = 0; j < 7; j++) {
                this.forceFour[i][j]=null;
            }
        }
    }
}

