package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;
import java.util.ArrayList;

public class Photos extends UserData<ArrayList<Photo>> implements Serializable {
    public ArrayList<Photo> data;

    public Photos(){
        super(new ArrayList<Photo>());
        this.data = super.data;
    }

    public Photos(ArrayList<Photo> photos){
        super(photos);
        this.data = photos;
    }

    public Photos(Photo photo){
        super(new ArrayList<Photo>());
        super.data.add(photo);
        this.data = super.data;
    }
}