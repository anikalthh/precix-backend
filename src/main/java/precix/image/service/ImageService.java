package precix.image.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    public String saveToFile(MultipartFile multipartfile, String fileName) throws Exception{
        // File file = File.createTempFile(fileName, ".jpg");
        File dir = new File(System.getProperty("user.dir"),"uploads");
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("dir doesnt exists");

        } else {
            System.out.println("dir exists");
        }
        File saveFile = new File(dir, fileName);
        System.out.println("saving file in BE " + saveFile);
        multipartfile.transferTo(saveFile);
        
        return new File(dir, fileName).toString();
    }

}
