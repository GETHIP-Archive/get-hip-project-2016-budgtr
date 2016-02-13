create table transaction (
  id                            bigserial not null,
  name                          varchar(100),
  comments                      varchar(1000),
  version                       bigint not null,
  when_created                  timestamp not null,
  when_updated                  timestamp not null,
  constraint pk_transaction primary key (id)
);

