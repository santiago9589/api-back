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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/cv")
public class RecursosController {

    @GetMapping("")
    public ResponseEntity<byte[]> downloadPdf() throws IOException {

        String relativePath = "static/CV2023.pdf";

        try {

            Resource resource = new ClassPathResource(relativePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "archivo.pdf");
            InputStream inputStream = resource.getInputStream();
            byte[] contenido = inputStream.readAllBytes();

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(contenido);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
