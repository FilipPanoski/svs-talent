package library.member;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterMember {

    public Member registerNewMember(Scanner scanner){
        System.out.println("Registering a new member...");

        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();

        System.out.print("Enter member surname: ");
        String memberSurname = scanner.nextLine();

        System.out.println(memberName + " " + memberSurname + " has been registered!");

        return new Member(memberName, memberSurname);
    }
}
