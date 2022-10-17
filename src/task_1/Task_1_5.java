package task_1;

public class Task_1_5 {
    public static void main(String[] args){
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));
    }

    // Определяет математическую операцию для верного a _ b = n
    public static String operation(int n, int a, int b){
        if (a+b == n){
            return "added";
        }
        else if (a-b == n){
            return "subtracted";
        }
        else if (a*b == n){
            return "multiply";
        }
        else if (a/b == n){
            return "divided";
        }
        else{
            return "none";
        }
    }
}
