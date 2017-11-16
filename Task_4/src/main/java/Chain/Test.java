package Chain;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        SymbolSetCreator setCreator = new SymbolSetCreator();
        setCreator.create("data//data.txt");

        System.out.println(setCreator.create("data//data.txt"));

//        String input = "   Я положил к твоей постели\n" +
//                "Полузавядшие цветы,\n" +
//                "И с лепестками помертвели\n" +
//                "Мои усталые мечты.\n" +
//                "    Я нашептал моим левкоям\n" +
//                "Об угасающей любви,\n" +
//                "И ты к оплаканным покоям\n" +
//                "Меня уж больше не зови.\n" +
//                "    Мы не живём, а мы тоскуем.\n" +
//                "Для нас мгновенье красота,\n" +
//                "Но не зажжёшь ты поцелуем\n" +
//                "Мои холодные уста.\n" +
//                "    И пусть в мечтах я всё читаю:\n" +
//                "«Ты не любил, тебе не жаль»,\n" +
//                "Зато я лучше понимаю\n" +
//                "Твою любовную печаль.";
//
//
//        String [] result = input.split("\\s+[^.!?]*[.!?]");
//        System.out.println("Ammount =" + result.length);
//        for(String tmp: result){
//            System.out.println("Element = " + tmp);
//        }

    }
}
