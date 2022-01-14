package dao;

public class UsuarioDao 
{
    public static boolean validar(String username, String pass)
    {
        return (username.equals("Admin") && pass.equals("eco123"));
    }
}
