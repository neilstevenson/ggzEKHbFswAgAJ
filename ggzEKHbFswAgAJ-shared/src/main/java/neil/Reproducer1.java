package neil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Reproducer1 {
    
    private static final int MAX_MAP_ENTRY_COUNT = 10_000;
    // Make this large
    private static final int MAX_TREEMAP_SIZE = 50;
    // Make this small
    private static final int MAX_LIST_SIZE = 2;

    public static Object serialize(Map<Integer, TreeMap<Integer, Payload>> theMap) {
        Collection<Integer> sizes = new ArrayList<>();
        
        for (int i = 0 ; i < MAX_MAP_ENTRY_COUNT; i++) {
            
            TreeMap<Integer, Payload> value = makeValue();
            
            theMap.put(i, value);
            
            sizes.add(Integer.valueOf(i));
        }
        
        return sizes;
    }

    public static Object deserialize(Map<Integer, TreeMap<Integer, Payload>> theMap) {
        Collection<Integer> sizes = new ArrayList<>();
        
        for (int i = 0 ; i < MAX_MAP_ENTRY_COUNT; i++) {
            theMap.get(i);
            
            sizes.add(Integer.valueOf(i));
        }
        
        return sizes;
    }

    private static TreeMap<Integer, Payload> makeValue() {
        TreeMap<Integer, Payload> treeMap = new TreeMap<>();
        
        for (int i = 0 ; i < MAX_TREEMAP_SIZE; i++) {
            Payload payload = new Payload();

            List<Payload> fullList = new ArrayList<>();
            for (int j = 0 ; j < MAX_LIST_SIZE ; j++) {
                fullList.add(new Payload());
            }
            payload.setPayloads(fullList);
            
            treeMap.put(Integer.valueOf(i), payload);
        }
        
        return treeMap;
    }
     
}
