package br.com.drogaria.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;
import br.com.drogaria.filter.VendaFilter;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(222.34D));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();

		List<Venda> vendas = vendaDAO.Listar();

		System.out.println(vendas);
	}

	@Test
	@Ignore
	public void buscaPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(2L);

		System.out.println(venda);
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(2L);

		vendaDAO.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(2L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(7L);

		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(12.34D));
		venda.setFuncionario(funcionario);

		vendaDAO.editar(venda);
	}

	@Test
	@Ignore
	public void buscar() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		VendaFilter filtro = new VendaFilter();
		filtro.setDataInicial(formato.parse("29/01/2015"));
		filtro.setDataFinal(formato.parse("16/02/2015"));

		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> vendas = vendaDAO.buscar(filtro);

		for (Venda venda : vendas) {
			System.out.println(venda);
		}
	}
}
