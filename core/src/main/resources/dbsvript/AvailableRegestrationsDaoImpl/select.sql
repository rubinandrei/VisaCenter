Select.AvalibleCount.byDay=select ar_id, ar_count, ar_day from availablereg where ar_day = date(?);
Select.Avalible.byNextDays=select ar_id, ar_count, ar_day from availablereg where ar_day > date(?) and ar_count>0;
