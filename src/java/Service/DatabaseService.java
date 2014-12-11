/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataType.Post;
import DataType.User;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.firebase.client.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author timothy.pratama
 */
@WebService(serviceName = "DatabaseService")
public class DatabaseService {
    
   

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") Date tanggal) {
        //TODO write your implementation code here:
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public Post[] listPost() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") int id, @WebParam(name = "judul") String judul, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") Date tanggal) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public String publishPost(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String pasword, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public Object[] listUser() {
        {
        Firebase ref = new Firebase("https://vivid-torch-7169.firebaseio.com/user");
        Map<String,Object> daftaruser = new HashMap<>();
        users = new ArrayList<>();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot ds) {
                daftaruser.putAll((Map<? extends String, ? extends User>) ds.getValue());
                for(Entry<String,Object> entry : daftaruser.entrySet())
                {
                    Map<String,Object>userDetail = (Map<String,Object>) entry.getValue();
                    String username = (String) userDetail.get("username");
                    String email = (String) userDetail.get("email");
                    String password = (String) userDetail.get("password");
                    String role = (String) userDetail.get("role");
                    User temp = new User(username, email, password, role);
                    users.add(temp);
                }
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        }
        return users.toArray();
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "nama") String nama, @WebParam(name = "role") String role, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "kontent") String kontent) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public Object[] listComment() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteComment")
    public Boolean deleteComment(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public Post[] search(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    public DatabaseService() {
    }
    
    private List<User> users;
}
