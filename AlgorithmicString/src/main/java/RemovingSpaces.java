public class RemovingSpaces {

    public String Remove(String data)
    {
        try
        {
            if(data.length()==0 && data.equals(""))
                throw new NullPointerException();
            for (int i = 0; i < data.length(); i++) {

                if(data.charAt(i)==' '&&data.length()==1)
                throw new NullPointerException();
                else
                    if(data.charAt(i)==' ')
                {
                    if(i==data.length()-1)
                        data=data.substring(0,i);
                    else
                        {
                        data = data.substring(0, i) + data.substring(i + 1, data.length());
                        i = i - 1;
                    }
                }
            }
        }
        catch (NullPointerException ex)
        {
            return null;
        }
        return data;
    }

}
