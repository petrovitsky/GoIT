package module8.lesson;

public interface DocumentService {
    Document generate();
    void fill(Document document, String dataToFill);
    void sign(Document document, String key);
    void send(Document document);
}
