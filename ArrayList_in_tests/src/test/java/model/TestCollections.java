package model;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.LowerCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestCollections {

    List<HeavyBox> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(List.of(
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(3, 3, 3, 4),
                new HeavyBox(2, 6, 5, 3),
                new HeavyBox(2, 3, 4, 7),
                new HeavyBox(1, 3, 3, 4),
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(1, 1, 1, 1)
        ));
    }

    // 1 (done)--------------------------------
    @Test
    //@Disabled
    void testPrintList() {
        list.forEach(System.out::println);
    }

    // 2 (done)--------------------------------
    @Test
    //@Disabled
    void testChangeWeightOfFirstByOne() {
        //Изменить (увеличить) вес первой коробки на 1.
        list.get(0).setWeight(list.get(0).getWeight() + 1);
//        int weight = list.get(0).getWeight();
//        list.get(0).setWeight(weight+1);
        assertEquals(new HeavyBox(1, 2, 3, 5), list.get(0));
    }

    // 3 (done)--------------------------------
    @Test
    //@Disabled
    void testDeleteLast() {
        //Удалить предпоследнюю коробку.
        list.forEach(System.out::println);
        System.out.println("---removed-----");
        list.remove(list.size() - 2);
        list.forEach(System.out::println);

        assertEquals(6, list.size());
        assertEquals(new HeavyBox(1, 2, 3, 4), list.get(0));
        assertEquals(new HeavyBox(1, 3, 3, 4), list.get(list.size() - 2));
    }

    // 4 (done)--------------------------------
    @Test
    //@Disabled
    void testConvertToArray() {
        //Получить массив содержащий коробки из коллекции тремя способами и вывести на консоль.
        //variant#1
//        HeavyBox[] arr = new HeavyBox[list.size()];
//        list.toArray(arr);
//        for(HeavyBox item: arr){
//            System.out.println(item);
//        }
        //variant#2
//        HeavyBox [] arr = new HeavyBox[7];
//        list.toArray(arr);
//        for (HeavyBox item:arr) {
//            System.out.println(item);
//        }
        //variant#3 <masters version>
//        HeavyBox [] arr = list.toArray(new HeavyBox[0]);
//        for (HeavyBox item:arr) {
//            System.out.println(item);
//        }
        //variant#4 <masters version>
        HeavyBox[] arr = list.toArray(HeavyBox[]::new);
        assertArrayEquals(new HeavyBox[]{
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(3, 3, 3, 4),
                new HeavyBox(2, 6, 5, 3),
                new HeavyBox(2, 3, 4, 7),
                new HeavyBox(1, 3, 3, 4),
                new HeavyBox(1, 2, 3, 4),
                new HeavyBox(1, 1, 1, 1)
        }, arr);
    }

    // 5 (done)--------------------------------
    @Test
    //@Disabled
    void testDeleteBoxesByWeight() {
        // Удалить все коробки, которые весят 4
        //variant#1
//        for (int i = list.size()-1; i >= 0 ; i--) {
//            if (list.get(i).getWeight() == 4){
//                list.remove(i);
//            }
//        }
        //variant#2
//        for (Iterator<HeavyBox> iterator = list.iterator(); iterator.hasNext(); ) {
//            HeavyBox box =  iterator.next();
//            if (box.getWeight()==4){
//                iterator.remove();
//            }
//        }
        //variant#3 <masters version>
        list.removeIf(x -> x.getWeight() == 4);
        list.forEach(System.out::println);
        assertEquals(3, list.size());
    }

    // 6 (done)--------------------------------
    @Test
    //@Disabled
    void testSortBoxesByWeight() {
        // отсортировать коробки по возрастанию веса. При одинаковом весе - по возрастанию объема
        //variant#1
        //list.sort(null);
        //variant#2
        list.sort(Comparator.comparingInt(HeavyBox::getWeight).
                thenComparingDouble(HeavyBox::getVolume));
        list.forEach(System.out::println);
        assertEquals(new HeavyBox(1, 1, 1, 1), list.get(0));
        assertEquals(new HeavyBox(2, 3, 4, 7), list.get(6));
        assertEquals(new HeavyBox(1, 2, 3, 4), list.get(3));
        assertEquals(new HeavyBox(1, 3, 3, 4), list.get(4));
    }

    // 7 (done)--------------------------------
    @Test
    //@Disabled
    void testClearList() {
        //Удалить все коробки.
        list.clear();
        assertTrue(list.isEmpty());
    }

    // 8 (done)--------------------------------

    @SneakyThrows
    @Test
    //@Disabled
    void testReadAllLinesFromFileToList() {
        // Прочитать все строки в коллекцию
        //variant#1
        //List<String> lines = reader.lines().toList();
        //variant#2
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        assertEquals(19, lines.size());
        assertEquals("", lines.get(8));
    }

    // 9 (done)--------------------------------
    @Test
    //@Disabled
    void testReadAllWordsFromFileToList() throws IOException {
        // Прочитать все строки, разбить на слова и записать в коллекцию
        List<String> words = readAllWordsFromFileToList();
        assertEquals(257, words.size());
    }

    @SneakyThrows
    List<String> readAllWordsFromFileToList() {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            if(line.isEmpty()){
                continue;
            }
            lines.addAll(Arrays.asList(line.split(REGEXP)));
        }
        return lines;
    }

    // 10 (done)-------------------------------
    @Test
    //@Disabled
    void testFindLongestWord() {
        // Найти самое длинное слово
        assertEquals("conversations", findLongestWord());
    }

    private String findLongestWord() {
        List<String> wordsList = readAllWordsFromFileToList();
        String longestWord = "";
        for (String word:wordsList) {
            if(word.length() > longestWord.length()){
                longestWord = word;
            }
        }
        return longestWord;
    }

    // 11 (done)-------------------------------
    @Test
    //@Disabled
    void testAllWordsByAlphabetWithoutRepeat() {
        // Получить список всех слов по алфавиту без повторов в нижнем регистре
        List<String> result = readAllWordsFromFileToList();
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).toLowerCase());
        }
        Set<String> set = new TreeSet<>(result);
        result = new ArrayList<>(set);

        assertEquals("alice", result.get(5));
        assertEquals("all", result.get(6));
        assertEquals("without", result.get(134));
        assertEquals(138, result.size());
    }

    // 12 (done)-------------------------------
    @Test
    //@Disabled
    void testFindMostFrequentWord() {
        // Найти самое часто вcтречающееся слово
        assertEquals("the", mostFrequentWord());
    }

    private String mostFrequentWord() {
        List<String> words = readAllWordsFromFileToList();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        return Collections
                .max(map.entrySet(), Map.Entry.comparingByValue()) //find max, and compare by value;
                .getKey(); // get most frequent by key;
    }

    // 13 (done)-------------------------------
    @Test
    //@Disabled
    void testFindWordsByLengthInAlphabetOrder() throws IOException {
        //  Получить список слов, длиной не более 5 символов, переведенных в нижний регистр,
        //  в порядке алфавита, без повторов

        List<String> strings = readAllWordsFromFileToList();
        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, strings.get(i).toLowerCase());
        }
        Set<String> set = new TreeSet<>(strings);
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            if(next.length() > 5){
                iterator.remove();
            }
        }
        strings = new ArrayList<>(set);
        //Version : classroom
//        List<String> words = readAllWordsFromFileToList();
//        words.replaceAll(String::toLowerCase);
//        var set = new TreeSet<>(words);
//        List<String> strings = new ArrayList<>();
//        for (String s : set) {
//            if(s.length() <= 5) strings.add(s);
//        }

        assertEquals(94, strings.size());
        assertEquals("a", strings.get(0));
        assertEquals("alice", strings.get(2));
        assertEquals("would", strings.get(strings.size() - 1));
    }


    static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @BeforeEach
    public void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("Text.txt"), StandardCharsets.UTF_8);
    }

    @AfterEach
    public void closeBufferedReader() throws IOException {
        reader.close();
    }
}
