package random;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by geetgobindsingh on 28/08/17.
 */
public class DateChecktest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", new Locale("en", "UK"));
        System.out.print(sdf.format(new Date()));
    }
}
