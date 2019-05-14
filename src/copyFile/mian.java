package copyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class mian {

    public static void main(String[] args) throws Exception {
    	 File f= new File("D:/1.rar");
    	 File copy = new File("D:/copy"+"/"+f.getName());
    	 byte[] all = get(f);
    	 out(all,copy);
    	 System.out.println("Ö´ÐÐÍê±Ï£¡");
    }
    
    public static byte[] get(File f) throws IOException{
    	byte[] all = new byte[(int)f.length()];
    	FileInputStream fis = new FileInputStream(f);
    	fis.read(all);
    	fis.close();
    	return all;
    }
    
    public static void out(byte[] all,File f) throws IOException{
   	 FileOutputStream fos = new FileOutputStream(f);
   	 fos.write(all);
   	 fos.close();
    }
}