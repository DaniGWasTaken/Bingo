import javax.swing.*;

public class Bingomanual {
    public static int[][] bingo = new int[3][9];
    public static int k=0;
    public static void main(String[] args) {
        int rangoMin=0;
        int rangoMax=10;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {

                boolean flag = false;
                int numero = 0;

                do{
                    boolean flag2=false;
                    do {
                        try {
                            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número:"));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Introduce un número escrito en número");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        if (rangoMin > numero || numero >= rangoMax) {
                            JOptionPane.showMessageDialog(null,"Introduce un número entre " + rangoMin + " y " + rangoMax);
                            flag2=false;
                        } else flag2 = true;
                        if (j>=1 && numero == bingo[(j-1)][k] || j>=2 && numero == bingo [j-2][k]){
                            JOptionPane.showMessageDialog(null,"Introduce un número que no hayas introducido ya");
                            flag2=false;
                        } else flag2=true;
                    } while (!flag2);
                    bingo[j][k]=numero;
                    if (bingo[j][k] != 0 && (bingo[j][k] >= rangoMin && bingo[j][k] < rangoMax)) {
                        flag = true;
                        if (bingo[1][k] != 0 && (bingo[1][k] == bingo[0][k] ||
                                bingo[1][k] == bingo[2][k])) {
                            flag = false;
                        } else if (bingo[2][k] != 0 && (bingo[2][k] == bingo[0][k] ||
                                bingo[2][k] == bingo[1][k])) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                    flag = true;

                } while (!flag);
            }
            ordenar();
            rangoMin+=10;
            rangoMax+=10;
            k++;
        }

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                System.out.print("(" + i + "," + j + ")" + "=" + bingo[i][j] + ";");
            }
            System.out.println();
        }
    }
    public static void ordenar() {

        if ( bingo[0][k] >  bingo[1][k] &&  bingo[0][k] >  bingo[2][k]) {
            int aux;
            if (bingo[1][k] > bingo[2][k]) {
                aux = bingo[0][k];
                bingo[0][k] = bingo[2][k];
                bingo[2][k] = aux;
            } else {
                aux =  bingo[0][k];
                bingo[0][k] = bingo[1][k];
                bingo[1][k] = bingo[2][k];
                bingo[2][k] = aux;
            }
        } else if (bingo[1][k] > bingo[0][k] && bingo[1][k] > bingo[2][k]) {
            int aux;
            int auxDos;
            if ( bingo[0][k] > bingo[2][k]) {
                aux = bingo[0][k];
                auxDos = bingo[1][k];
                bingo[0][k] = bingo[2][k];
                bingo[1][k] = aux;
                bingo[2][k] = auxDos;
            } else {
                aux = bingo[1][k];
                bingo[1][k] = bingo[2][k];
                bingo[2][k] = aux;
            }
        } else {
            if ( bingo[0][k] >  bingo[1][k]) {
                int aux = bingo[0][k];
                bingo[0][k] = bingo[1][k];
                bingo[1][k] = aux;
            }
        }

    }
}