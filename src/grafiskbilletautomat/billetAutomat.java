package grafiskbilletautomat;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;


public class billetAutomat
{
    public static String getDate()
    {
        Date epoch = new Date(System.currentTimeMillis());

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        return date.format(epoch);
    }

    public static String getTime()
    {
        Date epoch = new Date(System.currentTimeMillis());

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        return time.format(epoch);
    }
}
