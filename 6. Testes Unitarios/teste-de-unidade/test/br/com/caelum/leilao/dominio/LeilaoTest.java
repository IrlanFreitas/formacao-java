package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LeilaoTest {
	
	@Test
	public void recebeApenasUmLance() {
		Leilao leilao = new Leilao("iPhone 12");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Irlan"), 1000.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void recebeVariosLances() {
		Leilao leilao = new Leilao("iPhone 12");
		
		leilao.propoe(new Lance(new Usuario("Irlan"), 1000.0));
		leilao.propoe(new Lance(new Usuario("Pedro"), 2000.0));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(0).getValor(), 0.00001); 
		assertEquals(2000.0, leilao.getLances().get(1).getValor(), 0.00001); 
	}	
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 17,5");
		
		Usuario usuario = new Usuario("Irlan");
		
		leilao.propoe(new Lance(usuario, 2000.0));
		leilao.propoe(new Lance(usuario, 2500.0));
		leilao.propoe(new Lance(usuario, 2500.0));
		leilao.propoe(new Lance(usuario, 2500.0));
		leilao.propoe(new Lance(usuario, 2500.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001); 
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 17,5");
		
		Usuario irlan = new Usuario("Irlan");
		Usuario pedro = new Usuario("Pedro");
		
		leilao.propoe(new Lance(irlan, 2000.0));
		leilao.propoe(new Lance(pedro, 2500.0));
		
		leilao.propoe(new Lance(irlan, 5000.0));
		leilao.propoe(new Lance(pedro, 5500.0));
		
		leilao.propoe(new Lance(irlan, 7500.0));
		leilao.propoe(new Lance(pedro, 9500.0));
		
		leilao.propoe(new Lance(irlan, 12500.0));
		leilao.propoe(new Lance(pedro, 14500.0));
		
		leilao.propoe(new Lance(irlan, 16500.0));
		leilao.propoe(new Lance(pedro, 18500.0));
		
		//Devem ser ignorados
		leilao.propoe(new Lance(irlan, 25000.0));
		leilao.propoe(new Lance(pedro, 27500.0));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(18500.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.00001); 
	}
	
	@Test
	public void verificarSeUltimoLanceFoiDobrado() {
		Leilao leilao = new Leilao("Macbook Pro 17,5");
		
		Usuario irlan = new Usuario("Irlan");
		Usuario pedro = new Usuario("Pedro");
		
		leilao.propoe(new Lance(irlan, 16500.0));
		leilao.propoe(new Lance(pedro, 18500.0));
		
		leilao.propoe(new Lance(irlan, 2000.0));
		leilao.propoe(new Lance(pedro, 2500.0));
		
		leilao.propoe(new Lance(irlan, 5000.0));
		leilao.propoe(new Lance(pedro, 5500.0));
		
		leilao.propoe(new Lance(irlan, 7000.0));
		leilao.propoe(new Lance(pedro, 9500.0));

		leilao.dobraUltimoLanceDo(irlan);
		
		assertEquals(7000.0 * 2 , leilao.getLances().get(leilao.getLances().size() -1).getValor());
	}
	
	@Test
	public void verificarSeUltimoLanceFoiDobradoComListaVazia() {
		Leilao leilao = new Leilao("Macbook Pro 17,5");
		
		Usuario irlan = new Usuario("Irlan");
		
		leilao.dobraUltimoLanceDo(irlan);
		
		assertEquals(0 , leilao.getLances().size());
	}
	
	
}
