package iterator;

public class ConcreteAggregate implements Aggregate {
    private   String[] tasks;
    public void setTasks(String[] tasks) {
        this.tasks = tasks;
    }

    public String getTasks(Iterator iterator)
    {
        String collectedString="";
        while (iterator.hasNext())
            collectedString+=(String)iterator.next();
        return collectedString;
    }
    @Override
    public Iterator getIterator()
    {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator
    {
        int index=0;
        @Override
        public boolean hasNext()
        {
            if(tasks==null)
                throw new NullPointerException("Input String Uninitialized");
            if(index<tasks.length)
                return true;
            return false;
        }
        @Override
        public Object next()
        {
            return tasks[index++];
        }
    }
}
