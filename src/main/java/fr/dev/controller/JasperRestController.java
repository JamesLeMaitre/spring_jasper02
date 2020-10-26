package fr.dev.controller;

import fr.dev.dao.PersonneServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class JasperRestController {
    @Autowired
    private PersonneServiceImpl personneService;

    @GetMapping("/report/{format}")
    public String generatedFormat(@PathVariable  String format) throws FileNotFoundException, JRException {
        return personneService.exportReport(format);
    }

}
