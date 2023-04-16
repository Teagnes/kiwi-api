package com.kiwi.rbac.model.res;

import com.kiwi.rbac.model.UserEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserInfoRes {

    private UserEntity user;

    private String token;


}
