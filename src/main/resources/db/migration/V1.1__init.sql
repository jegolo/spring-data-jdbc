create table Orders (

  order_id number(9) primary key,
  order_date timestamp

);

create table Order_item (

  order_item_id number(9) primary key auto_increment,
  order_id number(9),
  description varchar2(200),
  foreign key (order_id) references Orders(order_id)

);

