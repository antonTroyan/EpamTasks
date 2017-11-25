package Chain.simple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {

        String input = "   Я положил к твоей постели\n" +
                "Полузавядшие цветы,\n" +
                "И с лепестками помертвели\n" +
                "Мои усталые мечты.\n" +
                "\n" +
                "    Я нашептал моим левкоям\n" +
                "Об угасающей любви,\n" +
                "И ты к оплаканным покоям\n" +
                "Меня уж больше не зови.\n" +
                "\n" +
                "    Мы не живём, а мы тоскуем.\n" +
                "Для нас мгновенье красота,\n" +
                "Но не зажжёшь ты поцелуем\n" +
                "Мои холодные уста.\n" +
                "\n" +
                "    И пусть в мечтах я всё читаю:\n" +
                "«Ты не любил, тебе не жаль»,\n" +
                "Зато я лучше понимаю\n" +
                "Твою любовную печаль.";



        Matcher matcher = Pattern.compile("(?s)(.*?[^\\:\\-\\,])(?:$|\\n{2,})").matcher(input);
        String result;
        while(matcher.find()){
            result = matcher.group();
            System.out.println("Paragraph - " + result);



        }
    }
}
