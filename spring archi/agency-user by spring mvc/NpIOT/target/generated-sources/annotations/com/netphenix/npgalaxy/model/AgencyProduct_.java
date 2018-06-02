package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Agency;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(AgencyProduct.class)
public class AgencyProduct_ { 

    public static volatile SingularAttribute<AgencyProduct, Boolean> showProduct;
    public static volatile SingularAttribute<AgencyProduct, String> icon;
    public static volatile SingularAttribute<AgencyProduct, Integer> productOrder;
    public static volatile SingularAttribute<AgencyProduct, Agency> agencyId;
    public static volatile SingularAttribute<AgencyProduct, Integer> id;
    public static volatile SingularAttribute<AgencyProduct, String> productName;
    public static volatile SingularAttribute<AgencyProduct, String> status;

}