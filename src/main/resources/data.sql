INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-10, 'Temperature room 2', 21.3, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-9, 'Window 1 status room 1', 1.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-8, 'Window 2 status room 1', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-7, 'Window 1 status room 2', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-6, 'Window 2 status room 2', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES (-5, 'Building 1 exterior', 18.0, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES (-4, 'Temperature room 1', 18.0, 'TEMPERATURE');

INSERT INTO SP_BUILDING(id, name, exterior_temperature_id) VALUES (-10, 'Building1', -5);

INSERT INTO SP_ROOM(id, name, floor, current_temperature_id, target_temperature, building_id) VALUES(-10, 'Room1', 1, -4, 18.0, -10);
INSERT INTO SP_ROOM(id, name, floor, current_temperature_id, target_temperature, building_id) VALUES(-9, 'Room2', 1, -10, 20.0, -10);

INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(-10, -9, 'Window 1 Room 1', -10);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(-9, -8, 'Window 2 Room 1', -10);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(-8, -7, 'Window 1 Room 2', -9);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(-7, -6, 'Window 2 Room 2', -9);

INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(1, 'Exterior temperature EF', 5.0, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(2, 'Temperature couloir pair 1er étage', 17.0, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(3, 'Temperature S1.29', 16.0, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(4, 'Status Window 1 S1.29', 1.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(5, 'Status Window 2 S1.29', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(6, 'Status Window 3 S1.29', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(7, 'Status Window 4 S1.29', 0.0, 'STATUS');

INSERT INTO SP_BUILDING(id, name, exterior_temperature_id) VALUES(1,'Espace Fauriel', 1);

INSERT INTO SP_ROOM(id, name, floor, current_temperature_id, target_temperature, building_id) VALUES(1, 'Couloir pair 1er étage', 1, 2, 18, 1);
INSERT INTO SP_ROOM(id, name, floor, current_temperature_id, target_temperature, building_id) VALUES(2, 'S1.29', 1, 3, 18, 1);
INSERT INTO SP_ADJACENT_ROOM(room_id, adjacent_room_id) VALUES(1, 2);
INSERT INTO SP_ADJACENT_ROOM(room_id, adjacent_room_id) VALUES(2, 1);

INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(1, 4, 'Window 1 S1.29', 2);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(2, 5, 'Window 2 S1.29', 2);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(3, 6, 'Window 3 S1.29', 2);
INSERT INTO SP_WINDOW(id, window_status_id, name, room_id) VALUES(4, 7, 'Window 4 S1.29', 2);
