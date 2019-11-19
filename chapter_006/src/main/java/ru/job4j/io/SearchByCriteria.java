package ru.job4j.io;
import ru.job4j.io.Search;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
public class SearchByCriteria {
    String parent;
    String ask;
    Queue<File> data = new LinkedList();
    List<String> templates = new ArrayList();
    List<File> result = new ArrayList<>();
    public SearchByCriteria(String parent, String ask) {
        this.parent = parent;
        this.ask = ask;
    }
    public void start() {
        scanfolder();
    }
    public List<File> scanfolder() {
        File filePar = new File(parent);
        data.offer(filePar);
        while (!data.isEmpty()) {
            File el = data.poll();
            for (File file : el.listFiles()) {
                if (file.isDirectory()) {
                    data.offer(file);
                } else {
                    check(file);
                }
            }
        }
        return result;
    }
    private void check(File file) {
        if (file.getName().indexOf(ask) != -1) {
            result.add(file);
        } else if (containsWord(ask, file.getName())) {
            result.add(file);
        }
    }
    public static boolean containsWord(String text, String word) {
        String regex = String.format(text, Pattern.quote(word));
        return text.matches(regex);
    }
}
