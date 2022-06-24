package com.example.ejercico13.procesos;

public class Personas {
    //NOMBRE DE LA BASE DE DATOS
    public static final String  NameDataBase = "PM1";
    //crear nombres estaticos
    public final static String tablaEmpleados = "empleados";

    //campos de la tabla empleados
    public static final String id ="id";
    public static final String nombres ="nombres";
    public static final String apellidos ="apellidos";
    public static final String edad ="edad";
    public static final String correo ="correo";
    public static final String direccion ="direccion";

    //hacer las sentencias sql para crear las tablas
    public static final String CreateTableEmpleados = "CREATE TABLE empleados " +
            "(id INTEGER PRIMARY KET AUTOINCREMENT," +
            "nombres TEXT, apellidos TEXT, edad INTEGER, " +
            "correo TEXT, direccion TEXT)";

    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";

}
