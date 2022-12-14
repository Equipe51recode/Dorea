package controllersOrganizador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrganizadorDAO;
import model.Organizador;

@WebServlet("/createAdmAndFind")
public class OrganizadorCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public OrganizadorCreateAndFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Organizador organizador = new Organizador();
		organizador.setNome(request.getParameter("nome"));
		organizador.setCnpj(request.getParameter("cnpj"));
		organizador.setEmail(request.getParameter("email"));
		organizador.setTelefone(request.getParameter("telefone"));
		organizador.setSenha(request.getParameter("senha"));
		OrganizadorDAO.criarOrganizador(organizador);
		response.sendRedirect("pages/loginAdm.html");
	}

}
