package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Teacher;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {
        String json2 = Api.getTeachersByDepartment(department);
        TeachersList teachers = new Gson().fromJson(json2, TeachersList.class);

        teachers.items.stream().filter(x -> x.email != null).sorted(Comparator.comparing(x -> x.email.length())).limit(5).forEach(x -> System.out.println(x.email));
    }
}