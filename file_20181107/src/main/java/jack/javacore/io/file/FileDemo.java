package jack.javacore.io.file;

import org.junit.Test;

import java.io.File;

/**
 * Theme:
 * <p> Java IO {@link File}
 *
 *
 * Description:
 *
 * {@link File}
 * An abstract representation of file and directory pathnames.
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-07
 */
public class FileDemo {


    @Test
    public void isFileOrDirectory() {

        // File#exists()
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx\\Collection.vsdx").exists());
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx\\Collection.vsdx1").exists());

        // File#isFile() return true when this abstract pathname is existing and is a file instead of a directory
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx\\Collection.vsdx").isFile());
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx\\Collection.vsdx1").isFile());

        // File#isDirectory() return true when this abstract pathname is existing and is a directory instead of a file
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx\\Collection.vsdx").isDirectory());
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsd").isDirectory());
        System.out.println(new File("C:\\Users\\D1M\\Desktop\\zzd_note\\Java core\\vsdx").isDirectory());
    }

}
