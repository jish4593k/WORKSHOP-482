import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToTextConverter {

    public static void convertPdfToText(String pdfPath, String outputTextPath) {
        try {
            PDDocument document = PDDocument.load(new File(pdfPath));
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);
            document.close();

            writeTextToFile(outputTextPath, text);
            System.out.println("Text extracted and saved to " + outputTextPath);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void writeTextToFile(String outputPath, String text) {
        try (Writer writer = new FileWriter(outputPath)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("le: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uspath");
        } else {
            String inputPdfPath = args[0];
            String outputTextPath = args[1];
            convertPdfToText(inputPdfPath, outputTextPath);
        }
    }
}
