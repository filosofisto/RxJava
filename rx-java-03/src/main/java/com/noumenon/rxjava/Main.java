package com.noumenon.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;

import static io.reactivex.rxjava3.core.Observable.just;

public class Main {

    public static void main(String[] args) {
        sample01();
    }

    private static void sample01() {
        Observable<String> source = just("Alpha", "Beta", "Gamma");
        source.subscribe(s -> System.out.println("Observer 1: " + s));
        source.subscribe(s -> System.out.println("Observer 2: " + s));
    }

    private static void sample02() {

    }
}
