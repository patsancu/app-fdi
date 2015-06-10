insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (0, 50, 'Aula 3', 'Valor cargado por defecto', 0)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (1, 88, 'Sala actos', 'Sala cargado por defecto', 1)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (2, 88, 'Auditorio principal', 'Sala cargado por defecto', 2)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (3, 3, 'Aula 4', 'Despacho de John Winston', 0)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (4, 10, 'Aula 5', 'Despacho del decano', 0)


insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (0, 'Es provisional', 1,'2015-06-07 12:30:57', '2015-06-15 12:30:57', '2015-06-15 13:30:57', 'Gerencia')
insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (1, 'Conferencia Stallman', 2,'2015-06-07 12:30:57', '2015-06-18 15:30:00', '2015-06-18 17:30:00', 'Administración')
insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (2, 'Ciclo de conferencias', 1,'2015-06-07 12:30:57', '2015-06-22 15:00:00', '2015-06-22 17:30:00', 'Gerencia')