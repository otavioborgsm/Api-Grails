package api

class Empregado {
    String nome
    String sobrenome

    static belongsTo = [departamento: Departamento]

    static constraints = {
    }
}
