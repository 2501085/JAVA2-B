import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;

public class ExcelHandler implements Constants {

    public ArrayList<ClassRoom> readExcel(String filePath) {
        ArrayList<ClassRoom> classRooms = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);

            for (int s = 0; s < sheets.length; s++) {
                XSSFSheet sheet = workbook.getSheet(sheets[s]);
                if (sheet == null) {
                    System.out.println("시트 없음: " + sheets[s]);
                    continue;
                }
                ArrayList<Student> students = new ArrayList<>();
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    XSSFRow row = sheet.getRow(i);
                    if (row == null) continue;
                    String studentID = readData(row, 0);
                    String name = readData(row, 1);
                    String gender = readData(row, 2);
                    Student student = new Student(name, gender);
                    student.setStudentID(studentID);
                    for (int j = 0; j < student.getSubjects().size(); j++) {
                        student.getSubject(j).setScore(
                                Integer.parseInt(readData(row, j + 3)));
                    }
                    students.add(student);
                }
                classRooms.add(new ClassRoom(sheets[s], students));
                System.out.printf("%s: %d명 읽었습니다\n", sheets[s], students.size());
            }
            bufferedInputStream.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return classRooms;
    }

    private String readData(XSSFRow row, int columnIndex) {
        XSSFCell cell = row.getCell(columnIndex);
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case FORMULA: value = cell.getCellFormula(); break;
                case NUMERIC: value = ((int) cell.getNumericCellValue()) + ""; break;
                case STRING:  value = cell.getStringCellValue(); break;
                case BLANK:   value = ""; break;
                default:      value = ""; break;
            }
        }
        return value;
    }
}