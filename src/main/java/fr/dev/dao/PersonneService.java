package fr.dev.dao;

import fr.dev.entities.Personne;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.Collection;

public interface PersonneService {
    public Collection<Personne> allPersone();

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException;

}
