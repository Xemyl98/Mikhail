public class Array {

public int[][] transfer(int data[][])
{
    if (data==null)
        return null;
    if(data.length!=5&&data[0].length!=6)
        return null;
    for(int i=0;i<5;i++)
            for(int j=0;j<6;j++)
            {
                if(data[i][j]==0)
                {
                    for(int k=j+1;k<6;k++)
                    {
                        if(data[i][k]!=0)
                        {
                            int temp=data[i][k];
                            data[i][k]=data[i][j];
                            data[i][j]=temp;
                            break;
                        }
                    }
                }
        }
    return data;
}
}
