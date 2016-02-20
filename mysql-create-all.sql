create table category (
  id                            bigint auto_increment not null,
  description                   varchar(255),
  amount_in_cents               bigint,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_category primary key (id)
);

create table goal (
  id                            bigint auto_increment not null,
  category_id_id                bigint,
  amount_in_cents               bigint,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint uq_goal_category_id_id unique (category_id_id),
  constraint pk_goal primary key (id)
);

create table transaction (
  id                            bigint auto_increment not null,
  user_id                       varchar(100),
  date                          date,
  payee                         varchar(100),
  amount_in_cents               bigint,
  description                   varchar(1000),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_transaction primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  first_name                    varchar(100),
  last_name                     varchar(100),
  email                         varchar(100),
  password                      varchar(100),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_user primary key (id)
);

alter table goal add constraint fk_goal_category_id_id foreign key (category_id_id) references category (id) on delete restrict on update restrict;

