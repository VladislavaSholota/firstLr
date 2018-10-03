import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Methods {
    Integer n, m;
    Double [] function;
    Double [][] coefficient;
    Scanner scanner;
    public Methods(){
        scanner = new Scanner(System.in);
        System.out.println("");
        n = scanner.nextInt();
        System.out.println("Введіть коефіцієнти цільової функції");
        function = new Double[n];
        for (int i = 0; i < n; i ++){
            function[i] = scanner.nextDouble();
        }
        System.out.println("Введіть кількість обмежень");
        m = scanner.nextInt();
        coefficient = new Double[m][m + 1];
        System.out.println("Введіть матрицю коефіцієнтів");
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n + 1; j ++){
                coefficient[i][j] = scanner.nextDouble();
            }
        }
        simplex();

    }

    private void simplex(){
        Double [][] simplexTable = new Double[m + 1][m + n + 1];
        Integer [] numbersBasis = new Integer[m];
        for (int i = 0; i < m; i ++){
            numbersBasis[i] = i + n + 1;
        }
        for (int i = 0; i < m + 1; i ++){
            for (int j = 0; j < m + n + 1; j ++){
                simplexTable[i][j] = 0.0;
            }
        }
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                simplexTable[i][j] = coefficient[i][j];
            }
        }
        for (int j = 0; j < n; j ++){
            simplexTable[m][j] = - function[j];
        }
        for (int i = 0; i < m; i ++){
            simplexTable [i][m+n] = coefficient[i][n];
        }
        for (int i = 0; i < m; i ++){
            simplexTable [i][i + n] = 1.0;
        }
        for (int i = 0; i < m + 1; i ++){
            for (int j = 0; j < m + n + 1; j ++){
                System.out.print(simplexTable[i][j] + "  ");
            }
            System.out.println();
        }
       // Boolean a = true;
        while (true){
            Double min = simplexTable[m][0];
            Integer count = 0;
            for (int i =0; i < n + m; i ++){
                if (min > simplexTable[m][i]){
                    count = i;
                    min = simplexTable[m][i];
                }
            }
            if (min >= 0){
                break;
            }
            Double k = 10000000000.0;
            Integer b = - 1;
            for (int i = 0; i < m; i ++){
                if (simplexTable[i][count] == 0){
                    continue;
                }
                if (simplexTable[i][m + n]/simplexTable[i][count] < k && simplexTable[i][m + n]/simplexTable[i][count] > 0){
                    k = simplexTable[i][m + n]/simplexTable[i][count];
                    b = i;
                }
            }
            if (b == - 1){
                break;
            }
            numbersBasis[b] = count + 1;
            if (simplexTable[b][count] != 0){
                Double dopom = simplexTable[b][count];
                for (int i = 0; i < n + m + 1; i ++){
                    simplexTable[b][i] = simplexTable[b][i]/dopom;
                }
                for (int i = 0; i < m + 1; i++){
                    if (i != b){
                        Double d = -simplexTable[i][count]/simplexTable[b][count];
                        for (int j = 0; j < n + m + 1; j++){
                            simplexTable[i][j] = simplexTable[i][j]+d*simplexTable[b][j];
                        }
                    }
                }
            }
            else {
                System.out.println("Good By!");
            }

        }
        for (int i = 0; i < m; i ++){
            System.out.println(" x" + numbersBasis[i] + " = " + simplexTable[i][n + m]);
        }
        System.out.println(simplexTable[m][n + m]);

    }
}