package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	private Funcionario funcionarioCadastro;

	private List<Funcionario> listaFuncionarios;
	private List<Funcionario> listaFuncionariosFiltrados;

	private String acao;
	private Long codigo;

	public Funcionario getFuncionarioCadastro() {
		return funcionarioCadastro;
	}

	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Funcionario> getListaFuncionariosFiltrados() {
		return listaFuncionariosFiltrados;
	}

	public void setListaFuncionariosFiltrados(
			List<Funcionario> listaFuncionariosFiltrados) {
		this.listaFuncionariosFiltrados = listaFuncionariosFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void novo() {
		funcionarioCadastro = new Funcionario();
	}

	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioCadastro.setSenha(DigestUtils.md5Hex(funcionarioCadastro
					.getSenha()));
			funcionarioDAO.salvar(funcionarioCadastro);

			funcionarioCadastro = new Funcionario();

			FacesUtil.adicionaMsgInfo("Funcionário salvo com sucesso.");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os funcionários:"
					+ ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listaFuncionarios = funcionarioDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os funcionários:"
					+ ex.getMessage());
		}
	}

	public void carregarCadastro() {

		try {
			if (codigo != null) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioCadastro = funcionarioDAO.buscarPorCodigo(codigo);
			} else {
				funcionarioCadastro = new Funcionario();
			}
		} catch (RuntimeException ex) {
			FacesUtil
					.adicionarMsgErro("Erro ao tentar obter os dados do funcionário:"
							+ ex.getMessage());
		}
	}

	public void excluir() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);

			FacesUtil.adicionaMsgInfo("Funcionário removido com sucessos.");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover o funcionário:"
					+ ex.getMessage());
		}
	}

	public void editar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioCadastro.setSenha(DigestUtils.md5Hex(funcionarioCadastro
					.getSenha()));
			funcionarioDAO.editar(funcionarioCadastro);

			FacesUtil.adicionaMsgInfo("Funcionário editado com sucesso.");
		} catch (RuntimeException ex) {
			FacesUtil
					.adicionarMsgErro("Erro ao tentar editar os dados do funcionário:");
		}
	}
}
