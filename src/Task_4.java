import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Task_4 {
    public static void main(String[] args){
        // 1
        textProcessor(10,7, "hello my name is Bessie and this is my essay"+'\n');
        // 2
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))") + "\n");
        // 3
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor") + "\n");
        //4
        double[] a = {9, 17, 30, 1.5};
        double[] b = {16, 18, 30, 1.8};
        double[] c = {13.25, 15, 30, 1.5};
        System.out.println(overTime(a));
        System.out.println(overTime(b));
        System.out.println(overTime(c) + "\n");
        //5
        System.out.println(bmi("205 pounds", "73 inches"));
        System.out.println(bmi("55 kilos", "1.65 meters"));
        System.out.println(bmi("154 pounds", "2 meters") + "\n");
        //6
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4) + "\n");
        //7
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand("") + "\n");
        //8
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move.") + "\n");
        //9
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337) + "\n");
        //10
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }


    // Форматирует строку s, разделяя ее на строки длины k. n - количество слов
    public static void textProcessor(int n, int k, String s){
        String[] mas = s.split(" ");
        int numberInString = 0; // Длина текущей строки
        String outS = ""; // Текущая строка
        for (String a: mas){
            numberInString += a.length();
            if (numberInString >= k){  // Если длин строки больше возможной, выводим текущую строку
                System.out.println(outS);
                numberInString = a.length();
                outS = a + " ";
            }
            else{
                outS += a + " ";  // Добавляем следующее слово в текущую строку
            }
        }
        System.out.println(outS);  // Все что осталось выводим
    }

    // Разделяет строку s вида "()()(())" на кластеры скобок ["()", "()", "(())"]
    public static ArrayList<String> split(String s){
        int open = 0;  // Счетчик открытых скобок
        int close = 0; // Счетчик закрытых скобок
        String cluster = "";  // Кластер
        ArrayList<String> clusters = new ArrayList<>();  // Список кластеров
        for (int i=0; i<s.length();i++){
            if (s.charAt(i) == '(') open += 1;  // Считаем количество открытых и закрытых скобок
            else if (s.charAt(i) == ')') close += 1;
            cluster += s.charAt(i);  // Добавляем символ к кластеру
            if (open == close) {  // Если число open и close равно, то добавляем кластер в список кластеров и обнуляем переменные
                clusters.add(cluster);
                cluster = "";
                open = 0;
                close = 0;
            }
        }
        return clusters;
    }

    // Принимает строку вида "get_color" и возвращает "getColor"
    public static String toCamelCase(String s){
        String[] mas = s.split("_");  // Создаем массив слов строки
        String new_s = mas[0];  // Записываем первое слово в новую строку
        for (int i=1; i<mas.length;i++){  // Перебираем все слова в массиве
            // Прибавляем первый символ в заглавном регистре + оставшуюся строку
            new_s += mas[i].substring(0,1).toUpperCase() + mas[i].substring(1);
        }
        return new_s;
    }

    // Принимает строку вида "getColor" и возвращает "get_color"
    public static String toSnakeCase(String s){
        String new_s = "";  // Строка для вывода
        for (int i=0;i<s.length();i++){  // Перебираем каждый символ в строке
            if (s.charAt(i) == Character.toLowerCase(s.charAt(i))){  // Если буква строчная
                new_s += s.charAt(i); // То прибавляем ее к строке
            }
            else new_s += "_" + Character.toLowerCase(s.charAt(i));  // Иначе добавляем "_" и символ в нижнем регистре
        }
        return new_s;
    }

    // Принимает массив вида [часы, сверхурочные, ставка, коэфицент сверхурочных] и возвращает зарплату
    public static String overTime(double[] mas){
        double over_hour = mas[1]-17;  // Сверхурочные
        double simple_hour = 17-mas[0];  // Обычные часы
        if (mas[1]<17) simple_hour = mas[1]-mas[0];  // Если работал не до конца дня, считаем обычные часы иначе
        double cash = simple_hour*mas[2];  // Считаем зп за обычные часы
        if (over_hour>0) cash += over_hour*mas[2]*mas[3];  // Если имеются сверхурочные, то добавляем и их
        BigDecimal bd = new BigDecimal(Double.toString(cash));  // Класс для округления
        bd = bd.setScale(2, RoundingMode.HALF_UP);  // Устанавливаем число знаков после запятой и метод округления
        return "$" + bd.doubleValue();  // Вывод
    }

    // Принимает вес и рост человека, возвращает индекс массы тела
    public static String bmi(String weight, String height){
        // Разделяем строку на слова и переводим первое слово в число
        double weight_kilo = Double.parseDouble(weight.split(" ")[0]); // Вес
        double height_meters = Double.parseDouble(height.split(" ")[0]); // Рост

        if (weight.contains("pounds")) weight_kilo = weight_kilo*0.453592; // Переводим в кг при необходимости
        if (height.contains("inches")) height_meters = height_meters*0.0254; // Переводим в метры при необходимости

        double bmi = weight_kilo/(height_meters*height_meters);  // Индекс массы тела
        bmi = Math.round(bmi*10d)/10d;  // Округляем до десятых
        if (bmi < 18.5) return (bmi + " Underweight");
        if (bmi < 24.9) return (bmi + " Normal weight");
        return (bmi + " Overweight");
    }

    // Принимает n, умножает его составляющие, пока произедение не станет одним числом. Возвращает число операций
    public static int bugger(int n){
        int count = 0;  //  Число операций
        while (n/10 > 0){
            String[] mas = String.valueOf(n).split("");  // Делим число на состовляющие
            n = 1;
            for (String c: mas){
                n *= Integer.parseInt(c);  // Перемножаем состовляющие друг на друга
            }
            count += 1;
        }
        return count;
    }

    // Принимает строку и возвращает отформатированную "abbccc" -> "ab*2c*3"
    public static String toStarShorthand(String s){
        if (s.length() == 1) return s;  // Проверка на пустую и односимвольную строку
        String outS = "";  // Строка на вывод
        int n = 1; // Счетчик последовательности
        for (int i=1; i<s.length();i++){ // Перебираем строку
            if (s.charAt(i) == s.charAt(i-1)){  // Если этот символ равен предыдущему
                n += 1;  // Увеличиваем счетчик последовательности
                if (i == s.length()-1) outS += s.charAt(i) + "*" + n;  // Если это последний символ, то выводим символ*n
            }
            else{  // Если этот символ не равен предыдущему
                outS += s.charAt(i-1);  // Выводим  предыдущий символ
                if (n != 1){  // Если до этого была последовательность
                    outS += "*" + n;  // Записываем ее
                    n = 1;  // Сбрасываем счетчик
                }
                if (i == s.length()-1) outS += s.charAt(i); // Если это последний символ, то выводим этот символ
            }
        }
        return outS;
    }

    // Проверяет, рифмуются ли две строки (если количество гласных в последних словах равно)
    public static boolean doesRhyme(String s1, String s2){
        s1 = s1.split(" ")[s1.split(" ").length-1];  // Берем последнее слово
        s2 = s2.split(" ")[s2.split(" ").length-1];
        String for_equal = "AEIOUaeiou";  // Строка, содержащая весь набор гласных
        int vowel1 = 0;  // Количество гласных
        int vowel2 = 0;
        for (int i=0; i<s1.length();i++){  // Перебираем первую строку
            // Если в наборе гласных содержится символ строки, то увеличиваем счетчик гласных
            if (for_equal.indexOf(s1.charAt(i)) != -1) vowel1 += 1;
        }
        for (int i=0; i<s2.length();i++){ // Перебираем вторую строку
            if (for_equal.indexOf(s2.charAt(i)) != -1) vowel2 += 1;
        }
        return vowel1 == vowel2;  // Если количество гласных равно, строки рифмуются
    }

    /* Принимает два числа, выводит true, если в первом числе цифра повторяется три раза подряд и
    * эта же цифра повторяется два раза в другом числе.
    * Иначе выводит false */
    public static boolean trouble(long n1, long n2){
        String s1 = Long.toString(n1);  // Переводим в строку введенные числа
        String s2 = Long.toString(n2);
        ArrayList<Long> mas1 = new ArrayList<>(); // Создаем два массива
        ArrayList<Long> mas2 = new ArrayList<>();
        int count = 1; // Счетчик последовательности
        for (int i=0; i<s1.length()-1; i++){  // Перебираем первое число
            if (Objects.equals(s1.charAt(i),s1.charAt(i+1))) {  // Если эта цифра равна следующей
                count += 1;  // То увеличиваем счетчик
                if (count == 3){  // Если длина последовательности равна 3
                    mas1.add((long)s1.charAt(i));  // То записываем в массив эту цифру
                    count = 1;  // И обнуляем счетчик
                }
            }
            else count = 1;  // Иначе просто обнуляем счетчик
        }
        for (int i=0; i<s2.length()-1; i++){  // Проходимся по второму циклу
            if (Objects.equals(s2.charAt(i),s2.charAt(i+1))){  // Если следующая цифра равна следующей
                mas2.add((long)s2.charAt(i));  // То просто записываем эту цифру
            }
        }
        for (long i:mas1) if (mas2.contains(i)) return true;  // Сравниваем значения из первого массива со вторым, и наоборот
        for (long i:mas2) if (mas1.contains(i)) return true;
        return false;
    }

    // Ищет количество уникальных символов между двумя другими символами (ends)
    public static int countUniqueBooks(String s, char ends){
        HashSet<Character> masUnique = new HashSet<>();
        int countEnds = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ends){
                countEnds += 1;
                if (countEnds == 2){
                    countEnds = 0;
                }
            }
            else if (countEnds == 1){
                masUnique.add(s.charAt(i));
            }
        }
        return masUnique.size();
    }
}
