package com.company;

public class GameBoard {
    private String[][] forceFour = new String[6][7];
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
        if (this.rowWin() || this.columnWin() || this.diagonalWin() || this.diagonalReverseWin()) {
            return "Win";
        }
        else{
            for (int i = 5; i >= 0 ; i --) {
                if (forceFour[i][column].equals("free")) {
                    forceFour[i][column] = sign;
                    this.lastSign = sign;
                    counter++;
                    return "Added";
                }
            }
        }
        if (counter == 42) {
            return "Draw";
        }
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
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 3; j++){
                if (forceFour[j][i].equals("x") && forceFour[1+j][i].equals("x") && forceFour[2+j][i].equals("x") && forceFour[3+j][i].equals("x")) {
                    return true;
                }
                if (forceFour[j][i].equals("o") && forceFour[1+j][i].equals("o") && forceFour[2+j][i].equals("o") && forceFour[3+j][i].equals("o")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalWin(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (forceFour[j][j+i].equals("x") && forceFour[1+j][1+j+i].equals("x")&& forceFour[2+j][2+j+i].equals("x") && forceFour[3+j][3+j+i].equals("x")) {
                    return true;
                }
                if (forceFour[j][j+i].equals("o") && forceFour[1+j][1+j+i].equals("o")&& forceFour[2+j][2+j+i].equals("o") && forceFour[3+j][3+j+i].equals("o")) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (forceFour[1+j-i][j+2*i].equals("x") && forceFour[2+j-i][1+j+2*i].equals("x")&& forceFour[3+j-i][2+j+2*i].equals("x") && forceFour[4+j-i][3+j+2*i].equals("x")) {
                    return true;
                }
                if (forceFour[1+j-i][j+2*i].equals("o") && forceFour[2+j-i][1+j+2*i].equals("o")&& forceFour[3+j-i][2+j+2*i].equals("o") && forceFour[4+j-i][3+j+2*i].equals("o")) {
                    return true;
                }
            }
        }
        if (forceFour[2][0].equals("x") && forceFour[3][1].equals("x") && forceFour[4][2].equals("x") && forceFour[5][3].equals("x")) {
            return true;
        }
        if (forceFour[2][0].equals("o") && forceFour[3][1].equals("o") && forceFour[4][2].equals("o") && forceFour[5][3].equals("o")) {
            return true;
        }
        if (forceFour[0][3].equals("x") && forceFour[1][4].equals("x") && forceFour[2][5].equals("x") && forceFour[3][6].equals("x")) {
            return true;
        }
        if (forceFour[0][3].equals("o") && forceFour[1][4].equals("o") && forceFour[2][5].equals("o") && forceFour[3][6].equals("o")) {
            return true;
        }
        return false;
    }

    private boolean diagonalReverseWin(){
        for (int i = 0; i < 2 ; i++){
            int row=0;
            for (int j = 3; j >0; j--){
                if (forceFour[row][j+3-i].equals("x") && forceFour[row+1][j+2-i].equals("x") && forceFour[row+2][j+1-i].equals("x") && forceFour[row+3][j-i].equals("x")) {
                    return true;
                }
                if (forceFour[row][j+3-i].equals("o") && forceFour[row+1][j+2-i].equals("o") && forceFour[row+2][j+1-i].equals("o") && forceFour[row+3][j-i].equals("o")) {
                    return true;
                }
                if (j>1) {
                    row++;
                }
            }
        }
        for (int i = 0; i < 2; i++){
            int row=0;
            for(int j = 2; j > 0; j--){
                if (forceFour[row+i][j+2+i*2].equals("x") && forceFour[row+1+i][j+1+i*2].equals("x") && forceFour[row+2+i][j+i*2].equals("x") && forceFour[row+3+i][j-1+i*2].equals("x")) {
                    return true;
                }
                if (forceFour[row+i][j+2+i*2].equals("o") && forceFour[row+1+i][j+1+i*2].equals("o") && forceFour[row+2+i][j+i*2].equals("o") && forceFour[row+3+i][j-1+i*2].equals("o")) {
                    return true;
                }
                if (j>1) {
                    row++;
                }
            }
        }
        if (forceFour[2][6].equals("x") && forceFour[3][5].equals("x") && forceFour[4][4].equals("x") && forceFour[5][3].equals("x")) {
            return true;
        }
        if (forceFour[2][6].equals("o") && forceFour[3][5].equals("o") && forceFour[4][4].equals("o") && forceFour[5][3].equals("o")) {
            return true;
        }
        if (forceFour[0][3].equals("x") && forceFour[1][2].equals("x") && forceFour[2][1].equals("x") && forceFour[3][0].equals("x")) {
            return true;
        }
        if (forceFour[0][3].equals("o") && forceFour[1][2].equals("o") && forceFour[2][1].equals("o") && forceFour[3][0].equals("o")) {
            return true;
        }
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

