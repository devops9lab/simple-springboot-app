insert into accounts (id, email_address, name)
values (1, 'user1@gmail.com', 'User 1') ;
insert into accounts (id, email_address, name)
values (2, 'user2@gmail.com', 'User 2') ;

insert into account_settings (id, setting_name, setting_value, account_id)
values (1, 'a1-s1', 'v1', 1);
insert into account_settings (id, setting_name, setting_value, account_id)
values (2, 'a1-s2', 'v2', 1);
insert into account_settings (id, setting_name, setting_value, account_id)
values (3, 'a2-s1', 'v1', 2);
insert into account_settings (id, setting_name, setting_value, account_id)
values (4, 'a2-s2', 'v2', 2);