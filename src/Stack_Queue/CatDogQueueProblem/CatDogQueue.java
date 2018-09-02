package Stack_Queue.CatDogQueueProblem;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;
    public CatDogQueue(){
        this.dogQueue = new LinkedList<PetEnterQueue>();
        this.catQueue = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }
    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQueue.add(new PetEnterQueue(pet, this.count++));
        }
        else if(pet.getPetType().equals("cat")){
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        }
        else{
            throw new RuntimeException("An error!");
        }
    }
    public Pet pollAll(){
        if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            if(this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()){
                return this.dogQueue.poll().getPet();
            }
            else {
                return this.catQueue.poll().getPet();
            }
        }
        else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }
        else if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        }
        else{
            throw new RuntimeException("An error occurs, no pet in the queue!");
        }
    }
    public Dog pollDog(){
        if(!this.dogQueue.isEmpty()){
            return (Dog)this.dogQueue.poll().getPet();
        }
        else{
            throw new RuntimeException("The dog queue is empty!");
        }
    }
    public Cat pollCat(){
        if(!this.catQueue.isEmpty()){
            return (Cat)this.catQueue.poll().getPet();
        }
        else{
            throw new RuntimeException("The cat queue is empty!");
        }
    }
    public boolean isEmpty(){
        //因为true表示为空，该操作当两个队列都为空时才会返回空，所以需要用&&
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }
    public boolean isDogQueueEmpty(){
        return this.dogQueue.isEmpty();
    }
    public boolean isCatQueueEmpty(){
        return this.catQueue.isEmpty();
    }
}
