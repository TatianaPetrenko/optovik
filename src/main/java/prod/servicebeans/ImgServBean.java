/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.servicebeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import prod.dao.ImageDaoImpl;
import prod.model.Images;


@ManagedBean
@SessionScoped
public class ImgServBean {

    private static final int BUFFER_SIZE = 6124;
    private Images new_file;
    private UploadedFile upl_file;
    private List<Images> filelist = null;

    public Images getNew_file() {
        return new_file;
    }

    public void setNew_file(Images new_file) {
        this.new_file = new_file;
    }

    
    
    public UploadedFile getUpl_file() {
        return upl_file;
    }

    public void setUpl_file(UploadedFile upl_file) {
        this.upl_file = upl_file;
    }

    public List<Images> getFilelist() {
        return filelist;
    }

    public void setFilelist(List<Images> filelist) {
        this.filelist = filelist;
    }

    
    public void doUpload(FileUploadEvent e) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.upl_file = e.getFile();

        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String relativeWebPath = "//resources//files//" + upl_file.getFileName();

        File result = new File(ec.getRealPath(relativeWebPath));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[BUFFER_SIZE];

            int bulk;
            InputStream inputStream = upl_file.getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

        } catch (IOException ee) {
            ee.printStackTrace();

        }

        ImageDaoImpl imdao = new ImageDaoImpl();
        
        //создать новый файл для бд
        new_file = new Images();
        new_file.setPath(ec.getRealPath(relativeWebPath));
        imdao.saveImage(new_file);
   //     this.filelist = getFiles();
        RequestContext.getCurrentInstance().update("data");

    }

  

}
