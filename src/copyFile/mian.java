package copyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class mian {

    public static void main(String[] args) throws Exception {
    	 File f= new File("D:/copy");
    	 File copy = new File("D:/5");
    	 copyfile(f,copy);
    }
    
    public static void copyfile(File f,File f1) throws IOException{
    	//判断复制后的文件夹是否存在 不存在创建
    	if(!f1.exists()){
    		f1.mkdirs();
    	}
    	
    	//判断是否是文件夹
    	if(!f.isDirectory()){
    		//不是文件夹既是文件 直接复制
    		File f2 = new File(f1+"/"+f.getName());
    		System.out.println(f2);
    		copy(f,f2);
    	}else{    
    		//如果是文件夹
    		
    		//创建list数组存放文件夹内所有文件
    		File[] list = new File[(int) f.length()];
    		//将文件夹内所有文件取出放进list数组
    		list = f.listFiles(); 		
    		//对所有文件进行操作
    		for(File fq:list){
    			//复制后文件的存放路径
    			File f2;
    			//判断是否还是文件夹
    			if(!fq.isDirectory()){
    				//不是了 合成复制后文件的存放路径
    				f2 = new File(f1.getAbsolutePath()+"/"+fq.getName());
    				System.out.println(f2);
    				//直接复制文件
    				copy(fq,f2);
    			}else{
    				//还是文件夹 合成复制后文件的存放路径
    				f2 = new File(f1.getAbsolutePath()+"/"+fq.getName());
    				System.out.println(f2);
    				//创建父文件夹
    				f2.mkdirs();
    				//调用自己
        			copyfile(fq,f2);
    			}
    		}
    	}
    	
    }
    
    public static void copy(File f,File f1) throws IOException{
    	FileInputStream fis = new FileInputStream(f);
    	FileOutputStream fos = new FileOutputStream(f1);
    	
    	byte[] all =new byte[(int) f.length()];
    	fis.read(all);
    	
    	fos.write(all);
    	
    	fis.close();
    	fos.close();
    }
    
}