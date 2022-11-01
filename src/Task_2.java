import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args){
        // 1
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));
        System.out.println(" ");

        // 2
        int[] a = {10, 4, 1, 4, -10, -50, 32, 21};
        int[] b = {44, 32, 86, 19};
        System.out.println(differenceMaxMin(a));
        System.out.println(differenceMaxMin(b));
        System.out.println(" ");

        // 3
        int[] c = {1, 3};
        int[] d = {1, 2, 3, 4};
        int[] e = {1, 5, 6};
        int[] f = {1, 1, 1};
        int[] g = {9, 2, 2, 5};
        System.out.println(isAvgWhole(c));
        System.out.println(isAvgWhole(d));
        System.out.println(isAvgWhole(e));
        System.out.println(isAvgWhole(f));
        System.out.println(isAvgWhole(g));
        System.out.println(" ");

        // 4
        int[] aa = {1, 2, 3};
        int[] ab = {1, -2, 3};
        int[] ac = {3, 3, -2, 408, 3, 3};
        System.out.println(cumulativeSum(aa));
        System.out.println(cumulativeSum(ab));
        System.out.println(cumulativeSum(ac));
        System.out.println(" ");

        // 5
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
        System.out.println(" ");

        // 6
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));
        System.out.println(" ");

        // 7
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
        System.out.println(" ");

        // 8
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        System.out.println(" ");

        // 9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println(" ");

        // 10
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
        System.out.println(" ");
    }

    // Повторяет каждый символ в строке n раз
    public static String repeat(String s, int n){
        String new_s = "";
        for (int i=0; i < s.length(); i++){
            for (int j=0; j<n; j++){
                new_s += s.charAt(i);
            }
        }
        return new_s;
    }

    // возвращает разницу между самыми большими и самыми маленькими числами
    public static int differenceMaxMin(int[] mas){
        int max = 0;
        int min = 10000;
        for (int i=0; i < mas.length; i++){
            if (mas[i] > max){
                max = mas[i];
            }
            if (mas[i] < min){
                min = mas[i];
            }
        }
        return max-min;
    }

    // возвращает true или false в зависимости от того, является ли среднее значение всех элементов массива целым числом или нет.
    public static boolean isAvgWhole(int[] mas){
        int sum = 0;
        for (int i=0; i < mas.length; i++){
            sum += mas[i];
        }
        return sum%mas.length == 0;
    }

    // возвращает массив, в котором каждое целое число является суммой самого себя + всех предыдущих чисел в массиве.
    public static String cumulativeSum(int[] mas){
        int[] sum = new int[mas.length];
        sum[0] = mas[0];
        for (int i=1; i<mas.length; i++){
            sum[i] = sum[i-1] + mas[i];
        }
        return Arrays.toString(sum);
    }

    //  возвращает число десятичных знаков, которое имеет число.
    public static double getDecimalPlaces(String s){
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '.'){
                return s.length()-s.charAt(i)-1;
            }
        }
        return 0;
    }

    // возвращает соответствующее число Фибоначчи.
    public static int fibonacci(int n){
        int[] mas = new int[n+2];
        mas[0] = 0;
        mas[1] = 1;
        for (int i=2; i<n+2; i++){
            mas[i] = mas[i-2] + mas[i-1];
        }
        return mas[n+1];
    }

    // Проверяет индекс по параметрам
    public static boolean isValid(String index){
        if (index.length() > 5){
            return false;
        }
        for (int i = 0; i < index.length(); i++){
            if (!Character.isDigit(index.charAt(i))){
                return false;
            }
        }
        return true;
    }

    // определяет странную пару по параметрам
    public static boolean isStrangePair(String s1, String s2){
        if (s1.equals("") && s2.equals("")){
            return true;
        }
        if (s1.equals("") || s2.equals("")){
            return false;
        }
        return (s1.charAt(0) == s2.charAt(s2.length()-1) && s1.charAt(s1.length()-1) == s2.charAt(0));
    }


    public static boolean isPrefix(String word, String prefix){
        for (int i=0; i<prefix.length()-1; i++){
            if (!(word.charAt(i) == prefix.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isSuffix (String word, String suffix){
        for(int i = 1; i < suffix.length();i++){
            int dif = i + (word.length()-suffix.length());
            if(word.charAt(dif) != suffix.charAt(i)) return false;
        }
        return true;
    }

    // принимает число (шаг) в качестве аргумента и возвращает количество полей на этом шаге последовательности.
    public static int boxSeq(int step){
        if (step == 0){
            return 0;
        }
        int[] mas = new int[step+1];
        mas[0] = 0;
        mas[1] = 3;

        for (int i=2; i<=step; i++){
            if (i%2 == 0){
                mas[i] = mas[i-1] - 1;
            }
            else{
                mas[i] = mas[i-1] + 3;
            }
        }
        return mas[step];
    }
}
