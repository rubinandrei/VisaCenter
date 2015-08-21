Select.admin=select su_id,su_login,su_admintyp,su_password from systemusers where su_login = ? and su_password = MD5(?) and su_admintyp=1 ;
Select.user=select su_id,su_login,su_admintyp,su_password from systemusers where su_login = ? and su_password = MD5(?) and su_admintyp=0 ;
Select.all=select su_id,su_login,su_admintyp,su_password from systemusers;