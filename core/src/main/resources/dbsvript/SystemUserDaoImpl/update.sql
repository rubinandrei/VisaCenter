Update.user = UPDATE systemusers SET su_id = ?,su_login = ?, su_password = MD5(?),su_admintyp = ? WHERE su_id = ?;
