CREATE TABLE propiedad (
    id SERIAL PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    precio INT NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

select * from propiedad
select * from t_role
select * from t_user

INSERT INTO propiedad (direccion, precio, tipo) VALUES 
('Calle San Ignacio 80, Santiago Centro', 95000000, 'Departamento'),
('Av. Apoquindo 4800, Las Condes', 250000000, 'Casa'),
('Av. Vicuña Mackenna 5600, La Florida', 175000000, 'Casa'),
('Calle Los Militares 5000, Las Condes', 300000000, 'Departamento'),
('Av. El Golf 100, Las Condes', 350000000, 'Departamento'),
('Av. Manuel Montt 200, Providencia', 145000000, 'Departamento'),
('Calle Lota 1234, Providencia', 210000000, 'Casa'),
('Av. Kennedy 6000, Vitacura', 450000000, 'Casa'),
('Calle Las Hualtatas 7000, Vitacura', 380000000, 'Casa'),
('Calle Esmeralda 50, Santiago Centro', 130000000, 'Departamento'),
('Av. Matta 1250, Santiago Centro', 160000000, 'Departamento'),
('Calle Carmen 700, Santiago Centro', 140000000, 'Departamento'),
('Calle Santo Domingo 800, Santiago Centro', 110000000, 'Departamento'),
('Av. Italia 1000, Providencia', 225000000, 'Casa'),
('Calle Suecia 1200, Providencia', 240000000, 'Casa'),
('Av. Las Torres 890, La Reina', 180000000, 'Casa'),
('Av. Las Industrias 300, Quilicura', 95000000, 'Departamento'),
('Calle Lo Ovalle 1500, San Miguel', 135000000, 'Departamento'),
('Calle Amapolas 1900, Ñuñoa', 220000000, 'Casa'),
('Av. Grecia 5200, Peñalolén', 185000000, 'Casa'),
('Av. La Florida 8000, La Florida', 160000000, 'Casa'),
('Calle Quilín 2000, Macul', 210000000, 'Casa'),
('Av. Pajaritos 3000, Maipú', 105000000, 'Departamento'),
('Av. El Parrón 4500, La Cisterna', 150000000, 'Casa'),
('Calle Mac Iver 123, Santiago Centro', 125000000, 'Departamento'),
('Av. Pedro de Valdivia 1500, Ñuñoa', 235000000, 'Casa'),
('Calle Los Alerces 2200, Las Condes', 295000000, 'Casa'),
('Av. Americo Vespucio 5600, La Florida', 195000000, 'Casa'),
('Calle Carmen 950, Santiago Centro', 140000000, 'Departamento');