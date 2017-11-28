package creator;


import action.TextFormulasCalculator;
import counter.interpreter.Client;

public class Test {
    public static void main(String[] args) {
//        13 5 +
//                3 5 +
//                6 9 3 4 - * +
//                5 1 2 * 2 4 5 9 - 4 + * 3 - * 2 - * 1 - *
//        71 2 4 * 3 2 1 2 / 2 * - * 2 - * 10 2 / - - 4 *
//        5 - 1 2 / 2 5 2 * + 8 - * + 1200 *


//        Client interpreter = new Client("5 - 1 2 / 2 5 2 * + 8 - * + 1200 *");
//        String answer = interpreter.calculate().toString();
//        System.out.println(answer);


        TextFormulasCalculator textFormulasCalculator = new TextFormulasCalculator();
        String result = textFormulasCalculator.calculateTextFormulas("    It has survived - not only (five) centuries, but also the leap into 13+ i--\n" +
                "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
                "popularised in the 5*(1*2*(2*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets\n" +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
                "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "    It is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)\n" +
                "-2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
                "opposed to using (Content here), content here', making it look like readable English.\n" +
                "\n" +
                "    It is a (5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "\n" +
                "    Bye.", 5 , 10);
        System.out.println(result);
    }
}
