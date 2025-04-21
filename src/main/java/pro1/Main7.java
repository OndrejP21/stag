package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.StudyField;
import pro1.apiDataModel.StudyFieldList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        System.out.println(getEprDeadlines(2025));
    }

    public static String getEprDeadlines(int year) {
        String json = Api.getSpecializations(year);

        StudyFieldList studyFields = new Gson().fromJson(json, StudyFieldList.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        // Pro jistotu vyfiltrujeme hodnoty, které by byly null
        List<StudyField> sorted = studyFields.items.stream().filter(x -> x.eprDeadline.value != null).sorted(Comparator.comparing(x -> LocalDate.parse(x.eprDeadline.value, formatter))).toList();

        // Chceme smazat duplicitní hodnoty
        return sorted.stream().map(x -> x.eprDeadline.value).distinct().collect(Collectors.joining(","));
    }
}
