/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nuevo;

/**
 *
 * @author ar466
 */
public class Tablero_1 {
    private int fila = 6;
    private int columna = 6;
    private FichasTablero[][] tablero;
    private String Player1;
    private String Player2;

    public Tablero_1() {
        tablero = new FichasTablero[fila][columna];
        Player1 = Usuarios.getUsername(1);
        Player2 = Usuarios.getUsername(2);
        inicializartablero();
    }

    private void inicializartablero() {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (i == 0 || i == (fila - 1)) {

                    switch (j) {
                        case 0:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'W');
                            break;
                        case 1:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'V');
                            break;
                        case 2:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'N');
                            break;
                        case 3:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'N');
                           break;
                        case 4:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'V');
                            break;
                        case 5:
                            tablero[i][j] = new FichasTablero(((i == 0) ? Player1: Player2), 'W');
                            break;
                        default:
                            tablero[i][j] = null;
                    }

                } else tablero[i][j] = null;

            }
        }
    }

    public String getValorCasilla(int fila, int columna) {
        if (tablero[fila][columna] != null) {
            return tablero[fila][columna].getMonster();
        }
        return " ";
    }

    public boolean InvocarZombie(int fila, int columna, int Turno) {

        if (tablero[fila][columna] == null) {

            tablero[fila][columna] = new FichasTablero(((Turno == 1) ? Player1 : Player2), 'Z');
            return true;
        }

        return false;
    }

    public void removeFicha(int x, int y) {
        tablero[x][y] = null;
    }

    public FichasTablero getFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean MoveFicha(int Xorigin, int Yorigin, int XDestiny, int YDestiny) {
        try {

            tablero[XDestiny][YDestiny] = tablero[Xorigin][Yorigin];
            tablero[Xorigin][Yorigin] = null;

            return true;
        } catch (Exception e) {}
        return false;
    }

    public int getFilas() {
        return fila;
    }

    public int getColumnas() {
        return columna;
    }

}
