package me.rain.android.arithmetic.factory;

/**
 * 简单工厂设计模式
 * Created by serein on 2017/2/9.
 */

public class AnimalFactory {

    public static Animal animal(int type) {
        Animal animal = null;

        if(type == 1) {
            animal = new Cat();
        }else if(type == 2) {
            animal = new Dog();
        }else {
            animal = new Sheep();
        }

        return animal;
    }
}
