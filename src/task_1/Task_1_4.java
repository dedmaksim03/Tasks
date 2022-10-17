package task_1;

public class Task_1_4 {
    public static void main(String[] args){
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(profitableGamble(0.9, 3, 2));
    }

    // Определяет по вероятности выигрыша prob, призу prize и взносу pay релевантность ставки
    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob*prize > pay;
    }
}
