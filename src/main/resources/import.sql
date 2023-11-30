-- CATEGORIAS
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('Sedan', 'Veículos confortáveis e espaçosos, ideais para famílias e viagens longas.', 'https://i.imgur.com/Pf1G4Fj.jpg');
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('SUV', 'Veículos robustos com alta capacidade de carga e desempenho em diferentes terrenos.', 'https://i.imgur.com/e3ruOvT.jpg');
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('Compacto', 'Carros pequenos e econômicos, perfeitos para uso urbano e fácil estacionamento.', 'https://i.imgur.com/YCRlcXG.jpg');
INSERT INTO TB_CATEGORIES (name, description, image_url) VALUES ('Elétrico', 'Carros elétricos com alta eficiência energética, ideais para a sustentabilidade.', 'https://i.imgur.com/DzUAL3F.jpg');

-- CIDADES
INSERT INTO TB_CITIES (name, state) VALUES ('São Paulo', 'SP');
INSERT INTO TB_CITIES (name, state) VALUES ('Uberlândia', 'MG');
INSERT INTO TB_CITIES (name, state) VALUES ('Goiânia', 'GO');

-- EMPRESAS DE ALUGUEL
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('AlugaCar SP', 1);
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('RentNow MG', 2);
INSERT INTO TB_RENTAL_COMPANIES (name, city) VALUES ('CarRent GO', 3);

-- CARROS
-- Sedan
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Nissan', 'Versa', 2021, 'https://i.imgur.com/9ELA36t.jpg', 130, true, 'O Nissan Versa 2021 se destaca por seu espaço interno e conforto. Com um design moderno e eficiência no consumo de combustível, este carro é ideal para quem procura um sedan acessível sem abrir mão do conforto e da tecnologia.', 1, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Toyota', 'Corolla', 2020, 'https://i.imgur.com/odvG3r1.jpg', 150, true, 'O Toyota Corolla 2020 combina elegância, conforto e desempenho em um pacote completo. Com seu design sofisticado e tecnologia avançada, este carro é perfeito para quem busca estilo e eficiência na estrada. Ideal para viagens urbanas e longas jornadas.', 1, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Honda', 'Civic', 2021, 'https://i.imgur.com/YyKTlqk.jpg', 160, true, 'O Honda Civic 2021 é um sedan elegante e moderno, oferecendo uma combinação perfeita de conforto e desempenho. Ideal para quem procura um carro espaçoso e eficiente para viagens urbanas ou longas.', 1, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Audi', 'A4', 2021, 'https://i.imgur.com/BDoq0yu.jpg', 190, true, 'O Audi A4 2021 é um sedan de luxo que combina design elegante, tecnologia avançada e desempenho excepcional. Perfeito para quem busca sofisticação e conforto.', 1, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Mercedes-Benz', 'Classe C', 2022, 'https://i.imgur.com/qPNva2T.jpg', 200, true, 'O Mercedes-Benz Classe C 2022 é um sedan premium, conhecido por seu interior refinado e desempenho dinâmico. Ideal para viagens com estilo e conforto.', 1, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('BMW', 'Série 3', 2020, 'https://i.imgur.com/zgLhXBi.jpg', 195, true, 'O BMW Série 3 2020 oferece uma experiência de condução esportiva e luxuosa, com um interior bem equipado e tecnologia de ponta.', 1, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Lexus', 'ES', 2021, 'https://i.imgur.com/bO3vUpT.jpg', 210, true, 'O Lexus ES 2021 é um sedan sofisticado e confortável, com um desempenho suave e um interior de luxo. Excelente para quem procura elegância e tranquilidade na estrada.', 1, 2);

