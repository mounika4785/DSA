import java.util.*;
class maxHeap {
    ArrayList<Integer>heap;
    public maxHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);
        int index = heap.size()-1;
        while(index > 0){
            int parent = (index - 1) / 2;
            if(heap.get(parent) < heap.get(index)){
                int temp = heap.get(parent);
                heap.set(parent , heap.get(index));
                heap.set(index , temp);
                index = parent;
            
            }
            else{
                break;
            }
            
        }
    }

    public void pop() {
        if(heap.isEmpty())
        return;
    if(heap.size()==1){
        heap.remove(0);
        return;
    }
     heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        while(true){
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if(left < heap.size() && heap.get(left) > heap.get(largest) )
            largest = left;
        
        if(right < heap.size() && heap.get(right) > heap.get(largest) )
            largest = right;
        
        if(largest == index)
         break;
        int temp = heap.get(index);
        heap.set(index , heap.get(largest));
        heap.set(largest , temp);
        index = largest; 
        }  
     }
    public int peek() {
        if (heap.isEmpty())
            return -1;
        return heap.get(0);
    }

    public int size() {
         return heap.size();
    }
    }
