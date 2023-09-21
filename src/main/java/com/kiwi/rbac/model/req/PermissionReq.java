package com.kiwi.rbac.model.req;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionReq {

    Integer permissionId;

    String permissionName;

    String permissionDesc;
}
