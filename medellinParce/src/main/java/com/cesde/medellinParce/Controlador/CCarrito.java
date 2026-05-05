package com.cesde.medellinParce.Controlador;

import com.cesde.medellinParce.Modelo.MCarrito;
import com.cesde.medellinParce.Servicio.SCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carritos")
@CrossOrigin(origins = "*")
public class CCarrito {
    @Autowired
    SCarrito sCarrito;

    // Adicionar carrito
    @PostMapping
    public ResponseEntity<?> adicionarRegistroCarrito(@RequestBody MCarrito mCarrito) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sCarrito.adicionarRegistroCarrito(mCarrito));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general carritos
    @GetMapping
    public ResponseEntity<?> consultaGeneralCarrito() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarrito.consultaGeneralCarrito());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID
    @GetMapping("/{idCarrito}")
    public ResponseEntity<?> consultaIndividualID(@PathVariable String idCarrito) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarrito.consultaIndividualID(idCarrito));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar carrito
    @PutMapping("/{idCarrito}")
    public ResponseEntity<?> modificarCarrito(@PathVariable String idCarrito, @RequestBody MCarrito mCarrito) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarrito.modificarCarrito(idCarrito, mCarrito));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar carrito
    @DeleteMapping("/{idCarrito}")
    public ResponseEntity<?> eliminarCarrito(@PathVariable String idCarrito) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarrito.eliminarCarrito(idCarrito));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
