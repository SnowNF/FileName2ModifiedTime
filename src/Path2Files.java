import java.io.File;
import java.util.ArrayList;

public class Path2Files {
    File path;
    ArrayList<File> files;
    Path2Files(File path){
        this.path = path;
        files = new ArrayList<>();
    }
    File[] getFiles(){
        dir2files(path.listFiles(),files);
        return files.toArray(new File[0]);
    }
    void dir2files(File[] dir,ArrayList<File> toAdd){
        if(dir == null)
            return;
        for (File file : dir) {
            if (file.isFile()){
           //     System.out.println("Added file : "+file.getName());
                toAdd.add(file);
            }
            if (file.isDirectory()){
           //     System.out.println("A directory : "+file.getName());
                dir2files(file.listFiles(), toAdd);
            }
        }
    }
}
