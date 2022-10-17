package task_1;

public class Task_1_7 {
    public static void main(String[] args){
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));
    }

    // Вычисляет сумму от 1 до n
    public static int addUpTo(int n){
        int sum = 0;
        for (int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }
}
