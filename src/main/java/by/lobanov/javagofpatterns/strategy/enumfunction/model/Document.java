package by.lobanov.javagofpatterns.strategy.enumfunction.model;

import by.lobanov.javagofpatterns.strategy.enumfunction.strategy.DocumentType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Document {

    private String content;
    private DocumentType type;
    private String clientId;
}
