package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Account;
import com.netphenix.npgalaxy.model.VbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(UserAccount.class)
public class UserAccount_ { 

    public static volatile SingularAttribute<UserAccount, Account> accountId;
    public static volatile SingularAttribute<UserAccount, Integer> id;
    public static volatile SingularAttribute<UserAccount, VbUser> userId;
    public static volatile SingularAttribute<UserAccount, Boolean> status;

}