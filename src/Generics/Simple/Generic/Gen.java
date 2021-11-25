package Generics.Simple.Generic;

public class Gen<T> {
   private T ob; // объявить объект типа Т

    // Передать конструктору ссылку на объект типа Т
   public Gen(T o) {
        ob = o;
    }

    // Вернуть объект оЬ из метода
   public T getOb() {
        return ob;
    }

    // Отобразить тип Т
    public void showType() {
        System.out.println("Тип Т - это " + ob.getClass().getName());
    }
}
