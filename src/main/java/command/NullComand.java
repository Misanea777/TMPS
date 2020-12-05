package command;

public class NullComand implements Command{
    @Override
    public void execute() {
        System.out.println("null command cannot be executed");
    }

    @Override
    public void unexecute() {
        System.out.println("null command cannot be unexecuted");
    }
}
