package task_1;

public class Task_1_10 {
    public static void main(String[] args){
        System.out.println(abcmath(42,5,10));
        System.out.println(abcmath(5,2,1));
        System.out.println(abcmath(1,2,3));
    }

    // Складывает b раз число a. Возвращает true, если итоговое a делится на c
    public static boolean abcmath(int a, int b, int c){
        for (int i=0; i<b; i++){
            a += a;
        }
        return (a%c == 0);
    }
}
