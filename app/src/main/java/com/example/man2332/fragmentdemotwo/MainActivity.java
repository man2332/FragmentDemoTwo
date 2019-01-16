package com.example.man2332.fragmentdemotwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**********************
        //-this shows how to create a Bundle to put data into a Fragment
        Bundle args = new Bundle();
        args.putString("argText","example text ");
        args.putInt("argNumber", 123);
        //1. create a frag obj    2.put frag obj into host activity
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);
        //-this shows how to put a fragment obj into your activity
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        ***********************/

        //-below code does same thing as code above, except by encapsulating the code into
        // "newInstance" method its less confusing/messy code
        ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();


    }
}
//-new ExampleFragment()
//-new Bundle()
//-fragment.setArguments(Bundle)
//-getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
//-fragment's xml file     example_fragment.xml -> LinearLayout
//-fragment's container    activity_main.xml -> FrameLayout(R.id.container)
