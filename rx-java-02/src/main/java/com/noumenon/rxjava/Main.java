package com.noumenon.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;

import static io.reactivex.rxjava3.core.Observable.just;

public class Main {

    public static void main(String[] args) {
        sample02();
    }

    private static void sample01() {
        Observable<String> source = just("Alpha", "Beta", "Gamma");
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        };

        source
                .map(String::length)
                .filter(l -> l >= 5)
                .subscribe(observer);
    }

    private static void sample02() {
        Observable<String> source = just("Alpha", "Beta", "Gamma");
        source
                .map(String::length)
                .filter(l -> l >= 5)
                .subscribe(l -> System.out.println(l), Throwable::printStackTrace, () -> System.out.println("Done!"));
    }
}
