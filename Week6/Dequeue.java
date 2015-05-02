//John Hewitt
//2/19/15
//Lab 5: Problem 18, Dequeue Class

package Week6;

public class Dequeue<T> extends ArrayBndQueue<T>{
   public Dequeue(){
      super();
   }
   
   public Dequeue(int maxSize){
      super(maxSize);
   }
   
   //new dequeue method, allows the user to enque at the beginning of the line, calls abq enqueue to beginning   
   
     public void enDequeue(T element){
      if(isFull())
         throw new QueueOverflowException("EnDequeue attempted on a full queue");
      else{
          rear += 1;
          
          for(int i = 0; i < numElements; i++){
               queue[rear - i] = queue[rear - i - 1]; 
          }
          queue[0] = element;
          numElements += 1;
      }
  }
   
   //new dequeue method, allows the user to deque the end of the line, calls abq dequeue to end 
    public T deDequeue(){
        if (isEmpty())
        throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        else
        {
              T toReturn = queue[rear];
              queue[rear] = null;
              rear -= 1;
              numElements -= 1;
              return toReturn;
      }
  }      
}   
