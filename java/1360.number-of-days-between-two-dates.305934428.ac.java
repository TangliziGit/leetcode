import java.time.*;
import java.text.*;

class Solution {
    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public int daysBetweenDates(String date1, String date2) {
        Instant start = null, end = null; 
        
        try {
            start = getInstant(date1);
            end = getInstant(date2);
        } catch (Exception e) {
            ;
        }

        return Math.abs((int)(Duration.between(start, end).getSeconds() / (60 * 60 * 24)));
    }
    
    private Instant getInstant(String date) throws Exception {
        return formater.parse(date).toInstant();
    }
}
