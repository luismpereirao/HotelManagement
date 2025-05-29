# HotelManagement

**HotelManagement** es una aplicación web completa para la gestión de hoteles, que permite administrar reservas, habitaciones, usuarios y más. Está compuesta por un backend en Java con Spring Boot y un frontend moderno construido con React. Además, cuenta con integración con **AWS S3** para la carga y gestión de imágenes.

## 📁 Estructura del Proyecto

```
HotelManagement/
├── backend/         # Backend en Java (Spring Boot)
├── frontend/        # Frontend en React
├── .mvn/
├── .gitignore
├── .gitattributes
└── README.md
```

## 🚀 Tecnologías Utilizadas

- **Backend**
  - Java 11+
  - Spring Boot
  - Spring Data JPA
  - Maven
  - AWS SDK (para S3)
  
- **Frontend**
  - React
  - JavaScript / JSX
  - Axios

- **Servicios**
  - AWS S3 (para almacenamiento de imágenes)
  - Docker (opcional para despliegue)

## ⚙️ Instalación y Ejecución

### Requisitos

- Java 11 o superior
- Node.js y npm
- Maven
- AWS CLI configurado (con credenciales y permisos S3 si deseas probar la funcionalidad de carga)
- Docker (opcional)

### Clonar el proyecto

```bash
git clone https://github.com/luismpereirao/HotelManagement.git
cd HotelManagement
```

### Backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm start
```

La aplicación estará disponible en: `http://localhost:3000`

## ☁️ Carga de Imágenes a AWS S3

El proyecto utiliza el SDK de AWS para cargar imágenes desde el frontend a un bucket de S3. Las imágenes se almacenan remotamente y se puede acceder a ellas mediante las URLs generadas por AWS S3.

Asegúrate de tener:

- Un bucket en S3 creado
- Las credenciales AWS configuradas en tu entorno (por ejemplo, mediante `~/.aws/credentials` o variables de entorno)
- Las políticas adecuadas para subir objetos al bucket

### Configuración en el backend (`application.properties` o `.yml`)

```properties
aws.s3.bucket-name=tu-nombre-de-bucket
aws.access-key=TU_ACCESS_KEY
aws.secret-key=TU_SECRET_KEY
aws.region=us-east-1
```

### Flujo de carga:

1. El usuario selecciona una imagen desde el navegador.
2. La imagen se envía desde React al backend vía una petición `multipart/form-data`.
3. El backend carga la imagen a AWS S3 y devuelve la URL pública o firmada.
4. La URL se almacena en la base de datos y se muestra directamente en la interfaz.

## ✅ Pruebas

### Backend

```bash
cd backend
mvn test
```

### Frontend

```bash
cd frontend
npm test
```

## 🐳 Despliegue con Docker (opcional)

```bash
docker build -t hotelmanagement-backend ./backend
docker run -p 8080:8080 hotelmanagement-backend
```

Para el frontend, se puede construir con:

```bash
cd frontend
npm run build
```

Y servir con Nginx, Vite, o como parte de una imagen Docker.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Puedes abrir un issue para reportar errores o proponer mejoras, o enviar un pull request directamente.
