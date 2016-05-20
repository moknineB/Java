package webapp_JDF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@RequestScoped
public class PersonneControleur {

	@Resource(name = "JEE_09")
	private DataSource dataSource;

	private Personne personne = new Personne();

	public PersonneControleur() {
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String enregistrer() throws SQLException {

		if (dataSource == null)
			throw new SQLException("Can't get data source");

		String request = "insert into adherent (email, motDePasse, siteWeb, dateAdhesion) values (?, ?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
				java.sql.PreparedStatement pstmt = connection.prepareStatement(request);) {

			pstmt.setString(1, personne.getEmail());
			pstmt.setString(2, personne.getmdp());
			pstmt.setString(3, personne.getSiteWeb());
			pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "subscription_success";
	}

	public List<Personne> getListePersonne() throws SQLException {
		List<Personne> list = new ArrayList<Personne>();
		if (dataSource == null)
			throw new SQLException("Can't get data source");
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("select email, siteWeb from Adherent");) {
			ResultSet result = pstmt.executeQuery();
			
			while (result.next()) {
				Personne UnePersonne = new Personne();

				UnePersonne.setEmail(result.getString("email"));
				UnePersonne.setSiteWeb(result.getString("siteWeb"));

				// store all data into a List
				list.add(UnePersonne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}