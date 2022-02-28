package mianshi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.ToIntFunction;

/**
 * Package: mianshi
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/3 22:42
 * <p>
 * Version: 0.0.1
 */
//如果提前知道网站内容可以通过solr完成，将网站加入分词器的词库，通过solr索引库进行搜索
//步知道可以逐行读取，通过map进行存储数据
public class Six {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\mianshi\\log.txt"));
            String str;
            List<String> list = new ArrayList<String>();
            while ((str = br.readLine()) != null) {
                String[] split = str.split(" ");
                //System.out.println(split[3]);
                list.add(split[3]);
            }

            //排序不能使用treemap
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                String url = list.get(i);
                if (map.keySet().contains(url)) {
                    int a = map.get(url);
                    a = a + 1;
                    map.put(url, a);
                } else {
                    map.put(url, 1);
                }
            }


            //进行排序
            List<Map.Entry<String, Integer>> infoIds = new ArrayList<>(map.entrySet());
            System.out.println(infoIds);
//            Collections.sort(infoIds, Comparator.comparing(Map.Entry::getValue));

//            Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
//                @Override
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return o1.getValue() > o2.getValue() ? 1 : o1.getValue() < o2.getValue() ? -1 : 0;
//                }
//            });
            Collections.sort(infoIds, Comparator.comparingInt(Map.Entry::getValue));
//            Collections.sort(infoIds, Comparator.comparingInt(value -> value.getValue()));

//            Collections.sort(infoIds, Comparator.comparingInt(new ToIntFunction <Map.Entry<String, Integer>>() {
//                @Override
//                public int applyAsInt(Map.Entry<String, Integer> value) {
//                    return value.getValue();
//                }
//            }));

//            Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
//                public int compare(Map.Entry<String, Integer> o1,
//                                   Map.Entry<String, Integer> o2) {
//                    return (o1.getValue() - o2.getValue());
//                }
//            });
            for (int i = infoIds.size() - 1; i > infoIds.size() - 4; i--) {
                Map.Entry<String, Integer> ent = infoIds.get(i);
                System.out.println(ent.getKey() + "=" + ent.getValue());
            }
        } finally {
            br.close();
        }

    }
}
