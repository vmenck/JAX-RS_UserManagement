package user.management.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios {

	@XmlElementWrapper(name="usuarios")
	@XmlElement(name="usuario")
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
	
	private void loadUsuarios(){
		users = new ArrayList<Usuario>();
		
		users.add(new Usuario(1,"John Mayer","jmayer", "j123"));
		users.add(new Usuario(2,"Bono Vox","bvox", "b123"));
		users.add(new Usuario(3,"Adan Levine","alevine", "a123"));
		users.add(new Usuario(4,"Norah Jones","njones", "n123"));
		users.add(new Usuario(5,"Paul McCartney","pmaccartney", "n123"));
		users.add(new Usuario(6,"Eric Clapton","eclapton", "e123"));
		users.add(new Usuario(7,"Stevie Wonder","swonder", "s123"));
	}
	
	public Usuario findById(Integer id){
		Usuario selected = new Usuario();
		for(Usuario u : users)
		{
			if(u.getId().equals(id))
			{
				selected = u;
				break;
			}
		}
		return selected;
	}
}
