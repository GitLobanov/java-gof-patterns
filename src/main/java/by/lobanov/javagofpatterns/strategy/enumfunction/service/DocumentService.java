package by.lobanov.javagofpatterns.strategy.enumfunction.service;

import by.lobanov.javagofpatterns.strategy.enumfunction.model.Document;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    public String processDocument(Document document) {
        return document.getType().process(document);
    }

    public String getArchivePath(Document document) {
        return document.getType().generateArchivePath() + document.getClientId() + "/";
    }
}
