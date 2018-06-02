package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Agency;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(AgencyLicence.class)
public class AgencyLicence_ { 

    public static volatile SingularAttribute<AgencyLicence, Integer> maxNoTab;
    public static volatile SingularAttribute<AgencyLicence, Date> expiryDate;
    public static volatile SingularAttribute<AgencyLicence, Integer> maxNoAccount;
    public static volatile SingularAttribute<AgencyLicence, Agency> agencyId;
    public static volatile SingularAttribute<AgencyLicence, Integer> id;
    public static volatile SingularAttribute<AgencyLicence, Integer> maxNoWidgetPerTab;
    public static volatile SingularAttribute<AgencyLicence, Integer> maxNoUser;
    public static volatile SingularAttribute<AgencyLicence, Integer> maxNoClient;

}