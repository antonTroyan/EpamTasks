package action;

import java.util.Scanner;

public class TextConverter {
    public static void main(String[] args) {
        TextConverter textConverter = new TextConverter();
        textConverter.setTextWithParameters("\n" +
                "    It has survived - not only (five) centuries, but also the leap into 13+ i--\n" +
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
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "\n" +
                "    Bye.", 5, 6);
    }


    public String setTextWithParameters(String text, int i, int j){

        int currentI = i;
        int currentJ = j;

        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()){
            String nextLine = scanner.nextLine();
            Scanner parametersScanner = new Scanner(nextLine);

            String founded = parametersScanner.findInLine("\\+\\+i|--i|i--|i\\+\\+|\\+\\+j|--j|j--|j\\+\\+");
            System.out.println("founded " + founded);

            if (founded != null){
                switch(founded){
                    case "++i":
                        result.append(nextLine.replace("++i", String.valueOf(++currentI))+"\n");
                        break;
                    case "--i":
                        result.append(nextLine.replace("--i", String.valueOf(--currentI))+"\n");
                        break;
                    case "i--":
                        result.append(nextLine.replace("i--", String.valueOf(currentI--))+"\n");
                        break;
                    case "i++":
                        result.append(nextLine.replace("i++", String.valueOf(currentI++))+"\n");
                        break;
                    case "++j":
                        result.append(nextLine.replace("++j", String.valueOf(++currentJ))+"\n");
                        break;
                    case "--j":
                        result.append(nextLine.replace("--j", String.valueOf(--currentJ))+"\n");
                        break;
                    case "j--":
                        result.append(nextLine.replace("j--", String.valueOf(currentJ--))+"\n");
                        break;
                    case "j++":
                        result.append(nextLine.replace("j++", String.valueOf(currentJ++))+"\n");
                        break;
                }
            } else {
                result.append(nextLine + "\n");
            }
        }

        System.out.println(result);
        return String.valueOf(result);
    }




}
