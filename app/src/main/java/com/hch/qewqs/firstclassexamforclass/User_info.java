package com.hch.qewqs.firstclassexamforclass;

import java.io.Serializable;

/**
 * Created by qewqs on 2017-06-27.
 */

public class User_info extends Personal_info  implements Serializable {
    private String Nickname;

    public User_info(){
        super();
        this.Nickname = "";
    }

    public User_info(String nickname){
        super();
        this.Nickname = nickname;
    }

    public User_info(String name, int pid, String phone, String nickname){
        super(name, pid, phone);
        this.Nickname = nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getNickname() {
        return Nickname;
    }

    @Override
    public String getAllData(){
        String parentData = super.getAllData();
        return parentData + "\n" + this.Nickname;
    }
}
