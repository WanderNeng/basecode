package basecode.container.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Travelsal {

    public static void main(String[] args){
        HashMap<Integer,String> hm = new HashMap<Integer, String>();
        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(3,"c");
        hm.put(4,"d");
        //第一种：普通使用，二次取值
        System.out.println("\n通过Map.keySet遍历key和value：");
        for(int key:hm.keySet())
        {
            System.out.println("Key: "+key+" Value: "+hm.get(key));
        }
        //第二种
        System.out.println("\n通过Map.entrySet使用iterator遍历key和value: ");
        Iterator map1it=hm.entrySet().iterator();
        while(map1it.hasNext())
        {
            Map.Entry<Integer, String> entry=(Map.Entry<Integer, String>) map1it.next();
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
        //第三种：推荐，尤其是容量大时
        System.out.println("\n通过Map.entrySet遍历key和value");
        for(Map.Entry<Integer, String> entry: hm.entrySet())
        {
            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }

        //第四种
        System.out.println("\n通过Map.values()遍历所有的value，但不能遍历key");
        for(String v:hm.values())
        {
            System.out.println("The value is "+v);
        }
    }
}
