package com.example.countermvp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.countermvp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CounterContacts.CounterView{
    ActivityMainBinding binding ;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initClickers();
        presenter = Injector.getPresenter();
        presenter.attachCounterView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachCounterView();
    }

    private void initClickers() {
        binding.plus.setOnClickListener(v->{
            presenter.increment();

        });


        binding.minus.setOnClickListener(v->{
            presenter.decrement();});
    }
    @Override
    public void updateCount(int count) {
        binding.txt.setText(String.valueOf(count));
        if (count!=15){binding.txt.setTextColor(getResources().getColor(R.color.black));}
        switch (count){
            case 10 :  Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show();
            break;
            case 15 : binding.txt.setTextColor(getResources().getColor(R.color.green));
            break;
        }
    }
}