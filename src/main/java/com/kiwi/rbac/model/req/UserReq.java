package com.kiwi.rbac.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
public class UserReq {


    @JsonProperty(value = "username")
    private String userName;

    @Getter
    @JsonProperty(value = "usercname")
    private String userCname;

    @Getter
    @JsonProperty(value = "pwd")
    private String pwd;

    @Getter
    private List<Integer> roles;

    public String getUserName(){
        return  userName.toLowerCase();
    }

}
