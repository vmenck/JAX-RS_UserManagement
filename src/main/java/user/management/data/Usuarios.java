package user.management.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios {

	@XmlElement(name="usuarios")
	private List<Usuario> users;
	
	public Usuarios(){
		this.loadUsuarios();
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	
	private void loadUsuarios()
	{
		users = new ArrayList<Usuario>();
		
		users.add(new Usuario("John Mayer","jmayer", "j123"));
		users.add(new Usuario("Bono Vox","bvox", "b123"));
		users.add(new Usuario("Adan Levine","alevine", "a123"));
		users.add(new Usuario("Norah Jones","njones", "n123"));
		users.add(new Usuario("Paul McCartney","pmaccartney", "n123"));
		users.add(new Usuario("Eric Clapton","eclapton", "e123"));
		users.add(new Usuario("Stevie Wonder","swonder", "s123"));
	}
}
