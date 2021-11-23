package Generics.Queue;

import Generics.Queue.QueueException.QueueEmptyException;
import Generics.Queue.QueueException.QueueFullException;

public class GenQueue<T> implements IGen<T> {
    private T q[]; //массив для хранения очереди
    private int putloc, getloc; //индексы вставки и извлечения элементов очереди

    public GenQueue(T[] qRef) {
        q = qRef;
        putloc = getloc = 0;
    }

    @Override
    public T get() throws QueueEmptyException {
        if(getloc == putloc){
            throw new QueueEmptyException();
        }
        return q[getloc++];
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if(putloc == q.length-1){
            throw new QueueFullException(q.length);
        }
        q[putloc++] = obj;
    }
}
