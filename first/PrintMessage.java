package first;

public class PrintMessage implements Task
{
    private String message;

    public PrintMessage(String message)
    {
        this.message = message;
    }

    @Override
    public void execute()
    {
        System.out.println(message);
    }
}
