import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Task_5 {

    public static final String vowels = "AEIOUaeiou";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        int[] mas = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(mas));
        System.out.println(Arrays.toString(encrypt("Sunshine")) + "\n");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6") + "\n");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful") + "\n");
        System.out.println(sumDigProd(new int[]{16, 28}));
        System.out.println(sumDigProd(new int[]{0}));
        System.out.println(sumDigProd(new int[]{1, 2, 3, 4, 5, 6}) + "\n");
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})) + "\n");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L) + "\n");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909) + "\n");
        System.out.println(toHexString(getSHA("password123")));
        System.out.println(toHexString(getSHA("Fluffy@home")));
        System.out.println(toHexString(getSHA("Hey dude!")) + "\n");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN.") + "\n");
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
    }

    // Шифрует и дешифрует строки. Строка шифруется в массив из разницы между символами строки
    // abc -> [код a, код b - код a, код c - код b]
    public static int[] encrypt(String s){
        int[] mas = new int[s.length()];
        int dif = s.charAt(0);
        mas[0] = dif;  // Здесь dif - код первого символа
        for (int i=1; i<s.length(); i++){
            dif = (int)s.charAt(i) - (int)s.charAt(i-1);  // код b - код a
            mas[i] = dif;
        }
        return mas;
    }

    // dif нам уже дано, складываем их друг с другом, и вводим символы по получившимся кодам
    public static String decrypt(int[] mas) {
        int dif = mas[0];
        String newS = "" + (char)mas[0];
        for (int i = 1; i < mas.length; i++) {
            dif += mas[i];  // Предыдущще значение плюс следующее
            newS += (char) dif;
        }
        return newS;
    }

    // Определяет, можно ли переместить фигуру из одной клетки в другую
    public static boolean canMove(String figure, String begin, String end){
        int dif_char = end.charAt(0) - begin.charAt(0);
        int dif_int = end.charAt(1) - begin.charAt(1);
        switch (figure){
            case("Rook"):  // Ладья
                if ((dif_char == 0 || dif_int == 0)) return true; break;
            case("Bishop"):  // Слон
                if (Math.abs(dif_char) == Math.abs(dif_int)) return true; break;
            case("Queen"):
                if ((Math.abs(dif_char) == Math.abs(dif_int)) || (dif_char == 0 || dif_int == 0)) return true; break;
            case("King"):
                if ((Math.abs(dif_char) <= 1) && (Math.abs(dif_int) <= 1)) return true; break;
            case("Knight"):  // Конь
                if ((Math.abs(dif_int) == 2 && Math.abs(dif_char) == 1) || (Math.abs(dif_int) == 1 && Math.abs(dif_char) == 2))
                    return true; break;
            case("Pawn"):  // Пешка
                if (dif_int == 1 && dif_char == 0) return true; break;

        }
        return false;
    }

    // Определяет, можно ли добавил несколько букв к одной строке, получить другую строку
    // Выписываем в новую строку те буквы, что совпадают. Если новая строка совпадет с введенной неполной, то true
    public static boolean canComplete(String sword_short, String sword) {
        String sub_sword = "";
        for (int i = 0; i < sword_short.length(); i++) {
            for (int n = 0; n < sword.length(); n++) {
                if (sword_short.charAt(i) == sword.charAt(n)) {
                    sub_sword += sword.charAt(n);
                    sword = sword.substring(n + 1);  // Чтобы не было повторений
                    break;
                }
            }
        }

        return sub_sword.equals(sword_short);
    }

    // Складываем введенные числа, а затем начинаем их перемножать друг до друга пока ответ не будет длиной 1
    public static int sumDigProd(int[] mas){
        int sum = 0;
        for (int i: mas) sum += i;  // Вычисляем сумму
        String[] s = Integer.toString(sum).split("");
        while (true){
            int multiply = 1;
            for (int i = 0; i< s.length; i++)
                multiply *= Integer.parseInt(s[i]);
            if (Integer.toString(multiply).length() == 1)
                return multiply;
            else
                s = Integer.toString(multiply).split("");
        }
    }

    // Массив слов на вход, на выход - первое слово массива, и оставшиеся слова, у которых гласные совпадают с гласными первого
    // слова
    public static Object[] sameVowelGroup(String[] s){
        ArrayList<String> out = new ArrayList<>(s.length);
        String vowelsS = "";
        for (int i=0; i<s[0].length(); i++){
            if (vowels.indexOf(s[0].charAt(i)) != -1) vowelsS += s[0].charAt(i);  // Определяю гласные в первом слове
        }
        for (int i=0; i<s.length; i++){
            boolean write = true;
            for (int j=0; j<s[i].length(); j++){
                if (vowels.indexOf(s[i].charAt(j)) != -1)
                    if (vowelsS.indexOf(s[i].charAt(j)) == -1)  // Если встречается гласная, которая не входит в первое слово
                        write = false;
            }
            if (write) out.add(s[i]);
        }
        return out.toArray();
    }

    // Определяет, верен ли номер карты по шагам
    public static boolean validateCard(long n){
        if (Long.toString(n).length() < 14  || Long.toString(n).length() > 19) return false;
        long check_n = n % 10; // Step 1
        n = n/10;
        long short_n = n;
        ArrayList<Long> mas = new ArrayList<>();
        for (int i = 0; i < Long.toString(n).length(); i++){  // Step 2  переворачиваем
             mas.add(short_n%10);
             short_n = short_n/10;
        }
        for (int i = 1; i< mas.size()-1; i += 2){ // Step 3  удваиваем нечетные числа
            long x = mas.get(i)*2;
            if (Long.toString(x).length() > 1) x = x/10 * x%10;
            mas.add(i, x);
        }
        int sum = 0;
        for (int i=0; i<mas.size(); i++){  // Складываем все числа
            sum += mas.get(i);
        }
        return (10-(sum%10) == check_n);
    }

    public static String numToEng(int n){
        String out = "";
        if (Integer.toString(n).length() == 3){
            switch (n / 100) {
                case (1) -> out += "One hundred ";
                case (2) -> out += "Two hundred ";
                case (3) -> out += "Three hundred ";
                case (4) -> out += "Four hundred ";
                case (5) -> out += "Five hundred ";
                case (6) -> out += "Six hundred ";
                case (7) -> out += "Seven hundred ";
                case (8) -> out += "Eight hundred ";
                case (9) -> out += "Nine hundred ";
            }
        }
        if ((n/10)%10 >= 2){
            switch ((n / 10) % 10) {
                case (2) -> out += "Twenty ";
                case (3) -> out += "Thirty ";
                case (4) -> out += "Forty ";
                case (5) -> out += "Fifty ";
                case (6) -> out += "Sixty ";
                case (7) -> out += "Seventy ";
                case (8) -> out += "Eighty ";
                case (9) -> out += "Ninety ";
            }
        }
        if ((n/10)%10 == 1){
            switch (n % 10) {
                case (0) -> out += "Ten";
                case (1) -> out += "Eleven";
                case (2) -> out += "Twelve";
                case (3) -> out += "Thirteen";
                case (4) -> out += "Fourteen";
                case (5) -> out += "Fifteen";
                case (6) -> out += "Sixteen";
                case (7) -> out += "Seventeen";
                case (8) -> out += "Eighteen";
                case (9) -> out += "Nineteen";
            }
            return out;
        }
        switch (n % 10) {
            case (1) -> out += "One ";
            case (2) -> out += "Two ";
            case (3) -> out += "Thee ";
            case (4) -> out += "Four ";
            case (5) -> out += "Five ";
            case (6) -> out += "Six ";
            case (7) -> out += "Seven ";
            case (8) -> out += "Eight ";
            case (9) -> out += "Nine ";
        }
        if (n == 0) return "Zero";

        return out;

    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Статический метод getInstance вызывается с хешированием SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static String correctTitle(String s){
        String outS = "";
        String[] mas = s.split(" ");
        for (int i=0; i<mas.length; i++){
            if (!Objects.equals(mas[i].toLowerCase(), "and") && !Objects.equals(mas[i].toLowerCase(), "the") && !Objects.equals(mas[i].toLowerCase(), "of") && !Objects.equals(mas[i].toLowerCase(), "in")){
                outS += mas[i].substring(0,1).toUpperCase() + mas[i].substring(1).toLowerCase() + " ";
            }
            else outS += mas[i].toLowerCase() + " ";
        }
        return outS;
    }

    public static String hexLattice(int n) {
        String ret_str = "";
        String space = " ";
        String circl = "o ";
        int iter_lat = isLattice(n);
        if (iter_lat == 0) return "incorrect";
        for (int i = iter_lat; i <= iter_lat+(iter_lat-1); i++){
            ret_str += space.repeat(iter_lat+(iter_lat-1) - i);
            ret_str += circl.repeat(i);
            ret_str += "\n";
        }
        for (int i = iter_lat+(iter_lat-2); i >= iter_lat; i--){
            ret_str += space.repeat(iter_lat+(iter_lat-1) - i);
            ret_str += circl.repeat(i);
            ret_str += "\n";
        }
        return ret_str;
    }

    public static int isLattice(int n) {
        for (int i = 1; i < 100; i++) {
            int k = (int) (1 + 6 * (0.5 * i * (i - 1)));
            if(k == n){
                return i;
            }
        }
        return 0;
    }

}
