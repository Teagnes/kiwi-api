package com.kiwi.rbac.model.req;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleReq {

    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private List<Integer> permissionIds;

}
