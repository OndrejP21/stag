package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(emailOfBestTeacher("KIKM",2024));
    }

    public static String emailOfBestTeacher(String department, int year)
    {
        String json1 = Api.getActionsByDepartment(department, year);
        String json2 = Api.getTeachersByDepartment(department);

        ActionsList actions = new Gson().fromJson(json1, ActionsList.class);
        TeachersList teachers = new Gson().fromJson(json2, TeachersList.class);

        return teachers.items.stream().max(Comparator.comparing(x -> TeacherScore(x.id, actions))).get().email;
    }

    public static long TeacherScore(long teacherId, ActionsList departmentSchedule)
    {
        return departmentSchedule.items.stream().filter(x -> x.teacherId == teacherId).collect(Collectors.summarizingInt(x -> x.personsCount)).getSum();
    }
}