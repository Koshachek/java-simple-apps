package Generics.Queue;

import Generics.Queue.QueueException.QueueEmptyException;
import Generics.Queue.QueueException.QueueFullException;

public interface IGen<T> {
    T get() throws QueueEmptyException;
    void put(T ch) throws QueueFullException;
}
