package task_1;

public class Task_1_2 {
    public static void main(String[] args){
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));
    }

    // Вычисляет площадь треугольника по переданным стороне a и высоте h
    public static int triArea(int a, int h){
        return (a * h)/2;
    }
}
