package edu.utvt.alumnos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad que representa un alumno en el sistema académico.
 * <p>
 * Esta clase mapea la información de los alumnos registrados en la institución.
 * Contiene datos personales, información académica y un registro de auditoría
 * con la fecha de creación del registro.
 * </p>
 * <p>
 * Incluye índices en la base de datos para optimizar búsquedas por matrícula,
 * correo electrónico y estado activo.
 * </p>
 *
 * @author Sistema de Gestión de Alumnos
 * @version 1.0
 * @since 1.0
 */
@Data
@Entity
@Table(name = "alumnos", indexes = {
        @Index(name = "idx_matricula", columnList = "matricula"),
        @Index(name = "idx_correo_electronico", columnList = "correo_electronico"),
        @Index(name = "idx_activo", columnList = "activo")
})
public class Alumno {

    /**
     * Identificador único del alumno (clave primaria).
     * Se genera automáticamente mediante identidad de secuencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Matrícula única del alumno.
     * <p>
     * Formato: Cadena de hasta 20 caracteres.
     * Restricciones: No nula, única en la base de datos.
     * </p>
     */
    @Column(length = 20, nullable = false, unique = true)
    private String matricula;

    /**
     * Nombre completo o primer nombre del alumno.
     * <p>
     * Restricciones: No nula, máximo 100 caracteres.
     * </p>
     */
    @Column(length = 100, nullable = false)
    private String nombre;

    /**
     * Apellido paterno del alumno.
     * <p>
     * Restricciones: No nula, máximo 100 caracteres.
     * </p>
     */
    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno.
     * <p>
     * Restricciones: Opcional, máximo 100 caracteres.
     * </p>
     */
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;

    /**
     * Correo electrónico del alumno.
     * <p>
     * Restricciones: No nula, única en la base de datos, máximo 255 caracteres.
     * </p>
     */
    @Column(name = "correo_electronico", length = 255, nullable = false, unique = true)
    private String correoElectronico;

    /**
     * Número telefónico del alumno.
     * <p>
     * Restricciones: Opcional, máximo 10 caracteres.
     * </p>
     */
    @Column(length = 10)
    private String telefono;

    /**
     * Fecha de nacimiento del alumno.
     * <p>
     * Restricciones: No nula.
     * </p>
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /**
     * Carrera o programa académico en el que está inscrito el alumno.
     * <p>
     * Restricciones: No nula, máximo 100 caracteres.
     * </p>
     */
    @Column(length = 100, nullable = false)
    private String carrera;

    /**
     * Semestre académico actual del alumno.
     * <p>
     * Restricciones: No nula.
     * </p>
     */
    @Column(nullable = false)
    private Integer semestre;

    /**
     * Indica si el alumno está activo en el sistema.
     * <p>
     * Valor por defecto: {@code true}
     * Restricciones: No nula.
     * </p>
     */
    @Column(nullable = false)
    private boolean activo = true;

    /**
     * Fecha y hora de registro del alumno en el sistema.
     * <p>
     * Se establece automáticamente al momento de la creación del registro.
     * Restricciones: No nula, no actualizable.
     * </p>
     */
    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;
}
