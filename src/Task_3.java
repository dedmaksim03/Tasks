import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Task_3 {
    public static void main(String[] args){
        // 1
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        System.out.println(" ");

        // 2
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println(" ");

        // 3
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));
        System.out.println(" ");

        // 4
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println(" ");

        // 5
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println(" ");

        // 6
        int[] a1 = {1, 3, 4, 4, 4};
        int[] a2 = {2, 5, 7};
        int[] a3 = {9, 8, 7, 6};
        int[] a4 = {4, 4, 3, 1};
        int[] a5 = {2};
        int[] a6 = {3, 3, 3, 3, 3};
        System.out.println(same(a1, a2));
        System.out.println(same(a3, a4));
        System.out.println(same(a5, a6));
        System.out.println(" ");

        // 7
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println(" ");

        // 8
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
        System.out.println(" ");

        // 9
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println(" ");

        // 10
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }

    // Возвращает число решений квадратного уравнения по заданным коэффицентам
    public static int solutions(int a, int b, int c){
        double d = b*b - 4*a*c; // Высчитываем дискриминант
        if (Math.sqrt(d) > 0){
            return 2;
        }
        else if(d == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    /** Возвращает позицию второго вхождения "zip" в строку, или -1, если оно
     * не происходит по крайней мере дважды **/
    public static int findZip(String s){
        int i1 = s.toLowerCase().indexOf("zip"); // Позиция первого вхождения "zip"
        return s.toLowerCase().indexOf("zip", i1+2); // Вернет либо индекс второго вхождения, либо -1 если не найдет
    }

    /** Проверяет число на совершенность - сумма делителей числа должна быть равна числу **/
    public static boolean checkPerfect(int a){
        int sum = 0; // Сумма делителей
        for (int i=1; i<a; i++){ // Перебираем все числа от 1 до a
            if (a%i == 0){
                sum += i;
            }
        }
        return (sum == a);
    }

    /** Возвращает строку, меняя местами первый и последний символ **/
    public static String flipEndChars(String s){
        if (s.length() < 2){   // Проверка длины строки
            return "incompatible";
        }
        if (s.charAt(0) == s.charAt(s.length()-1)){  // Проверка не одинаковы ли первый и последний символ
            return "Two's a pair";
        }
        String new_s = "";
        // Складываем последний символ + кусок строки + первый символ
        new_s += s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0);
        return s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0);
    }

    // является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String s){
        return Pattern.matches("^#[a-zA-Z0-9]{6}$", s);
    }

    // Возвращает true, если два массива имеют одинаковое количество элементов
    public static boolean same(int[] a, int[] b){
        int count_uniqueA = a.length; // Предполагаем, что все элементы уникальные
        int count_uniqueB = b.length;
        HashMap<Integer, Integer> uniqueA = new HashMap<>(); // Хэшмап вида "Число" - "Наличие"
        HashMap<Integer, Integer> uniqueB = new HashMap<>();
        for (int i:a){  // Перебираем массив a
            if (uniqueA.containsKey(i)) count_uniqueA -= 1;  // Если в хэшмапе уже есть данное число, уменьшаем количество уникальных элементов
            uniqueA.put(i,1); // Вставляем данное число
        }
        for (int i:b){  // Перебираем массив b
            if (uniqueB.containsKey(i)) count_uniqueB -= 1;
            uniqueB.put(i,1);
        }
        return count_uniqueA == count_uniqueB;
    }

    // Находит число капрекара 9 -> 9*9=81 -> 8+1 == 9 -> true
    public static boolean isKaprekar(int n){
        String new_n = String.valueOf(n*n); // Переводим число в строку
        if (n == 0 || n == 1) return true; // 0 и 1 всегда числа капрекара
        if (new_n.length()==1) return false; // Если длина квадрата числа равна один, то это не капрекара число
        String left = "";
        String right = "";
        for (int i=0; i<new_n.length(); i++){  // Перебираем каждый символ строки
            if (i < new_n.length()/2){  // До первой половины записываем в переменную left
                left += new_n.charAt(i);
            }else right += new_n.charAt(i); // После второй половины записываем в right
        }
        return Integer.valueOf(left)+Integer.valueOf(right) == n; // Сравниваем сумму с изначальным числом
    }

    // Возвращает самую длинную последовательность последовательных нулей в двоичной строке
    public static String longestZero(String s_in){
        String[] s = s_in.split("1"); // Разделяем строку на последовательности нулей
        Arrays.sort(s); // Сортируем полученный массив
        if (s.length == 0) return ""; // Возвращаем пустую строку, если строка состоит из единиц
        return s[s.length-1]; // Возвращаем последний элемент
    }

    // Находит следующее простое число, после a. Если a простое, возвращает a
    public static int nextPrime(int a){
        int nextA = a;
        while (true){
            boolean prime = true;
            for (int i=2; i<nextA; i++){  // Определяем, является ли nextA простым
                if (nextA%i == 0){
                    prime = false;
                    break;
                }
            }
            if (prime) return nextA;  // Если найдено простое число, возвращаем его
            nextA += 1;
        }
    }

    // Определяет, является ли треугольник прямоугольным по трем сторонам
    public static boolean rightTriangle(int a, int b, int c){
        if (a*a == b*b+c*c) return true; // Используем теорему пифагора
        if (b*b == a*a+c*c) return true;
        if (c*c == b*b+a*a) return true;
        return false;
    }
}
