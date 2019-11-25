package invertedindex;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertedIndexTest {

    @Test
    void searchs1NOTs2() {
        InvertedIndex index = new InvertedIndex();

        File f = new File("textfiles");
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);

        index.print();

        List<File> list = index.searchs1NOTs2("Trees", "Deciduous");
        // Trees is in three files, Deciduous is in file2
        //System.out.println(list.toString());
        String expected = "[textfiles\\File1.txt, textfiles\\File3.txt]";
        assertEquals(expected, list.toString());

        list = index.searchs1NOTs2("Trees","cedar");
        expected = "[textfiles\\File1.txt, textfiles\\File2.txt]";
        assertEquals(expected, list.toString());

        list = index.searchs1NOTs2("Trees","ash");
        expected = "[textfiles\\File3.txt]";
        assertEquals(expected, list.toString());

        list = index.searchs1NOTs2("birch","wisteria");
        expected = "[textfiles\\File1.txt]";
        assertEquals(expected, list.toString());
    }
}