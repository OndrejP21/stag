package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Action;
import pro1.apiDataModel.ActionsList;

import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(maxPersonsCount("KIKM",2024));
    }

    public static long maxPersonsCount(String department, int year)
    {
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);

        Action maxAction = actions.items.stream().max(Comparator.comparing(x -> x.personsCount)).get();

        return maxAction.personsCount;

        // return actions.items.stream().mapToLong(x -> x.personsCount).max().getAsLong(); // TODO 2.1: Vrať nejvyšší dosažený počet přihlášených studentů na jedné akci
    }
}