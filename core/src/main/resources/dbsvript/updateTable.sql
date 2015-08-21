ALTER TABLE regisrtform 
ADD COLUMN rf_declarant_passpord BIGINT(19) NOT NULL AFTER `rf_status`;
ALTER TABLE declarpassport
CHANGE COLUMN dp_password_indent_nb dp_passport_indent_nb VARCHAR(45) NOT NULL ;
ALTER TABLE availablereg
CHANGE COLUMN ar_id ar_id BIGINT(19) NOT NULL ,
ADD COLUMN status INT NULL DEFAULT 0 AFTER ar_day;
UPDATE regisrtform SET rf_declarant_passpord=1 WHERE rf_id=1;
UPDATE regisrtform SET rf_declarant_passpord=2 WHERE rf_id=2;
