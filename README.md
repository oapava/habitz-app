# Habitz - Aplicación de Gestión de Hábitos

## Descripción del Proyecto

Habitz es una aplicación móvil Android desarrollada con Jetpack Compose y Kotlin que permite a los usuarios crear, gestionar y realizar seguimiento de sus hábitos diarios. La aplicación proporciona una interfaz intuitiva y moderna para establecer rutinas personalizadas y mantener la motivación a través del monitoreo de progreso.

### Características Principales

- **Creación de Hábitos Personalizados**: Permite definir hábitos con nombre, descripción, periodicidad y duración específicas
- **Gestión de Horarios**: Configuración de días específicos de la semana para cada hábito  
- **Seguimiento de Rachas**: Visualización del progreso y mantenimiento de rachas activas
- **Interfaz Moderna**: Implementación de Material Design 3 con componentes nativos de Android
- **Navegación Intuitiva**: Flujo de navegación optimizado para mejorar la experiencia del usuario

## Requisitos del Sistema

### Requisitos de Desarrollo

- **Android Studio**: Hedgehog 2023.1.1 o superior
- **JDK**: Java 11 o superior
- **Kotlin**: 1.9.0 o superior
- **Gradle**: 8.0 o superior

### Requisitos del Dispositivo

- **API Level Mínimo**: 24 (Android 7.0)
- **API Level Target**: 34 (Android 14)
- **Arquitectura**: ARM64, x86_64
- **RAM**: Mínimo 2GB recomendado

## Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/oapava/habitz-app.git
cd habitz-app
```

### 2. Configurar Android Studio

1. Abrir Android Studio
2. Seleccionar "Open an Existing Project"
3. Navegar a la carpeta del proyecto clonado
4. Esperar a que se complete la sincronización de Gradle

### 3. Configurar Variables de Entorno

Crear un archivo `local.properties` en la raíz del proyecto (si no existe):

```properties
sdk.dir=/path/to/your/Android/Sdk
```

### 4. Sincronizar Dependencias

```bash
./gradlew clean build
```

## Ejecución del Proyecto

### Ejecutar en Emulador

1. Configurar un emulador Android desde AVD Manager
2. Iniciar el emulador
3. Ejecutar el proyecto desde Android Studio o mediante línea de comandos:

```bash
./gradlew installDebug
```

### Ejecutar en Dispositivo Físico

1. Habilitar las "Opciones de Desarrollador" en el dispositivo
2. Activar la "Depuración USB"
3. Conectar el dispositivo vía USB
4. Ejecutar el proyecto desde Android Studio

### Comandos de Gradle

```bash
# Limpiar el proyecto
./gradlew clean

# Compilar el proyecto
./gradlew build

# Ejecutar tests unitarios
./gradlew test

# Generar APK de debug
./gradlew assembleDebug

# Generar APK de release
./gradlew assembleRelease
```

## Arquitectura del Proyecto

### Estructura de Carpetas

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/habitz/
│   │   │   ├── ui/
│   │   │   │   ├── screens/         # Pantallas de la aplicación
│   │   │   │   ├── shared/          # Componentes compartidos
│   │   │   │   └── theme/           # Tema y colores
│   │   │   └── MainActivity.kt      # Actividad principal
│   │   ├── res/
│   │   │   ├── drawable/            # Recursos gráficos
│   │   │   ├── values/              # Colores, strings, etc.
│   │   │   └── AndroidManifest.xml  # Manifest de la app
│   │   └── AndroidManifest.xml
│   ├── androidTest/                 # Tests de integración
│   └── test/                        # Tests unitarios
└── build.gradle.kts                 # Configuración de módulo
```

### Tecnologías Utilizadas

- **Jetpack Compose**: Framework para interfaces de usuario modernas y declarativas
- **Material 3**: Sistema de diseño de Google para interfaces consistentes
- **Navigation Compose**: Biblioteca para navegación entre pantallas
- **Kotlin**: Lenguaje de programación principal
- **Gradle Version Catalog**: Sistema de gestión centralizada de dependencias

## Pantallas Principales

### HomeScreen

Pantalla principal que presenta la vista general de hábitos actuales del usuario, incluyendo secciones de rachas y progreso, así como acceso rápido para crear nuevos hábitos.

### CreateHabitScreen

Formulario completo para la creación de hábitos que permite configurar periodicidad, duración, selección de días de la semana y opciones de notificaciones motivacionales.

### PermissionsScreen

Interface de gestión de permisos de la aplicación con controles independientes para cada tipo de permiso, presentada de manera clara y accesible.

## Funcionalidades Implementadas

### Gestión de Hábitos

- Creación de hábitos personalizados con nombre y descripción
- Edición de hábitos existentes
- Eliminación de hábitos
- Configuración de periodicidad (diaria, semanal, mensual)
- Establecimiento de duración de actividades

### Interfaz de Usuario

- Implementación de Material Design 3
- Componentes nativos de Android optimizados
- Sistema de navegación fluido entre pantallas
- Elementos interactivos como dropdowns, switches y checkboxes
- Esquema de colores coherente y accesible

## Solución de Problemas

### Errores de Sincronización de Gradle

```bash
# Limpiar cache de Gradle
./gradlew clean
./gradlew --refresh-dependencies
```

### Problemas de Compilación

1. Verificar la versión correcta de JDK instalada
2. Limpiar el proyecto: Build > Clean Project
3. Reconstruir el proyecto: Build > Rebuild Project

### Errores de API Level

- Verificar la instalación de Android SDK 34
- Revisar la configuración en `app/build.gradle.kts`
- Confirmar compatibilidad con dispositivo o emulador

## Contribución

### Proceso de Contribución

1. Realizar fork del proyecto
2. Crear una rama para la nueva funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Realizar commit de los cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Hacer push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abrir un Pull Request para revisión

### Estándares de Código

- Seguir las convenciones establecidas de Kotlin
- Utilizar nombres descriptivos para variables y funciones
- Documentar código complejo mediante comentarios
- Escribir tests unitarios para nuevas funcionalidades
- Mantener consistencia en el estilo de código

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo LICENSE para obtener más detalles sobre los términos de uso.

## Historial de Versiones

### Versión 1.0.0

- Implementación inicial de la aplicación
- Desarrollo de pantallas principales
- Sistema de navegación funcional
- Componentes de interfaz de usuario básicos
- Gestión de estados con Compose