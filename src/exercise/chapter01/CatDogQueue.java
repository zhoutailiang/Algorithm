package exercise.chapter01;

import utils.Utils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by zhoutailiang on 2017/3/12.
 */
public class CatDogQueue {
    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(new Dog(1));
        catDogQueue.add(new Dog(2));
        catDogQueue.add(new Dog(3));
        catDogQueue.add(new Dog(4));
        catDogQueue.add(new Dog(5));
        catDogQueue.add(new Cat(1));
        catDogQueue.add(new Cat(2));
        catDogQueue.add(new Cat(3));
        catDogQueue.add(new Cat(4));
        catDogQueue.add(new Cat(5));
        Utils.println("isEmpty= "+catDogQueue.isEmpty());
        Utils.println("isCatEmpty= "+catDogQueue.isCatEmpty());
        Utils.println("isDogEmpty= "+catDogQueue.isDogEmpty());
        catDogQueue.pollCat();
        Utils.println("isEmpty= " + catDogQueue.isEmpty());
        Utils.println("isCatEmpty= " + catDogQueue.isCatEmpty());
        Utils.println("isDogEmpty= " + catDogQueue.isDogEmpty());
        catDogQueue.pollDog();
        Utils.println("isEmpty= " + catDogQueue.isEmpty());
        Utils.println("isCatEmpty= " + catDogQueue.isCatEmpty());
        Utils.println("isDogEmpty= " + catDogQueue.isDogEmpty());

    }

    //implement
    private LinkedList mAllQueue;
    private long mCatCount;
    private long mDogCount;

    public CatDogQueue() {
        this.mAllQueue = new LinkedList();
    }

    public void add(Pet pet) {
        mAllQueue.add(pet);
        if (pet.getClass() == Cat.class) {
            mCatCount++;
        } else {
            mDogCount++;
        }
    }

    public void pollAll() {
        if (!isEmpty()) {
            for (Object obj : mAllQueue) {
                Pet pet = (Pet) obj;
                Utils.println(pet.getPetType());
            }
            mCatCount = 0;
            mDogCount = 0;
            mAllQueue.clear();
        }
    }

    public void pollDog() {
        if (mDogCount != 0) {
            Iterator iterator = mAllQueue.iterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                Pet pet = (Pet) obj;
                if (pet.getClass() == Dog.class) {
                    Utils.println(pet.getPetType());
                    mDogCount--;
                    mAllQueue.remove();
                }
            }

        }
    }

    public void pollCat() {
        if (!isCatEmpty()) {
            Iterator iterator = mAllQueue.iterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                Pet pet = (Pet) obj;
                if (pet.getClass() == Cat.class) {
                    Utils.println(pet.getPetType());
                    mCatCount--;
                    mAllQueue.remove();
                }
            }
        }
    }

    public boolean isEmpty() {
        return mAllQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return mDogCount == 0;
    }

    public boolean isCatEmpty() {
        return mCatCount == 0;
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog(int number) {
        super("dog " + number);
    }
}

class Cat extends Pet {
    public Cat(int number) {
        super("cat " + number);
    }
}