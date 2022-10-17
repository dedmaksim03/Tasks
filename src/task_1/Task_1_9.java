package task_1;

public class Task_1_9 {
    public static void main(String[] args){
        int[] a = {1, 5, 9};
        int[] b = {3, 4, 5};
        int[] c = {2};
        int[] d = {};

        System.out.println(sumOfCubes(a));
        System.out.println(sumOfCubes(b));
        System.out.println(sumOfCubes(c));
        System.out.println(sumOfCubes(d));
    }

    // Вычисляет сумму кубов элементов переданного массива
    public static int sumOfCubes(int[] mas){
        int sum=0;
        for (int i=0; i< mas.length; i++){
            sum += mas[i]*mas[i]*mas[i];
        }
        return sum;
    }
}
