public class Bingo {
    public static int[][] bingo = new int[3][9];
    public static int k = 0;
    public static int simple = 6;
    public static int doble = 3;

    public static void main(String[] args) {
        boolean flag;
        int rangoMin = 0;
        int rangoMax = 10;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    bingo[j][k] = (int) (Math.random() * 100);
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
                } while (!flag);
            }
            ordenar();
            huecos();
            rangoMin += 10;
            rangoMax += 10;
            k++;
        }

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                if (bingo[i][j] < 10){
                    System.out.print(" "+bingo[i][j] + ", ");
                }else {
                    System.out.print(bingo[i][j] + ", ");
                }
                }
            System.out.println();
        }
    }

    public static void ordenar() {

        if (bingo[0][k] > bingo[1][k] && bingo[0][k] > bingo[2][k]) {
            int aux;
            if (bingo[1][k] > bingo[2][k]) {
                aux = bingo[0][k];
                bingo[0][k] = bingo[2][k];
                bingo[2][k] = aux;
            } else {
                aux = bingo[0][k];
                bingo[0][k] = bingo[1][k];
                bingo[1][k] = bingo[2][k];
                bingo[2][k] = aux;
            }
        } else if (bingo[1][k] > bingo[0][k] && bingo[1][k] > bingo[2][k]) {
            int aux;
            int auxDos;
            if (bingo[0][k] > bingo[2][k]) {
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
            if (bingo[0][k] > bingo[1][k]) {
                int aux = bingo[0][k];
                bingo[0][k] = bingo[1][k];
                bingo[1][k] = aux;
            }
        }
    }

    public static void huecos() {
        //declaramos las variables a usar, que serán:
        int hueco; //la fila en la que haremos el hueco
        int hueco2; //la segunda fila en caso de que salga un hueco doble
        int random = (int)(Math.random()*2); //un número aleatorio que elige si hay un hueco simple o doble en la columna

        //un if que genera el hueco simple ya sea si lo elige la variable "random" o si ya se han hecho 3 huecos dobles
        if (random == 0 && simple != 0 || doble==0){
            hueco = (int) (Math.random() * 3); //se elige una fila aleatoria donde se hará el hueco
            bingo[hueco][k] = 0; //se cambia el valor de la casilla por 0 para simbolizar el hueco
            simple=simple-1; //resta uno al contador de huecos simples en el cartón
        }
        //otro if que genera 2 huecos en casillas diferentes cuando lo elige la variable "random o ya se han hecho 6 huecos simples
        if (random == 1 && doble != 0 || simple==0){
            hueco = (int) (Math.random() * 3); //se elige una fila aleatoria donde se hará el hueco
            bingo[hueco][k] = 0; //se cambia el valor de la casilla por 0 para simbolizar el hueco
            do {
                hueco2 = (int) (Math.random() * 3); //se genera un número aleatorio para la segunda fila y se comprueba que es distinto del primero
            } while (hueco2 == hueco);
            bingo[hueco2][k] = 0; //se cambia el valor de la casilla por 0 para simbolizar el hueco
            doble=doble-1; //resta uno al contador de huecos dobles en el cartón
        }
    }
}