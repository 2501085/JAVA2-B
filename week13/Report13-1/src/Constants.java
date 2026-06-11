import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface Constants {
    String path = ".\\week13\\Report13-1\\";
    String datafile = "student.xlsx";
    String excel = "studentOut.xlsx";
    String pdf = "studentOut.pdf";
    String[] titles = {"국어", "영어", "수학", "기술", "가정"};
    String[] sheets = {"1학년 A반", "1학년 B반"};

    default void error(String message) {
        System.out.println("ERROR - " + message);
        System.exit(-1);
    }

    default CellStyle getCellStyle(XSSFWorkbook workbook, IndexedColors color) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(color.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        return cellStyle;
    }
}