package es.sms.bolsa.view.jsf.bean;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.poi.util.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.sms.bolsa.model.entity.Fichero;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PDFViewerBean  extends MasterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(SesionBean.class);
	
	

	@Value("${es.sms.boltra.ruta.nfs}")
	private String rutaNFS;
	
	@Value("${es.sms.boltra.url}")
	private String rutaIntranet;
	
	private StreamedContent tmpPDF;
	
	private InputStream inputStreamPDF;
	
	
	private ByteArrayInputStream byteInput;
	
	private String rutaPDF;

	

	public String getRutaNFS() {
		return rutaNFS;
	}




	public void setRutaNFS(String rutaNFS) {
		this.rutaNFS = rutaNFS;
	}




	public InputStream getInputStreamPDF() {
		return inputStreamPDF;
	}




	public void setInputStreamPDF(InputStream inputStreamPDF) {
		this.inputStreamPDF = inputStreamPDF;
	}




	public ByteArrayInputStream getByteInput() {
		return byteInput;
	}




	public void setByteInput(ByteArrayInputStream byteInput) {
		this.byteInput = byteInput;
	}




	public String getRutaPDF() {
		return rutaPDF;
	}




	public void setRutaPDF(String rutaPDF) {
		this.rutaPDF = rutaPDF;
	}




	public void setTmpPDF(StreamedContent tmpPDF) {
		this.tmpPDF = tmpPDF;
	}




	public void cargarFichero(Fichero fichero) {
		
		
		String rutaFichero = rutaNFS + "mi-carpeta/" + fichero.getDni() + "/" + fichero.getNombreCarpeta();
		this.rutaPDF=rutaFichero;
	   this.openDialog("pdf");
	
	}
	

    

    public StreamedContent getTmpPDF() throws IOException {
    
    	byte[] imageInByte = null;
    	try {
    	//	if(inputStreamPDF!=null)
    	//	this.inputStreamPDF.close();
    	this.inputStreamPDF = new FileInputStream(this.rutaPDF);
    	imageInByte = IOUtils.toByteArray(this.inputStreamPDF);
    	
    	} catch (Exception e) {
    	System.out.println("err" + e.getMessage());
    	}
    	 FacesContext context = FacesContext.getCurrentInstance();

         if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
             return new DefaultStreamedContent();
         } else {
            // if(this.byteInput!=null)
        	// this.byteInput.close();         
        	 this.byteInput = new ByteArrayInputStream(imageInByte);
        	 return new DefaultStreamedContent(byteInput,"application/pdf");
         }
    }

	
	
}
