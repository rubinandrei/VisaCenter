ALTER TABLE regisrtform 
ADD COLUMN rf_declarant_passpord BIGINT(19) NOT NULL AFTER `rf_status`;
ALTER TABLE declarpassport
CHANGE COLUMN dp_password_indent_nb dp_passport_indent_nb VARCHAR(45) NOT NULL ;
ALTER TABLE availablereg
CHANGE COLUMN ar_id ar_id BIGINT(19) NOT NULL ,
ADD COLUMN status INT NULL DEFAULT 0 AFTER ar_day;