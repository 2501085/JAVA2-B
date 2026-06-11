import java.io.File;
import java.util.ArrayList;

public class Main implements Constants {
    public static void main(String[] args) {
        File file = new File(path + datafile);
        if (!file.exists()) {
            System.out.printf("%s 파일이 없습니다.\n", path + datafile);
            return;
        }

        ExcelHandler excelHandler = new ExcelHandler();
        ArrayList<ClassRoom> classRooms = excelHandler.readExcel(path + datafile);

        if (classRooms.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }

        PDFHandler pdfHandler = new PDFHandler();
        pdfHandler.writePDF(path + "studentOut.pdf", classRooms);
    }
}