package iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class ConcreteAggregateTest {
    private static ConcreteAggregate concreteAggregateWithCorrectData;
    private static ConcreteAggregate concreteAggregateWithUninitializedData;
    @BeforeClass
    public static void beforeClass()
    {
        String[] correctedDataToConcreteAggregate={"task1","task2"};
        concreteAggregateWithCorrectData =new ConcreteAggregate();
        concreteAggregateWithUninitializedData =new ConcreteAggregate();
        concreteAggregateWithCorrectData.setTasks(correctedDataToConcreteAggregate);
        concreteAggregateWithUninitializedData.setTasks(null);

    }
    @Test
    public void getConcreteAggregateFromCorrectDataValue()
    {
        assertEquals("task1task2", concreteAggregateWithCorrectData.getTasks(concreteAggregateWithCorrectData.getIterator()));
    }
    @Test(expected = NullPointerException.class)
    public void getConcreteAggregateFromUninitializedData()
    {
        concreteAggregateWithUninitializedData.getTasks(concreteAggregateWithUninitializedData.getIterator());
    }
}