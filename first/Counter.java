package first;

public class Counter implements Task
{
    private int counter;

    public Counter()
    {
        counter = 0;
    }

    @Override
    public void execute()
    {
        counter++;
        System.out.println(counter);
    }
}
