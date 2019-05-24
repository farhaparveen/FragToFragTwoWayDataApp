package com.example.fragtofragtwowaydataapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    FragOneListener listener;
    Button btnFragOne;
    EditText editFragOne;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        btnFragOne=view.findViewById(R.id.frag1Btn);
        editFragOne=view.findViewById(R.id.frag1EditTxt);
        btnFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editFragOne.getText().toString();
                listener.onButtonOfFragOne(s);
            }
        });
        setRetainInstance(true);
        return view;
    }

    interface FragOneListener
    {
        void onButtonOfFragOne(String str);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragOneListener)context;
    }
    void receiveFromActivityToFrag1ViaFrag2(String str)
    {
        editFragOne.setText(str);
    }


}
