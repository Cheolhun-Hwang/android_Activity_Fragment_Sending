package com.hch.qewqs.firstclassexamforclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment {
    private View view;
    private TextView UpperTextview;

    public UpperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upper, container, false);
        UpperTextview = (TextView) view.findViewById(R.id.Upper_Textview);

        return view;
    }

    public void setUpperTextview(){
        UpperTextview.setText(((MainActivity)getActivity()).getUser_info().getAllData());
    }

}
