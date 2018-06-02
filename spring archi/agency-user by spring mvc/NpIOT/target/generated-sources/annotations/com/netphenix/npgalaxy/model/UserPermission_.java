package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Permission;
import com.netphenix.npgalaxy.model.VbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(UserPermission.class)
public class UserPermission_ { 

    public static volatile SingularAttribute<UserPermission, Permission> permissionId;
    public static volatile SingularAttribute<UserPermission, Integer> id;
    public static volatile SingularAttribute<UserPermission, VbUser> userId;
    public static volatile SingularAttribute<UserPermission, Boolean> status;

}