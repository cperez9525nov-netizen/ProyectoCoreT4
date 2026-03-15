Estrategia de Persistencia del Proyecto:

Ficheros JSON (resources/): Utilizados para la persistencia de datos maestros (hospitales)
y perfil clínico del usuario. Ventaja: Fácil portabilidad y configuración sin dependencias externas.

Ficheros Log (.txt): Utilizados para la persistencia histórica de alertas. La ventaja sería el
Registro inmutable para auditoría policial.

Base de Datos (Escalabilidad futura): Se plantea su uso para el almacenamiento masivo de incidencias
y análisis estadístico en tiempo real, donde los ficheros planos serían ineficientes.