public class HolaTodos {
    public static void main(String[] args) {
        String SaludoFrom = args[0];
        String Respuesta = Saludar(SaludoFrom);
        System.out.println(Respuesta);
    }

    public static String Saludar(String Saludo) {
        return Saludo + " HolaAs400";
    }
}
