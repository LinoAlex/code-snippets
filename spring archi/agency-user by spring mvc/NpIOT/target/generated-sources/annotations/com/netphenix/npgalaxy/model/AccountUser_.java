package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Account;
import com.netphenix.npgalaxy.model.VbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(AccountUser.class)
public class AccountUser_ { 

    public static volatile SingularAttribute<AccountUser, Account> accountId;
    public static volatile SingularAttribute<AccountUser, Integer> id;
    public static volatile SingularAttribute<AccountUser, VbUser> userId;
    public static volatile SingularAttribute<AccountUser, Boolean> status;

}