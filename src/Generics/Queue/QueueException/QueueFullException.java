package Generics.Queue.QueueException;

public class QueueFullException extends Exception {
    int size;

    public QueueFullException(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "Очередь заполнена. Максимальный размер очереди: " + size;
    }
}
