package UseCases.useredit;

import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a response model for a given user.
 */
public class UserEditResponseModel {
    public String bio;
    public String name;
    public String courses;
    public HashMap<Integer, Boolean> interestsDict;
    public HashMap<Integer, ArrayList<Object>> attributeDict;
    public ArrayList<ArrayList<Integer>> breakersDict;
    public UserEditResponseModel(User user){
        this.bio = user.getBio().getData();
        this.name = user.getDisplayName().getData();
        this.courses = user.getCourses().toString();
        this.interestsDict = user.getInterests().getData();
        this.attributeDict = user.getAttributes().getData();
        this.breakersDict = user.getPreferences().getData();
    }
}
