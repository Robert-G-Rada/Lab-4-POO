package second;

import first.Task;

import java.util.LinkedList;
import java.util.List;

public class Queue implements Container
{
    private List<Task> list;

    public Queue()
    {
        list = new LinkedList<>();
    }

    @Override
    public Task pop()
    {
        Task ret = list.get(0);
        list.remove(0);
        return ret;
    }

    @Override
    public void push(Task task)
    {
        list.add(task);
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public void transferFrom(Container container)
    {
        while (!container.isEmpty())
        {
            push(container.pop());
        }
    }
}
