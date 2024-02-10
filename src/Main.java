public class Main {
    public static void main(String[] args) {
        String str = null;

        try {
            int res = Integer.decode("12345c1");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}