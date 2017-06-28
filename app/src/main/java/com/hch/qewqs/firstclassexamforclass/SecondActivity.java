package com.hch.qewqs.firstclassexamforclass;

import android.app.*;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {
    private Serializable user_info;
    private PresentativeCompany_info presentativeCompany_info;
    private TextView upperTextview, underTextview;
    private Button saveBTN, cancelBTN, dialogBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();

        user_info = getIntent().getSerializableExtra("UINFO");
        presentativeCompany_info = (PresentativeCompany_info) getIntent().getSerializableExtra("PCINFO");

        if(user_info == null || presentativeCompany_info == null){
            Log.e("SecondActivity", "user_info or presentativeCompany_info is Error! please check!!");
            upperTextview.setText("NONE");
            underTextview.setText("NONE");
        }else{
            upperTextview.setText(((User_info)user_info).getAllData());
            underTextview.setText(presentativeCompany_info.getAllData());
        }
    }

    public void init(){
        upperTextview = (TextView) findViewById(R.id.secondMain_UpperTextview);
        underTextview = (TextView) findViewById(R.id.secondMain_UnderTextview);
        saveBTN = (Button) findViewById(R.id.secondMain_save);
        cancelBTN = (Button) findViewById(R.id.secondMain_cancel);
        dialogBTN = (Button) findViewById(R.id.secondMain_Dialog);
        setEvent();
    }
    public void setEvent(){
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("UINFO", ((User_info)user_info));
                intent.putExtra("PCINFO", presentativeCompany_info);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        cancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        dialogBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                Bundle bundle = new Bundle();
                //bundle.putSerializable("PCINFO", presentativeCompany_info);
                DialogFragment dialogFragment = new DialogFragment();
                //dialogFragment.setArguments(bundle);
                dialogFragment.show(manager, "DialogFragments");
            }
        });
    }

    public PresentativeCompany_info getPresentativeCompany_info(){
        return this.presentativeCompany_info;
    }
}
