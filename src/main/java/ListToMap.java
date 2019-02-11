import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMap {
    //list转化为map
    public static <K, V> Map<K, V> listToMap(List<V> vList, String kName) {
        Map<K, V> map = new HashMap<K, V>();
        if (vList == null || kName == null || vList.size() == 0) {
            return map;
        }
        Field kField = getField(vList.get(0).getClass(), kName);
        for (V v : vList) {
            try {
                map.put((K) kField.get(v), v);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    //获取key对应的类型字段
    private static <V> Field getField(Class<V> clazz, String kName) {
        if (clazz == null || kName == null) {
            return null;
        }
        for (Field fieldElem : clazz.getDeclaredFields()) {
            fieldElem.setAccessible(true);
            if (fieldElem.getName().equals(kName)) {
                return fieldElem;
            }
        }
        return null;
    }
    //调用示例
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        List<Person> pList = new ArrayList<Person>();
        Person p1 = new Person(2, "taxuexing");
        pList.add(p1);
        Person p2 = new Person(3, "jikewang");
        pList.add(p2);
        Map<Integer, Person> map = ListToMap.listToMap(pList, "age");

        System.out.println(map.get(2).getUserName());
        System.out.println(map.get(3).getUserName());
    }
}

