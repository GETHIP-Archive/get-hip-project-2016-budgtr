alter table if exists goal drop constraint if exists fk_goal_category_id;

alter table if exists transaction drop constraint if exists fk_transaction_user_id;
drop index if exists ix_transaction_user_id;

drop table if exists category cascade;

drop table if exists goal cascade;

drop table if exists transaction cascade;

drop table if exists user cascade;

