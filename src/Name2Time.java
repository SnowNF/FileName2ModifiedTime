import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Name2Time {
    SimpleDateFormat sdf;
    File file;
    Date date = null;
    Name2Time(File file,SimpleDateFormat sdf){
        this.file = file;
        this.sdf = sdf;
    }
    boolean conv(int pos){
        try {
            date = sdf.parse(file.getName(),new ParsePosition(pos));
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        if(date == null)
            return false;
        return file.setLastModified(date.getTime());
    }
}
