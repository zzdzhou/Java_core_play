package jack.tools.exportenterpriseuser;

import jack.tools.exportenterpriseuser.exception.FileException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-25
 */
public class DateTimeTransform {

    // Thu Jul 26 2018 05:50:27 GMT+0000 (UTC)
    public static final DateTimeFormatter SERVER_DATE_FORMAT = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
    // 2019-01-25 12:39:00
    public static final DateTimeFormatter DEST_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    public static void main(String[] args) {
        try {
            readAndTransformFromXlsx("C:\\Users\\D1M\\Desktop\\daily\\20190124\\SA-Enterprise_user binding.xlsx");
        } catch (FileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String transform(String date, DateTimeFormatter sourceDateFormat, DateTimeFormatter destDateFormat) {
        date = date.replaceAll("GMT\\+0000 \\(UTC\\)", "").trim();
//        System.out.println(date);
        LocalDateTime parse = LocalDateTime.parse(date, sourceDateFormat);

        // todo handle tomezone
//        OffsetDateTime utc = OffsetDateTime.of(parse, ZoneOffset.UTC);
        parse = parse.plusHours(8);
        return parse.format(destDateFormat);
    }

    public static void readAndTransformFromXlsx(String filepath) throws FileException, IOException {
        File file = new File(filepath);
        if (!file.isFile()) {
            throw new FileException(String.format(FileException.FILE_NOT_EXISTS, filepath));
        }

        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row: sheet) {
                Cell cell = row.getCell(1);
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        try {
                            String transform = transform(cell.getStringCellValue(), SERVER_DATE_FORMAT, DEST_DATE_FORMAT);
                            System.out.println(transform);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("transform error");
                        }
                }
            }
        } catch (InvalidFormatException e) {
            throw new FileException(String.format(FileException.FORMAT_NOT_MATCH, filepath));
        }
    }

}
