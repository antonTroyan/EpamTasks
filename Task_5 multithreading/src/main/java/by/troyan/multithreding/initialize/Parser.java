package by.troyan.multithreding.initialize;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Parser {

    public List<String> findInformationInFile(String filename, String pattern){
        List<String> resultList = null;
        Scanner lineScanner;
        try {
            lineScanner = new Scanner(new FileReader(filename));

        while(lineScanner.hasNext()){
            String founded = lineScanner.nextLine();
            if(founded.startsWith(pattern)){
                resultList = new ArrayList<>(Arrays.asList(founded.split(" ")));
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        resultList.remove(0);
        System.out.println(resultList);
        return resultList;
    }
}
