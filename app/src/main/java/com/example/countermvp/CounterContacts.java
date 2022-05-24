package com.example.countermvp;

public class CounterContacts {
    interface CounterPresenter{
void increment();

void decrement();

void attachCounterView(CounterView view);
void detachCounterView();
    }
    interface CounterView{

        void updateCount(int count);
    }
}
