package Generics.Simple.Generic;

public class NumericFns<T extends Number> {
    public T num;

    //передать конструктору ссылку на числовой объект
    public NumericFns(T num) {
        this.num = num;
    }

    //вернуть обратную величину
    public double reciprocal() {
        return 1 / num.doubleValue();
    }

    //вернуть дробную часть
    public double fraction() {
        return num.doubleValue() - num.intValue();
    }

    //проверить равенство абсолютных значений двух объектов
    public boolean absEqual(NumericFns<?> ob) {
        if (Math.abs(num.doubleValue()) ==
                Math.abs(ob.num.doubleValue())) return true;

        return false;
    }
}
