package back.port.port;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/cv")
public class RecursosController {

    @GetMapping("")
    public ResponseEntity<FileSystemResource> downloadPdf() throws IOException {


        String relativePath = "static/CV2023.pdf";

        /*
        Resource resource = new ClassPathResource(relativePath);
        String absolutePath = resource.getFile().getAbsolutePath();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "archivo.pdf");


        FileSystemResource pdfFile = new FileSystemResource(absolutePath);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .body(pdfFile);
         */
        try {
            // Cargar el archivo desde el classpath
            FileSystemResource resource = new FileSystemResource(new ClassPathResource(relativePath).getFile());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "archivo.pdf");
            // Configurar la respuesta con el archivo PDF
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
