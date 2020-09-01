public class BinaryConverter {
    
    public static void main(String[] args){
        for(int i = -5; i < 33; i++){
            System.out.println(i + ": " + toBinary(i));
            System.out.println(i);
            //always another way
            System.out.println(i + ": " + Integer.toBinaryString(i));
        }
    }
    
    /*
     * pre: none
     * post: returns a String with base10Num in base 2
     */
    public static String toBinary(int base10Num){
        boolean isNeg = base10Num < 0;
        base10Num = Math.abs(base10Num);        
        String result = "";
        
        while(base10Num > 1){
            result = (base10Num % 2) + result;
            base10Num /= 2;
        }
        assert base10Num == 0 || base10Num == 1 : "value is not <= 1: " + base10Num;
        
        result = base10Num + result;
        assert all0sAnd1s(result);
        
        if( isNeg )
            result = "-" + result;
        return result;
    }
    
    /*
     * pre: cal != null
     * post: return true if val consists only of characters 1 and 0, false otherwise
     */
    public static boolean all0sAnd1s(String val){
        assert val != null : "Failed precondition all0sAnd1s. parameter cannot be null";
        boolean all = true;
        int i = 0;
        char c;
        
        while(all && i < val.length()){
            c = val.charAt(i);
            all = c == '0' || c == '1';
            i++;
        }
        return all;
    }
}
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
    }
}

String DRIVER = "com.ora.jdbc.Driver";
String DataURL = "jdbc:db://localhost:5112/users";
String LOGIN = "admin"; String PASSWORD = "admin123";
Class.forName(DRIVER);

//Make'connection'to'DB'Connection'
connection = DriverManager.getConnection(DataURL, LOGIN, PASSWORD);
String Username = request.getParameter("USER");
String Password = request.getParameter("PASSWORD");
int iUserID = Y1;
String sLoggedUser = "";
String sel = "SELECT User_id, Username FROM USERS WHERE Username = '" +Username + "' AND Password = '" +
Password + "'";
Statement selectStatement = connection.createStatement ();
ResultSet resultSet = selectStatement.executeQuery(sel);
if (resultSet.next()) {
	iUserID = resultSet.getInt(1);
	sLoggedUser = resultSet.getString(2);
}
PrintWriter writer = response.getWriter ();
if (iUserID >= 0) {
writer.println ("User logged in: " + sLoggedUser);
} else {
	writer.println ("Access Denied!");
}
