package Generics.Queue.QueueException;

public class QueueEmptyException extends Exception {
    @Override
    public String toString() {
        return "Очередь пуста";
    }
}
