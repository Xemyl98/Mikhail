import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void badSize() {
        Array array=new Array();
        int[][]data={{1,2,3},{4,5,6}};
        int[][] actual= array.transfer(data);
        assertArrayEquals(null,actual);
    }
    @Test
    public void empty()
    {
        Array array=new Array();
        assertArrayEquals(null,array.transfer(null));
    }
    @Test
    public void allZero()
    {
        Array array=new Array();
        int[][]data={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        int[][]expected={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        int[][]actual=array.transfer(data);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void withoutZero()
    {
        Array array=new Array();
        int[][]data={{1,2,3,4,5,6},{8,7,9,10,11,-12},{13,14,17,16,15,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        int[][]expected={{1,2,3,4,5,6},{8,7,9,10,11,-12},{13,14,17,16,15,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        int[][]actual=array.transfer(data);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void usualArray() {
        Array array=new Array();
        int[][]data={{1,2,3,0,0,4},{1,2,3,0,4,0},{0,1,2,3,4,5},{1,2,0,0,0,3},{0,0,1,2,0,0}};
        int[][] actual= array.transfer(data);
        int [][]expected={{1,2,3,4,0,0},{1,2,3,4,0,0},{1,2,3,4,5,0},{1,2,3,0,0,0},{1,2,0,0,0,0}};
        assertArrayEquals(expected,actual);
    }
}