package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int index = 0; index < users.length; index++) {
            if (!login.equals(users[index].getUsername())) {
                throw new UserNotFoundException();
            }
            user = users[index];
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("The user is not valid");
        } catch (UserNotFoundException un) {
            System.out.println("User is not found");
        }
    }
}
