package random; /**
 * Created by geetgobindsingh on 22/08/17.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertListToSet
{
    public static void main( String[] args )
    {
        System.out.println("List values .....");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");

        for (String temp : list){
            System.out.println(temp);
        }

        Set<String> set = new HashSet<String>(list);

        if(set.contains("1")) {
            set.remove("1");
        }
        System.out.println("Set values .....");
        for (String temp : set){
            System.out.println(temp);
        }

    }
}
