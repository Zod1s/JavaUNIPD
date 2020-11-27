public class Padlock{
    private String pw;
    private boolean closed;
    public Padlock(){
        pw = "0000";
        closed = false;
    }

    public Padlock(String pw){
        if (pw != null && pw != ""){
            this.pw = pw;
        }
        else{
            this.pw = "0000";
        }
        closed = false;
    }

    public void close(){
        closed = true;
    }

    public void open(String pw){
        if (this.pw == pw){
            closed = false;
        }
    }

    public void setPasswd(String oldPw, String newPw){
        if (pw == oldPw && newPw != null && newPw != ""){
            pw = newPw;
        }
    }

    public String toString(){
        if (closed){
            return "Lock close";
        }
        else{
            return "Lock open";
        }
    }
}

