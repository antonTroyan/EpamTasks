package by.troyan.epam.task1v2.validator;

import org.apache.log4j.Logger;

public class Validator {
    private static Logger log = Logger.getLogger("Validator");
    private final int COLUMN_AMOUNT = 6;

    public boolean validateString (String input) {
        log.info("Validating string " + input);
        if (input.length() == 0) {
            log.info("Length 0 " + input.length());
            return false;
        }
        try {
            String stringTest[] = input.split(" ");
            int intTest[] = new int[COLUMN_AMOUNT];
            for (int i = 0; i < COLUMN_AMOUNT; i++) {
                intTest[i] = Integer.parseInt(stringTest[i]);
            }
            log.info("String " + input + " was validated successfully");
            return true;

        } catch (NumberFormatException e) {
            log.error("Wrong Format " + e);
            // возможно тут стоит выбросить свое исключение
            return false;
        } catch (ArrayIndexOutOfBoundsException e){
            log.error("Wrong parameters amount " + e);
            return false;
        }

    }
}