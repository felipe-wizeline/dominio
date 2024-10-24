package com.example.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dominio")
public class DominioController {

    private final DataService dataService;

    DominioController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody RequestModel request) {
        try {
            DataModel data = new DataModel();
            data.setData(request.getData());
            dataService.save(data);
            return new ResponseEntity<>("Datos guardados correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar los datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
    