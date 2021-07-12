import java.util.ArrayList;

public class HashTable <k,v>{

    public  class HashEntry <k,v> {
        public k key;
        public v value;
        public HashEntry next;
        public HashEntry(k key, v value){
            this.key =key;
            this.value = value;
        }
    }

    private ArrayList<HashEntry> buckets;
    private int size;
    private int slots;

    public HashTable (){
        buckets = new ArrayList<HashEntry>();
        slots = 5;
        for (int i =0; i <slots ; i++){
            buckets.add(null);
        }

    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    private int getIndex(k key){
        int hashCode = key.hashCode();
        int index = hashCode % this.slots;
        if (index<0){
            index = (index+slots) %slots;
        }

        return index;
    }

    public void insert(k key, v value){
        int index = getIndex(key);
        HashEntry<k, v> entry = new HashEntry(key,value);
        HashEntry <k,v> head = buckets.get(index);


        if(head ==null){
            buckets.add(index,entry);
        }
        else {
            while (head != null && head.next != null) {

                if (head.key.equals(key)){
                    head.value = value;
                    return;
                }

            }

            head.next = entry;
        }
        capacityCheck();
        size++;
        return;


    }

    public v get(k key){
        int index = getIndex(key);
        HashEntry<k,v> head = buckets.get(index);

        while (head !=null){
            if (head.key.equals(key)){
                return head.value;
            }
        }

        return null;

    }

    public void capacityCheck(){
        if (1.0*size/slots == 0.6){
            ArrayList<HashEntry> temp = this.buckets;
            buckets = new ArrayList<HashEntry>();
            slots = slots*2;

            for (int i = 0 ; i<slots; i++){
                if (slots < temp.size()){
                    buckets.add(i,temp.get(i));
                }
                else{
                    buckets.add(null);
                }
            }

        }
    }

    public void delete (k key){
        int index = getIndex(key);
        HashEntry<k,v> head = buckets.get(index);
        HashEntry<k,v> previous = null;

        while(head !=null){
            if(head.key.equals(key)){
                break;
            }
            previous =head;
            head = head.next;
        }

        if(head==null){
            return;
        }


        if (previous==null){
            head = head.next;
            buckets.add(index, head);
        }
        else{
            previous.next = head.next;
        }
        size--;
        return;

    }



}
