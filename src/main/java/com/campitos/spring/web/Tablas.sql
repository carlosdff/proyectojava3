create table usuario (id integer primary key
                  auto_increment,
                nombre varchar(80),
                sueldo float);

create table nomina2 (id_nomina integer primary key
              auto_increment,id_usuario integer, saldo float, foreign key (id_usuario) references usuario(id));

create table puesto (id_puesto integer primary key
              auto_increment,id_pues integer, tipo_puesto varchar(80), foreign key (id_pues) references nomina2(id_nomina));


