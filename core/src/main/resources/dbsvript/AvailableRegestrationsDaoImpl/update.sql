Update.AvalibleCount.byDay=UPDATE availablereg set ar_count = ?  where ar_day = date(?);
Update.AvalibleCount.byReg=UPDATE availablereg set ar_count = ar_count-?  where ar_day = date(?);
Update.AvalibleCount.byterminate=UPDATE availablereg set status = 1  where ar_day = date(?);
