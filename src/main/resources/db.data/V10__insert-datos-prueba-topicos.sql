insert into topicos (titulo, mensaje, fecha_creacion, status, curso_id, usuario_id) values
('Introducción a Java',
 'Este es un tópico para discutir dudas sobre el curso de introducción a Java.',
 '2025-01-01 10:00:00',
 true,
 16, -- ID de curso existente
 1  -- ID de usuario existente
),
('Configuración de Spring Boot',
 'Dudas sobre cómo configurar Spring Boot en proyectos nuevos.',
 '2025-01-02 15:30:00',
 true,
 17, -- ID de curso existente
 2  -- ID de usuario existente
),
('Errores comunes en Hibernate',
 'Un espacio para compartir y resolver errores comunes al usar Hibernate.',
 '2025-01-03 09:45:00',
 false,
 17, -- ID de curso existente
 3  -- ID de usuario existente
),
('Buenas prácticas con REST API',
 'Discusión sobre cómo diseñar y documentar APIs REST de forma eficiente.',
 '2025-01-04 12:00:00',
 true,
 17, -- ID de curso existente
 4  -- ID de usuario existente
),
('Debugging avanzado con IntelliJ',
 'Compartamos técnicas avanzadas para depuración con IntelliJ.',
 '2025-01-05 14:20:00',
 false,
 17, -- ID de curso existente
 5  -- ID de usuario existente
);

