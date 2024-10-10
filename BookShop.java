package bcit.ca.comp2522.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BookShop
{
    private final String name;
    private final HashMap<String, Novel> novelHashMap;

    public BookShop(final String name, final List<Novel> novels)
    {
        this.name = name;
        this.novelHashMap = new HashMap<>();
        populateHashMap(novelHashMap, novels);
    }

    private void populateHashMap(final HashMap<String, Novel> novelHashMap, final List<Novel> novels)
    {
        for(Novel novel : novels)
        {
            novelHashMap.put(novel.getTitle(), novel);
        }
    }

    public void printHashMap()
    {
        for(HashMap.Entry<String, Novel> novel : novelHashMap.entrySet())
        {
            System.out.println(novel.getKey());
        }
    }

    public void removeNovels()
    {
        List<String> keysToRemove = new ArrayList<>();
        for(String key : novelHashMap.keySet())
        {
            if(key.toLowerCase().contains("the"))
            {
                keysToRemove.add(key);
            }
        }
        for(String key : keysToRemove)
        {
            novelHashMap.remove(key);
        }
    }

    public void sortAndPrintNovels()
    {
        Set<String> keySet = novelHashMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);

        for(String key : keyList)
        {
            System.out.println(novelHashMap.get(key));
        }
    }

    public static void main(final String[] args)
    {
        BookStore bookstore = new BookStore("Classic Novels Collection");
        // Retrieves the list from the BookStore
        List<Novel> novels = bookstore.novels;

        BookShop bookShop = new BookShop("Classic Novels Collection", novels);

        System.out.println("All Titles in HashMap:");
        bookShop.printHashMap();
        System.out.println("\nRemoving titles containing 'the'...");
        bookShop.removeNovels();
        System.out.println("\nSorted Titles (without 'the'):");
        bookShop.sortAndPrintNovels();
    }
}