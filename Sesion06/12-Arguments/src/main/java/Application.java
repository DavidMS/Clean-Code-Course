import utils.ArgsException;

public class Application {

    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean loggin = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(loggin, port, directory);
        } catch(ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }

    private static void executeApplication(boolean loggin, int port, String directory) {
        if(loggin) {
            System.out.printf("Logging application on port %d and directory %s", port, directory);
        }
        else {
            System.out.printf("NOT Logging application on port %d and directory %s", port, directory);
        }
    }


}
