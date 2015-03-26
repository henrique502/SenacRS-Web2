package br.com.hrdev.helpers;

/**
 *
 * @author henriqueschmidt
 */
public class StringHelper {
    
    public static String characterLimiter(String str, int limit){
        if(str.length() <= limit)
            return str;
        
        String out = "";
        for(String val : str.split(" ")){
            out += val  + ' ';
            if(out.length() >= limit){
                return out.trim();
            }
        }
        
        return null;
    }
    
    public static String stripTags(String str){
        
    }
}