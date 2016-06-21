package br.unirio.bsi.pm.capes.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import br.unirio.bsi.pm.capes.model.Linha;
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
        assertEquals(3, Linha.leXml().size());
    }
	
	@Test
    public void TestNumeroProfessoresTerceraLinha() throws ParserConfigurationException, SAXException, IOException{
        assertEquals(7, Linha.leXml().get(2).getProfessores().size());
    }
}
