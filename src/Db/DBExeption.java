package Db;

public class DBExeption extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DBExeption(String msg){
        super(msg);
    }
}
