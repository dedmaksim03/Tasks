import java.util.*;

public class Task_6 {
    public static final String vowels = "AEIOUaeiou";

    public static void main(String[] args) {
        System.out.println("---bell---");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
        System.out.println("---translateWord---");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateWord(""));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println("---validColor---");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println("---stripUrlParams---");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new Character[]{'b'}));
        System.out.println(stripUrlParams("https://edabit.com", new Character[]{'b'}));
        System.out.println("---getHastTags---");
        System.out.println(Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println(Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println(Arrays.toString(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println(Arrays.toString(getHashTags("Visualizing Science")));
        System.out.println("---ulam---");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
        System.out.println("---longestNonrepeatingSubstring----");
        System.out.println(lonNotRepSubstr("abcabcbb"));
        System.out.println(lonNotRepSubstr("aaaaaaa"));
        System.out.println(lonNotRepSubstr("abcde"));
        System.out.println(lonNotRepSubstr("abcda"));
        System.out.println("---convertToRoman---");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));
        System.out.println(convertToRoman(3999));
        System.out.println("----formula---");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println("---palindrom---");
        System.out.println(palindrome(11211230));
        System.out.println(palindrome(13001120));
        System.out.println(palindrome(23336014));
        System.out.println(palindrome(11));
    }


    // Количество способов, которыми массив из n элементов может
    //быть разбит на непустые подмножества
    /*
    Белл Вычисление с помощью треугольника Пирса
      0  1   2   3   4
    0|1
    1|1	 2
    2|2	 3	5
    3|5  7	10	15
    4|15 20	27	37	52
    1+1 = 2, 2 переписывается, 1+2 = 3, 2+ 3 = 5
    когда оканчивается расчет, последнее число последней строки берется, как ответ
     */
    public static int bell(int n) {
        int[][] bell_int = new int[n][];
        bell_int[0] = new int[1];
        bell_int[0][0] = 1;
        for (int m = 1; m < n; m++) {
            bell_int[m] = new int[m + 1];
            bell_int[m][0] = bell_int[m - 1][m - 1];
            for (int i = 1; i < m + 1; i++) {
                bell_int[m][i] = bell_int[m][i - 1] + bell_int[m - 1][i - 1];
            }
        }
        return bell_int[n - 1][n - 1];
    }

    // Переводит слово в "свино-латинский язык"
    public static String translateWord(String string) {
        if (string.equals("")) return "";
        String out = "";
        if (vowels.indexOf(string.charAt(0)) != -1) {  // Если буква гласная
            out += string;
            out += "yay";
        } else {  // Если буква согласная
            for (int i = 0; i < string.length(); i++)
                if (vowels.indexOf(string.charAt(i)) != -1) {
                    out = string.substring(i);
                    out += string.substring(0, i);
                    out += "ay";
                    break;
                }
        }
        return out;
    }

    // Переводит строку в "свино-латинский язык"
    public static String translateSentence(String string) {
        char last_char = string.charAt(string.length() - 1);
        char first_char;
        String ret_s = "";
        string = string.toLowerCase();
        string = string.substring(0, string.length() - 1);
        String[] s_arr = string.split(" ");
        for (String s : s_arr) {
            ret_s = ret_s + translateWord(s) + " ";
        }
        first_char = Character.toUpperCase(ret_s.charAt(0));
        ret_s = first_char + ret_s.substring(1, ret_s.length() - 1);
        return ret_s + last_char;
    }

    /*
Смотрим rgb или rgba потом создаем массив по знаку ',' переводим значение массива в числа, делаем проверку
     */
    public static boolean validColor(String s) {
        String value_of_css = "";
        if (s.contains("rgba")) {
            value_of_css = s.substring(5, s.length() - 1);
            String[] s_arr = value_of_css.split(",");
            Double[] i_arr = new Double[]{-1.0, -1.0, -1.0, -1.0};
            for (int i = 0; i < s_arr.length; i++) {
                if (!s_arr[i].equals("")) i_arr[i] = Double.valueOf(s_arr[i]);
            }
            if ((i_arr[0] < 256 && i_arr[0] >= 0) && (i_arr[1] < 256 && i_arr[1] >= 0) &&
                    (i_arr[2] < 256 && i_arr[2] >= 0) && (i_arr[3] <= 1 && i_arr[3] >= 0)) return true;
        } else if (s.contains("rgb")) {
            value_of_css = s.substring(4, s.length() - 1);
            String[] s_arr = value_of_css.split(",");
            Double[] i_arr = new Double[]{-1.0, -1.0, -1.0};
            for (int i = 0; i < s_arr.length; i++) {
                if (!s_arr[i].equals("")) i_arr[i] = Double.valueOf(s_arr[i]);
            }
            if ((i_arr[0] < 256 && i_arr[0] >= 0) && (i_arr[1] < 256 && i_arr[1] >= 0) &&
                    (i_arr[2] < 256 && i_arr[2] >= 0)) return true;
        }
        return false;
    }

    // Принимает url и удаляет в нем повторяющиеся параметры
    public static String stripUrlParams(String url) {
        int last_char;
        if (url.contains("?")) last_char = url.indexOf('?') + 1;
        else return url;

        HashMap<Character, Integer> map_par = new HashMap<>();
        String out = url.substring(0, last_char);
        url = url.substring(last_char);

        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '=') {
                int value = Character.getNumericValue(url.charAt(i + 1));
                map_par.put(url.charAt(i - 1), value);
            }
        }
        Set<Character> keys = map_par.keySet();
        for (Character k : keys) {
            String val = Integer.toString(map_par.get(k));
            out += k + "=" + val + "&";
        }
        out = out.substring(0, out.length() - 1);
        return out;
    }

    // Принимает url и параметры, которые надо удалить
    public static String stripUrlParams(String url, Character[] argum) {

        int last_char;
        if (url.contains("?")) last_char = url.indexOf('?') + 1;
        else return url;

        String urlNew = url.substring(last_char);
        StringBuilder out = new StringBuilder(url.substring(0, last_char));

        String[] str_r_arr = urlNew.split("&");
        List<String> listHave = Arrays.asList(str_r_arr);  // то что на ввод
        List<Character> listIn = Arrays.asList(argum);  // то что на вывод
        for (String s : listHave) {
            if (!listIn.contains(s.charAt(0))) {
                out.append(s).append("&");
            }
        }
        out = new StringBuilder(stripUrlParams(out.toString()));
        return out.toString();
    }

    /*
    Логика метода getHashTags
    делим строку по пробелам, если в конце слова есть "," то убираем её
    Добавляем значения в словарь где ключ - слово, значение - длина слова
    Делаем перебор 3 раза
    Где находим максимальную длину слова
    и добавляем её в список
    обнуляем длину
    Потом переводим список в Массив и возращаем его
     */

    public static String[] getHashTags(String str) {
        List<String> ret_list = new ArrayList<>();
        HashMap<String, Integer> map_par = new HashMap<>();
        str = str.toLowerCase();
        String[] arr_str = str.split(" ");
        for (String s : arr_str) {
            if (s.charAt(s.length() - 1) == ',') {
                s = s.substring(0, s.length() - 1);
            }
            map_par.put(s, s.length());
        }
        Set<String> keys = map_par.keySet();
        for (int i = 0; i < 3; i++) {
            String max_k = "";
            String add_k = "#";
            Integer max = 0;
            for (String s : keys) {
                if (map_par.get(s) > max) {
                    max_k = s;
                    max = map_par.get(s);
                }
            }
            map_par.put(max_k, 0);
            add_k += max_k;
            if (!add_k.equals("#"))
                ret_list.add(add_k);
        }
        return ret_list.toArray(new String[0]);


    }

    // Выводит n-e число в последовательности улама - следующее число строится по принципу
    // "минимальная сумма двух разных чисел"
    public static int ulam(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        for (int i = 3; i < n + 1000000; i++) {
            if (isUlam(i, list)) {
                list.add(i);
            }
            if (list.size() == n) {
                return i;
            }
        }

        return 0;
    }

    public static boolean isUlam(int i, List<Integer> list) {
        int count = 0;
        for (int k = 0; k < list.size(); k++) {
            for (int k2 = k; k2 < list.size(); k2++) {
                if ((list.get(k) + list.get(k2) == i) && (list.get(k) != list.get(k2))) {
                    count += 1;
                }
                if (count > 1) return false;
            }
        }
        return count == 1;
    }

    // Возвращает самую длину неповторяющуюся подстроку
    public static String lonNotRepSubstr(String s) {
        int length_out = 0;
        int length_test = 1;
        String out = "";
        String test = "";
        for (int i = 0; i < s.length(); i++) {
            String char_i = "";
            char_i += s.charAt(i);
            if (!test.contains(char_i)) {
                test += char_i;
                length_test += 1;
            } else {
                test = "";
                length_test = 1;
            }
            if (length_test > length_out) {
                length_out = length_test;
                out = test;
            }
        }
        return out;
    }

    // Переводит арабские числа в римские
    //Макс 3.999 I = 1 V = 5 X = 10 L = 50 C = 100 D = 500 M = 1000
    public static String convertToRoman(int n) {
        StringBuilder out = new StringBuilder();
        while (n > 0) {
            if (n >= 1000) {
                out.append("M");
                n -= 1000;
            } else if (n >= 500) {
                if (n / 100 == 9) {
                    out.append("CM");
                    n -= 900;
                } else {
                    out.append("D");
                    n -= 500;
                }
            } else if (n >= 100) {
                if (n / 100 == 4) {
                    out.append("CD");
                    n -= 400;
                } else {
                    out.append("C");
                    n -= 100;
                }
            } else if (n >= 50) {
                if (n / 10 == 9) {
                    out.append("XC");
                    n -= 90;
                } else {
                    out.append("L");
                    n -= 50;
                }
            } else if (n >= 10) {
                if (n / 10 == 4) {
                    out.append("XL");
                    n -= 40;
                } else {
                    out.append("X");
                    n -= 10;
                }
            } else if (n >= 5) {
                if (n == 9) {
                    out.append("IX");
                    n -= 9;
                } else {
                    out.append("V");
                    n -= 5;
                }
            } else {
                if (n == 4) {
                    out.append("IV");
                    n -= 4;
                } else {
                    out.append("I");
                    n -= 1;
                }
            }
        }
        return out.toString();
    }

    // Проверяет равенство формулы
    public static boolean formula(String str) {
        String[] str_1 = str.split("=");
        Integer[] int_1 = new Integer[str_1.length];
        for (int k = 0; k < str_1.length; k++) {
            String[] str_2 = str_1[k].split(" ");
            if (!str_2[0].equals("")) int_1[k] = Integer.parseInt(str_2[0]);
            else int_1[k] = Integer.parseInt(str_2[1]);

            //System.out.println(int_1[k]);
            for (int i = 0; i < str_2.length; i++) {
                if ("+*/-".contains(str_2[i])) {
                    switch (str_2[i]) {
                        case ("+") -> int_1[k] += Integer.parseInt(str_2[i + 1]);
                        case ("*") -> int_1[k] *= Integer.parseInt(str_2[i + 1]);
                        case ("-") -> int_1[k] -= Integer.parseInt(str_2[i + 1]);
                        case ("/") -> int_1[k] /= Integer.parseInt(str_2[i + 1]);
                    }
                }
            }
        }
        for (int i = 0; i < int_1.length - 1; i++) {
            if (int_1[i] != int_1[i + 1]) return false;
        }
        return true;
    }

    // Является ли число палиндромом либо его потомком
    public static boolean palindrome(int n){
        if (isPalindrome(n)) return true;
        String number = Integer.toString(n);
        String new_number = "";
        for (int j=0; j<3; j++) {
            for (int i = 0; i < number.length(); i += 2) {
                new_number += Character.getNumericValue(number.charAt(i)) + Character.getNumericValue(number.charAt(i + 1));
            }
            if (isPalindrome(Integer.parseInt(new_number))) return true;
            number = new_number;
            new_number = "";
        }
        return false;
    }
    public static boolean isPalindrome(int n){
        String left = "";
        String right = "";
        String str_n = String.valueOf(n);
        for(int i = 0;i < str_n.length()/2; i++){
            left += str_n.charAt(i);
            right += str_n.charAt(str_n.length()-i-1);
        }
        return left.equals(right);
    }
}