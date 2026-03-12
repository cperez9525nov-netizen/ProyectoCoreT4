package com.emergencias.detector;

// Importamos el Enum que está dentro de EmergencyDetector
import com.emergencias.detector.EmergencyDetector.TipoEmergencia;

public class SeverityAnalizer {

    public enum NivelSeveridad {
        BAJA, MEDIA, ALTA, CRITICA, NULA
    }

    public NivelSeveridad evaluateSeverity(TipoEmergencia tipo, double magnitud) {
        return switch (tipo) {
            case INCENDIO -> {
                if (magnitud > 80) yield NivelSeveridad.CRITICA;
                if (magnitud > 45) yield NivelSeveridad.ALTA;
                if (magnitud > 25) yield NivelSeveridad.MEDIA;
                yield NivelSeveridad.BAJA;
            }
            case EXPLOSION -> {
                if (magnitud > 2.0) yield NivelSeveridad.CRITICA;
                if (magnitud > 0.5) yield NivelSeveridad.ALTA;
                yield NivelSeveridad.MEDIA;
            }
            case ACCIDENTE -> {
                if (magnitud > 80) yield NivelSeveridad.CRITICA;
                if (magnitud > 50)  yield NivelSeveridad.ALTA;
                yield NivelSeveridad.BAJA;
            }
            case INUNDACION -> {
                if (magnitud > 3.0) yield NivelSeveridad.CRITICA;
                if (magnitud > 1.0) yield NivelSeveridad.ALTA;
                yield NivelSeveridad.MEDIA;
            }
            default -> NivelSeveridad.NULA;
        };
    }
}