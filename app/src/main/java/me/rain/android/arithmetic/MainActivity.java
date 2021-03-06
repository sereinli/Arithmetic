package me.rain.android.arithmetic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.rain.android.arithmetic.factory.Animal;
import me.rain.android.arithmetic.factory.AnimalFactory;
import me.rain.android.arithmetic.strategy.Discount;
import me.rain.android.arithmetic.strategy.FullCut;
import me.rain.android.arithmetic.strategy.Price;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        SortUtils.selectSort(new int[] {3, 5, 4, 2, 6, 8});

        SortUtils.bubbleSort(new int[] {12, 90, 3, 5, 4, 41, 2, 6, 8});

        int[] arrays = new int[] {8, 6, 3, 10, 2, 20, 1};
        SortUtils.quickSort(arrays, 0, arrays.length - 1);

        int[] arraysMerge = new int[] {8, 300, 6, 1000, 3, 10, 999, 2, 20, 1, 467};
        int[] arraysMergeResult = new int[arraysMerge.length];
        SortUtils.mergeSort(arraysMerge, arraysMergeResult, 0, arraysMerge.length - 1);

        FIFO fifo = new FIFO(20);
        fifo.push(10);
        fifo.push(1);
        fifo.push(9);
        fifo.push(19);
        fifo.push(2030);
        fifo.push(456);
        fifo.push(5566);
        fifo.pop();
        fifo.push(888);
        fifo.push(763);
        fifo.push(223);
        fifo.push(567);
        fifo.push(890);
        fifo.peek();
        fifo.push(123);
        fifo.printStack();

        Animal animal1 = AnimalFactory.animal(1);
        animal1.sound();

        Animal animal2 = AnimalFactory.animal(2);
        animal2.sound();

        Animal animal3 = AnimalFactory.animal(3);
        animal3.sound();

        Discount discount = new Discount();
        Price price1 = new Price(discount);
        price1.finalPrice(1000, 0.6, 0);

        FullCut fullCut = new FullCut();
        Price price2 = new Price(fullCut);
        price2.finalPrice(1000, 300, 100);
    }
}
