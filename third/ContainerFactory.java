package third;

import second.Container;
import second.Queue;
import second.Stack;

public class ContainerFactory implements IFactory
{
    @Override
    public Container createContainer(Strategy strategy)
    {
        if (strategy == Strategy.FIFO)
            return new Queue();
        else if (strategy == Strategy.LIFO)
            return new Stack();

        return null;
    }
}
