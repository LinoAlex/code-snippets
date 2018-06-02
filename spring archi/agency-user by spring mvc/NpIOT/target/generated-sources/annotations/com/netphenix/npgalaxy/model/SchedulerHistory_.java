package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Scheduler;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(SchedulerHistory.class)
public class SchedulerHistory_ { 

    public static volatile SingularAttribute<SchedulerHistory, String> fileName;
    public static volatile SingularAttribute<SchedulerHistory, Scheduler> schedulerId;
    public static volatile SingularAttribute<SchedulerHistory, String> emailId;
    public static volatile SingularAttribute<SchedulerHistory, Date> executedDate;
    public static volatile SingularAttribute<SchedulerHistory, Date> executionEndTime;
    public static volatile SingularAttribute<SchedulerHistory, String> emailSubject;
    public static volatile SingularAttribute<SchedulerHistory, String> emailMessage;
    public static volatile SingularAttribute<SchedulerHistory, Date> executionStartTime;
    public static volatile SingularAttribute<SchedulerHistory, Date> startTime;
    public static volatile SingularAttribute<SchedulerHistory, Integer> id;
    public static volatile SingularAttribute<SchedulerHistory, Date> endTime;
    public static volatile SingularAttribute<SchedulerHistory, String> schedulerName;
    public static volatile SingularAttribute<SchedulerHistory, String> status;

}