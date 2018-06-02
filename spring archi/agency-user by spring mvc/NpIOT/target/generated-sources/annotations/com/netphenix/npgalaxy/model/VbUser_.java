package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.AccountUser;
import com.netphenix.npgalaxy.model.Agency;
import com.netphenix.npgalaxy.model.AgencyUser;
import com.netphenix.npgalaxy.model.UserAccount;
import com.netphenix.npgalaxy.model.UserPermission;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(VbUser.class)
public class VbUser_ { 

    public static volatile SingularAttribute<VbUser, String> lastName;
    public static volatile SingularAttribute<VbUser, String> gender;
    public static volatile SingularAttribute<VbUser, Integer> failedLoginCount;
    public static volatile SingularAttribute<VbUser, Agency> agencyId;
    public static volatile SingularAttribute<VbUser, Boolean> isAdmin;
    public static volatile SingularAttribute<VbUser, String> userName;
    public static volatile SingularAttribute<VbUser, String> disableNotification;
    public static volatile SingularAttribute<VbUser, String> emailSignature;
    public static volatile CollectionAttribute<VbUser, AgencyUser> agencyUserCollection;
    public static volatile SingularAttribute<VbUser, String> firstName;
    public static volatile SingularAttribute<VbUser, Date> lastLoginTime;
    public static volatile SingularAttribute<VbUser, String> primaryPhone;
    public static volatile CollectionAttribute<VbUser, UserPermission> userPermissionCollection;
    public static volatile SingularAttribute<VbUser, String> password;
    public static volatile CollectionAttribute<VbUser, AccountUser> accountUserCollection;
    public static volatile CollectionAttribute<VbUser, UserAccount> userAccountCollection;
    public static volatile SingularAttribute<VbUser, Date> createdTime;
    public static volatile SingularAttribute<VbUser, String> theme;
    public static volatile SingularAttribute<VbUser, Integer> id;
    public static volatile SingularAttribute<VbUser, String> userRefId;
    public static volatile SingularAttribute<VbUser, String> email;
    public static volatile SingularAttribute<VbUser, String> secondaryPhone;
    public static volatile SingularAttribute<VbUser, String> status;

}