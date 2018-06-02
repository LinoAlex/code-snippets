package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.AgencySettings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(Currency.class)
public class Currency_ { 

    public static volatile SingularAttribute<Currency, String> nation;
    public static volatile SingularAttribute<Currency, String> currency;
    public static volatile SingularAttribute<Currency, Integer> id;
    public static volatile SingularAttribute<Currency, String> inUsd;
    public static volatile CollectionAttribute<Currency, AgencySettings> agencySettingsCollection;
    public static volatile SingularAttribute<Currency, String> currencyCode;

}