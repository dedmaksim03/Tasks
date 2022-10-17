public class Task_1 {
    public static void main(String[] args){
        // 1
        System.out.println(remainder(1,3));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));
        System.out.println(" ");

        // 2
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));
        System.out.println(" ");

        // 3
        System.out.println(animals(2,3,5));
        System.out.println(animals(1,2,3));
        System.out.println(animals(5,2,8));
        System.out.println(" ");

        // 4
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(profitableGamble(0.9, 3, 2));
        System.out.println(" ");

        // 5
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));
        System.out.println(" ");

        // 6
        System.out.println(ctoa('A') );
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(" ");

        // 7
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));
        System.out.println(" ");

        // 8
        System.out.println(nextEdge(8,10));
        System.out.println(nextEdge(5,7));
        System.out.println(nextEdge(9,2));
        System.out.println(" ");

        // 9
        int[] a = {1, 5, 9};
        int[] b = {3, 4, 5};
        int[] c = {2};
        int[] d = {};

        System.out.println(sumOfCubes(a));
        System.out.println(sumOfCubes(b));
        System.out.println(sumOfCubes(c));
        System.out.println(sumOfCubes(d));
        System.out.println(" ");

        // 10
        System.out.println(abcmath(42,5,10));
        System.out.println(abcmath(5,2,1));
        System.out.println(abcmath(1,2,3));
    }

    // Возвращает остаток от деления числа a на чисто b
    public static int remainder(int a, int b){
        return a%b;
    }

    // Вычисляет площадь треугольника по переданным стороне a и высоте h
    public static int triArea(int a, int h){
        return (a * h)/2;
    }

    // Вычисляет количество ног у переданных животных
    public static int animals(int chickens, int cows, int pigs){
        return (chickens*2 + cows*4 + pigs*4);
    }

    // Определяет по вероятности выигрыша prob, призу prize и взносу pay релевантность ставки
    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob*prize > pay;
    }

    // Определяет математическую операцию для верного a _ b = n
    public static String operation(int n, int a, int b){
        if (a+b == n){
            return "added";
        }
        if (a-b == n){
            return "subtracted";
        }
        if (a*b == n){
            return "multiply";
        }
        if (a/b == n){
            return "divided";
        }
        return "none";
    }

    // Возвращает ASCII код символа
    public static int ctoa(char ch){
        return (ch);
    }

    // Вычисляет сумму от 1 до n
    public static int addUpTo(int n){
        int sum = 0;
        for (int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }

    // Вычисляет максимальный размер третьей стороны треугольника по заданным двум
    public static int nextEdge(int a, int b){
        return a+b-1;
    }

    // Вычисляет сумму кубов элементов переданного массива
    public static int sumOfCubes(int[] mas){
        int sum=0;
        for (int i=0; i< mas.length; i++){
            sum += mas[i]*mas[i]*mas[i];
        }
        return sum;
    }

    // Складывает b раз число a. Возвращает true, если итоговое a делится на c
    public static boolean abcmath(int a, int b, int c){
        for (int i=0; i<b; i++){
            a += a;
        }
        return (a%c == 0);
    }
}

