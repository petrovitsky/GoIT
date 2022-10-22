package module8.lesson;

public abstract class ReportService implements DocumentService {

    @Override
    public void sign(Document document, String key) {
        System.out.println("");
    }

    @Override
    public void send(Document document) {

    }
}
