package by.troyan.web.command;


/**
 * Перечень всех команд.
 * @author  Anton Troyan
 */


public enum CommandEnum {
    SHOW_MAIN_PAGE("showMainPage");


    private String value;

    private CommandEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static CommandEnum getEnum(String value) throws IllegalArgumentException{
        for(CommandEnum commandEnum : values()){
            if(commandEnum.value.equals(value)){
                return commandEnum;
            }
        }
        return getDefault();
    }

    private static CommandEnum getDefault(){
        return SHOW_MAIN_PAGE;
    }
}
