package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Account;
import com.netphenix.npgalaxy.model.AgencyProduct;
import com.netphenix.npgalaxy.model.VbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(Agency.class)
public class Agency_ { 

    public static volatile CollectionAttribute<Agency, Account> accountCollection;
    public static volatile CollectionAttribute<Agency, VbUser> vbUserCollection;
    public static volatile SingularAttribute<Agency, String> agencyPath;
    public static volatile SingularAttribute<Agency, byte[]> logo;
    public static volatile CollectionAttribute<Agency, AgencyProduct> agencyProductCollection;
    public static volatile SingularAttribute<Agency, String> description;
    public static volatile SingularAttribute<Agency, Integer> id;
    public static volatile SingularAttribute<Agency, String> agencyName;
    public static volatile SingularAttribute<Agency, String> email;
    public static volatile SingularAttribute<Agency, String> status;

}