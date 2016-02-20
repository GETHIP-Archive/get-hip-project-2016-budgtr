alter table goal drop foreign key fk_goal_category_id;

alter table transaction drop foreign key fk_transaction_user_id;
drop index ix_transaction_user_id on transaction;

drop table if exists category;

drop table if exists goal;

drop table if exists transaction;

drop table if exists user;

