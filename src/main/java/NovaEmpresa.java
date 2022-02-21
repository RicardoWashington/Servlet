

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando uma empresa nova");
		
		String name = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		
		Empresa empresa = new Empresa();
		empresa.setNome(name);
		empresa.setCnpj(cnpj);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		for (Empresa emp : banco.getEmpresas()) {
			System.out.println(name);
			System.out.println(cnpj);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa "+ name + "- CNPJ: "+ cnpj + " .Cadastrado com sucesso.");
		
	}

}
