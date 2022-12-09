package HashRand;
import java.util.Random;
import java.util.Objects;
import java.util.ArrayList;

public class hashyrashy {

    public static void main(String[] args) {
        table traverse = new table("table", 200);
        long Begin;
        Random rand = new Random();
        String Ending = null;
        
        for(int i = 1; i <= 10000; i++) {
        	int val = rand.nextInt(1000000);
        	traverse.add("this will " + val, " move through " + val + " number of seconds!");	
        	if(i == 100) {
        		Ending = val + "";
        	}
        }
        
        Begin = System.currentTimeMillis();
        traverse.get(Ending);
        System.out.println("Searched through the hashtable in " + (System.currentTimeMillis() - Begin) + " milliseconds.");
    }

	public String hashtable;
	public String Key;
    final int Last;
    hashyrashy next; //move next
    hashyrashy(String key, String hashtable, int Last) {
        this.Key = key;
        this.hashtable = hashtable;
        this.Last = Last;
    }
}
 
class table {
    public ArrayList<hashyrashy> Integer;
    public int length;
    public int size;
 
    public table(String key, int hashCode) {
        Integer = new ArrayList<>();
        length = 10;
        size = 0;
 
        for (int i = 0; i < length; i++) {
            Integer.add(null);
        }
    }
 
    public int Size() {
    	return size;
    }
    
    public boolean Empty() {
    	return Size() == 0;
    }
     
      public int hasherdasher (String key) {
        return Objects.hashCode(key);
    }
   
    private int Index(String key)
    {
        int hashCode = hasherdasher(key);
        int index = hashCode % length;
        index = index < 0 ? index * -1 : index;
        return index;
    }
 
    public String remove(String key) {
        int lookInLeft = Index(key);
        int hash = hasherdasher(key);
        hashyrashy head = Integer.get(lookInLeft);
 
        hashyrashy prev = null;
        while (head != null) {
            if (head.Key.equals(key) && hash == head.Last) {
                break;
            }
 
            prev = head;
            head = head.next;
        }
 
        if (head == null) {
            return null;
        }
 
        if (prev != null) {
            prev.next = head.next;
        }
        else {
            Integer.set(lookInLeft, head.next);
        }
        return head.hashtable;
    }
 
    public String get(String key)
    {
        int lookInLeft = Index(key);
        int hash = hasherdasher(key);
       
        hashyrashy head = Integer.get(lookInLeft);
 
        while (head != null) {
            if (head.Key.equals(key) && head.Last == hash) {
                return head.hashtable;
            }
           
        }
        
        return null;
    }
 
    public void add(String key, String value) {
        int lookInLeft = Index(key);
        int hash = hasherdasher(key);
        hashyrashy head = Integer.get(lookInLeft);
 
        while (head != null) {
            if (head.Key.equals(key) && head.Last == hash) {
                head.hashtable = value;
                return;
           }
       }
   }
}