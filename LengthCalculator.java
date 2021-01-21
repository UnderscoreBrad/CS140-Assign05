package assignment05;

import java.util.*;

public class LengthCalculator {

    public static void removeNulls(List<String> list){
        if(list==null){
            throw new IllegalArgumentException("list parameter cannot be null");
        }else if(list.size()==0){
            return;
        }
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            if(iter.next()==null){
                iter.remove();
            }
        }
    }
    public static List<Integer> stringLengths(List<String> list){
        if(list == null || list.size() == 0){
            throw new IllegalArgumentException("list parameter cannot be empty or null");
        }
        removeNulls(list);
        if(list.size() == 0){
            throw new IllegalArgumentException("list parameter cannot be empty or null");
        }
        List<Integer> x = new ArrayList<>();
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            int y = iter.next().length();
            x.add(y);
        }
        return x;
    }
}
