package com.noumenon.rxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        sample05();
    }

    private static void sample01() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");

            emitter.onComplete();
        });

        source.subscribe(System.out::println);
    }

    private static void sample02() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");

                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        source.subscribe(System.out::println);
    }

    private static void sample03() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");

                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(l -> l >= 5);

        filtered.subscribe(s -> System.out.println("Received: " + s));
    }

    private static void sample04() {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        source
                .map(String::length)
                .filter(l -> l >= 5)
                .subscribe(s -> System.out.println("Received: " + s));
    }

    private static void sample05() {
        List<String> list = List.of("Alpha", "Beta", "Gamma");
        Observable<String> source = Observable.fromIterable(list);
        source
                .map(String::length)
                .filter(l -> l >= 5)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