-- SUV
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Chevrolet', 'Tracker', 2022, 'https://i.imgur.com/DYXhBeR.png', 180, true, 'O Chevrolet Tracker 2022 é um SUV compacto e dinâmico, oferecendo um alto desempenho em diferentes terrenos. Com um design moderno e recursos tecnológicos, é perfeito para aventuras urbanas e viagens.', 2, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Land Rover', 'Discovery Sport', 2021, 'https://i.imgur.com/i078GtS.jpg', 220, true, 'O Land Rover Discovery Sport 2021 é um SUV robusto e luxuoso, oferecendo desempenho superior em todos os terrenos e um interior espaçoso.', 2, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Volvo', 'XC40', 2020, 'https://i.imgur.com/PAfo7R0.jpg', 215, true, 'O Volvo XC40 2020 é um SUV compacto com design inovador, segurança avançada e um interior confortável e tecnológico.', 2, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Jaguar', 'F-PACE', 2022, 'https://i.imgur.com/sOudQ68.jpg', 230, true, 'O Jaguar F-PACE 2022 combina luxo e desempenho, oferecendo uma experiência de condução emocionante e um design impressionante.', 2, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Porsche', 'Macan', 2021, 'https://i.imgur.com/KFaTP6q.jpg', 240, true, 'O Porsche Macan 2021 é um SUV de alto desempenho, com um design esportivo e um interior de luxo. Ideal para quem busca aventura e estilo.', 2, 3);


-- Compacto
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Peugeot', '208', 2021, 'https://i.imgur.com/czijX7v.png', 130, true, 'O Peugeot 208 2021 é um carro compacto, eficiente e com um design atraente. Perfeito para a vida urbana, com um interior tecnológico e confortável.', 3, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Toyota', 'Yaris', 2020, 'https://i.imgur.com/aKO3dZ6.jpg', 135, true, 'O Toyota Yaris 2020 é um carro compacto versátil e econômico, oferecendo um equilíbrio perfeito entre desempenho e eficiência.', 3, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Ford', 'Focus', 2021, 'https://i.imgur.com/ZOE2IzR.jpg', 140, true, 'O Ford Focus 2021 é um hatchback compacto que oferece uma condução dinâmica e um design moderno, ideal para a condução diária na cidade.', 3, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Renault', 'Clio', 2019, 'https://i.imgur.com/N0uxk3B.jpg', 125, true, 'O Renault Clio 2019 é um carro compacto com um design atraente e eficiência energética, sendo uma opção econômica e prática para o uso urbano.', 3, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Ford', 'Fiesta', 2019, 'https://i.imgur.com/2WBVX0M.jpg', 120, true, 'O Ford Fiesta 2019 é um carro compacto e ágil, perfeito para a cidade. Oferece uma condução divertida e econômica, com um interior confortável e recursos modernos. Uma escolha excelente para o dia a dia, combinando praticidade e prazer ao dirigir.', 3, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Fiat', 'Argo', 2022, 'https://i.imgur.com/k9sTxTZ.jpg', 110, true, 'O Fiat Argo 2022 é um hatch versátil e cheio de estilo. Com um design esportivo e interior tecnológico, oferece uma experiência de condução dinâmica e confortável. Perfeito para quem busca um carro compacto com personalidade e eficiência.', 3, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Renault', 'Sandero', 2018, 'https://i.imgur.com/xmq75NO.jpg', 100, true, 'O Renault Sandero 2018 é um hatch prático e robusto, ideal para o uso diário. Oferece um bom espaço interno e um desempenho confiável, sendo uma opção econômica para quem busca um carro funcional para a família ou para o trabalho.', 3, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Volkswagen', 'Polo', 2020, 'https://i.imgur.com/3Yh0WMu.jpg', 140, true, 'O Volkswagen Polo 2020 é um hatch que combina design moderno, segurança e tecnologia. Com um desempenho equilibrado e um interior confortável, é uma escolha sólida para quem deseja um carro confiável e estiloso para qualquer ocasião.', 3, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Hyundai', 'HB20', 2020, 'https://i.imgur.com/zUuKH1i.jpg', 100, true, 'O Hyundai HB20 2020 é um carro compacto, eficiente e estiloso. Com um design atraente e um interior confortável, é a escolha ideal para navegar na cidade com facilidade e economia.', 3, 2);

