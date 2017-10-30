package second;

import first.Task;

import java.util.ArrayList;

public class Stack implements Container
{
    private ArrayList<Task> array;

    public Stack()
    {
        array = new ArrayList<>();
    }

    @Override
    public Task pop()
    {
        Task top = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return top;
    }

    @Override
    public void push(Task task)
    {
        array.add(task);
    }

    @Override
    public int size()
    {
        return array.size();
    }

    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
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
