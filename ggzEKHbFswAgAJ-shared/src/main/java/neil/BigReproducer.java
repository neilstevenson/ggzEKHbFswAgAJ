package neil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BigReproducer {

    public static Object run(Map<Key, TreeMap<Long, AnObject>> theMap) {
        int count = 0;
        Collection<Integer> sizes = new ArrayList<>();
        
        for (int i = 0 ; i < 100 ; i++) {
            for (int j = 0 ; j < 100 ; j++) {
                count++;
                
                Key key = makeKey(i, j, count);
                TreeMap<Long, AnObject> value = makeValue(i, j, count);
                
                theMap.put(key, value);
                
                TreeMap<Long, AnObject> value2 = theMap.get(key);
                
                sizes.add(Integer.valueOf(value2.size()));
            }
        }
        
        return sizes;
    }

    private static Key makeKey(int i, int j, long count) {
        Key key = new Key();
        
        key.setField0(String.valueOf(i));
        key.setField1(String.valueOf(j));
        key.setField2(count);
        key.setField3(Enum0.ONE);

        return key;
    }

    private static TreeMap<Long, AnObject> makeValue(int i, int j, long count) {
        TreeMap<Long, AnObject> treeMap = new TreeMap<>();
        
        for (int k=0 ; k < 5 ; k++) {
            treeMap.put(Long.valueOf(k), makeAnObjectOuter(i, j, k, count));
        }
        
        return treeMap;
    }

    // Populated sub-list
    private static AnObject makeAnObjectOuter(int i, int j, int k, long count) {
        AnObject anObject = makeAnObjectShared(i, j, k, count);

        List<AnObject> fullList = new ArrayList<>();
        for (int l = 0 ; l < 5 ; l++) {
            fullList.add(makeAnObjectInner(i, j, k, count));
        }
        anObject.setAnObjectField4(fullList);

        return anObject;
    }
    
    // Empty sub-list
    private static AnObject makeAnObjectInner(int i, int j, int k, long count) {
        AnObject anObject = makeAnObjectShared(i, j, k, count);
        
        List<AnObject> emptyList = Collections.emptyList();
        anObject.setAnObjectField4(emptyList);
        
        return anObject;
    }
 
    // Null sub-list, for caller to set
    private static AnObject makeAnObjectShared(int i, int j, int k, long count) {
        AnObject anObject = new AnObject();
        return anObject;
    }

}
