create table category (
  id                            bigserial not null,
  description                   varchar(255),
  amount_in_cents               bigint,
  version                       bigint not null,
  when_created                  timestamp not null,
  when_updated                  timestamp not null,
  constraint pk_category primary key (id)
);

create table goal (
  id                            bigserial not null,
  category_id                   bigint,
  amount_in_cents               bigint,
  version                       bigint not null,
  when_created                  timestamp not null,
  when_updated                  timestamp not null,
  constraint uq_goal_category_id unique (category_id),
  constraint pk_goal primary key (id)
);

create table transaction (
  id                            bigserial not null,
  user_id                       bigint,
  date                          date,
  payee                         varchar(100),
  amount_in_cents               bigint,
  description                   varchar(1000),
  version                       bigint not null,
  when_created                  timestamp not null,
  when_updated                  timestamp not null,
  constraint pk_transaction primary key (id)
);

create table user (
  id                            bigserial not null,
  first_name                    varchar(100),
  last_name                     varchar(100),
  email                         varchar(100),
  password                      varchar(100),
  version                       bigint not null,
  when_created                  timestamp not null,
  when_updated                  timestamp not null,
  constraint pk_user primary key (id)
);

alter table goal add constraint fk_goal_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;

alter table transaction add constraint fk_transaction_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_transaction_user_id on transaction (user_id);

