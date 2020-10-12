package SwimgBD.util;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author PERSONAL
 */
public class DatetoLocalDate {
    public LocalDate conversion(Date d){
        LocalDate l = null;
        if(d!=null){
            l = new java.sql.Date(d.getTime()).toLocalDate();
        }
        return l;
    }
}
