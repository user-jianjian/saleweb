package passwordEncryptor;
import org.walkframework.shiro.util.password.DefaultPasswordEncryptor;
import org.walkframework.shiro.util.password.PasswordEncryptor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final PasswordEncryptor passwordEncryptor = new DefaultPasswordEncryptor();
		System.out.println(passwordEncryptor.encrypt("123456"));
	}

}
