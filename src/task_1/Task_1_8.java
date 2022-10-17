package task_1;

public class Task_1_8 {
    public static void main(String[] args){
        System.out.println(nextEdge(8,10));
        System.out.println(nextEdge(5,7));
        System.out.println(nextEdge(9,2));
    }

    // Вычисляет максимальный размер третьей стороны треугольника по заданным двум
    public static int nextEdge(int a, int b){
        return a+b-1;
    }
}
