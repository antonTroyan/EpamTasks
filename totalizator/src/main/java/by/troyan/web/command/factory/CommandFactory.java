package by.troyan.web.command.factory;


import by.troyan.web.command.CommandEnum;
import by.troyan.web.command.ICommand;
import by.troyan.web.command.implementation.ShowMainPageCommand;

import java.util.HashMap;
import java.util.Map;

import static by.troyan.web.command.CommandEnum.SHOW_MAIN_PAGE;


public class CommandFactory {
    private static final CommandFactory factory = new CommandFactory();
    public static CommandFactory getFactory(){
        return factory;
    }

    private Map<CommandEnum, ICommand> commands;

    private CommandFactory(){
        commands = new HashMap<CommandEnum, ICommand>();
        commands.put(SHOW_MAIN_PAGE, new ShowMainPageCommand());
    }

    public ICommand createCommand(CommandEnum command){
        if(commands.containsKey(command)){
            return commands.get(command);
        }
        return null;
    }
}
