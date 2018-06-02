package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.AgencySettings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(Timezone.class)
public class Timezone_ { 

    public static volatile SingularAttribute<Timezone, String> description;
    public static volatile CollectionAttribute<Timezone, AgencySettings> agencySettingsCollection;
    public static volatile SingularAttribute<Timezone, Integer> id;
    public static volatile SingularAttribute<Timezone, String> shortDescription;
    public static volatile SingularAttribute<Timezone, String> longName;
    public static volatile SingularAttribute<Timezone, String> relativeToGMT;

}