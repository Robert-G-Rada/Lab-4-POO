package first;

import java.util.Random;

public class GenerateRandom implements Task
{
    private int random_number = 0;

    public GenerateRandom()
    {
        Random random = new Random();
        random_number = random.nextInt();
    }

    @Override
    public void execute()
    {
        System.out.println(random_number);
    }
}
