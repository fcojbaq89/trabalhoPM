package br.unirio.bsi.pm.capes.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import br.unirio.bsi.pm.capes.model.Programa;

public class TestCapes  {
	
    @Test
    public void TestNomePrograma() throws ParserConfigurationException, SAXException, IOException {
    	Programa programa = new Programa();
    	programa.setNome(programa.leXml());
        assertEquals("PPGI-UNIRIO", programa.getNome());
    }
	
	@Test
    public void TestNumeroLinhasPrograma() throws ParserConfigurationException, SAXException, IOException {
		Programa programa = new Programa();
    	programa.setNome(programa.leXml());
        assertEquals(3, programa.getLinhas().size());
    }
	
	@Test
    public void TestNumeroProfessoresTerceraLinha() throws ParserConfigurationException, SAXException, IOException{
		Programa programa = new Programa();
    	programa.setNome(programa.leXml());
        assertEquals(7, programa.getLinhas().get(0).getProfessores().size());
    }
}