-- Elétrico
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Polestar', '2', 2021, 'https://i.imgur.com/E4hnrLB.jpg', 220, true, 'O Polestar 2 é um carro elétrico com um design inovador e uma tecnologia avançada, oferecendo um desempenho potente e uma condução suave.', 4, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Volkswagen', 'ID.3', 2020, 'https://i.imgur.com/dJ8xJFF.jpg', 210, true, 'O Volkswagen ID.3 2020 é um carro elétrico revolucionário, com um design moderno e uma autonomia impressionante, ideal para o futuro da mobilidade urbana.', 4, 1);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Lucid', 'Air', 2022, 'https://i.imgur.com/scl72R4.jpg', 250, true, 'O Lucid Air 2022 é um sedan elétrico de luxo, conhecido por sua autonomia líder de mercado e tecnologia de ponta.', 4, 2);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Rivian', 'R1T', 2021, 'https://i.imgur.com/fenZLz9.jpg', 260, true, 'O Rivian R1T 2021 é um veículo elétrico utilitário com capacidades off-road impressionantes e um design inovador.', 4, 3);
INSERT INTO TB_CARS (brand, model, car_year, image_url, price_per_day, is_available, description, fk_category_id, fk_rental_company_id) VALUES ('Tesla', 'Model 3', 2021, 'https://i.imgur.com/5l9GOzt.jpg', 200, true, 'O Tesla Model 3 é um carro elétrico revolucionário, combinando desempenho excepcional com sustentabilidade. Com uma autonomia impressionante e recursos tecnológicos avançados, é ideal para uma experiência de condução futurista.', 4, 3);


-- CARACTERISTICA
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 1);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 2);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 3);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 4);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 5);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 6);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('4 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 7);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 8);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 9);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 10);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 11);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas espaçoso', 'icon_url', 4, 12);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas compacto', 'icon_url', 4, 13);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas eficiente', 'icon_url', 4, 14);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas prático', 'icon_url', 4, 15);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas ágil', 'icon_url', 4, 16);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas versátil', 'icon_url', 4, 17);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas dinâmico', 'icon_url', 4, 18);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas inovador', 'icon_url', 4, 19);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas autônomo', 'icon_url', 4, 20);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas sustentável', 'icon_url', 4, 21);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas revolucionário', 'icon_url', 4, 22);
INSERT INTO TB_CHARACTERISTICS (seats, trunk, icon, car_doors, fk_car_id) VALUES ('5 lugares', 'Porta-malas futurista', 'icon_url', 4, 23);




-- USUÁRIOS
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('customer', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'customer@customer.com', 'customer');
INSERT INTO TB_USERS (username, password, email, full_name) VALUES ('admin', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'admin@admin.com', 'admin');

-- ROLES
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_CLIENT');
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_ADMIN');

-- USER ROLES
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 1);
INSERT INTO TB_USER_ROLE (user_id, role_id) VALUES (2, 2);

-- AVALIAÇÕES
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (5, 'Excelente carro e serviço.', 1, 1);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (4, 'Muito confortável e econômico.', 2, 2);
INSERT INTO TB_REVIEWS (rating, comment, fk_car_id, fk_user_id) VALUES (3, 'Bom carro, mas com alguns problemas menores.', 3, 1);

-- RESERVAS
INSERT INTO TB_BOOKINGS (fk_car_id, fk_user_id, booking_start, booking_date, return_date) VALUES (1, 1, '08:00:00', '2023-01-01', '2023-01-07');
INSERT INTO TB_BOOKINGS (fk_car_id, fk_user_id, booking_start, booking_date, return_date) VALUES (2, 2, '09:00:00', '2023-02-15', '2023-02-20');

