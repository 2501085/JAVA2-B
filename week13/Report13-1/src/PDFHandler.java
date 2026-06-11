import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDFHandler implements Constants {

    public void writePDF(String output, ArrayList<ClassRoom> classRooms) {
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(output));
            document.open();

            // 한글 폰트
            BaseFont baseFont = BaseFont.createFont(
                    "C:/Windows/Fonts/malgun.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
            Font titleFont  = new Font(baseFont, 14, Font.BOLD,   new BaseColor(255, 0, 0));
            Font headerFont = new Font(baseFont,  9, Font.BOLD);
            Font cellFont   = new Font(baseFont,  9, Font.NORMAL);
            Font avgFont    = new Font(baseFont,  9, Font.BOLD,   new BaseColor(0, 0, 255));

            // 전체 학생 리스트 (학년 석차용)
            ArrayList<Student> allStudents = new ArrayList<>();
            for (int i = 0; i < classRooms.size(); i++) {
                allStudents.addAll(classRooms.get(i).getStudents());
            }

            // 학년 평균
            float gradeTotal = 0;
            for (int i = 0; i < allStudents.size(); i++) {
                gradeTotal += allStudents.get(i).avg();
            }
            float gradeAvg = gradeTotal / allStudents.size();

            for (int r = 0; r < classRooms.size(); r++) {
                ClassRoom classRoom = classRooms.get(r);
                ArrayList<Student> students = classRoom.getStudents();

                // 반별 새 페이지 (첫 페이지 제외)
                if (r > 0) document.newPage();

                // 제목
                Paragraph title = new Paragraph(classRoom.getClassName() + " 성적표", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(10);
                document.add(title);

                // 반 평균 / 학년 평균
                Paragraph avgInfo = new Paragraph(
                        String.format("반 평균 : %06.2f          학년 평균 : %06.2f",
                                classRoom.getClassAvg(), gradeAvg), avgFont);
                avgInfo.setAlignment(Element.ALIGN_RIGHT);
                avgInfo.setSpacingAfter(8);
                document.add(avgInfo);

                // 표 (15컬럼)
                PdfPTable table = new PdfPTable(15);
                table.setWidthPercentage(100);
                table.setWidths(new float[]{
                        10, 8, 5,
                        7, 6,   // 국어점수, 국어학점
                        7, 6,   // 영어점수, 영어학점
                        7, 6,   // 수학점수, 수학학점
                        7, 6,   // 선택점수, 선택학점
                        7, 8,   // 합계, 평균
                        6, 6    // 반석차, 학년석차
                });

                // 헤더
                String[] headers = {
                        "학번", "이름", "성별",
                        "국어 점수", "국어 학점",
                        "영어 점수", "영어 학점",
                        "수학 점수", "수학 학점",
                        "선택 점수", "선택 학점",
                        "합계", "평균",
                        "반 석차", "학년 석차"
                };
                BaseColor yellow = new BaseColor(255, 255, 0);
                for (String h : headers) {
                    PdfPCell hCell = new PdfPCell(new Phrase(h, headerFont));
                    hCell.setBackgroundColor(yellow);
                    hCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    hCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    hCell.setPadding(3);
                    table.addCell(hCell);
                }

                // 데이터 행
                BaseColor pink = new BaseColor(255, 182, 193);
                BaseColor blue = new BaseColor(173, 216, 230);

                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    boolean isFemale = student.getGender().equals("여");
                    BaseColor rankColor = isFemale ? pink : blue;

                    int classRank  = classRoom.getRank(i);
                    int gradeRank  = classRoom.getGradeRank(i, allStudents);

                    String[] values = {
                            student.getStudentID(),
                            student.getName(),
                            student.getGender(),
                            String.valueOf(student.getSubject(0).getScore()),
                            student.getSubject(0).getGrade(),
                            String.valueOf(student.getSubject(1).getScore()),
                            student.getSubject(1).getGrade(),
                            String.valueOf(student.getSubject(2).getScore()),
                            student.getSubject(2).getGrade(),
                            String.valueOf(student.getSubject(3).getScore()),
                            student.getSubject(3).getGrade(),
                            String.valueOf(student.sum()),
                            String.format("%.2f", student.avg()),
                            String.valueOf(classRank),
                            String.valueOf(gradeRank)
                    };

                    for (int k = 0; k < values.length; k++) {
                        boolean isRankCol = (k == 13 || k == 14);
                        PdfPCell dCell = new PdfPCell(new Phrase(values[k], cellFont));
                        dCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        dCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        dCell.setPadding(3);
                        if (isRankCol) dCell.setBackgroundColor(rankColor);
                        table.addCell(dCell);
                    }
                }
                document.add(table);
            }

            document.close();
            System.out.println("PDF 파일 생성 성공: " + output);

        } catch (DocumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}