package homework;

public class HWException {
    public static final String REGEX = "^[a-zA-z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth("login", "123", "123");
            System.out.println("Все отлично");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Регистрация не пройдена");
        }
    }

    private static void checkAuth(String login, String password, String confirmPassword) throws WrongLoginException,
            WrongPasswordException {
        if (!login.matches(REGEX) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!password.matches(REGEX) || password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}
