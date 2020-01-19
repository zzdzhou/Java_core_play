package jack.tools.exportenterpriseuser.exception;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-25
 */
public class FileException extends Exception {

    public static final String FILE_NOT_EXISTS = "%s 不是一个文件或不存在";
    public static final String FORMAT_NOT_MATCH = "%s 不是 .xlsx 格式";

    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }
}
