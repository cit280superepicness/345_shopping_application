package javaBeans;

public class User implements java.io.Serializable {
    private int userID = 0;
    private String userUsername = "";
    private String userPassword = "";
    private String userFName = "";
    private String userLName = "";
    private String userInitial = "";
    private String userDOB = "";
    private String userAddress = "";
    private String userCity = "";
    private String userStateProvince = "";
    private String userCountry = "";
    private String userZIP = "";
    private String userAreaCode = "";
    private String userPhone = "";
    private String userCardNumber = "";
    private int userIsVendor;
    private boolean loggedIn;
    
    public User(){
    }
    
    public User(int u_id, String u_name, String u_pass, String u_fn, String u_ln, String u_init, String u_dob, String u_add, String u_city, String u_sp, String u_co, String u_zip, String u_area, String u_ph, String u_cn, int u_iv){
        setUserID(u_id);
        setUserUsername(u_name);
        setUserPassword(u_pass);
        setUserFName(u_fn);
        setUserLName(u_ln);
        setUserInitial(u_init);
        setUserDOB(u_dob);
        setUserAddress(u_add);
        setUserCity(u_city);
        setUserStateProvince(u_sp);
        setUserCountry(u_co);
        setUserZIP(u_zip);
        setUserAreaCode(u_area);
        setUserPhone(u_ph);
        setUserCardNumber(u_cn);
        setUserIsVendor(u_iv);
        setLoggedIn(false);
    }
    
    public int getUserID(){
        return(userID);
    }
    
    public final void setUserID(int uID){
        userID = uID;
    }
    
    public String getUserUsername(){
        return(userUsername);
    }
    
    public final void setUserUsername(String uName){
        userUsername = uName;
    }
    
    public String getUserPassword(){
        return(userPassword);
    }
    
    public final void setUserPassword(String uPass){
        userPassword = uPass;
    }
    
    public String getUserFName(){
        return(userFName);
    }
    
    public final void setUserFName(String uFName){
        userFName = uFName;
    }
    
    public String getUserLName(){
        return(userLName);
    }
    
    public final void setUserLName(String uLName){
        userLName = uLName;
    }
    
    public String getUserInitial(){
        return(userInitial);
    }
    
    public final void setUserInitial(String uInitial){
        userInitial = uInitial;
    }
    
    public String getUserDOB(){
        return(userDOB);
    }
    
    public final void setUserDOB(String uDOB){
        userDOB = uDOB;
    }
    
    public String getUserAddress(){
        return(userAddress);
    }
    
    public final void setUserAddress(String uAddress){
        userAddress = uAddress;
    }
    
    public String getUserCity(){
        return(userCity);
    }
    
    public final void setUserCity(String uCity){
        userCity = uCity;
    }
    
    public String getUserStateProvince(){
        return(userStateProvince);
    }
    
    public final void setUserStateProvince(String uStateProvince){
        userStateProvince = uStateProvince;
    }
    
    public String getUserCountry(){
        return(userCountry);
    }
    
    public final void setUserCountry(String uCountry){
        userCountry = uCountry;
    }
    
    public String getUserZIP(){
        return(userZIP);
    }
    
    public final void setUserZIP(String uZIP){
        userZIP = uZIP;
    }
    
    public String getUserAreaCode(){
        return(userAreaCode);
    }
    
    public final void setUserAreaCode(String uAreaCode){
        userAreaCode = uAreaCode;
    }
    
    public String getUserPhone(){
        return(userPhone);
    }
    
    public final void setUserPhone(String uPhone){
        userPhone = uPhone;
    }
    
    public String getUserCardNumber(){
        return(userCardNumber);
    }
    
    public final void setUserCardNumber(String uCardNumber){
        userCardNumber = uCardNumber;
    }
    
    public int getUserIsVendor(){
        return(userIsVendor);
    }
    
    public final void setUserIsVendor(int uIsVendor){
        userIsVendor = uIsVendor;
    }
    
    public final void setLoggedIn(boolean log) {
        loggedIn = log;
    }
    
    public boolean getLoggedIn() {
        return(loggedIn);
    }
}
