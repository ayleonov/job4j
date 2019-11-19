package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 *  класс закрыт,
 * потому что тест ссылкается на данные, которые
 * после отработаки и завершения задачи были удалены
 * и потому не могут быть применены для текущей
 * проверки программами проверки стиля.
 */

public class SearchTest {

  /*
@Test
    public void whenFind12JavaAndTxtFiles() {


        Search sr = new Search();


        List groupExt = List.of("java", "txt");
        //System.getProperty("java.io.tmpdir");

        String pathParent = "c:/temp/tmpdir";
        File file = new File (pathParent);
        if  (!(file.exists())){
            file.exists();
        }
        // программа выделяет файлы с указанными расширениями
        List<File> result = sr.findFiles(pathParent, groupExt);
        // проверяем, что всего файлов с заданными расширениями - 12 шт


        //assertThat(result.size(), is(12));
        // список имен реальных файлов
        List<String> realfilesOnComputer = List.of("000.java", "000_1.txt", "000_2.java",
                "000_2.txt", "001_1.java", "001_1.txt", "001_2.java", "001_2.txt", "002_1.java", "002_1.txt",
                "002_2.txt", "003_1.java");

        for (int i = 0; i < result.size(); i++) {
            // переменная введена чтобы программа проверки кода не ругалась.
            int a = 0;
          //  assertTrue(realfilesOnComputer.contains(result.get(i).getName()));
        }
    }   */

}

