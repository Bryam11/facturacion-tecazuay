-- Inserciones en la tabla Tipo_Pago
INSERT INTO Tipo_Pago (tpo, descrip)
VALUES
    ('Efectivo', 'Pago en efectivo'),
('Tarjeta', 'Pago con tarjeta de crédito/débito'),
('Transferencia', 'Pago mediante transferencia bancaria');

-- Inserciones en la tabla Persona
INSERT INTO Persona (nombre, apellido, dni, celular, correo)
VALUES
    ('Juan', 'Pérez', '12345678', '987654321', 'juan.perez@example.com'),
('María', 'Gómez', '87654321', '912345678', 'maria.gomez@example.com');

-- Inserciones en la tabla Competencia
INSERT INTO Competencia (nombre, descrip)
VALUES
    ('Administrador', 'Competencia en gestión y administración'),
('Vendedor', 'Competencia en ventas y atención al cliente');

-- Inserciones en la tabla Rol
INSERT INTO Rol (rol, estado, id_competencia)
VALUES
    ('Administrador', TRUE, 1),
('Vendedor', TRUE, 2);

-- Inserciones en la tabla Usuario
INSERT INTO Usuario (id_persona, username, password, id_rol)
VALUES
    (1, 'juanp', 'password123', 1),
(2, 'mariag', 'password123', 2);

-- Inserciones en la tabla Clasificacion
INSERT INTO Clasificacion (grupo)
VALUES
    ('Electrónica'),
('Ropa');

-- Inserciones en la tabla Proveedores
INSERT INTO Proveedores (nombre, ruc, telefono, pais, correo, moneda)
VALUES
    ('Proveedor 1', '111222333', '123456789', 'Perú', 'proveedor1@example.com', 'PEN'),
('Proveedor 2', '444555666', '987654321', 'Chile', 'proveedor2@example.com', 'CLP');

-- Inserciones en la tabla Producto
INSERT INTO Producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva)
VALUES
    (100, 1500.00, 'unidad', 1, 1, TRUE),
(50, 200.00, 'unidad', 2, 2, FALSE);

-- Inserciones en la tabla Factura
INSERT INTO Factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total)
VALUES
    ('12345678', 1, '2024-12-29', 1, 50.00, 1450.00),
('87654321', 2, '2024-12-28', 2, 20.00, 180.00);

-- Inserciones en la tabla Item_Factura
INSERT INTO Item_Factura (id_factura, id_producto, cantidad, precio, subtotal)
VALUES
    (1, 1, 1, 1500.00, 1500.00),
(2, 2, 1, 200.00, 200.00);
