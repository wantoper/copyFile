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
    	//�жϸ��ƺ���ļ����Ƿ���� �����ڴ���
    	if(!f1.exists()){
    		f1.mkdirs();
    	}
    	
    	//�ж��Ƿ����ļ���
    	if(!f.isDirectory()){
    		//�����ļ��м����ļ� ֱ�Ӹ���
    		File f2 = new File(f1+"/"+f.getName());
    		System.out.println(f2);
    		copy(f,f2);
    	}else{    
    		//������ļ���
    		
    		//����list�������ļ����������ļ�
    		File[] list = new File[(int) f.length()];
    		//���ļ����������ļ�ȡ���Ž�list����
    		list = f.listFiles(); 		
    		//�������ļ����в���
    		for(File fq:list){
    			//���ƺ��ļ��Ĵ��·��
    			File f2;
    			//�ж��Ƿ����ļ���
    			if(!fq.isDirectory()){
    				//������ �ϳɸ��ƺ��ļ��Ĵ��·��
    				f2 = new File(f1.getAbsolutePath()+"/"+fq.getName());
    				System.out.println(f2);
    				//ֱ�Ӹ����ļ�
    				copy(fq,f2);
    			}else{
    				//�����ļ��� �ϳɸ��ƺ��ļ��Ĵ��·��
    				f2 = new File(f1.getAbsolutePath()+"/"+fq.getName());
    				System.out.println(f2);
    				//�������ļ���
    				f2.mkdirs();
    				//�����Լ�
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