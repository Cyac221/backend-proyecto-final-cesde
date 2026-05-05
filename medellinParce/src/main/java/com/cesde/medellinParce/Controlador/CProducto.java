package com.cesde.medellinParce.Controlador;

import com.cesde.medellinParce.Modelo.MProducto;
import com.cesde.medellinParce.Servicio.SProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class CProducto {
    @Autowired
    SProducto sProducto;

    // Adicionar producto
    @PostMapping
    public ResponseEntity<?> adicionarRegistroProducto(@RequestBody MProducto mProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sProducto.adicionarRegistroProducto(mProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general productos
    @GetMapping
    public ResponseEntity<?> consultaGeneralProducto() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaGeneralProducto());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID
    @GetMapping("/{idProducto}")
    public ResponseEntity<?> consultaIndividualID(@PathVariable String idProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaIndividualID(idProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por nombre
    @GetMapping("/nombre/{nombreProducto}")
    public ResponseEntity<?> consultaIndividualNombre(@PathVariable String nombreProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaIndividualNombre(nombreProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar producto
    @PutMapping("/{idProducto}")
    public ResponseEntity<?> modificarProducto(@PathVariable String idProducto, @RequestBody MProducto mProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.modificarProducto(idProducto, mProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar producto
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable String idProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.eliminarProducto(idProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
