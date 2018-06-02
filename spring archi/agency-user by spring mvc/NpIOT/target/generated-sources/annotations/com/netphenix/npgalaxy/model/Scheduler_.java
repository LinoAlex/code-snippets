package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.model.Account;
import com.netphenix.npgalaxy.model.Agency;
import com.netphenix.npgalaxy.model.SchedulerHistory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T16:53:02")
@StaticMetamodel(Scheduler.class)
public class Scheduler_ { 

    public static volatile SingularAttribute<Scheduler, String> schedulerYearly;
    public static volatile SingularAttribute<Scheduler, Boolean> isAccountEmail;
    public static volatile CollectionAttribute<Scheduler, SchedulerHistory> schedulerHistoryCollection;
    public static volatile SingularAttribute<Scheduler, Date> endDate;
    public static volatile SingularAttribute<Scheduler, Integer> lastNdays;
    public static volatile SingularAttribute<Scheduler, Integer> lastNyears;
    public static volatile SingularAttribute<Scheduler, String> schedulerNow;
    public static volatile SingularAttribute<Scheduler, Agency> agencyId;
    public static volatile SingularAttribute<Scheduler, String> schedulerMonthly;
    public static volatile SingularAttribute<Scheduler, String> schedulerTime;
    public static volatile SingularAttribute<Scheduler, String> lastExecutionStatus;
    public static volatile SingularAttribute<Scheduler, Integer> id;
    public static volatile SingularAttribute<Scheduler, String> schedulerName;
    public static volatile SingularAttribute<Scheduler, Integer> lastNmonths;
    public static volatile SingularAttribute<Scheduler, String> schedulerWeekly;
    public static volatile SingularAttribute<Scheduler, String> dateRangeName;
    public static volatile SingularAttribute<Scheduler, Integer> schedulerYearOfWeek;
    public static volatile SingularAttribute<Scheduler, String> schedulerEmail;
    public static volatile SingularAttribute<Scheduler, String> customEndDate;
    public static volatile SingularAttribute<Scheduler, String> schedulerRepeatType;
    public static volatile SingularAttribute<Scheduler, String> schedulerType;
    public static volatile SingularAttribute<Scheduler, Account> accountId;
    public static volatile SingularAttribute<Scheduler, String> schedulerStatus;
    public static volatile SingularAttribute<Scheduler, Integer> lastNweeks;
    public static volatile SingularAttribute<Scheduler, Date> startDate;
    public static volatile SingularAttribute<Scheduler, String> customStartDate;
    public static volatile SingularAttribute<Scheduler, String> status;

}