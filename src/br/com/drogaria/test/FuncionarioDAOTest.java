package br.com.drogaria.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("111.111.111-11");
		funcionario.setFuncao("ADMINISTRADOR");
		funcionario.setNome("JOAO DA SILVA");
		funcionario.setSenha("q1w2e3r4");

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(3L);

		System.out.println(funcionario);
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(3L);

		dao.excluir(funcionario);
		;

	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(3L);

		funcionario.setCpf("444.444.444-44");
		funcionario.setFuncao("USUARIO");
		funcionario.setNome("JOSE DA SILVA");
		funcionario.setSenha("q1w2e3r4t5y6");

		dao.editar(funcionario);
	}

	@Test
	@Ignore
	public void autenticar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.autenticar("222.222.222-22",
				"q1w2e3r4");

		System.out.println("Funcionario: " + funcionario);

		Assert.assertNotNull(funcionario);
	}
}
