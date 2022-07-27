package com.example.jhkim20220707;

import android.util.Log;

import org.junit.Test;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class ExampleJavaUnitTest {

    @Test
    public void reactive_programming() {
        PublishSubject<Integer> items = PublishSubject.create();
        items.onNext(1);
        items.onNext(2);
        items.onNext(3);
        items.onNext(4);
        //짝수만 출력
        items.filter(item -> item % 2 == 0).subscribe(
                System.out::println
        );
        items.onNext(5);
        items.onNext(6);
        items.onComplete();
        items.onError(new Throwable());
        items.onNext(7);
        items.onNext(8);
    }


}
