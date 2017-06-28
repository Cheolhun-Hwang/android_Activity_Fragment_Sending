package com.hch.qewqs.firstclassexamforclass;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment {
    private Dialog dialog;
    private View view;
    private TextView dialogTextview;
    private Button quitBTN;

    public DialogFragment() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false); //true 로 바꾸면??
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_dialog, null);
        dialog.setContentView(view);

        dialogTextview = (TextView) view.findViewById(R.id.Dialog_Textview);
        quitBTN = (Button) view.findViewById(R.id.Dialog_quit);

        //PresentativeCompany_info presentativeCompany_info = (PresentativeCompany_info) getArguments().getSerializable("PCINFO");
        //dialogTextview.setText(presentativeCompany_info.getAllData());

        dialogTextview.setText(((SecondActivity)getActivity()).getPresentativeCompany_info().getAllData());
        Log.d("DialogFragment", ((SecondActivity)getActivity()).getPresentativeCompany_info().getAllData());
        quitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return dialog;
    }

}
