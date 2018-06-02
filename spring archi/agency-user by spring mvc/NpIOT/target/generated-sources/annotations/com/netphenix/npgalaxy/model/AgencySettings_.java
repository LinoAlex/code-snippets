package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Agency;
import com.netphenix.npgalaxy.model.Currency;
import com.netphenix.npgalaxy.model.Timezone;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(AgencySettings.class)
public class AgencySettings_ { 

    public static volatile SingularAttribute<AgencySettings, Timezone> timeZoneId;
    public static volatile SingularAttribute<AgencySettings, Agency> agencyId;
    public static volatile SingularAttribute<AgencySettings, Integer> id;
    public static volatile SingularAttribute<AgencySettings, Currency> currencyId;

}