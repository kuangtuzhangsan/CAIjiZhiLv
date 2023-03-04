package com.xyx;

import java.util.ArrayList;
import java.util.List;

public class FizzCuzz0302 {
    public List<String> fizzBuzz(int n) {

        List<String> list =new ArrayList<String>();
        for( int i =1 ; i <= n; i++ ) {
            String str = "";
            if (i%3 == 0){
                str += "Fizz";
            }
            if (i%5 == 0){
                str += "Buzz";
            }
            if ("".equals(str)) str = Integer.toString(i);
            list.add(str);
        }
        return list;
    }
}
