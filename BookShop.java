package bcit.ca.comp2522.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class BookShop
{
    private final String name;
    private final Map<String, Novel> novelHashMap;

    public BookShop(final String name, final List<Novel> novels)
    {
        this.name = name;
        this.novelHashMap = new HashMap<>();
        populateHashMap(novelHashMap, novels);
    }

    private void populateHashMap(final Map<String, Novel> novelHashMap, final List<Novel> novels)
    {
        for(final Novel novel : novels)
        {
            novelHashMap.put(novel.getTitle(), novel);
        }
    }

    public void printHashMap()
    {
        for(final HashMap.Entry<String, Novel> novel : novelHashMap.entrySet())
        {
            System.out.println(novel.getKey());
        }
    }

    public void removeNovels()
    {
        final List<String> keysToRemove;

        keysToRemove = new ArrayList<>();

        for(final String key : novelHashMap.keySet())
        {
            if(key.toLowerCase().contains("the"))
            {
                keysToRemove.add(key);
            }
        }

        for(final String key : keysToRemove)
        {
            novelHashMap.remove(key);
        }
    }

    public void sortAndPrintNovels()
    {
        final Set<String> keySet;
        final List<String> keyList;

        keySet = novelHashMap.keySet();
        keyList = new ArrayList<>(keySet);

        Collections.sort(keyList);

        for(final String key : keyList)
        {
            System.out.println(novelHashMap.get(key));
        }
    }

    public static void main(final String[] args)
    {
        final BookStore bookstore;
        final List<Novel> novels;
        final BookShop bookShop;

        bookstore = new BookStore("Classic Novels Collection");
        novels = bookstore.novels;
        bookShop = new BookShop("Classic Novels Collection", novels);

        System.out.println("All Titles in HashMap:");
        bookShop.printHashMap();
        System.out.println("\nRemoving titles containing 'the'...");
        bookShop.removeNovels();
        System.out.println("\nSorted Titles (without 'the'):");
        bookShop.sortAndPrintNovels();
    }
}