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
  end_date                      datetime(6),
  user_id                       varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_goal primary key (id)
);

create table transaction (
  id                            bigint auto_increment not null,
  date                          datetime(6)(100),
  user_id                       bigint(1000),
  amount_in_cents               bigint(1000),
  description                   varchar(1000),
  payee                         varchar(1000),
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

