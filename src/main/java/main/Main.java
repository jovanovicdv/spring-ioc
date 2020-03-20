package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyConfig;
import domain.User;
import service.UserService;

@Component(value = "main")
public class Main {
	
	@Autowired
	private UserService userService;
	
	
	

	public static void main(String[] args) {
		//kreirairati kontejner
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		//iz kontejnera uzeti main objekat
		Main main = container.getBean("main", Main.class);
		
		
		//dohvatim user i posatavim vrednosti....
		User user1 = container.getBean("user", User.class);
		user1.setFirstname("Pera-1");
		user1.setLastname("Peric-1");
		user1.setUsername("pera");
		user1.setPassword("pera");
		System.out.println(user1);
		//pozvati metodu: void addUser(User user)
		main.addUser(user1, "linked");
		
		
		User user2 = container.getBean("user", User.class);
		user2.setFirstname("Pera-2");
		user2.setLastname("Peric-2");
		user2.setUsername("pera");
		user2.setPassword("pera");
		System.out.println(user2);
		//pozvati metodu: void addUser(User user)
		main.addUser(user2, "array");
		
		
		//pozovem metodu: void printUsers()
		main.printUsers();
	}
	
	void addUser(User user, String type) {
		//poziv service-a
		System.out.println("===========void addUser(UserService userService, User user)==========");
		userService.save(user, type);
	}
	void printUsers() {
		userService.print();
	}
	
	

}
