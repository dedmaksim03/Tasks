package task_1;

public class Task_1_1 {
    public static void main(String[] args){
        System.out.println(remainder(1,3));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));
    }

    // Возвращает остаток от деления числа a на чисто b
    public static int remainder(int a, int b){
        return (a%b);
    }
}
