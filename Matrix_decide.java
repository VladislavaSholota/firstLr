import java.util.Scanner;
import java.util.ArrayList;

public class Matrix_decide {
    ArrayList <ArrayList<Double>> arrayLists = new ArrayList<ArrayList<Double>>();


    public Integer n; //кількість рядків
    public Integer m; //кількість стовбців


    public Matrix_decide (Integer n, Integer m){
        Scanner scanner = new Scanner(System.in);
        this.n = n;
        this.m = m;
        System.out.println("Введіть матрицю розмірності " + n + "на " + m + " ");
        for (int i = 0; i < n; i ++){
            ArrayList <Double> arrayList = new ArrayList<Double>(m);
            for (int j = 0; j < m; j ++){
                arrayList.add(scanner.nextDouble());
            }
            arrayLists.add(arrayList);
        }
    }

    public ArrayList <ArrayList<Double>> returning(){
        return arrayLists;
    }

    Matrix_decide (ArrayList <ArrayList<Double>> arrayLists){
        this.arrayLists = arrayLists;
        this.n = arrayLists.size();
        this.m = arrayLists.get(0).size();
    }

    public ArrayList <ArrayList<Double>> returnMatrix(){
        return arrayLists;
    }

    public void outing() {
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(0).size(); j++) {
                System.out.print(arrayLists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
