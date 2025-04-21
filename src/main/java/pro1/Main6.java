package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main6 {

    public static void main(String[] args) {
        System.out.println(idOfBestTeacher("KIKM",2024));
    }

    public static long idOfBestTeacher(String department, int year)
    {
        String json = Api.getActionsByDepartment(department, year);

        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        HashMap<Long, Integer> dictionary = new HashMap<Long, Integer>();
        actions.items.stream().forEach(x -> {
            Integer v = dictionary.getOrDefault(x.teacherId,0);
            dictionary.put(x.teacherId, x.personsCount + v);
        });

        return dictionary.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }
}