package com.example.man2332.fragmentdemotwo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragment extends Fragment {
    //-using constants is recommended when using key values
    public static final String ARG_TEXT = "argText";
    public static final String ARG_NUMBER = "argNumber";

    private String text;
    private int number;

    //-encapsulate the logic in this method so it's easier to create this ExampleFragment obj
    //  from the outside-less messy code
    //-newInstance is just a name, can be named anything
    //-FACTORY METHOD
    public static ExampleFragment newInstance(String text, int number) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();//-create a bundle(args) and put values into that bundle
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);//put a bundle(args) into your fragment obj(fragment)
        return fragment;
    }//-when we call newInstance-we get back a ExampleFragment obj
    //-when a fragment is destroyed(user rotates screen)- then the default ctor is called
    //-the system ONLY uses a no arg ctor-so we can't use a custom ctor
    //  like  public ExampleFragment(String text, int number) to pass our values to the fragment
    //-the proper way to pass data into a fragment obj is with a bundle & pass it
    // to a factory method as shown above


    @Nullable//-inflater obj passed in to help inflate a view
    @Override//-container is where the view is the parent view where get's its layout parameters from
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.example_fragment, container, false);//-false cause fragment manager is responsible for attaching it to root
        //-with this view v, we can access it's child views with findViewById
        TextView textView = v.findViewById(R.id.text_view_fragment);

        //-if getArguments() is null- that means no args(extra data) were sent to our fragment(onCreateView())
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);
        }
        //-- both setArguments() & getArguments() methods belong to the Fragment class
        //-- it just gets/sets extra data that was passed to the fragment obj
        textView.setText(text + number);

        return v;
    }
    //1.inflate a fragment view using it's fragment xml
    //2.get & set the fragment's child views you want to use with findViewById
    //3.return the fragment view
}
//-import android.support.v4.app.Fragment;
//-extends Fragment
//-onCreateView(inflate, container, savedInstanceState)
//-getArguments() in onCreateView()
//-setArguments()
//-CONSTANTS    public static final

