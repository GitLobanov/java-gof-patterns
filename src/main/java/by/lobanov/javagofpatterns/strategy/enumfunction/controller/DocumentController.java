package by.lobanov.javagofpatterns.strategy.enumfunction.controller;

import by.lobanov.javagofpatterns.strategy.enumfunction.model.Document;
import by.lobanov.javagofpatterns.strategy.enumfunction.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processDocument(@RequestBody Document document) {
        String result = documentService.processDocument(document);
        String archivePath = documentService.getArchivePath(document);

        return ResponseEntity.ok(result + " Архивный путь: " + archivePath);
    }
}
