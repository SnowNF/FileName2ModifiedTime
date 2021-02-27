import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Invalid args");
            return;
        }
        File dir = new File(args[0]);
        if(!dir.isDirectory()){
            System.out.println("The path is not a directory");
            return;
        }
        if(dir.canRead()&&dir.canWrite()){
            File[] files = new Path2Files(dir).getFiles();
            SimpleDateFormat sdf = new SimpleDateFormat(getFormat(files));
            int pos = getPos();
            for (File file : files) {
                if(new Name2Time(file,sdf).conv(pos))
                    System.out.println("成功转换："+file.getAbsolutePath());
                else
                    System.out.println("无法转换："+file.getAbsolutePath());
            }
        }else {
            System.out.println("The dir can not be read or write");
        }
    }
    static String getFormat(File[] files){
        System.out.println("共发现"+files.length+"个文件");
        System.out.println("请输入文件名格式：");
        System.out.println("yyyy 年份 ~ MM 月份 ~ dd 日期 ~ HH 二十四小时 ~ mm 分 ~ ss 秒");
        return new Scanner(System.in).nextLine();
    }

    static int getPos(){
        System.out.println("请输入起始位置：");
        return new Scanner(System.in).nextInt();
    }
}
