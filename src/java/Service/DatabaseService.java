/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataType.Komentar;
import DataType.Post;
import DataType.User;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.firebase.client.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.annotation.WebInitParam;

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
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "author")String author, @WebParam(name = "konten") String konten, @WebParam(name = "tanggal") String tanggal) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String, String> p = new HashMap<>();
        p.put("judul",judul);
        p.put("author",author);
        p.put("konten",konten);
        p.put("tanggal",tanggal);
        p.put("status","unpublished");
        ref.child("post").push().setValue(p);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public String listPost() {
        return "https://vivid-torch-7169.firebaseio.com/post";
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
    public Boolean deletePost(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL + "/post/" + id);
        ref.removeValue();
        return true;
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
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "role") String role) {
        Firebase ref = new Firebase(firebaseURL);
        Map<String,String> u = new HashMap<>();
        u.put("username", username);
        u.put("password",password);
        u.put("email", email);
        u.put("role", role);
        ref.child("user").push().setValue(u);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listUser")
    public String listUser() 
    {
        return "https://vivid-torch-7169.firebaseio.com/user";
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
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "id_post")String id_post, @WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "komentar") String komentar) {
        Firebase ref = new Firebase(firebaseURL);
        HashMap<String, String> newComment = new HashMap<>();
        newComment.put("id_post", id_post);
        newComment.put("Nama", nama);
        newComment.put("Email", email);
        newComment.put("Komentar", komentar);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal = format.format(date);
        newComment.put("Tanggal", tanggal);
        ref.child("komentar").push().setValue(newComment);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public String listComment() {
        return "https://vivid-torch-7169.firebaseio.com/komentar";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteComment")
    public Boolean deleteComment(@WebParam(name = "id") String id) {
        Firebase ref = new Firebase(firebaseURL + "/komentar/" + id);
        ref.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public Post[] search(@WebParam(name = "query") String query) {
        return null;
    }

    public DatabaseService() {
        firebaseURL = "https://vivid-torch-7169.firebaseio.com";
    }
    
    //Methods
    private List<User> users;
    private String firebaseURL;
}
