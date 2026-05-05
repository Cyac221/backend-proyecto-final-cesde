package com.cesde.medellinParce.Controlador;

import com.cesde.medellinParce.Modelo.MCarritoItems;
import com.cesde.medellinParce.Servicio.SCarritoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carritoItems")
@CrossOrigin(origins = "*")
public class CCarritoItems {
    @Autowired
    SCarritoItems sCarritoItems;

    // Adicionar carritoItem
    @PostMapping
    public ResponseEntity<?> adicionarRegistroCarritoItems(@RequestBody MCarritoItems mCarritoItems) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sCarritoItems.adicionarRegistroCarritoItems(mCarritoItems));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general carritoItems
    @GetMapping
    public ResponseEntity<?> consultaGeneralCarritoItems() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarritoItems.consultaGeneralCarritoItems());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID compuesto
    @GetMapping("/{idProductoFK}/{idCarritoFK}")
    public ResponseEntity<?> consultaIndividualID(@PathVariable String idProductoFK, @PathVariable String idCarritoFK) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarritoItems.consultaIndividualID(idProductoFK, idCarritoFK));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar carritoItem
    @PutMapping("/{idProductoFK}/{idCarritoFK}")
    public ResponseEntity<?> modificarCarritoItems(@PathVariable String idProductoFK, @PathVariable String idCarritoFK, @RequestBody MCarritoItems mCarritoItems) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarritoItems.modificarCarritoItems(idProductoFK, idCarritoFK, mCarritoItems));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar carritoItem
    @DeleteMapping("/{idProductoFK}/{idCarritoFK}")
    public ResponseEntity<?> eliminarCarritoItems(@PathVariable String idProductoFK, @PathVariable String idCarritoFK) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCarritoItems.eliminarCarritoItems(idProductoFK, idCarritoFK));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
