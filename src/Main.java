import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задание: " + bessie(7, "hello my name is Bessie and this is my essay")); // 1
        System.out.println();
        System.out.print("2 задание: " + split("((()))"));
        System.out.println("2 задание: " + split("()()()"));
        System.out.println("3 задание: " + toCamelCase("hello_edabit"));
        System.out.println("3 задание: " + toSnakeCase("getColor"));
        System.out.println("4 задание: " + overTime(new double[] {9, 17, 30, 1.5}));
        System.out.println("5 задание: " + BMI("205 pounds", "73 inches"));
        System.out.println("6 задание: " + bugger(39));
        System.out.println("7 задание: "+ toStarShorthand("abbcсс"));
        // System.out.println("8 задание: " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("9 задание: " + trouble(33789, 12345337));
        System.out.println("10 задание: " + countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    public static String bessie(int k, String input) {
        var res = new StringBuilder();
        int x = 0; // current len
        for (var word : input.split(" ")) {
            if (x != 0 && x + word.length() <= k) {
                res.append(" ");
                x += word.length();
            } else {
                if (x != 0)
                    res.append("\n");
                x = word.length();
            }
            res.append(word);
        }
        return res.toString();
    }

    public static List<String> split(String stroka) {
        char[] str = stroka.toCharArray();
        int count = 0;
        StringBuilder result = new StringBuilder();
        List<String> skobki = new ArrayList<>();

        for (char symbol : str) {
            if (symbol == '(')
                count += 1;
            else
                count -= 1;

            result.append(symbol);

            if (count == 0) {
                skobki.add(result.toString());
                result.setLength(0);
            }
        }
        return skobki;
    }

    public static String toCamelCase(String str)
    {
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '_')
            {
                String a = String.valueOf(s.charAt(i+1));
                s.replace(i, i+2, a.toUpperCase());
            }
        }

        return s.toString();
    }

    public static String toSnakeCase(String str)
    {
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < s.length(); i++)
        {
            if (String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i)).toUpperCase()))
            {
                String a = String.valueOf(s.charAt(i));
                s.replace(i, i+1, "_" + a.toLowerCase());
            }
        }

        return s.toString();
    }

    public static String overTime(double[] array)
    {
        double payDay2 = array[1] <= 17 ? (array[1] - array[0]) * array[2]: array[2] * ((17 - array[0]) + (array[1] - 17) * array[3]);
        return String.format("$" + "%.2f", payDay2);
    }

public static String BMI(String weight, String height) {
        var weight1 = weight.split(" ");
        double w_d = Double.parseDouble(weight1[0]);
        w_d *= "kilos".equals(weight1[1]) ? 1 : 0.453;

        var height1 = height.split(" ");
        double h_d = Double.parseDouble(height1[0]);
        h_d *= "meters".equals(height1[1]) ? 1 : 0.0254;
        double res = w_d / (h_d * h_d);

        if (res < 18.5) {
            return String.format("%.1f Underweight", res);
        }
        if (res < 25) {
            return String.format("%.1f Normal weigth", res);
        }
        return String.format("%.1f Overweight", res);
}
public static int bugger (int n) {
        int count = 0;
        while (n > 9) {
            count += 1;
            String n_str = Integer.toString(n);
            int result = 1;
            for (int i = 0; i < n_str.length(); i++) {
                result *= Integer.parseInt(String.valueOf(n_str.charAt(i)));
            }
            n = result;
        }
        return count;
}
public static String toStarShorthand(String s) {
    if (s.length() == 0)
        return s;
    var res = new StringBuilder();
    char a = s.charAt(0), x;
    int c = 1;
    for (int i = 1, n = s.length(); i < n; i++) {
        if (a == (x = s.charAt(i)))
            ++c;
        else {
            res.append(a);
            if (c != 1) {
                res.append('*');
                res.append(c);
            }
            c = 1;
            a = x;
        }
    }
    if (c != 1) {
        res.append('*');
        res.append(c);
    }
    return res.toString();
}
public static boolean trouble (int num1, int num2) {
        String num1_str = String.valueOf(num1);
        String num2_str = String.valueOf(num2);
        for (int i = 0; i < num1_str.length(); i++) {
            String current_1 = Character.toString(num1_str.charAt(i)).repeat(3);
            String current_2 = Character.toString(num2_str.charAt(i)).repeat(2);
            if (num1_str.split(current_1, -1).length-1 == 1 && num2_str.split(current_2, -1).length-1 == 1) {
                return true;
            }
        }
        return false;
}
public static int countUniqueBooks (String s, char endBook) {
        boolean isOpen = false;
        var s_b = new StringBuilder(s);
        var books = new HashSet<>();
        int j = 0;
        for (int i = 0, n = s_b.length(); i < n; ++i) {
            if (s_b.charAt(i) == endBook) {
                if (isOpen)
                    books.addAll(s_b.subSequence(j, i).chars().boxed().toList());
                else
                    j = i + 1;
                isOpen ^= true;
            }
        }
        return books.size();
}
}


