package depotBeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;

import javax.servlet.http.Part;

import Entities.Deposant;

public class UploadUtils {

	private static final String upload = "C:\\laragon\\www\\otdav"; 
    final Date date = new Date();
    String year;
    String month;

    public static String uploadFile(Deposant deposant, Part fileOrigin) {
       
       String fileName="";  
       File mainDirectory = new File(upload );
       
       File deposerdDirectory = new File(upload + "/" + deposant.getCin());
       
       if (!mainDirectory.exists())
        	mainDirectory.mkdir();

        if (!deposerdDirectory.exists())
        	deposerdDirectory.mkdir();
       
        try (InputStream input = fileOrigin.getInputStream()) {
        	fileName = fileOrigin.getSubmittedFileName();
            Files.copy(input, new File(deposerdDirectory, fileName).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
		return fileName;
    }


    public static String getExtension(String filename) {

        String ext = filename.substring(filename.lastIndexOf(".") + 1);
        return ext;
    }
	
}
