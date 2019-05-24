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


public class Fragment2 extends Fragment {
    Button btnFragTwo;
    EditText editFragTwo;
    FragTwoListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment2, container, false);
        editFragTwo=view.findViewById(R.id.frag2EditTxt);
        btnFragTwo=view.findViewById(R.id.frag2Btn);

        btnFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editFragTwo.getText().toString();
                listener.onButtonOfFragTwo(s);
            }
        });


        setRetainInstance(true);
        return view;
    }
    void receiveFromActivityToFrag2ViaFrag1(String str)
    {
        editFragTwo.setText(str);
    }
    interface FragTwoListener
    {
        void onButtonOfFragTwo(String str);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragTwoListener)context;
    }





}
