package NetT.HttpTest.ChatingRoom;

import java.util.*;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 14:05
 * <p>
 * Version: 0.0.1
 */
public class ClientMap<K, V> {
    // 创建一个线程安全的HashMap
    public Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());

    // 根据value来删除指定项
    public synchronized void removeByValue(Object value) {
        for (Object key : map.keySet()) {
            if (map.get(key) == value) {
                map.remove(key);
                break;
            }
        }
    }

    // 获取所有value组成的set集合
    public synchronized Set<V> values() {
        Set<V> result = new HashSet<V>();
        map.forEach((key, value) -> {
            result.add(value);
        });
        return result;
    }

    // 根据value查找key
    public synchronized K getKeyByValue(V val) {
        for (K key : map.keySet()) {
            if (map.get(key) == val || map.get(key).equals(val)) {
                return key;
            }
        }
        return null;
    }

    //实现put方法，该方法不允许value重复
    public synchronized V put(K key, V value) {
        for (V val : values()) {
            if (val.equals(value) && val.hashCode() == value.hashCode()) {
                throw new RuntimeException("MyMap实力不能有重复value");
            }
        }
        return map.put(key, value);
    }
}
