package com.hch.qewqs.firstclassexamforclass;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager = getSupportFragmentManager();
    private User_info user_info;
    private PresentativeCompany_info presentativeCompany_info;
    private Button upperBTN, underBTN, nextBTN;
    private UpperFragment upperFragment;
    private UnderFragment underFragment;

    private final static int SignalForNextButton = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        user_info = new User_info("황철훈", 111111, "010-4826-0178", "Honney");
        presentativeCompany_info = new PresentativeCompany_info("황철훈", 111111, "010-4826-0178", "HUGO BOSS");
        upperBTN = (Button) findViewById(R.id.Main_UpperButton);
        underBTN = (Button) findViewById(R.id.Main_UnderButton);
        nextBTN = (Button) findViewById(R.id.Main_NextButton);
        upperFragment = new UpperFragment();
        underFragment = new UnderFragment();
        manager.beginTransaction().replace(R.id.Upper_Framelayout, upperFragment).commit();
        manager.beginTransaction().replace(R.id.Under_Framelayout, underFragment).commit();

        setEventBTN();
    }

    public void setEventBTN(){
        upperBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              UpperFragment upperFragment = (UpperFragment) manager.findFragmentById(R.id.Upper_Framelayout);
              upperFragment.setUpperTextview();
            }
        });


        underBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnderFragment underFragmentforModify = underFragment; //Error 인 이유?
                UnderFragment underFragmentforModify = new UnderFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("PCINFO", presentativeCompany_info.getAllData());
                //underFragment.setArguments(bundle); //Error 인 이유
                underFragmentforModify.setArguments(bundle);
                manager.beginTransaction().replace(R.id.Under_Framelayout, underFragmentforModify).commit();
                underFragment = underFragmentforModify;
            }
        });
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("UINFO", user_info);
                intent.putExtra("PCINFO", presentativeCompany_info);
                startActivityForResult(intent, SignalForNextButton);
            }
        });
    }
    public PresentativeCompany_info getPresentativeCompany_info(){
        return this.presentativeCompany_info;
    }

    public User_info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_info user_info) {
        this.user_info = user_info;
    }

    public void setPresentativeCompany_info(PresentativeCompany_info presentativeCompany_info) {
        this.presentativeCompany_info = presentativeCompany_info;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case RESULT_OK:
                User_info user_infoforResult = (User_info) data.getSerializableExtra("UINFO");
                PresentativeCompany_info presentativeCompany_infoforResult = (PresentativeCompany_info) data.getSerializableExtra("PCINFO");
                Toast.makeText(getApplicationContext(), "유저명 : " + user_infoforResult.getName() +
                        "회사 대표명 : " + presentativeCompany_infoforResult.getName(), Toast.LENGTH_LONG).show();
                break;
            case RESULT_CANCELED:
                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
                break;

            default:
                Log.e("MainActivity", "onActivity Error, please check!");
                break;
        }
    }
}



