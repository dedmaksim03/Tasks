package task_1;

public class Task_1_3 {
    public static void main(String[] args){
        System.out.println(animals(2,3,5));
        System.out.println(animals(1,2,3));
        System.out.println(animals(5,2,8));
    }

    // Вычисляет количество ног у переданных животных
    public static int animals(int chickens, int cows, int pigs){
        return (chickens*2 + cows*4 + pigs*4);
    }
}
