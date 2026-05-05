package com.cesde.medellinParce.Controlador;

import com.cesde.medellinParce.Modelo.MOrdenCompra;
import com.cesde.medellinParce.Servicio.SOrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenCompra")
@CrossOrigin(origins = "*")
public class COrdenCompra {
    @Autowired
    SOrdenCompra sOrdenCompra;

    // Adicionar orden de compra
    @PostMapping
    public ResponseEntity<?> adicionarRegistroOrdenCompra(@RequestBody MOrdenCompra mOrdenCompra) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sOrdenCompra.adicionarRegistroOrdenCompra(mOrdenCompra));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general ordenes de compra
    @GetMapping
    public ResponseEntity<?> consultaGeneralOrdenCompra() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sOrdenCompra.consultaGeneralOrdenCompra());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID
    @GetMapping("/{idCompra}")
    public ResponseEntity<?> consultaIndividualID(@PathVariable String idCompra) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sOrdenCompra.consultaIndividualID(idCompra));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar orden de compra
    @PutMapping("/{idCompra}")
    public ResponseEntity<?> modificarOrdenCompra(@PathVariable String idCompra, @RequestBody MOrdenCompra mOrdenCompra) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sOrdenCompra.modificarOrdenCompra(idCompra, mOrdenCompra));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar orden de compra
    @DeleteMapping("/{idCompra}")
    public ResponseEntity<?> eliminarOrdenCompra(@PathVariable String idCompra) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sOrdenCompra.eliminarOrdenCompra(idCompra));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
