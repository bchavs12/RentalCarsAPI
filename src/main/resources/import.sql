-- CATEGORIAS
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('Sedan', 'Veículos confortáveis e espaçosos, ideais para famílias e viagens longas.', 'url_imagem_sedan');
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('SUV', 'Veículos robustos com alta capacidade de carga e desempenho em diferentes terrenos.', 'url_imagem_suv');
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('Compacto', 'Carros pequenos e econômicos, perfeitos para uso urbano e fácil estacionamento.', 'url_imagem_compacto');

-- CIDADES
INSERT INTO TB_CITIES (name, state) VALUES ('São Paulo', 'SP');
INSERT INTO TB_CITIES (name, state) VALUES ('Uberlândia', 'MG');
INSERT INTO TB_CITIES (name, state) VALUES ('Goiânia', 'GO');

-- EMPRESAS DE ALUGUEL
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('AlugaCar SP', (SELECT id FROM TB_CITIES WHERE name = 'São Paulo'));
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('RentNow MG', (SELECT id FROM TB_CITIES WHERE name = 'Uberlândia'));
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('CarRent GO', (SELECT id FROM TB_CITIES WHERE name = 'Goiânia'));

-- CARROS
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Toyota', 'Corolla', 2020, 'url_imagem_corolla', 150, true, 1, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Ford', 'Fiesta', 2019, 'url_imagem_fiesta', 120, true, 2, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Nissan', 'Versa', 2021, 'url_imagem_versa', 130, true, 1, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Fiat', 'Argo', 2022, 'url_imagem_argo', 110, true, 3, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Renault', 'Sandero', 2018, 'url_imagem_sandero', 100, true, 3, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, fk_category_id, fk_rental_company_id) VALUES ('Volkswagen', 'Polo', 2020, 'url_imagem_polo', 140, true, 2, 1);


-- USUÁRIOS
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('Carlos', '123', 'Carlos@example.com', 'Carlos');
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('Bruno', '123', 'Bruno@example.com', 'Bruno');
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('Lucas', '123', 'Lucas@example.com', 'Lucas');
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('João', '123', 'João@example.com', 'João');
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('Maria', '123', 'Maria@example.com', 'Maria');

-- AVALIAÇÕES
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (5, 'Excelente carro e serviço.', 1, 1);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (4, 'Muito confortável e econômico.', 2, 2);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (3, 'Bom carro, mas com alguns problemas menores.', 3, 1);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (2, 'Carro razoável, mas esperava mais.', 5, 4);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (4, 'Bom desempenho e limpeza impecável.', 1, 5);

-- RESERVAS
INSERT INTO TB_BOOKINGS (fk_car_id, fk_user_id, booking_start, booking_date, return_date) VALUES (1, 1, '08:00:00', '2023-01-01', '2023-01-07');
INSERT INTO TB_BOOKINGS (fk_car_id, fk_user_id, booking_start, booking_date, return_date) VALUES (2, 2, '09:00:00', '2023-02-15', '2023-02-20');
INSERT INTO TB_BOOKINGS (fk_car_id, fk_user_id, booking_start, booking_date, return_date) VALUES (3, 3, '10:00:00', '2023-03-10', '2023-03-15');

