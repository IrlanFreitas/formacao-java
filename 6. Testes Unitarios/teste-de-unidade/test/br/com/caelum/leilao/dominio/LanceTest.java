package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class LanceTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDevePermitirLanceIgualaZero() {
		
		new Lance(new Usuario("Irlan"), 0.0);
		Assert.fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDevePermitirLanceMenorQueZero() {
		
		new Lance(new Usuario("Irlan"), -10.0);
		Assert.fail();
	}
}
