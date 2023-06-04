package Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class log {
	public log()
    {
    
    }
    public void Logs(String s) throws IOException{
        Date date = new Date();
        System.out.print(date +": "+ s + "\n");
        try{
            //tạo tệp và lưu vào ổ D:\\javatest3\\test22_5 với tên là Logs
               File foder = new File("D:\\javatest3\\CorbaServer\\Logs");
                if (!foder.exists()) {
                if (foder.mkdir()) { }
                 }
            //tạo file txt để ghi log và lưu vào tệp vừa tạo
               File file =new File("D:\\javatest3\\CorbaServer\\Logs\\DangTrongDanh_20521160_Corba.txt");

               if(!file.exists()){
                  file.createNewFile();
               }

               //nối thêm nội dung vào tệp
               FileWriter fw = new FileWriter(file,true);
               //ghi bufferedWriter để cho hiệu suất tốt hơn
               BufferedWriter bw = new BufferedWriter(fw);
               bw.write(date+": " + s + "\n");
               //đóng luồng
               bw.close();

             }catch(IOException ioe){
                System.out.println(ioe);
              }
    }
}
