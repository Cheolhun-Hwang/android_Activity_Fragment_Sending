package com.hch.qewqs.firstclassexamforclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnderFragment extends Fragment {
    private View view;
    private TextView UnderTextview;


    public UnderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_under, container, false);
        UnderTextview = (TextView) view.findViewById(R.id.Under_Textview);

        setUnderTextview();

        return view;
    }

    public void setUnderTextview(){
        String Message;
        if(getArguments() != null){
            Message = getArguments().getString("PCINFO");
        }else{
            Message = "NONE";
        }

        UnderTextview.setText(Message);
    }

}
