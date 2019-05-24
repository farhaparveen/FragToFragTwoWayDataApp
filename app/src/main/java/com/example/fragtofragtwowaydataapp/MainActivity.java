package com.example.fragtofragtwowaydataapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.FragOneListener,Fragment2.FragTwoListener {

    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getSupportFragmentManager();
        fragment1 = (Fragment1) manager.findFragmentByTag("FragOneTag");

        if(fragment1==null)

        {
            fragment1=new Fragment1();
            transaction=manager.beginTransaction();
            transaction.add(R.id.frag_container1,fragment1,"FragOneTag");
            transaction.commit();
        }
        fragment2 = (Fragment2) manager.findFragmentByTag("FragTwoTag");

if(fragment2==null) {
    fragment2 = new Fragment2();
    transaction=manager.beginTransaction();
    transaction.add(R.id.frag_container2, fragment2, "FragTwoTag");
    transaction.commit();
}
    }

    @Override
    public void onButtonOfFragOne(String s) {
fragment2.receiveFromActivityToFrag2ViaFrag1(s);
    }

    @Override
    public void onButtonOfFragTwo(String str) {
        fragment1.receiveFromActivityToFrag1ViaFrag2(str);
    }
}
