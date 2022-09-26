package learnprogramming.academy.imbizo_wil3.OOP;

import java.util.Comparator;

public class Lecture {

    String userName;
    String lectureName;
    String lectureImage;
    String categoryType;
    String typeOfContent;
    String storage;

    public Lecture()
    {

    }

    public Lecture(String userName, String lectureName, String lectureImage, String categoryType) {
        this.userName = userName;
        this.lectureName = lectureName;
        this.lectureImage = lectureImage;
        this.categoryType = categoryType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureImage() {
        return lectureImage;
    }

    public void setLectureImage(String lectureImage) {
        this.lectureImage = lectureImage;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }



    public static Comparator<Lecture> StuNameComparatorAsc = new Comparator<Lecture>() {

        public int compare(Lecture l1, Lecture l2) {
            String LectureName1 = l1.getLectureName().toUpperCase();
            String LectureName2 = l2.getLectureName().toUpperCase();
            //ascending order
            return LectureName1.compareTo(LectureName2);


        }};

    public static Comparator<Lecture> StuNameComparatorDesc = new Comparator<Lecture>() {

        public int compare(Lecture l1, Lecture l2) {
            String LectureName1 = l1.getLectureName().toUpperCase();
            String LectureName2 = l2.getLectureName().toUpperCase();



            //descending order
            return LectureName2.compareTo(LectureName1);
        }};


}
