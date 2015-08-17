ALTER TABLE regisrtform 
ADD COLUMN rf_declarant_passpord BIGINT(19) NOT NULL AFTER `rf_status`;
ALTER TABLE declarpassport
CHANGE COLUMN dp_password_indent_nb dp_passport_indent_nb VARCHAR(45) NOT NULL ;