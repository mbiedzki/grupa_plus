package pl.coderslab.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.Contract;
import pl.coderslab.model.User;
import pl.coderslab.service.ContractService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PdfCreator {

    private static final FontProvider CUSTOM_FONT_PROVIDER = new FontProvider() {

        @Override
        public boolean isRegistered(String fontName) {
            return true;
        }

        @Override
        public Font getFont(String fontName, String encoding, boolean embedded, float size, int style, BaseColor color) {
            try {
                BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
                Font font = new Font(helvetica, size, style, color);
                return font;
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static void pdfCreate(String body) throws IOException, DocumentException {

        OutputStream file = new FileOutputStream(new File("/usr/local/bin/grupaplus/output.pdf"));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, file);
        document.open();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(body.getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, inputStream, StandardCharsets.UTF_8, CUSTOM_FONT_PROVIDER);
        document.close();
        file.close();

    }

    public static void downloadPDF(HttpServletRequest request, HttpServletResponse response, String fileName)
            throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
        try {
            File file = new File("/usr/local/bin/grupaplus/output.pdf");
            FileInputStream fileInputStream = new FileInputStream(file);
            DataOutputStream outputStream = new DataOutputStream(response.getOutputStream());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, length);
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void displayPDF(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline");
        try {
            File file = new File("/usr/local/bin/grupaplus/output.pdf");
            FileInputStream fileInputStream = new FileInputStream(file);
            DataOutputStream outputStream = new DataOutputStream(response.getOutputStream());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, length);
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return;
    }
}