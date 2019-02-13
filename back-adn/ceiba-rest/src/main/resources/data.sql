INSERT INTO public.tipo_vehiculo(
	 id, codigo, vehiculo, cupo, placa_bloqueada, dias_permitidos)
	VALUES (1,  'A1', 'Automovil', 20, 'A', 'LU-DO');

INSERT INTO public.tipo_vehiculo(
	 id, codigo, vehiculo, cupo, placa_bloqueada, dias_permitidos)
	VALUES (2, 'M1', 'Moto', 10, 'A', 'LU-DO');
	
INSERT INTO public.empleado(
   id,nombres, apellidos, cargo)
   VALUES (1, 'Carlos', 'Tamayo', 'vigilante');

INSERT INTO public.tarifa(
	id, codigo, hora, valor_hora, codigo_tipo_vehiculo, dia, valor_dia, cilindro_vehiculo, precio_cilindro)
	VALUES (1,'T1', 1, 1000, 'A1', 9, 8000, 0, 0);
	
INSERT INTO public.tarifa(
	id, codigo, hora, valor_hora, codigo_tipo_vehiculo, dia, valor_dia, cilindro_vehiculo, precio_cilindro)
	VALUES (2,'T2', 1, 500, 'M1', 9, 4000, 500, 2000);	