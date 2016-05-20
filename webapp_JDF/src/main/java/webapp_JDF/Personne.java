package webapp_JDF;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Personne {

	private String mdp;
	private String mdpcomfirme;
	private String email;
	private String SiteWeb;
	private Boolean VuApprouve;

	public Personne(String mdp, String mdpcomfirme, String email, String siteWeb) {
		super();
		this.mdp = mdp;
		this.mdpcomfirme = mdpcomfirme;
		this.email = email;
		SiteWeb = siteWeb;
	}
	
	public Personne() {
		
	}
	
	public boolean getVuApprouve() {
		return VuApprouve;
	}

	public void setVuApprouve(Boolean vuApprouve) {
		VuApprouve = vuApprouve;
	}

	public String getmdp() {
		return mdp;
	}

	public void setmdp(String mdp) {
		this.mdp = mdp;
	}

	public String getmdpcomfirme() {
		return mdpcomfirme;
	}

	public void setmdpcomfirme(String mdpcomfirme) {
		this.mdpcomfirme = mdpcomfirme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiteWeb() {
		return SiteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		SiteWeb = siteWeb;
	}

}