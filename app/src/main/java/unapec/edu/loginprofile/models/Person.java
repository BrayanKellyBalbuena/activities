package unapec.edu.loginprofile.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
   private  String fullName;
   private  String about ;
   private  String repo;

   public Person(){}

    public Person(String fullName, String about, String repo){
       this.fullName = fullName;
       this.about = about;
       this.repo = repo;
    }

   protected Person(Parcel in){
       this.fullName = in.readString();
       this.about = in.readString();
       this.repo = in.readString();
   }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel parcel, int i) {
       parcel.writeString(fullName);
       parcel.writeString(about);
       parcel.writeString(repo);
   }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
