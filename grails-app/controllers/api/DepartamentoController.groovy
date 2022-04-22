package api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepartamentoController {

    DepartamentoService departamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond departamentoService.list(params), model:[departamentoCount: departamentoService.count()]
    }

    def show(Long id) {
        respond departamentoService.get(id)
    }

    def create() {
        respond new Departamento(params)
    }

    def save(Departamento departamento) {
        if (departamento == null) {
            notFound()
            return
        }

        try {
            departamentoService.save(departamento)
        } catch (ValidationException e) {
            respond departamento.errors, view:'create'
            return
        }


        respond departamento, [status: CREATED, view:"show"]
    }


    def update(Departamento departamento) {
        if (departamento == null) {
            notFound()
            return
        }

        try {
            departamentoService.save(departamento)
        } catch (ValidationException e) {
            respond departamento.errors, view:'edit'
            return
        }

        respond departamento, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        departamentoService.delete(id)

        render status: NO_CONTENT
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'departamento.label', default: 'Departamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
