package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Agency;
import com.netphenix.npgalaxy.model.Scheduler;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> accountName;
    public static volatile SingularAttribute<Account, String> geoLocation;
    public static volatile CollectionAttribute<Account, Scheduler> schedulerCollection;
    public static volatile SingularAttribute<Account, String> description;
    public static volatile SingularAttribute<Account, String> logo;
    public static volatile SingularAttribute<Account, String> emailId;
    public static volatile SingularAttribute<Account, Agency> agencyId;
    public static volatile SingularAttribute<Account, Integer> id;

}