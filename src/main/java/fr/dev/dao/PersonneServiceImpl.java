package fr.dev.dao;

import fr.dev.entities.Personne;
import fr.dev.repository.PersonneRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Collection<Personne> allPersone() {
        return personneRepository.findAll();
    }

    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        Collection<Personne> personnes = personneRepository.findAll();

        File file = ResourceUtils.getFile("classpath:personne.jrxml");
        JasperDesign jasperDesign;
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(personnes);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreateBy", "self@Dev");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        String path = "C:\\Users\\James\\Desktop\\Report";
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+ "\\personne.html");
        }
            if(reportFormat.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToPdfFile(jasperPrint, path+ "\\personne.pdf");

            }
        return "rapport généré dans la dossier : "+path;
    }
}
