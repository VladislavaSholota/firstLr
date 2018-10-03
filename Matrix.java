import  java.util.*;
public class Matrix {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторна робота №1. Робота з матрицями");
        System.out.println("Введення першої матриці.");
        Matrix_decide matrix_decide = new Matrix_decide(4, 4);
        matrix_decide.outing();
        System.out.println("Введення другої матриці.");
        Matrix_decide matrix_decide1 = new Matrix_decide(4, 4);

        Mathing mathing = new Mathing();
        System.out.println("Додавання матриць.");
        mathing.add(matrix_decide.returning(), matrix_decide1.returning());
        System.out.println("Множення матриці на скаляр.");
        mathing.scalarMatrix(matrix_decide.returning(), 15.0);
        System.out.println("Множення матриць.");
        mathing.multiple(matrix_decide.returning(), matrix_decide1.returning());
        System.out.println("Транспонування матриці.");
        mathing.transpon(matrix_decide.returning());
        System.out.println("Знаходження оберненої матриці.");
        if (mathing.square(matrix_decide.returning())){
            Double k = mathing.det_mat(matrix_decide.returning(), matrix_decide.returning().size());
            System.out.println("Детермінант матриці:");
            System.out.println(k);
            if (k != 0){
                System.out.println("Метод перший:");
                mathing.matrix(matrix_decide.returning(), matrix_decide.returning().size());
                System.out.println("Метод другий:");
                mathing.matrix(matrix_decide.returning(), matrix_decide.returning().size());
            }
        }

    }
}
