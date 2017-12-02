package by.troyan.task4.action;

import by.troyan.task4.structurecreator.RegularExpression;

import java.util.Scanner;

public class ParametersTextFiller {

    public String fillTextByParameters(String text, int i, int j){

        int currentI = i;
        int currentJ = j;

        StringBuilder result = new StringBuilder();
        Scanner parametersScanner = null;

        try(Scanner lineScanner = new Scanner(text)){
            while (lineScanner.hasNext()){
                String nextLine = lineScanner.nextLine();
                parametersScanner = new Scanner(nextLine);
                String founded = parametersScanner.findInLine(RegularExpression.REGEX_IANDJ);
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
        } finally {
            if (parametersScanner != null){
                parametersScanner.close();
            }
        }
        return String.valueOf(result);
    }
}
