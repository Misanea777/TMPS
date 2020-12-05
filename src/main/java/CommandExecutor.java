import command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeAllComands() {
        commands.clear();
    }

    public void executeAllCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void unexecuteAllCommands() {
        for(int i=commands.size()-1; i>=0; i--) {
            commands.get(i).unexecute();
        }
    }

    public void executeLastCommand() {
        commands.get(commands.size()-1).execute();
    }

    public void unexecuteLastCommand() {
        commands.get(commands.size()-1).unexecute();
    }
}
