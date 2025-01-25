package com.uma.wiki.controller;

import com.uma.wiki.dto.MapaCreateDTO;
import com.uma.wiki.dto.MapaResponseDTO;
import com.uma.wiki.dto.VisitaDTO;
import com.uma.wiki.service.MapaService;
import com.uma.wiki.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/examen")
@RestController
//@CrossOrigin(origins = "https://front-end-examen.vercel.app/")
@CrossOrigin(origins = "https://front-iw.vercel.app/")
public class MapController {

    @Autowired
    MapaService mapaService;

    @Autowired
    VisitaService visitaService;

    @GetMapping()
    public ResponseEntity<List<MapaResponseDTO>> getAll() {
        List<MapaResponseDTO> mapaResponseDTOS = mapaService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapaResponseDTOS);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<MapaResponseDTO>> getByEmail(@PathVariable String email) {
        List<MapaResponseDTO> mapaResponseDTO = mapaService.getByEmail(email);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(mapaResponseDTO);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MapaResponseDTO> createMapa(@ModelAttribute MapaCreateDTO mapaCreateDTO) {
        MapaResponseDTO newMapaResponseDTO = mapaService.createMapa(mapaCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newMapaResponseDTO);
    }

    @GetMapping("/visitas/{email}")
    public ResponseEntity<List<VisitaDTO>> getVisitasAutor(@PathVariable String email) {
        List<VisitaDTO> visitasDTO = visitaService.getVisitasByAutor(email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(visitasDTO);
    }

    @PostMapping("/visitas")
    public ResponseEntity<VisitaDTO> createVisita(@ModelAttribute VisitaDTO visitaDTO) {
        VisitaDTO newVisitaDTO = visitaService.crearVisita(visitaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newVisitaDTO);
    }
}
