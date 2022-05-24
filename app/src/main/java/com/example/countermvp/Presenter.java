package com.example.countermvp;

public class Presenter implements CounterContacts.CounterPresenter {
    CounterModel counterModel = new CounterModel();
CounterContacts.CounterView counterView;
    @Override
    public void increment() {
counterModel.increment();
counterView.updateCount(counterModel.getCounter());
    }

    @Override
    public void decrement() {
counterModel.decrement();
counterView.updateCount(counterModel.getCounter());
    }

    @Override
    public void attachCounterView(CounterContacts.CounterView counterView) {
        this.counterView = counterView;
    }

    @Override
    public void detachCounterView() {
        this.counterView = null;
    }
}
