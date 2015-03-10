insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (0, 50, 'Aula 3', 'Valor cargado por defecto', 0)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (1, 88, 'Sala actos', 'Sala cargado por defecto', 1)
insert into Espacio (ESPACIO_ID, aforo, nombre, notas, tipoEspacio) values (2, 88, 'Auditorio principal', 'Sala cargado por defecto', 2)


insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (0, 'Es provisional', 1,'2015-03-01 12:30:57', '2015-03-07 12:30:57', '2015-03-07 13:30:57', 'Gerencia')
insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (1, 'Conferencia Stallman', 2,'2015-03-10 10:30:00', '2015-03-10 15:30:00', '2015-03-10 17:30:00', 'Gerencia')
insert into Reserva (id, aclaraciones, ESPACIO_ID, fechaCreacion, fechaInicio, fechaFin, titular) values (2, 'Ciclo de conferencias', 1,'2015-03-12 10:30:00', '2015-03-22 15:00:00', '2015-03-22 17:30:00', 'Gerencia')