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
  category_id                   varchar(255),
  amount_in_cents               bigint,
  end_date                      date,
  user_id                       varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_goal primary key (id)
);

create table transaction (
  id                            bigint auto_increment not null,
  date                          date,
  user_id                       bigint,
  category                      varchar(255),
  dollars                       bigint,
  cents                         bigint,
  description                   varchar(255),
  payee                         varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_transaction primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_user primary key (id)
);

