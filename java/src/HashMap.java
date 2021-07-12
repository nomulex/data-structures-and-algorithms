import com.sun.jdi.Value;

import static java.lang.Math.abs;

public class HashMap {

    static class Entry <K, V> {
        final K key;
        V value;
        Entry <K,V> next;
        public Entry (K key, V value , Entry <K,V> next){
            this.key = key;
            this.value = value;
            this.next =next;
        }

        public int getHashCode (){
            return  this.key.hashCode();
        }

    }

    public static class MyMap <K,V>  {
        private Entry <K,V> [] buckets;
        private static final int INITIAL_CAPACITY = 16;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private int size = 0;
        private int capacity = 0;

        public  MyMap (int capacity){
            buckets = new Entry[capacity];
            capacity = capacity;
        }

        public  MyMap (){
            this (INITIAL_CAPACITY);
        }

        private int getBucketSize (){
            return buckets.length;
        }

        private void capacityCheck (){
            if (size == DEFAULT_LOAD_FACTOR * capacity){
                Entry <K, V > [] old = buckets;
                capacity = capacity*2;
                size = 0;
                buckets = new Entry[capacity];
                for (int i =0; i < old.length ; i ++){
                    buckets[i] = old[i];
                    size++;
                }
            }
        }

        public void put (K key, V value){
            capacityCheck ();

            Entry <K,V> entry = new Entry<K,V>(key,value, null);
            int index = abs(entry.getHashCode() % getBucketSize());
            Entry <K, V> existing = buckets[index];

            if (existing == null){
                buckets[index] = entry;
                size++;
            }
            else { // we have a collision

                while (existing.next != null){
                    if (existing.key.equals(key)){
                        existing.value = value;
                        return;
                    }
                    existing = existing.next;
                }

                //end of linked list
                //check if last node has the key
                if(existing.key.equals(key)){
                    existing.value = value;
                }
                else{
                    existing.next = entry;
                    size++;
                }
            }
        }

        public V get (K key){
            int index = abs(key.hashCode() % getBucketSize());
            Entry <K,V> entry = buckets[index];
            while (entry != null ){
                if (entry.key.equals(key)){
                    return  entry.value;
                }
                entry = entry.next;
            }

            return null;
        }



    }

    public static void main (String[] args){
        MyMap<String, String> map = new MyMap<>();
        map.put("Kenya", "Nairobi");
        map.put ("Uganda", "Kampala");
        map.put ("Tanzania", "Dar");

        System.out.println(map.get("Uganda"));
        System.out.println(map.get("Kenya"));
        System.out.println(map.get("Tanzania"));

        map.put("Kenya", "Nakuru");
        System.out.println(map.get("Kenya"));

    }


}
