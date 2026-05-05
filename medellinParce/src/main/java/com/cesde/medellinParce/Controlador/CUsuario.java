package com.cesde.medellinParce.Controlador;

import com.cesde.medellinParce.Modelo.MUsuario;
import com.cesde.medellinParce.Servicio.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class CUsuario {
    @Autowired
    SUsuario sUsuario;

    // Adicionar usuario
    @PostMapping
    public ResponseEntity<?> adicionarRegistroUsuario(@RequestBody MUsuario mUsuario) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sUsuario.adicionarRegistroUsuario(mUsuario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general usuarios
    @GetMapping
    public ResponseEntity<?> consultaGeneralUsuario() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaGeneralUsuario());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<?> consultaIndividualID(@PathVariable String idCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaIndividualID(idCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por nombre
    @GetMapping("/nombre/{nombreCliente}")
    public ResponseEntity<?> consultaIndividualNombre(@PathVariable String nombreCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.consultaIndividualNombre(nombreCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar usuario
    @PutMapping("/{idCliente}")
    public ResponseEntity<?> modificarUsuario(@PathVariable String idCliente, @RequestBody MUsuario mUsuario) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.modificarUsuario(idCliente, mUsuario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar usuario
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String idCliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sUsuario.eliminarUsuario(idCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
